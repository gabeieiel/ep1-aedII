import java.util.Iterator;

public class SimpleList implements Iterable<String> {
    private static class Node {
        String value;
        Node next;
    }

    private Node head;

    public void add(String value) {
        Node novo_node = new Node();
        novo_node.value = value;
        novo_node.next = head;
        head = novo_node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    /* esse tipo permite a utilização do for each na classe */
    @Override
    public Iterator<String> iterator() { return new IteratorType();}

    public class IteratorType implements Iterator<String> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            
            String value = current.value;
            current = current.next;
            
            return value;
        }
    }
}