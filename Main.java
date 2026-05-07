package assignment4;

// Main.java
public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");// Создаём вершины
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        a.addAdjacentVertex(b, 4); // Добавляем рёбра (неориентированный граф для примера)
        a.addAdjacentVertex(c, 2);
        b.addAdjacentVertex(a, 4);
        b.addAdjacentVertex(c, 1);
        b.addAdjacentVertex(d, 5);
        c.addAdjacentVertex(a, 2);
        c.addAdjacentVertex(b, 1);
        c.addAdjacentVertex(d, 8);
        c.addAdjacentVertex(e, 10);
        d.addAdjacentVertex(b, 5);
        d.addAdjacentVertex(c, 8);
        d.addAdjacentVertex(e, 2);
        e.addAdjacentVertex(c, 10);
        e.addAdjacentVertex(d, 2);

        WeightedGraph<String> graph = new WeightedGraph<>();// Создаём граф и добавляем вершины
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();// BFS (без учёта весов)
        System.out.println("BFS путь от A до E: " + bfs.findPath(a, e));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(); // Dijkstra (с учётом весов)
        System.out.println("Dijkstra путь от A до E: " + dijkstra.findPath(a, e));
    }
}