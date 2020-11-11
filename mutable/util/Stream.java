/** Ben F Rayfield offers this simpleblobtable software opensource MIT license */
package mutable.util;
import java.io.Closeable;
import java.io.IOException;

public class Stream{
	
	public static void closeQuiet(Closeable c){
		try {
			if(c != null) c.close();
		}catch(IOException e){}
	}

}
