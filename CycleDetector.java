public class CycleDetector {
    private DirectedGraph   graph;
    private MyHashTable     visited;
    private MyHashTable     onStack;
    private boolean         hasCycle;

    public CycleDetector(DirectedGraph graph) {
        this.graph      = graph;
        this.visited    = new MyHashTable(100);
        this.onStack    = new MyHashTable(100);
        this.hasCycle   = false;
        
        // dfs em todos os vértices não visitados
        for (String vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfs(vertex);
            }
        }
    }

    private void dfs(String v) {
        visited.put(v, true);   // marca o vértice como visitado
        onStack.put(v, true);   // adiciona o vértice à pilha de recursão

        SimpleList vizinhos = graph.getAdj(v);
        if (vizinhos != null) {
            for (String w : vizinhos) {
                if (hasCycle) return;

                if (!visited.contains(w)) {
                    dfs(w);
                }

                else if (onStack.contains(w)) {
                    hasCycle = true;
                    return;
                }
            }
        }

        onStack.put(v, false);  // remove vértice da pilha de recursão
    }

    public boolean hasCycle() {
        return hasCycle;        // retorna se há ciclo
    }
}
