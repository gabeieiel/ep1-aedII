public class PathFinder {
    private DirectedGraph   graph;
    private SimpleList      atualCaminho;
    private MyHashTable     visited;

    public PathFinder(DirectedGraph graph) {
        this.graph          = graph;                    // vértice visitado (v.v.)    
        this.atualCaminho   = new SimpleList();         // caminho em construção
        this.visited        = new MyHashTable(100);
    }

    
    public void findAllPaths(String source, String target) {
        visited         = new MyHashTable(100);     // reinicia marcações
        atualCaminho    = new SimpleList();         // reinicia caminho
        dfs(source, target);                        // dfs a partir de source
    }

    private void dfs(String atual, String target) {
        visited.put(atual, true);               // v.v.
        atualCaminho.add(atual);                // adiciona ao caminho atual

        if (atual.equals(target)) {   // caminho completo encontrado
            print_atualCaminho();                   
        }
        
        else {
            SimpleList vizinhos = graph.getAdj(atual);  // vizinhos de atual
            if (vizinhos != null) {

                for (String vizinho : vizinhos) {

                    if (!visited.contains(vizinho))
                        dfs(vizinho, target);    // explora vizinho
                    
                }
            }
        }

        visited.put(atual, false);              // desmarca para permitir novos caminhos
        atualCaminho.removeFirst();             // remove da trilha atual
    }

    private void print_atualCaminho() {
        SimpleList.IteratorType it = atualCaminho.new IteratorType();

        boolean first = true;

        while (it.hasNext()) {
            if (!first) System.out.print(" -> ");

            System.out.print(it.next());

            first = false;
        }
        
        System.out.println();
    }
}
