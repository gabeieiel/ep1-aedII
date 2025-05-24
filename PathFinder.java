public class PathFinder {
    private DirectedGraph graph;
    private MyHashTable visited;
    private MyHashTable edgeTo;
    private String start;

    public PathFinder(DirectedGraph graph) {
        this.graph      = graph;
        this.visited    = new MyHashTable(100);
        this.edgeTo     = new MyHashTable(100); // armazena o caminho percorrido
    }

    public boolean hasPath(String from, String to) {
        this.start  = from;
        visited     = new MyHashTable(100); // reinicia marcações
        edgeTo      = new MyHashTable(100); // reinicia o rastreamento de caminho

        dfs(from);
        return visited.contains(to);
    }

    private void dfs(String v) {
        visited.put(v, true);
        
        SimpleList vizinhos = graph.getAdj(v);  // vizinhos de v

        if (vizinhos != null) {
            for (String w : vizinhos) {
                if (!visited.contains(w)) {
                    edgeTo.put(w, v);   //  alcançado a partir de v
                    dfs(w);
                }
            }
        }
    }

    public SimpleList pathTo(String to) {
        if (!visited.contains(to)) return null; // não há caminho se "to" não foi visitado

        SimpleList path = new SimpleList();     // lista do caminho de volta

        for (String x = to; !x.equals(start); x = (String) edgeTo.get(x)) {
            path.add(x);
        }
        path.add(start);
        return path;
    }
}
