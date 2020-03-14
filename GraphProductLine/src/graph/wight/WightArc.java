package graph.wight;

import graph.Arc;

public class WightArc extends Arc {

	private int wight;
	
	public int getWight() {
		return wight;
	}

	public void setWight(int wight) {
		System.out.println(String.format("Asignado Wight = %d", wight));
		this.wight = wight;
	}

	@Override
	public String toString() {
		return "WightArc [wight=" + wight + ", getFrom()=" + getFrom() + ", getTo()=" + getTo() + "]";
	}

	
}
