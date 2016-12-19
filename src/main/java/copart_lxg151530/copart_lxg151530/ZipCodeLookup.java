package copart_lxg151530.copart_lxg151530;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.*;
import java.io.IOException;
import java.util.ArrayList;

public class ZipCodeLookup {	
	public static void main(String[] args) {
		if(args.length>1) {
			System.out.println("input should be zipcode");
			return;
		}
		String zipcode = args[0];
        Client client = new ClientBuilder("YOUR AUTH-ID HERE", "YOUR AUTH-TOKEN HERE").build();

        Lookup lookup = new Lookup();
        lookup.setZipCode();
        lookup.setStreet("1600 Amphitheatre Pkwy");
        lookup.setCity("Mountain View");
        lookup.setState("CA");

        try {
            client.send(lookup);
        }
        catch (SmartyException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Candidate> results = lookup.getResult();

        if (results.isEmpty()) {
            System.out.println("No candidates. This means the address is not valid.");
            return;
        }

        Candidate firstCandidate = results.get(0);

        System.out.println("Address is valid. (There is at least one candidate)\n");
        System.out.println("ZIP Code: " + firstCandidate.getComponents().getZipCode());
        System.out.println("County: " + firstCandidate.getMetadata().getCountyName());
        System.out.println("Latitude: " + firstCandidate.getMetadata().getLatitude());
        System.out.println("Longitude: " + firstCandidate.getMetadata().getLongitude());
    }

}
