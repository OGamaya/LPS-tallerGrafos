package graph.search;

import java.util.List;
import java.util.Map;

import graph.Node;

public abstract class AbstractSearch {
	public abstract List<Node> findRoute(String form, String to, Map<String, Node> nodes);
}
