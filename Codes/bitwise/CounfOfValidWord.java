package bitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CounfOfValidWord {

	
	
	public static ArrayList<Integer> findNumberOfValidWords(String[] words, String[] puzzles){
		
		
		//hashmap to stores character domain. 
		Map<Character, ArrayList<Integer>> hm  = new HashMap<>();
		
		 ArrayList<Integer> res = new ArrayList<>();
		for(int i=0 ; i <26;i++) {
			hm.put((char)('a'+i), new ArrayList<Integer>());			
		}
		for(String word : words) {
			
			 int mask =0; 
			 //creating mask for word
			 for(char c :word.toCharArray()) {
				 
				 mask=mask|(1<<c-'a');
				 
			 }
			 HashSet<Character> set = new HashSet<>();
			 for(char c :  word.toCharArray()) {
				 if(set.contains(c)) {
					 continue;
				 }
				 set.add(c);
				 hm.get(c).add(mask);
			 }
			 
		}
		
		int pmask=0;
		for(String puzzle : puzzles) {
			
			for(char c :puzzle.toCharArray()) {
				 
				pmask=pmask|(1<<c-'a');
				 
			 }
			 char fchar= puzzle.charAt(0);
			 ArrayList<Integer> wordstoCheck=hm.get(fchar);
			 int count=0;
			 for(Integer matchMask : wordstoCheck) {
				 if((matchMask&pmask)==matchMask) {
					 count++;
				 }
				 
			 }
			 
			res.add(count);
			 
			 
			 
		 }
		
		return res;
		
			
		
	}
	
	
	public static void main(String[] args) {
		
		String[] puzzles= {"aboveyz","abrodyz","abslute"};
		String[] words= {"aaaa","asas","able",};
		System.out.println(findNumberOfValidWords(words, puzzles));
		
		
	}
}
