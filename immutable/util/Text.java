/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Text{
	private Text(){}
	
	public static final String n = "\n";
	
	public static byte[] stringToBytes(String s){
		try{
			return s.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(unicodeMessage);
		}
	}
	
	private static String unicodeMessage = "UTF-8 is standard for string encoding. Its simple definition is on Wikipedia and can be copied into this software if your version of Java doesn't support it. Each byte starts with 0, 10, 110, or 1110, used to find alignment at unknown position in data, and the rest are the data.";
	
	public static String bytesToString(byte b[]){
		try{
			return new String(b, "UTF-8");
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(unicodeMessage,e);
		}
	}
	
	public static String bytesToString(byte b[], int from, int to){
		try{
			return new String(b, from, to-from, "UTF-8");
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(unicodeMessage,e);
		}
	}
	
	public static String replaceFileExtension(String pathOrFilename, String newExtension){
		int lastDot = pathOrFilename.lastIndexOf('.');
		int lastSlash = Math.max(pathOrFilename.lastIndexOf('/'), pathOrFilename.lastIndexOf('\\'));
		if(lastSlash < lastDot){
			return pathOrFilename.substring(0,lastDot+1)+newExtension;
		}else{
			return pathOrFilename+'.'+newExtension;
		}
	}
	
	public static String floatsToString(float... a){
		List l = new ArrayList();
		for(float f : a) l.add(f);
		return l.toString();
	}
	
	public static String[] splitByWhitespaceNoEmptyTokens(String s){
		s = s.trim();
		if(s.isEmpty()) return new String[0];
		return s.split("\\s+");
	}
	
	public static String longToConstLenHex(long g){
		String s = "000000000000000"+Long.toHexString(g);
		return s.substring(s.length()-16);
	}
	
	public static int hexDigitToInt(char d){
		if(d > 'f') throw new Error("Not a hex digit["+d+"]"); //some chars would wrap and match a digit
		return hexDigitToInt((byte)d);
	}
	
	static final char[] hexDigits = "0123456789abcdef".toCharArray();
	
	public static String bytesToHex(byte[] b){
		StringBuilder sb = new StringBuilder();
		for(byte x : b){
			int i = x&0xff;
			sb.append(hexDigits[(i>>4)&0xf]);
			sb.append(hexDigits[i&0xf]);
		}
		return sb.toString();
	}
	
	public static boolean isHexDigit(byte c){
		return ('0'<=c && c<='9') ||('a'<=c && c<='f') || ('A'<=c && c<='F'); 
	}
	
	public static int hexDigitToInt(byte d){
		switch(d){
		case '0': return 0;
		case '1': return 1;
		case '2': return 2;
		case '3': return 3;
		case '4': return 4;
		case '5': return 5;
		case '6': return 6;
		case '7': return 7;
		case '8': return 8;
		case '9': return 9;
		case 'a': case 'A': return 10;
		case 'b': case 'B': return 11;
		case 'c': case 'C': return 12;
		case 'd': case 'D': return 13;
		case 'e': case 'E': return 14;
		case 'f': case 'F': return 15;
		}
		throw new Error("Not a hex digit: (baseTen)"+d);
	}
	
	/** TODO paragraphs are separated by empty line,
	or in the oldYear2015 data format by ... with whitespace around it.
	<br><br>
	Parses space, endLine, commas, etc, into approximately the same string if you concat
	the returned tokens, except "\n" or "\r" by itself (or "\n\r" if aligned that way) will all become "\r\n".
	<br><br>
	TODO Should there be an extra parsing step to join adjacent tokens around a decimal point?
	The difference is a period ending a sentence has any kind of whitespace after it or is last token.
	<br><br>
	Merges decimal points into numbers, decimal points and other chars into URLs, and maybe other things.
	<br><br>
	Heres some examples of the things I'm writing code (TODO) to handle as single tokens...
	<br><br>
	3f4.d33
	<br><br>
	.d33
	<br><br>
	Not 3f4. because thats an integer and would not normally have a decimal point, and in the worst case gets a period.
	<br><br>
	http://code.google.com/index.html
	<br><br>
	sha256:len://af234234ffdcca53af234234ffdcca53af234234ffdcca53af234234ffdcca53:43f
	<br><br>
	http://en.wikipedia.org/wiki/Parenthesis#Parentheses_(_)
	<br><br>
	The URL examples very much complicate my syntax. It may be better to have less rules, as long as all the content
	gets put together the same way from some way of dividing it into tokens. Below list the ways of dividing tokens
	that are really important, and start from there in a simpler design...
	<br><br>
	. ? ! ; :
	I was afraid of that. Some of these occur in URLs. Maybe I need to parse URLs and numbers first like I did for lines.
	*/
	public static List<String> parseNaturalLanguageAndSymbolsUrlsAndNumbers(String s){
		//lg("\r\nparseNaturalLanguageAndSymbolsUrlsAndNumbers: "+s);
		List<String> tokens = new ArrayList();
		int lastUrlEnd = 0;
		for(immutable.util.IntRange urlRange : findURLs(s)){
			String before = s.substring(lastUrlEnd, urlRange.start);
			tokens.addAll(parseBetweenURLs(before));
			tokens.add(s.substring(urlRange.start, urlRange.endExclusive));
			lastUrlEnd = urlRange.endExclusive;
		}
		String last = s.substring(lastUrlEnd);
		tokens.addAll(parseBetweenURLs(last));
		return Collections.unmodifiableList(tokens);
	}
	
	protected static List<String> parseBetweenURLs(String s){
		//lg("parseBetweenURLs: "+s);
		List<String> tokens = new ArrayList();
		int lastWhitespace = -1;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			boolean isWhitespace = Character.isWhitespace(c);
			if(isWhitespace || i==s.length()-1){
				int nonwhitespaceStart = lastWhitespace+1;
				int nonwhitespaceEndExcl = isWhitespace ? i : i+1;
				if(nonwhitespaceStart < nonwhitespaceEndExcl){
					String nonwhitespace = s.substring(nonwhitespaceStart, nonwhitespaceEndExcl);
					//if(nonwhitespace.matches(".*\\s.*")) throw new Err("Whitespace in: "+nonwhitespace);
					//lg("parseBetweenURLs nonwhitespace: "+nonwhitespace);
					tokens.addAll(findTokensInBlockWithNoWhitespaceThatDoesntContainUrls(nonwhitespace));
				}
				if(isWhitespace) tokens.add(""+c);
			}
			if(isWhitespace) lastWhitespace = i;
		}
		/*
		int lastThingEnd = 0;
		for(humanaicore.common.IntRange urlRange : findThingsContainingSpecialChars(s)){
			String before = s.substring(lastThingEnd, urlRange.start);
			tokens.addAll(parseNaturalLanguageAndSymbolsButNoURLsOrNumbers(before));
			tokens.add(s.substring(urlRange.start, urlRange.endExclusive));
		}
		String last = s.substring(lastThingEnd);
		tokens.addAll(parseNaturalLanguageAndSymbolsButNoURLsOrNumbers(last));
		*/
		return tokens;
	}
	
	protected static List<String> findTokensInBlockWithNoWhitespaceThatDoesntContainUrls(String s){
		//lg("findTokensInBlockWithNoWhitespaceThatDoesntContainUrls: "+s);
		if(s.isEmpty()) return Collections.EMPTY_LIST;
		if(s.length() == 1) return Collections.singletonList(s);
		char first = s.charAt(0), last = s.charAt(s.length()-1);
		if(s.equals("(other/empty)")){
			//ugly hack
			return Collections.singletonList(s);
		}
		List<String> tokens = new ArrayList();
		if(first=='(' || first==','){
			tokens.add(""+first);
			tokens.addAll(findTokensInBlockWithNoWhitespaceThatDoesntContainUrls(s.substring(1)));
			return tokens;
		}
		if(last==')' || last=='.' || last=='!' || last=='?' || last==','){
			tokens.addAll(findTokensInBlockWithNoWhitespaceThatDoesntContainUrls(s.substring(0,s.length()-1)));
			tokens.add(""+last);
			return tokens;
		}
		if(first=='['&&']'==last || first=='<'&&'>'==last || first=='{'&&'}'==last){
			//Example: (other/empty)
						
			//FIXME "{$x{$blah$}$}" should parse "{$blah$}" token but not match the outer because theres extra data,
			//and the {${${$base64$}$}$} syntax is a way of quoting a quote recursively with {$base64$} in middle,
			//but since I'm not using that yet (as of 2016-9) and will do it in mapacyc, dont need this code yet.
			return Collections.singletonList(s);
		}
		if(s.matches(".*\\d{4}-\\d{1,2}-\\d{1,2}.*")) return Collections.singletonList(s);
		StringTokenizer st = new StringTokenizer(s,",\";^+*/",true);
		while(st.hasMoreTokens()) tokens.add(st.nextToken());
		return tokens;
	}
	
	/*public static List<String> parseNaturalLanguageAndSymbolsButNoURLsOrNumbers(String s){
		String lines[] = Text.lines(s); //TODO inline some of this code
		List<String> tokens = new ArrayList<String>();
		for(int i=0; i<lines.length; i++){
			if(i != 0) tokens.add(n);
			String line = lines[i];
			int start = 0;
			for(int j=0; j<line.length(); j++){
				char c = line.charAt(j);
				switch(c){
				case' ':case'\t':case'[':case']':case'{':case'}':case'(':case')':case'<':case'>':
				case'?':case'.':case'!':case';':case':':case'"':case'\'':case',':
				case'*':case'/':case'+':case'-':case'%':case'=':
				case'~':case'`':case'@':case'$':case'^':case'&':case'|':case'\\':
					if(start < j) tokens.add(line.substring(start,j));
					tokens.add(""+c);
					start = j+1;
				}
				//else the current token ranges start to this or some later j
			}
			if(start < line.length()) tokens.add(line.substring(start));
		}
		//String tokensArray[] = tokens.toArray(StringUtil.EMPTY);
		//tokensArray = mergeSomeTokens(tokensArray);
		//return tokensArray;
		return tokens;
	}*/
	
	/** Examples:
	<br><br>
	http://code.google.com/index.html
	<br><br>
	sha256:len://af234234ffdcca53af234234ffdcca53af234234ffdcca53af234234ffdcca53:43f
	<br><br>
	http://en.wikipedia.org/wiki/Parenthesis#Parentheses_(_)
	*/
	public static IntRange[] findURLs(String s){
		List<IntRange> ranges = new ArrayList();
		String urlCore = "://";
		int lastCoreStart = -urlCore.length();
		while(true){
			int coreStart = s.indexOf(urlCore, lastCoreStart+urlCore.length());
			lastCoreStart = coreStart;
			if(coreStart == -1) break;
			//search left
			int minLeft = ranges.isEmpty() ? 0 : ranges.get(ranges.size()-1).endExclusive;
			int left;
			for(left=coreStart-1; left>=minLeft; left--){
				char c = s.charAt(left);
				if(Character.isWhitespace(c) || left==minLeft){
					if(left != minLeft) left++;
					break;
				}
			}
			//TODO clean up and verify the logic for finding left border of URL,
			//especially in cases of string starts with URL or 2 adjacent URLs
			if(Character.isWhitespace(s.charAt(left))) left++;
			//search right
			int maxRightExclusive = s.length();
			int rightExclusive;
			for(rightExclusive=coreStart+urlCore.length(); rightExclusive<maxRightExclusive; rightExclusive++){
				char c = s.charAt(rightExclusive);
				if(Character.isWhitespace(c)){
					break;
				}
			}
			String url = s.substring(left,rightExclusive);
			if(!isURL(url)){
				throw new RuntimeException("Tried to parse URL but instead parsed["+url+"]");
			}
			ranges.add(new IntRange(left,rightExclusive));
		}
		return ranges.toArray(new IntRange[0]);
	}
	
	static long countSpecialCharMessageDisplays = 0;
	
	/** Example: java.util.List
	Example: package-info.html
	Example: index.html
	*/
	public static IntRange[] findThingsContainingSpecialChars(String s){
		if(countSpecialCharMessageDisplays < 100){
			System.err.println("TODO findThingsContainingSpecialChars is returning empty array. do real parsing of things like java.util.List instead.");
			countSpecialCharMessageDisplays++;
		}
		//throw new RuntimeException("TODO");
		return new IntRange[0];
	}
	
	/** TODO improve accuracy of this function by making it return false more often */
	public static boolean isURL(String s){
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isWhitespace(c)) return false;
		}
		if(!s.contains("://")) return false;
		return true;
		
	}
	
	public static String[] lines(String s){
		/*List<String> lines = new ArrayList();
		BufferedReader br = new BufferedReader(new StringReader(s));
		String line;
		try{
			while((line = br.readLine()) != null){
				lines.add(line);
			}
		}catch(IOException e){
			throw new Error(e); //StringReader wont do this
		}
		return lines.toArray(new String[0]);
		*/
		return s.split("(\\r\\n)|\\r|\\n",-1); //negative means keep empty lines at end
	}
	
	public static String quote(String s){
		StringBuilder sb = new StringBuilder().append('"');
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			switch(c){
			case '\\':
				sb.append("\\\\");
			break; case '"':
				sb.append("\\\"");
			break; case '\r': //FIXME TODO multiline string starting at same tab level as first quote
				sb.append("\\r");
			break; case '\n':
				sb.append("\\n");
			break; default:
				sb.append(c);
			}
		}
		return sb.append('"').toString();
	}
	
	public static String urlUnescape(String s){
		try{
			return URLDecoder.decode(s,"UTF-8");
		}catch(UnsupportedEncodingException e){ throw new Error(e); }
	}

	/** Length will depend on min needed possibleNames *
	public static String newJibberishWord(double possibleNames){
		Random r = Rand.strongRand;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(possibleNames > 1){
			String g = (i&1)==0 ? "bcdfghjklmnpqrstvwxyz" : "aeiou";
			sb.append(g.charAt(r.nextInt(g.length())));
			possibleNames /= g.length();
			i++;
		}
		return sb.toString();
	}*/
	
	public static String toString(Throwable t){
		StringWriter w = new StringWriter();
		t.printStackTrace(new PrintWriter(w));
		return w.toString();
	}
	
	public static String firstWhitespaceDelimitedToken(String s){
		boolean foundNonwhitespace = false;
		for(int i=0; i<s.length(); i++){
			if(Character.isWhitespace(s.charAt(i)) && foundNonwhitespace){
				return s.substring(0, i).trim();
			}else{
				foundNonwhitespace = true;
			}
		}
		return s.trim();
	}

}
