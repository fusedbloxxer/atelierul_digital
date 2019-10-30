package main;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);
        list.addElement(2);

        System.out.println(list);	// 4 5 6 2 0 1
        list.reverse();
        System.out.println(list); // 1 0 2 6 5 4
    }
}

// Nodul dintr-o lista
class Node {
    int value;
    Node next;

    Node(int value) {
        this(value, null);
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class List {
    // Capul listei
    private Node head;

    // Inserarea la cap.
    void addElement(int value) {
        head = new Node(value, head);
    }

    // Functie care inverseaza lista.
    void reverse() {
        // Se incepe de la capul listei
        Node current = head;
        // Verific daca lista nu cumva este goala.
        if (current != null) {
            // Cat timp am elemente in dreapta acestui nod, respectiv nod de referinta (initial este capul listei)
            while (current.next != null) {
                Node temporary = current.next; // Retin urmatorul nod.
                current.next = temporary.next; // Leg de referinta urmatorul nod
                temporary.next = head; // Leg nodul temporar la capul listei
                head = temporary; // Acesta este considerat noul cap.
            }
        }
    }

    @Override
    public String toString() {
        // Parcurgerea si afisarea listei.
        Node node = head;
        StringBuilder str = new StringBuilder();
        while (node != null) {
            str.append(node.value).append(" ");
            node = node.next;
        }
        return str.toString();
    }
}