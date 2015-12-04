package queue;

//implement a queue using a singly linked list
public class LinkedListQueue
{
    class Node {

        Node next;
        String data;

        public Node(String data) {
            this.next = null;
            this.data = data;
        }
    }

    Node rootNode;

    public void enqueue(String data) {
        Node currentNode = rootNode;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(data);
    }

    public String dequeue(){
        Node head = rootNode;
        rootNode = rootNode.next;
        return head.data;
    }
}