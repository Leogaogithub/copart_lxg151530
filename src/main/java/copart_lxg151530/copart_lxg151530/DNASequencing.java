package copart_lxg151530.copart_lxg151530;

import java.util.List;

public class DNASequencing{
	public static void main(String[] args) {
		//String test1="ATGGCAAGGGGTT";
		List<String> test1 = DataReader.readLines("./DNASequencingInput.txt");
		System.out.println("input filename is : ./DNASequencingInput.txt");
		System.out.println("input string is : " + test1.get(0));
		int longest = getLongestSubstring(test1.get(0));
		System.out.println("output string is : "+getLongestSubstring(test1.get(0)));
		DataWriter.write("./DNASequencingOutput.txt", longest+"");
		System.out.println("output filename is : ./DNASequencingOutput.txt");
	}
	
	public static int getLongestSubstring(String str){
		int max = Integer.MIN_VALUE;
		if(str == null) return 0;	    
		int start = 0, end = 0, len = str.length();	
		max = 1;
		if(str.length()<= 1) return len;
		for(int  i = 1; i < len; i++){
			if(str.charAt(start)!=str.charAt(i)){
				max = Math.max(i-start, max);
				start = i;
			}
		}
		if(start!=len-1){
			max = Math.max(len-start, max);
		}
		return max;
	}
}
