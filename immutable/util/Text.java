/** Ben F Rayfield offers this simpleblobtable software opensource MIT license */
package immutable.util;
import java.io.UnsupportedEncodingException;

public class Text{
	
	public static byte[] strToBytes(String s){
		try{
			return s.getBytes("UTF-8");
		}catch (UnsupportedEncodingException e){ throw new Error(e); }
	}
	
	public static String bytesToHex(byte b[]){
		StringBuilder sb = new StringBuilder(b.length*2);
		for(int i=0; i<b.length; i++){
			String s = Integer.toHexString(b[i]).toLowerCase();
			if(s.length() == 1) s = "0"+s;
			s = s.substring(s.length()-2); //TODO optimize by not creating whole 8 digits. Also dont need strings in middle steps.
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static byte[] hexToBytes(String hex){
		byte[] b = new byte[hex.length()/2];
		for(int i=0; i<b.length; i++){
			b[i] = (byte)((hexDigitToInt((byte)hex.charAt(i*2))<<4)|hexDigitToInt((byte)hex.charAt(i*2+1)));
			//b[i] = Byte.parseByte(hex.substring(i*2, i*2+2), 16);
		}
		return b;
	}
	
	public static String bytesToStr(byte[] b){
		try{
			return new String(b, "UTF-8");
		}catch (UnsupportedEncodingException e){ throw new Error(e); }
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

}
