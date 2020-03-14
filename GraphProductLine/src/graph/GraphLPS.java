package graph;

import graph.directed.GraphFactory;
import graph.directed.IGraph;
import properties.PropertyManager;

public class GraphLPS {
	
	public static void main(String[] args) {
		IGraph g = GraphFactory.instanceGraph();
		
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");

		
		if (PropertyManager.getProperty("Weighted")) {
			g.addArc("A", "B", 2);
			g.addArc("B", "C", 5);
			g.addArc("A", "C", 6);
		} else if (PropertyManager.getProperty("Unweight")) {
			g.addArc("A", "B");
			g.addArc("B", "C");
			g.addArc("A", "C");
		}
		
		System.out.println(String.format("Se crearon %d arcos en total", g.countArcs()));
		System.out.println(g.existRoute("A", "C")); 
	}	

}
