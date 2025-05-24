import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DirectedGraph graph = new DirectedGraph();

        // leitura do grafo a partir de um arquivo
        try {
            Scanner fileScanner = new Scanner(new File("grafo.txt")); // nome do arquivo com arestas
            while (fileScanner.hasNext()) {
                String from = fileScanner.next();
                String to = fileScanner.next();

                graph.addEdge(from, to);    // adiciona aresta ao grafo
            }
            fileScanner.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            return;
        }


        CycleDetector cd = new CycleDetector(graph);
        if (cd.hasCycle()) {
            System.out.println("O grafo possui ciclos.");
        }
        
        else {
            System.out.println("O grafo NÃO possui ciclos.");
        }

        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o vértice de origem: ");
        String source = input.next();
        
        System.out.print("Digite o vértice de destino: ");
        String target = input.next();

        input.close();

        // imprime todos os caminhos de source para target
        System.out.println("Caminhos de " + source + " para " + target + ":");
        PathFinder pf = new PathFinder(graph);
        pf.findAllPaths(source, target);
    }
}
