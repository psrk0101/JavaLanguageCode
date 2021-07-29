package collections;

public class LinkedList {
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);

        new LinkedList().printNode(node1);

    }

    private void printNode(Node node){
        System.out.println(node.getVal());
        if(node.getNextNode() != null){
            printNode(node.getNextNode());
        }
    }

    private void reverseOrder(Node node){

    }
}

class Node{
    Node nextNode;
    int val;

    Node(int val){
        this.val = val;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public int getVal(){
        return this.val;
    }
}
