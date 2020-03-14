package graph.directed;

import java.util.List;

import graph.Node;

public abstract class GraphDecorator implements IGraph {
	
	protected final SimpleGraph graph;
	
	public GraphDecorator(SimpleGraph graph) {
		this.graph = graph;
	}

	@Override
	public void addNode(String name) {
		graph.addNode(name);
	}

	@Override
	public void addArc(String from, String to) {
		graph.addArc(from, to);
	}

	@Override
	public void addArc(String from, String To, int wight) {
		graph.addArc(from, To, wight);
	}
	@Override
	public List<Node> findRoute(String form, String to) {
		return graph.findRoute(form, to);
	}

	@Override
	public boolean existRoute(String form, String to) {
		return graph.existRoute(form, to);
	}
	@Override
	public Node findNode(String name) {
		return graph.findNode(name);
	}
	@Override
	public int countArcs() {
		return graph.countArcs();
	}
}
