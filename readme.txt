
1.Describe all the files
1) DataReader.java contains DataReader Class which is used to read data from fileSystem.
2) DataWriter.java contains DataWriter Class which is used to write data into fileSystem.
3) MostAppropriateFacility.java for question Most Appropriate Facility
4) ZipCodeLookup.java for question Zip Code Lookup
5) DNASequencing.java for question DNA Sequencing
6) PieceOfCake.java for question Piece Of Cake
7) Project Ideas.txt is Project Ideas
8) MostAppropriateFacilityInput.txt is input of MostAppropriateFacility
9) MostAppropriateFacilityDB.txt is data base of MostAppropriateFacility
10) DNASequencingInput.txt is input of DNASequencing
11) DNASequencingOutput.txt is ouput of DNASequencing
12) ZipCodeLookupInput.txt is input of ZipCodeLookupOutput
13) ZipCodeLookupOutput.txt is ouput of ZipCodeLookupOutput
14) PieceOfCakeInput.txt is input of PieceOfCakeInput
15) PieceOfCakeOutput.txt is ouput of PieceOfCakeInput


2. How to compile the project
This project is maven project. So make sure you have installed maven and used maven to build the project for the first time.


３.Ideas about all the questions as following
-----------------------------------------------
question1 : Most Appropriate Facility
1). I have interface ClosestCopartRule, all other rule Class implement method getClosestCopartFacility(String id, String zipcode).
class ClosestCopartRuleBasedOnDB is for the rule Based on DB.  (the rule could be implement in method getClosestCopartFacility)
class ClosestCopartRuleBasedOnEngine is for the rule Based on Engine.(the rule could be implement in method getClosestCopartFacility)
2). CusterFromDBAPI is used for loading Customer Information　and caching Customer Information. Here I use singleton pattern. there are two reasons:
first we just need one CusterFromDBAPI instance all the time. second it could save time, we just load all data one time, then use it all time.
CusterFromDBAPI contains a Map<String , Customer> customerMap,  key of map is customer id, value of the map is Customer Instance.
readDataFromDB method is used to load Customer information from file System.

3) Customer class represent a customer, Customer have attribute such as id, zipcode and ClosestCopartRule which is the rule the customer could specify.　
4) MostAppropriateFacility class is my application, String getClosestCopartFacility(String id, String zipcode) is the interface, which input is customer id and US zipcode, return value is Most Appropriate Copart Facility.

-----------------------------------------------
question2: Zip Code Lookup
1) main idea of my solution is to send http request to Google api then parse json format string replied from Google, then parse city and state name from formatted_address.
2) getHTML method is used to send http to google server to look up zip code.
3) getAddressFromJson method is used to parse json format string replied from Google and to get city and state name.

-----------------------------------------------
question３:　DNA　Sequencing   
1) time complexity : O(n)
2) getLongestSubstring method is api, input is a string.
return the length of a a longest substring of the the nucleotide.
variable start is used to mark the begin of current rep.
At the beginning of the code, start is initialized to 0, then we go through the char in the input String, 
if the char is not equal to the value at start position, then we should get the length of the current substring. the we compare the length with the max of length. then update max and start.

-----------------------------------------------
question4: Piece Of Cake
1) time complexity : O(1)
2) main idea of this solution is that square has minimum perimeter given area of rectangle. But for this question, the width and length should be integer.
Then the result should be in the top two nearest to the sqrt(area). Of course, the two pairs should be valid pairs. which means both of them are pairs of Integer.
Then choose the minimum perimeter.