import jdk.javadoc.internal.doclets.formats.html.markup.Header;

public class Pilha{

    private class Node{
       Integer element;
       Node next;
       Node prev;
       public Node (Integer element){
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

    public int pop(){
        if(count == 0) throw new IndexOutOfBoundsException();
        
        Node last = trailer.prev;

        trailer.prev = last.prev;
        last.prev.next = trailer;
        count--;

        return last.element;
    }

    public void push(Integer element){
        Node newNode = new Node(element);
        Node last = trailer.prev;

        newNode.prev = last;
        newNode.next = trailer;
        last.next = newNode;
        trailer.prev = newNode;

        count ++;
    }

    public int top(){
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