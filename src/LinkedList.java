
public class LinkedList<T> {

    Node head;
    Node tail;

    class Node {

        private T data;
        private Node next;

        private Node() {

        }

        private Node(T val) {
            this.data = val;
        }
    }

    public LinkedList() {

    }

    public Node addNode(T val) {

        Node node = new Node(val);
        if (head == null) {

            node.next = null;
            head = node;
            tail = node;
        } else {

            Node prev = head;

            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = node;
            tail = node;
        }
        return head;
    }

    public Node reverse() {

        if (head == tail) {

        } else {

            Node headTemp = new Node(head.data);
            Node tailTemp = headTemp;
            headTemp.next = null;
            tailTemp.next = null;

            Node next = head.next;
            while (next != null) {
                Node n = new Node(next.data);
                n.next = headTemp;
                headTemp = n;
                next = next.next;
            }
            head = headTemp;
            tail = tailTemp;
        }
        return head;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (head == null) {
            sb.append("[]");
        } else {
            Node prev = head;
            sb.append("[ ").append(prev.data);
            while (prev.next != null) {
                prev = prev.next;
                sb.append(", ").append(prev.data);
            }
            sb.append("]");
        }

        return sb.toString();
    }
}

class Main {

    public static void main(String[] args) {

        LinkedList<Integer> li = new LinkedList<>();
        li.addNode(1);
        li.addNode(8);
        li.addNode(3);
        li.addNode(4);
        li.addNode(99);
        li.addNode(11);
        li.addNode(47);
        System.out.println(li);
        LinkedList<Integer>.Node head = li.reverse();
        System.out.println(li);
    }
}