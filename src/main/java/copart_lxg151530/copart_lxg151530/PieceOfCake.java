package copart_lxg151530.copart_lxg151530;
import java.util.List;
public class PieceOfCake {

	public static void main(String[] args) {
		String inputfile = "./PieceOfCakeInput.txt";
		String outputfile = "./PieceOfCakeOutput.txt";
		List<String> lines = DataReader.readLines(inputfile);
		System.out.println("input filename is : ./DNASequencingInput.txt");
		System.out.println("input string is : " );
		for(String line : lines){
			System.out.println(line);
		}
		
		String outputlines = "";
		int n = Integer.valueOf(lines.get(0));
		int idx = 0;
		for(String line: lines){
			if(idx==0){ 
				idx++;
				continue;
			}
			int area = Integer.valueOf(line);
			outputlines += getMinimumPerimeter(area)+"\n";
		}
		System.out.println("output is : \n"+outputlines);
		DataWriter.write(outputfile, outputlines);
		System.out.println("output filename is : "+outputfile);
	}
	
	public static int getMinimumPerimeter(int area){
		double width = Math.sqrt(area);
		int minPerimeter = Integer.MAX_VALUE;
		int length = (int)width+1;
		if((area/length)*length == area) 
			minPerimeter = Math.min(minPerimeter, (length+area/length)*2);
		if(length==1) return 4;
		for(int i = length-1; i > 0; i--){			
		 if((area/i)*i == area){
			minPerimeter = Math.min(minPerimeter, (i+area/i)*2);
		 	break;
		 }
		}
		return minPerimeter;
	}
}
