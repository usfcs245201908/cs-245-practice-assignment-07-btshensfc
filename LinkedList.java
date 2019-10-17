@SuppressWarnings("unchecked")
public class LinkedList<T> implements List<T>{

    private Node start = null;
    private int size = 0;

    private class Node<T>{
    	private T data;
    	private Node next;

    	public Node(T item){
    		data = item;
    		next = null;
    	}
    }

    public void add(T item){
        if (start == null){
            start = new Node(item);
            size++;
        } else {
            Node before = start;
            while (before.next != null){
                before = before.next;
            }
            Node newest = new Node(item);
            before.next = newest;
            size++;
        }
    }

    public void add(int pos, T item){
        if (pos < 0 || pos > size){
            throw new RuntimeException();
        }
        if (pos == 0){
            start = new Node(item);
            size++;
        } else {
            Node now = new Node(item);
            Node before = start;
            for (int i = 0; i< pos-1; i++) {
                before = before.next;
            }
            now.next = before.next;
            before.next = now;
            size++;
        }
    }
    public T get(int pos) {
        if (pos < 0 || pos >= size)
            throw new RuntimeException();
        Node before = start;
        for (int i = 0; i < pos; i++) {
            before = before.next;
        }
        return (T)before.data;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size)
            throw new RuntimeException();

        if (pos == 0){
            T item = (T) start.data;
            start = start.next;
            size--;
            return item;
        } else {
            Node before = start;
            for (int i = 0; i < pos-1; i++){
                before = before.next;
            }
            Node now = before.next;
            T item = (T) now.data;
            before.next = now.next;
            size--;
            return item;
        }
    }

    public int size() {
        return size;
    }
}

