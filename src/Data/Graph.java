package Data;

import java.util.*;


/**
 * Implements a graph. 
 * We use two maps: one map for adjacency properties and tracking investments(adjancencyMap) 
 * and one map (dataMap) to keep track of the Company data. 
 * 
 * @author Jacqueline Deprey
 */

public class Graph<E> {
	
	private HashMap<String, HashMap<String, Investment>> adjacencyMap;
	private HashMap<String, Company> dataMap;


	//initializes the Graph object
	public Graph(){

		adjacencyMap = new HashMap<String, HashMap<String, Investment>>();
		dataMap = new HashMap<String, Company>();
	}

	//adds or updates a company's investment in another company
	public void addInvestment(String investor, String receiver, Investment investment){

		adjacencyMap.get(investor).put(receiver, investment);
		//dataMap.get(investor).investments.add(adjacencyMap.get(receiver));
	}

	//adds a Company to the graph
	public void addCompany(String companyName, Company companyData){

		adjacencyMap.put(companyName, new HashMap<String, Investment>());
		dataMap.put(companyName, companyData);
	}

	//returns a map with information about investments associated with the company passed in
	public Map<String, Investment> getInvestments(String companyName){

		return adjacencyMap.get(companyName);
	}

	//returns the amount invested from one company into another
	public double getInvestmentAmount(String startVertexName, String endVertexName){

		return adjacencyMap.get(startVertexName).get(endVertexName).amount;
	}

	//returns a set with all the companies that have been added
	public Set<String> getCompanies(){

		return adjacencyMap.keySet();
	}

	//returns a string with information about the graph of companies
	@Override
	public String toString(){

		String toReturn = "Companys: ";

		ArrayList<String> companyNames = new ArrayList<String>();
		companyNames.addAll(adjacencyMap.keySet());
		companyNames.sort(String.CASE_INSENSITIVE_ORDER);

		toReturn += companyNames.toString();
		toReturn += "Investments:\n";

		//goes through all the vertices and adds their edge information
		for(String name: companyNames){

			toReturn += "Company(" + name + ")--->";

			ArrayList<String> investmentCompanies = new ArrayList<String>();
			investmentCompanies.addAll(adjacencyMap.get(name).keySet());
			investmentCompanies.sort(String.CASE_INSENSITIVE_ORDER);

			toReturn += "{";
			int last = investmentCompanies.size();

			//goes through all the end vertices and adds their edge information
			for(String end: investmentCompanies){

				toReturn += end + "=" + adjacencyMap.get(name).get(end);

				//checks to see if a comma needs to be added after the edge
				if(last != 1){

					toReturn += ", ";
					last--;
				}
			}

			toReturn += "}\n";
		}

		return toReturn;
	}
	
	private class Company{
		
		String name;
		Set<Company> investors;
		Set<Company> investments;
		
		/*can include other fields like company type, size, location, etc. if wanted*/
	}
	
	private class Investment{

		double amount;
		Company investee; //will link to company that is receiving the money
		Company investor; //will link to company that is spending the money
		
	}

	/*Functions Needed: addCompany, addInvestment*/
}
