package graph.directed;

import graph.search.AbstractSearch;

public class SimpleGraph extends AbstractGraph {
	
	private String name;

	public SimpleGraph(AbstractSearch search) {
		super(search);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
