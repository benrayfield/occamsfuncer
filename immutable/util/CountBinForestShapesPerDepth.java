package immutable.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/** Level0 has 1 binary forest shapes.
Level1 has 2 binary forest shapes.
Level2 has 5 binary forest shapes.
Level3 has 26 binary forest shapes.
Level4 has 677 binary forest shapes.
Level5 has 458330 binary forest shapes.
<br><br>
Each number so far is either 1 to start or 1+prev^2.
TODO how can I match those to binaryForestShapes efficiently? 
<br><br>
I only need to cache up to level4. Thats where occamsfuncer opcodes go.
Put it in short.
TODO find simple math that generates these numbers
and choose ordering (possibly by height recursively)
so given a number 0 to 676 the forest shape is
computable without bruteForce.
*/
public class CountBinForestShapesPerDepth{
	
	public static final String leaf = "leaf";
	
	public static String pair(String x, String y){
		return Text.bytesToHex(HashUtil.sha256(Text.stringToBytes(x+","+y)));
	}
	
	public static void lg(String line){
		System.out.println(line);
	}
	
	public static void main(String[] args){
		Set<String> nodesSet = new TreeSet();
		List<String> nodesList = new ArrayList();
		Map<String,String> display = new HashMap();
		Map<String,Integer> height = new HashMap();
		for(int i=0; i<4; i++){
			if(i==0){ 
				nodesSet.add(leaf);
				nodesList.add(leaf);
				display.put(leaf, "0");
				//display.put(leaf, "0.");
				height.put(leaf,0);
				lg(display.get(leaf)+" <0>");
			}else{
				int j=0;
				String[] nodesArray = nodesList.toArray(new String[0]);
				for(String nodeX : nodesArray){
					for(String nodeY : nodesArray){
						String newPair = pair(nodeX,nodeY);
						int h = Math.max(height.get(nodeX),height.get(nodeY))+1;
						//String disp = h+"`"+display.get(nodeX)+display.get(nodeY);
						//String disp = h+display.get(nodeX)+display.get(nodeY);
						String disp = h+"("+display.get(nodeX)+","+display.get(nodeY)+")";
						if(!nodesSet.contains(newPair)){
							nodesSet.add(newPair);
							nodesList.add(newPair);
							height.put(newPair, h);
							display.put(newPair, disp);
							lg(disp+" <"+(j++)+">");
						}else{
							lg(disp+" <dup>");
						}
					}
				}
			}
			lg("Level"+i+" has "+nodesList.size()+" binary forest shapes.");
		}
	}

}
