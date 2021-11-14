package collections;

public class LinkedList {
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setLink(node2);
        node2.setLink(node3);
        node3.setLink(node4);
        node4.setLink(node5);


        new LinkedList().reverseOrder(node1);
        new LinkedList().printNode(node1);

    }

    private void printNode(Node node){
        System.out.println(node.getVal());
        if(node.getLink() != null){
            printNode(node.getLink());
        }
    }

    private void reverseOrder(Node node){
        Node nextNode = node;
        Node currentNode = null;
        Node preNode = null;
        while(nextNode != null){
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.link;
            currentNode.link = preNode;
        }
    }
}

class Node{
    Node link;
    int val;

    Node(int val){
        this.val = val;
    }

    public void setLink(Node link){
        this.link = link;
    }

    public Node getLink(){
        return this.link;
    }

    public int getVal(){
        return this.val;
    }
}
