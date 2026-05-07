package assignment4;
import java.util.*;
public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances;
    public DijkstraSearch() {
        distances = new HashMap<>();
    }
    public List<Vertex<V>> findPath(Vertex<V> start, Vertex<V> target) {
        if (start.equals(target)) {
            List<Vertex<V>> path = new ArrayList<>();
            path.add(start);
            return path;
        }
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(start, 0.0); // приоритетная очередь по расстоянию
        visited.add(start);
        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            double currentDist = distances.getOrDefault(current, Double.POSITIVE_INFINITY);
            if (current.equals(target)) {
                return reconstructPath(target);
            }
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = currentDist + weight;
                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    } else { // если уже в очереди, обновляем приоритет (удаляем и добавляем заново)
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return null;
    }
}