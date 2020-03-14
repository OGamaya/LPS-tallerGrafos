package graph.directed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graph.Arc;
import graph.Node;
import graph.search.AbstractSearch;
import graph.wight.ArcProvider;
import graph.wight.WightArc;

public abstract class AbstractGraph implements IGraph {
	protected Map<String, Node> nodes;
	protected List<Arc> arcs;
	protected AbstractSearch search;

	public AbstractGraph(AbstractSearch search) {
		nodes = new HashMap<String, Node>();
		arcs = new LinkedList<>();
		this.search = search;
	}

	@Override
	public void addNode(String name) {
		Node n = new Node(name);
		nodes.put(name, n);
	}

	@Override
	public void addArc(String from, String to) {
		Arc a = new Arc();
		arcHelper(a, from, to);
	}
	@Override
	public void addArc(String from, String to, int wight) {
		WightArc a = ArcProvider.instanceWightArc();
		arcHelper(a, from, to);
		a.setWight(wight);
	}
	
	private void arcHelper(Arc a, String from, String to) {
		Node startNode = findNode(from);
		Node endNode = findNode(to);
		a.setFrom(startNode);
		a.setTo(endNode);	
		startNode.addArc(a);
		arcs.add(a);
	}

	@Override
	public boolean existRoute(String form, String to) {
		if (findRoute(form, to) != null) {
			return true;
		}
		return false;
	}
		
	@Override
	public Node findNode(String name) {
		return nodes.get(name);
	}

	@Override
	public List<Node> findRoute(String form, String to) {
		return search.findRoute(form, to, nodes);
	}
	@Override
	public int countArcs() {
		return arcs.size();
	}
}
