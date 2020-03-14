package graph.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import graph.Node;

public class DFSStrategy extends AbstractSearch {

	@Override
	public List<Node> findRoute(String from, String to, Map<String, Node> nodes) {
		System.out.println("Buscando ruta "+from+" -> "+to+" por el método DFS");
		
		Node startNode = nodes.get(from);
		Node finishNode = nodes.get(to);
		List<Node> route = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (startNode == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (finishNode == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		if (buscarRutaDFS(route, startNode, finishNode)) {
			return route;
		} else {
			return null;
		}
	}

	private boolean buscarRutaDFS(List<Node> route, Node startNode, Node finishNode) {
		// agrega el origen
		route.add(startNode);
		
		// origen y destino son el mismo ?
		if(startNode.getName().equals(finishNode.getName())){
            return true;
        }
		
		// si no son el mismo, revise las rutas usando una pila
        Stack<Node> stackNodes = new Stack<>();
        ArrayList<Node> visitedNodes = new ArrayList<>();

        stackNodes.add(startNode);

        while(!stackNodes.isEmpty()){
            Node actual = stackNodes.pop();

            // ignore los nodos ya visitados
            if (visitedNodes.contains(actual))
            	continue;
            
            // es el nodo que estamos buscando ?
            if (actual.equals(finishNode)) {
            	route.addAll(stackNodes);
            	route.add(finishNode);
                return true;
            }
            else {
                // siga buscando en las rutas no visitadas
            	visitedNodes.add(actual);
            	for(Node node: actual.getNodosAdyacentes()) {
            		if (!stackNodes.contains(node))
            			stackNodes.add(node);
            	}
            }
        }
        return false;
	}

	
}
