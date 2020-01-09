/** Ben F Rayfield offers this software opensource MIT license.
occamserver package: Minimalist server wrapping your func of bytes or map in and out.
*/
package mutable.internet.occamserver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class WrapMapFuncInHttpBytesFunc implements UnaryOperator<byte[]>{
	
	public final UnaryOperator<Map> mapfunc;
	
	public WrapMapFuncInHttpBytesFunc(UnaryOperator<Map> mapfunc){
		this.mapfunc = mapfunc;
	}
	
	public byte[] apply(byte[] in){
		return mapToBytes(mapfunc.apply(bytesToMap(in)));
	}
	
	/** Must be http request or response bytes */
	public static Map bytesToMap(byte b[]){
		Map m = new HashMap();
		int contentStarts = b.length; //If no \r\n\r\n found, then content is empty, like in a GET.
		for(int i=b.length; i>=4; i--){
			if(b[i-4]=='\r' && b[i-3]=='\n' && b[i-2]=='\r' && b[i-1]=='\n'){
				contentStarts = i;
				break;
			}
		}
		int contentLen = b.length-contentStarts;
		if(0 < contentLen){
			byte content[] = new byte[contentLen];
			System.arraycopy(b, contentStarts, content, 0, contentLen);
			m.put("content", content);
		}
		//TODO optimize: use String constructor with array range
		byte bytesBeforeContent[] = new byte[contentStarts];
		System.arraycopy(b, 0, bytesBeforeContent, 0, contentStarts);
		String beforeContent = utf8BytesToString(bytesBeforeContent);
		BufferedReader br = new BufferedReader(new StringReader(beforeContent));
		String line;
		boolean first = true;
		try{
			while((line = br.readLine()) != null){
				if(first){
					m.put("firstLine", line);
					first = false;
				}else{
					int colonWhere = line.indexOf(':');
					if(colonWhere != -1){ //FIXME this ignores more than empty lines
						String key = line.substring(0, colonWhere).trim();
						String value = line.substring(colonWhere+1).trim();
						m.put(key, value);
					}
					//FIXME should be error if key is "content" or "firstLine"
				}
			}
			return Collections.unmodifiableMap(m);
		}catch(Exception e){
			throw new Error(e);
		}
	}
	
	/** TODO what order? firstLine is first, and content is last, but what about headers between? Does it matter? Still I'd prefer some consistent order. */
	public static byte[] mapToBytes(Map<Object,Object> m){
		try{
			ByteArrayOutputStream out = new ByteArrayOutputStream(256); //grows if needed
			Object firstLine = m.get("firstLine");
			if(firstLine == null) throw new RuntimeException(
				"Must contain key \"firstLine\" with value similar to \"GET /page%20name HTTP/1.1\"");
			out.write(asBytes(firstLine));
			for(Map.Entry entry : m.entrySet()){
				Object keyOb = entry.getKey();
				Object valueOb = entry.getValue();
				//TODO optimize by comparing as byte[] if its that, instead of creating byte[] and String for it
				String key = asString(keyOb);
				if(key.equals("content") || key.equals("firstLine")) continue;
				out.write('\r');
				out.write('\n');
				//FIXME If keyOb or valueOb contains multiple lines (by \r\n aka 13 10) then error
				out.write(asBytes(keyOb));
				out.write(':');
				out.write(' ');
				out.write(asBytes(valueOb));
			}
			out.write('\r');
			out.write('\n');
			out.write('\r');
			out.write('\n');
			Object content = m.get("content");
			if(content != null) out.write(asBytes(content));
			return out.toByteArray();
		}catch(Exception e){
			throw new Error(e);
		}
	}
	
	public static String utf8BytesToString(byte b[]){
		try{
			return new String(b,"UTF-8");
		}catch(UnsupportedEncodingException e){
			throw new Error(e);
		}
	}
	
	public static byte[] stringToUtf8Bytes(String s){
		try{
			return s.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e){
			throw new Error(e);
		}
	}
	
	/** Returns param if already byte[], else converts from string */
	public static byte[] asBytes(Object ob){
		if(ob instanceof byte[]) return (byte[])ob;
		if(ob instanceof String) return stringToUtf8Bytes((String)ob);
		throw new Error("Not byte[] or String: "+ob);
	}
	
	/** Returns param if already String, else converts from byte[] */
	public static String asString(Object ob){
		if(ob instanceof String) return (String)ob;
		if(ob instanceof byte[]) return utf8BytesToString((byte[])ob);
		throw new Error("Not byte[] or String: "+ob);
	}

}
