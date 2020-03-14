package graph.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import graph.Node;

public class BFSStrategy extends AbstractSearch {

	@Override
	public List<Node> findRoute(String from, String to, Map<String, Node> nodes) {
		System.out.println("Buscando ruta "+from+" -> "+to+" por el método BFS");
		
		
		Node startNode = nodes.get(from);
		Node finishNode = nodes.get(to);
		List<Node> route = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (startNode == null) {
			throw new RuntimeException("Error en la Búsqueda: NodeOrigen no encontrado");
		}
		if (finishNode == null) {
			throw new RuntimeException("Error en la Búsqueda: NodeOrigen no encontrado");
		}
		
		if (buscarRutaBFS(route, startNode, finishNode)) {
			return route;
		} else {
			return null;
		}
	}

   private boolean buscarRutaBFS(List<Node> route, Node startNode, Node finishNode) {
		
		// origen y destino son el mismo ?
		if(startNode.getName().equals(finishNode.getName())){
			System.err.println("Nodo destino encontrado en el mismo nodo origen");
			route.add(startNode);
            return true;
        }
		
		// si no son el mismo, revise las rutas usando una cola
        Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> visitedNodes = new ArrayList<>();
        
        queue.add(startNode);
        visitedNodes.add(startNode);

        while(!queue.isEmpty()){
        	
            Node actual = queue.remove();
            if(actual.equals(finishNode)) {
            	route.add(actual);
                return true;
            }
            else{
                if(actual.getNodosAdyacentes().isEmpty())
                    return false;
                else {
                	for (Node node: actual.getNodosAdyacentes()) {
                		if (!visitedNodes.contains(node))
                			queue.add(node);
                	}
                }
                    
            }
            if (!route.contains(actual))
            	route.add(actual);
        }

        return false;        
	}	
}
