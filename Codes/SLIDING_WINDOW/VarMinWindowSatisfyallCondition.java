
//CORRECT
package slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Conditions {
	static int condIndex;
	int freq;
	int index;
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Conditions() {
		super();

	}
	public Conditions(int freq, int index) {
		super();
		this.freq = freq;
		this.index = index;
	}
	public static int getCondIndex() {
		return condIndex;
	}
	public static void setCondIndex(int condIndex) {
		Conditions.condIndex = condIndex;
	}


}

public class VarMinWindowSatisfyallCondition {

	public static int calwindow(String s, String t) {

		//process t;
		Map<Character, Conditions> tMap= new HashMap<>();
		for(int i =0 ; i < t.length();i++) {
			if(tMap.get(t.charAt(i)) != null) {

				Conditions tempfreq= tMap.get(t.charAt(i));
				tempfreq.setFreq(tempfreq.getFreq()+1);
				continue;
			}
			Conditions newCon = new Conditions(1,Conditions.condIndex++);
			tMap.put(t.charAt(i), newCon);

		}
		int[] conditionArray= new int[tMap.size()];
		for(Entry<Character, Conditions> temp : tMap.entrySet()) {
			System.out.println(temp.getKey()+","+temp.getValue().getFreq()+"-"+temp.getValue().getIndex());
		}

		int l=0, r=0;
		int minLength = Integer.MAX_VALUE;
		Map<Character, Conditions> runMap= new HashMap<>(); 
		while(r<s.length()) {
			char key = s.charAt(r);
			if(tMap.containsKey(s.charAt(r))) {
				Conditions c = tMap.get(s.charAt(r));

				if(runMap.containsKey(s.charAt(r))) {
					Conditions temp=runMap.get(key);
					temp.setFreq(temp.getFreq()+1);
					runMap.put(s.charAt(r),temp);

					//whether condition satisfies at this index?

					Conditions temp2=tMap.get(key);
					if(temp2.getFreq()<=temp.getFreq()) {
						conditionArray[temp2.getIndex()]=1; 
					}else {
						conditionArray[temp2.getIndex()]=0;
					}

					boolean allCondSatisfied=true;
					for(int i : conditionArray) {
						if(i==0) {
							allCondSatisfied=false;
							break;
						}
					}

					if(allCondSatisfied) {

						//calculate length of window
						minLength=Math.min(minLength, r-l+1);
						//check for new L value;

						if(tMap.containsKey(s.charAt(l))){
							Conditions temp3= runMap.get(s.charAt(l));
							temp3.setFreq(temp3.getFreq()-1);
							runMap.put(s.charAt(l),temp3);
							if(temp3.getFreq() <tMap.get(s.charAt(l)).getFreq()) {
								conditionArray[temp3.getIndex()]=0;
								allCondSatisfied=false;
							}else
							conditionArray[temp3.getIndex()]=1;
							l++; 
						}

						while(true && l<=r) {

							if(!tMap.containsKey(s.charAt(l))) {
								l++;
								continue;
							}
							minLength=Math.min(minLength, r-l+1);
							break;
						}


					}

				}
				else {

					runMap.put(s.charAt(r), new Conditions(1,c.getIndex()));
					
					
					//check whether conditions get satisfied at this r
					Conditions ref = tMap.get(s.charAt(r));
					if(ref.getFreq() <=runMap.get(s.charAt(r)).getFreq()) {
						conditionArray[ref.getIndex()]=1;
					}
					boolean allCondSatisfied=true;
					for(int i : conditionArray) {
						if(i==0) {
							allCondSatisfied=false;
							break;
						}
					}

					if(allCondSatisfied) {

						//calculate length of window
						minLength=Math.min(minLength, r-l+1);
						//check for new L value;

						if(tMap.containsKey(s.charAt(l))){
							Conditions temp3= runMap.get(s.charAt(l));
							temp3.setFreq(temp3.getFreq()-1);
							runMap.put(s.charAt(l),temp3);
							if(temp3.getFreq() <tMap.get(s.charAt(l)).getFreq()) {
								conditionArray[temp3.getIndex()]=0;
								allCondSatisfied=false;
							}else
							conditionArray[temp3.getIndex()]=1;
							l++; 
						}

						while(true && l<=r) {

							if(!tMap.containsKey(s.charAt(l))) {
								l++;
								continue;
							}
							if(allCondSatisfied)
							minLength=Math.min(minLength, r-l+1);
							
							break;
						}


					}
							
				}
			}


			r++;




		} 
		System.out.println(s.substring(l, r));
		return minLength;
	}






	public static void main(String[] args) {

	/*	String s = "ADOBECODEBANC";
		String t="ABC"; */
		/*String s = "A";
		String t="A";*/
		
		String s = "TOTMTAPTAT";
		String t="TTA"; 
		System.out.println(calwindow(s,t));
	}

}
