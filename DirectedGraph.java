public class DirectedGraph {
    private MyHashTable adj;

    public DirectedGraph() {
        adj = new MyHashTable(20);
    }

    public void addEdge(String from, String to) {
        SimpleList vizinhos;

        if (adj.contains(from)) {
            vizinhos = (SimpleList) adj.get(from);
        }
        
        else {
            SimpleList vizinhos = new SimpleList();
            adj.put(from, neighbours);
        }

        vizinhos.add(to);
    }

    public SimpleList getAdj(String v) {
        if (adj.contains(v)){
            return v.value;
        }
        
        return null;
    }

    public boolean containsVertex(String v) {
        return adj.contains(v);
    }
}