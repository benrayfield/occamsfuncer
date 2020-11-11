/** Ben F Rayfield offers this software opensource MIT license */
package mutable.util;

import java.io.IOException;
import java.io.InputStream;

public class ByteStreams{
	private ByteStreams(){}
	
	

	public static byte[] bytes(InputStream in){
		System.out.println("Reading "+in);
		try{
			byte b[] = new byte[1];
			int avail;
			int totalBytesRead = 0;
			while((avail = in.available()) != 0){
				int maxInstantCapacityNeeded = totalBytesRead+avail;
				if(b.length < maxInstantCapacityNeeded){
					byte b2[] = new byte[maxInstantCapacityNeeded*2];
					System.arraycopy(b, 0, b2, 0, totalBytesRead);
					b = b2;
				}
				//System.out.println("totalBytesRead="+totalBytesRead+" avail="+avail);
				int instantBytesRead = in.read(b, totalBytesRead, avail);
				if(instantBytesRead > 0) totalBytesRead += instantBytesRead; //last is -1
			}
			byte b2[] = new byte[totalBytesRead];
			System.arraycopy(b, 0, b2, 0, totalBytesRead);
			return b2;
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] bytes(InputStream in, int maxBytes, double maxSeconds, boolean close){
		try{
			try{
				byte b[] = new byte[256];
				int siz = 0;
				long nanoStart = System.nanoTime();
				while(true){
					int remainingArrayCapacity = b.length-siz;
					if(remainingArrayCapacity == 0){ //enlarge array
						if(siz == maxBytes+1) throw new IOException("Exceeded max bytes "+maxBytes);
						byte b2[] = new byte[Math.min(maxBytes==Integer.MAX_VALUE?Integer.MAX_VALUE:maxBytes+1,b.length*2)];
						System.arraycopy(b, 0, b2, 0, siz);
						b = b2;
						remainingArrayCapacity = b.length-siz;
					}
					int nextByte = in.read();
					if(nextByte == -1) break;
					b[siz++] = (byte)nextByte;
					//System.out.print((char)nextByte);
					double duration = (System.nanoTime()-nanoStart)*1e-9;
					if(maxSeconds < duration) throw new IOException("Took longer than "+maxSeconds+" seconds");
					/*if(parseHttpToFindEnd){
						boolean isGet = 3<=siz && (b[0]=='G' && b[1]=='E' && b[2]=='T');
						if(isGet && 7<=siz && b[siz-4]=='\r' && b[siz-3]=='\n' && b[siz-2]=='\r' && b[siz-1]=='\n'){
							break; //stream may close or not, but this is end since its GET and theres no data to POST.
						}
					}*/
				}
				byte b2[] = new byte[siz];
				System.arraycopy(b, 0, b2, 0, siz);
				return b2;
				//FIXME: If cant read even 1 more byte, wont time out since only checks then
			}finally{
				if(close) in.close();
			}
		}catch(IOException e){ throw new Error(e); }
	}
	
	

}
