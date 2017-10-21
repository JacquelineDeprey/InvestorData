package Data;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * Parses data from a .csv file and passes it into a directed graph.
 * The vertices of the graph are companies and the edges are the investments.
 * 
 * @author James Gu
 * @author Jacqueline Deprey
 */

@SuppressWarnings("serial")
public class Investment extends DefaultWeightedEdge {
	
	double amount;
	Company investor; //will link to company that is spending the money
	Company investee; //will link to company that is receiving the money
	
	public Investment(Company investor, Company investee, double amount) {
		this.investor = investor;
		this.investee = investee;
		this.amount = amount;
	}
	
	@Override
	public double getWeight() {
		return amount;
	}
}
