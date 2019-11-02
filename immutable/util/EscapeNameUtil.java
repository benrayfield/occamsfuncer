/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

public class EscapeNameUtil{
	/** All these are replaced urlEscaping (but on these chars), such as "_" becomes "%5f".
	Also, capitals must be preceded by "_" since names are caseSensitive
	but must also work in fileSystems that check filename equality caseInsensitive (Windows).
	*/
	public static final String escapedChars = "%\\/:;\r\n?*\"<>|._";
	public static final int maxEscapedNameLen = 200; //TODO chars or bytes? Check at least Windows and Linux limits.

	private EscapeNameUtil(){}

	/** escapeName is the normal way. This is used when choosing how to rename when its too long. */
	public static String escapeNameNoThrow(String name){
		if(!name.equals(name.trim())){
			throw new Error("FIXME_NO_THROW. Name has leading or trailing whitespace["+name+"]");
		}
		//TODO optimize
		for(int i=0; i<escapedChars.length(); i++){
			name = name.replace(escapedChars.substring(i,i+1),EscapeNameUtil.escapeFor(escapedChars.charAt(i)));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<name.length(); i++){
			char c = name.charAt(i);
			if(Character.isUpperCase(c)) sb.append('_');
			sb.append(c);
		}
		String escaped = sb.toString();
		return escaped;
	}

	public static String escapeName(String name){
		String escaped = escapeNameNoThrow(name);
		//TODO does any relevant filesystem measure in bytes instead of chars? What max len per path part?
		if(maxEscapedNameLen < escaped.length()){
			throw new Error("EscapedName too long: escaped="+escaped+" escapedLen="+escaped.length()+" name="+name);
		}
		return escaped;
	}

	/** 2017-9-15 Some of benrayfields existing data is too long when names are escaped. Will fix them later. */
	public static boolean isValidName(String name){
		//capital letters must be prefixed by _ so caseInsensitive file systems can store case sensitive listweb names
		return name.length()!=0 && (name.length() <= maxEscapedNameLen/2
			|| escapeNameNoThrow(name).length() <= maxEscapedNameLen);
	}

	public static String escapeFor(char c){
		String s = Integer.toHexString(c);
		if(s.length() > 2) throw new RuntimeException("TODO urlescape multibyte char: "+c);
		if(s.length() == 1) s = "0"+s;
		return "%"+s;
	}

	public static String unescape(String escaped, boolean dropUnderscores){
		byte b[] = Text.stringToBytes(escaped);
		//each escape shortens by 2. Each _ is removed, but you can include _ as %5f
		byte b2[] = new byte[b.length];
		int b2Siz = 0;
		for(int i=0; i<b.length; i++){
			if(i<b.length-2 && b[i] == '%' && Text.isHexDigit(b[i+1]) && Text.isHexDigit(b[i+2])){
				b2[b2Siz++] = (byte)(Text.hexDigitToInt(b[++i])<<4 | Text.hexDigitToInt(b[++i]));
			}else if(!dropUnderscores || b[i] != '_'){
				b2[b2Siz++] = b[i];
			}
		}
		byte b3[] = new byte[b2Siz];
		System.arraycopy(b2, 0, b3, 0, b2Siz);
		return Text.bytesToString(b3);
		
		/*try{
			escaped = escaped.replace("_",""); //remove what precedes capitals.
			return URLDecoder.decode(escaped, "UTF-8"); //ERROR changes "+" to " "
		}catch (UnsupportedEncodingException e){
			throw new RuntimeException(e);
		}*/
	}

	public static String unescapeName(String escaped){
		return unescape(escaped,true);
	}

	public static String unescapeUrl(String escaped){
		return unescape(escaped,false);
	}

	/** This is used when ready to shorten a name if its too long,
	such as when importing data and copying the full name into def if shortened.
	TODO optimize by adding 2 len for each escapedChars found.
	*/
	public static int charsLenOfEscapedName(String name){
		return escapeNameNoThrow(name).length();
	}

	public static int byteLenOfEscapedName(String name){
		return Text.stringToBytes(name).length;
	}
	
	

}
