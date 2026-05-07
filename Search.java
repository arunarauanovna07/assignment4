package assignment4;
import java.util.*;
public abstract class Search<V> {
    protected Map<Vertex<V>, Vertex<V>> parent;
    protected Set<Vertex<V>> visited;
    public Search() {
        parent = new HashMap<>();
        visited = new HashSet<>();
    }
    public abstract List<Vertex<V>> findPath(Vertex<V> start, Vertex<V> target);
    protected List<Vertex<V>> reconstructPath(Vertex<V> target) {
        List<Vertex<V>> path = new LinkedList<>();
        Vertex<V> current = target;

        while (current != null) {
            path.add(0, current);
            current = parent.get(current);
        }
        return path;
    }
}
