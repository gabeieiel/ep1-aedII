public class MyHashTable {
    private static class Node {
        String key;
        Object value;
        Node next;
    }

    private Node[] table;
    private int capacity;

    public MyHashTable(int capacity) {
        this.capacity = capacity;

        this.table = new Node[capacity];
    }

    private int hash(String key) {
        return key.hashCode();
    }

    public void put(String key, Object value) {
        int point       = hash(key);

        Node keyNode    = table[point]; // primeiro nó da coluna key

        // caso tenha encontrado a chave
        if (contains(key)){
            Object valor = get(key);    // valor da chave na tabela

            // altera o valor da chave
            if (valor != null){
                valor = value;
                return;
            }

            
            // insere um novo valor
            while (keyNode != null){  
                if (keyNode.key == key){
                    keyNode.value = valor;
                    return;
                }
                    
                keyNode = keyNode.next;
            }
        }

        // chave não encontrada
        Node novo_node  = new Node();
        
        novo_node.key   = key;
        novo_node.value = value;
        novo_node.next  = keyNode;
        keyNode         = novo_node;

        return;
    }

    public Object get(String key) {
        int point = hash(key);
        
        Node keyNode = table[point];

        while (keyNode != null && keyNode.key != key){
            keyNode = keyNode.next;
        }

        if (keyNode.key == key) return keyNode;

        return null;
    }

    public boolean contains(String key) {
        if (get(key) == null) return false;
        else return true;
    }
}