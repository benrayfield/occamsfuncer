/** Ben F Rayfield offers this software opensource MIT license */
package immutable.util;

public class TestUtil{
	
	/** FIXME move this to another class? like ImportStatic or Lg,
	but since this is in formalverify package its not supposed to share code with occamsfuncerV3 prototype.
	*/
	public static void lg(String line){
		System.out.println(line);
	}
	
	public static void test(boolean x){
		if(!x) throw new Error("Test failed");
		lg("### test pass");;
	}
	
	public static void test(String name, boolean x){
		if(!x) throw new Error("Test failed: "+name);
		lg("### test pass: "+name);;
	}
	
	public static void testEqq(String name, Object a, Object b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testNotEqq(String name, Object a, Object b){
		if(a == b){
			throw new Error("Test failed (cuz they equal but shouldnt): "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testNotEqq pass: "+name);
	}
	
	public static void testEqq(String name, long a, long b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testEqq(String name, double a, double b){
		if(a != b){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testEqq pass: "+name);
	}
	
	public static void testDotEq(String name, Object a, Object b){
		if(!a.equals(b)){
			throw new Error("Test failed: "+name+" a["+a+"] b["+b+"]");
		}
		lg("### testDotEq pass: "+name);
	}

}
