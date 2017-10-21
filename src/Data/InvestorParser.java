package Data;

import org.jgrapht.*;
import org.jgrapht.graph.*;

/**
 * Parses data from a .csv file and passes it into a directed graph.
 * The vertices of the graph are companies and the edges are the investments.
 * 
 * @author James Gu
 * @author Jacqueline Deprey
 */

public class InvestorParser {
	private static DirectedGraph<Company, Investment> graph = 
			new DefaultDirectedGraph<Company, Investment>
			(new ClassBasedEdgeFactory<Company, Investment>(Investment.class));
	
    public static void main(String[] args) {
    	// Just testing adding stuff
    	Company fb = new Company("Facebook");
    	Company meow = new Company("Meow");
    	Investment invest = new Investment(fb, meow, 5);
    	
    	graph.addVertex(fb);
    	graph.addVertex(meow);
    	
    	graph.addEdge(fb, meow, invest);
    	System.out.println(graph.getEdgeWeight(invest));
    }
}
