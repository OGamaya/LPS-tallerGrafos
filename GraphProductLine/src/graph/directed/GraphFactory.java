package graph.directed;

import graph.search.AbstractSearch;
import graph.search.BFSStrategy;
import graph.search.DFSStrategy;
import properties.PropertyManager;

public class GraphFactory {

	public static IGraph instanceGraph() {
		IGraph gd = null;
		AbstractSearch search = null;
		
		if (PropertyManager.getProperty("DFS")) {
			search = new DFSStrategy();
		} else if (PropertyManager.getProperty("BFS")) {
			search = new BFSStrategy();
		}
	
		if (PropertyManager.getProperty("Directed")) {
			gd = new SimpleGraph(search);
		} else if (PropertyManager.getProperty("Undirected")) {
			gd = new UndirectedGraphDecorator(new SimpleGraph(search));
		}
		return gd;
	}
}
