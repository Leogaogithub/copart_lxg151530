package copart_lxg151530.copart_lxg151530;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.io.*;
import java.net.*;
public class ZipCodeLookup {	
	public static void main(String[] args) {
		String inputfile = "./ZipCodeLookupInput.txt";
		String outputfile = "./ZipCodeLookupOutput.txt";
		List<String> lines = DataReader.readLines(inputfile);
		System.out.println("input filename is : "+inputfile);
		System.out.println("input string is : " );
		String zipCode = lines.get(0);
		try {
			String jsonFile = getHTML("http://maps.googleapis.com/maps/api/geocode/json?address="+zipCode+"&sensor=true");
			String address = getAddressFromJson(jsonFile);			
			System.out.println("output is : \n"+address);
			DataWriter.write(outputfile, address);
			System.out.println("output filename is : "+outputfile);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	 public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }
	
	public static String getAddressFromJson(String jsonString){
		final JSONObject obj = new JSONObject(jsonString);
	    final JSONArray geodata = obj.getJSONArray("results");
	    final JSONObject person = geodata.getJSONObject(0);
	    String address = person.getString("formatted_address");
	    String addressArray[] = address.split(",");
	    String state = addressArray[1].trim().split(" ")[0];
	    String result = "";
	    result += addressArray[0] + ","+state;
	    return result;
	}
}
