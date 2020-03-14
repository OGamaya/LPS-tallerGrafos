package graph;

public class Arc {
	private Node from;
	private Node to;
	
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "Arc [from=" + from + ", to=" + to + "]";
	}
}
