package copart_lxg151530.copart_lxg151530;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode);
}

class ClosestCopartRuleBasedOnDB implements ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode){		
		return "Vallejo,CA";
	}	
}

class ClosestCopartRuleBasedOnEngine implements ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode){		
		return "Martinez,CA";
	}	
}

class Customer{
	String id;
	String zipcode;
	public Customer(String id, String zipcode){
		this.id = id;
		this.zipcode = zipcode;
	}
	//assuming default rule is ClosestCopartRuleBasedOnDB
	ClosestCopartRule rule = new ClosestCopartRuleBasedOnDB();
	ClosestCopartRule getClosestCopartRule(){
		return rule;
	}	
	public void setClosestCopartRule(ClosestCopartRule rule ){
		this.rule = rule;
	}
}

class CusterFromDBAPI{
	Map<String , Customer> customerMap = new HashMap<String , Customer>();
	public static CusterFromDBAPI single = null; 
	static CusterFromDBAPI getSingleton(){
		if(single!=null) return single;
		single = new CusterFromDBAPI();
		single.readDataFromDB();
		return single;
	}
	public void readDataFromDB(){
		// some code that retrive data from DB
		List<String> lines = DataReader.readLines("./MostAppropriateFacilityDB.txt");
		System.out.println("database is : ./MostAppropriateFacilityDB.txt");
		for(String line : lines){
			String fields[] = line.split(",");
			Customer customer = new Customer(fields[1], fields[0]);
			ClosestCopartRule rule = null;
			if(fields[2].equals("ClosestCopartRuleBasedOnDB")){
				rule = new ClosestCopartRuleBasedOnDB();
			}else if(fields[2].equals("ClosestCopartRuleBasedOnEngine")){
				rule = new ClosestCopartRuleBasedOnEngine();
			}else{
				rule = new ClosestCopartRuleBasedOnDB();
			}
			customer.setClosestCopartRule(rule);
			customerMap.put(customer.id, customer);
		}
	}
	
	public Customer getCustomerFromDB(String id){
		if(!customerMap.containsKey(id))return null;
		return customerMap.get(id);
	}
}

public class MostAppropriateFacility {
	public static String getClosestCopartFacility(String id, String zipcode){
		Customer customer = CusterFromDBAPI.getSingleton().getCustomerFromDB(id);
		return customer.rule.getClosestCopartFacility(id, zipcode);
	}
	
	public static void main(String[] args) {	
		String inputfile = "./MostAppropriateFacilityInput.txt";
		String outputfile = "./MostAppropriateFacilityOutput.txt";
		List<String> lines = DataReader.readLines(inputfile);
		System.out.println("input filename is : "+inputfile);
		System.out.println("input string is : " );
		for(String line : lines){
			String fields[] = line.split(",");		
			String result = getClosestCopartFacility(fields[1], fields[0]);
			System.out.println("For customer "+fields[0]+" with a provided zip code of " + fields[1] + ", closest Corpart Facility is " + result);
		}	
	}
}
