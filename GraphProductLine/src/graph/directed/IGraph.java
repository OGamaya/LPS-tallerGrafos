package graph.directed;

import java.util.List;

import graph.Node;

public interface IGraph {
	public int countArcs();
	
	public void addNode(String name);
	public void addArc(String from, String to);
	public void addArc(String from, String to, int wight);
	public boolean existRoute(String from, String to);
	public Node findNode(String name);
	public List<Node> findRoute(String form, String to);
}
