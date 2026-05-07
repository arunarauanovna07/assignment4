package assignment4;
import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public List<Vertex<V>> findPath(Vertex<V> start, Vertex<V> target) {
        if (start.equals(target)) {
            List<Vertex<V>> path = new ArrayList<>();
            path.add(start);
            return path;
        }
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        parent.put(start, null);
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    if (neighbor.equals(target)) {
                        return reconstructPath(target);
                    }
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }
}
