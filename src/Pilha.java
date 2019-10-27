public class Pilha<T>{

    private class Node{
       T element;
       Node next;
       Node prev;
       public Node (T element){
           this.element = element;
           next = null;
           prev = null;
       }
    }

    Node header;
    Node trailer;
    int count;
    
    public Pilha(){
        header = new Node(null);
        trailer = new Node(null);

        header.next = trailer;
        trailer.prev = header;

        count = 0;
    }

    public void push(T element){
        Node newNode = new Node(element);
        Node last = trailer.prev;

        newNode.prev = last;
        newNode.next = trailer;
        last.next = newNode;
        trailer.prev = newNode;

        count ++;
    }
    
    public T pop(){
        if(count == 0) throw new IndexOutOfBoundsException();

        Node last = trailer.prev;

        trailer.prev = last.prev;
        last.prev.next = trailer;
        count--;

        return last.element;
    }

    public T top(){
        return trailer.prev.element;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void clear(){
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
}