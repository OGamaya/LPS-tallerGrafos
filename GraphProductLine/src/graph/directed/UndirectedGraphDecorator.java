package graph.directed;

public class UndirectedGraphDecorator extends GraphDecorator {

	public UndirectedGraphDecorator(SimpleGraph graph) {
		super(graph);
	}
	
	@Override
	public void addArc(String from, String to) {
		super.addArc(from, to);
		super.addArc(to, from);
	}
	@Override
	public void addArc(String from, String to, int wight) {
		super.addArc(from, to, wight);
		super.addArc(to, from, wight);
	}
}
