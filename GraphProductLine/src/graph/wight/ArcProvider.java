package graph.wight;

import graph.Arc;
import properties.PropertyManager;

public class ArcProvider {
	
	public static Arc instanceArc () {
		if (PropertyManager.getProperty("Unweight")) {
			return new Arc();
		} else {
			throw new UnsupportedOperationException();
		}
	}
	public static WightArc instanceWightArc () {
		if (PropertyManager.getProperty("Weighted")) {
			return new WightArc();
		} else {
			throw new UnsupportedOperationException();
		}
	}

}
