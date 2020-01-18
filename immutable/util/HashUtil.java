/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import mutable.util.Files;

public class HashUtil{
	
	public static byte[] sha256(byte[] b){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(b);
			return md.digest();
		}catch(NoSuchAlgorithmException e){ throw new Error(e); }
	}
	
	/** last 32 bits of sha256 of utf8 of the string,
	for creating "magic numbers" that work between people who dont try to create collisions
	in low thousands of unique things, such as the CoreType and Op enums
	can use this to help forks of opensource occamsfuncer VM code merge code together
	without relying on a central authority of Enum.ordinal() of a specific enum.
	Use these things by their string name instead of Enum.ordinal(),
	and only optimize to use Enum at runtime but use this in datastructs to merkle hash.
	*/
	public static int sha256HashStringToInt(String s){
		byte[] b = sha256(Text.stringToBytes(s));
		return ((b[28]&0xff)<<24)|((b[29]&0xff)<<16)|((b[30]&0xff)<<8)|(b[31]&0xff);
	}

}
