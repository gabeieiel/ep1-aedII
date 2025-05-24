public class CycleDetector {
    private DirectedGraph graph;
    private MyHashTable visited;
    private MyHashTable onStack;
    private boolean hasCycle;

    public CycleDetector(DirectedGraph graph) {
        this.graph = graph;
        this.visited = new MyHashTable(100);
        this.onStack = new MyHashTable(100);
        this.hasCycle = false;

        for (String vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfs(vertex);
            }
        }
    }

    private void dfs(String v) {
        visited.put(v, true);
        onStack.put(v, true);

        SimpleList vizinhos = graph.getAdj(v);
        if (vizinhos != null) {
            for (String w : vizinhos) {
                if (hasCycle) return;
                if (!visited.contains(w)) {
                    dfs(w);
                } else if (onStack.contains(w)) {
                    hasCycle = true;
                    return;
                }
            }
        }

        onStack.put(v, false);
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
