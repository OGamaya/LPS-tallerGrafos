package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
	
	private String name;

	private List<Arc> arcs = new LinkedList<>();

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addArc(Arc a) {
		return arcs.add(a);
	}

	public List<Node> getNodosAdyacentes() {
		List<Node> nodes = new ArrayList<>();
		for (Arc arc : arcs) {
			nodes.add(arc.getTo());
		}
		return nodes;
	}
	
}
