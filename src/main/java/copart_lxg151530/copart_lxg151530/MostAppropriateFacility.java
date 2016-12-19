package copart_lxg151530.copart_lxg151530;

interface ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode);
}

class ClosestCopartRuleBasedOnDB implements ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode){		
		return null;
	}	
}

class ClosestCopartRuleBasedOnEngine implements ClosestCopartRule{
	public String getClosestCopartFacility(String id, String zipcode){		
		return null;
	}	
}

class Customer{
	String id;
	//assuming default rule is ClosestCopartRuleBasedOnDB
	ClosestCopartRule rule = new ClosestCopartRuleBasedOnDB();
	ClosestCopartRule getClosestCopartRule(){
		return rule;
	}
	
	public void setClosestCopartRule(ClosestCopartRule rule ){
		this.rule = rule;
	}
}

public class MostAppropriateFacility {
	public static void main(String[] args) {		
		
	}
}
