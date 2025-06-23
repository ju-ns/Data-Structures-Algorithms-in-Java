import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
    public int getLength(){
        return length;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void printAll(){
        if (length == 0){
            System.out.println("Head: null");
            System.out.println("Tail: null");
        }
        else{
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nLinked List:");
        if(length == 0){
            System.out.println("empty");
        }
        else{
            printList();
        }
    }
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
    public void append(int value){
        Node newNode = new Node (value);
        if(length == 0) {
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }
    public Node removeLast(){
        if(length == 0)return null;
        Node temp = head;
        Node prep = head;
        while(temp.next != null){
            prep = temp;
            temp = prep.next;
        }
        tail = prep;
        tail.next = null;
        length --;

        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }
    public Node get(int index){
        if(index < 0 || index > length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node (value);
        Node temp = get(index -1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length) return removeLast();

        Node prev = get(index -1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            temp = after;
        }
    }
    public Node findMiddleNode(){
        if(head == null) return null;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public boolean hasLoop(){
        if(head == null) return false;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
    public Node findKthFromEnd(int k){
        Node fast = head;
        Node slow = head;
        for(int i = 0; i < k; i++){
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void removeDuplicates(){
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while(current != null){
            if(values.contains(current.value)){
                previous.next = current.next;
                length -= 1;
            }
            else{
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }
    public int binaryToDecimal(){
        int num = 0;
        Node current = head;
        while(current != null){
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }
    public void partitionList(int x){
        if(head == null) return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        while(current != null){
            if(current.value < x){
                prev1.next = current;
                prev1 = current;
            }
            else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }
    public void reverseBetween(int startIndex, int endIndex){
        if(head == null) return;
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
        for(int i = 0; i < startIndex; i++){
            previousNode = previousNode.next;
        }
        Node currentNode = previousNode.next;
        for(int i = 0; i < endIndex - startIndex; i++){
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
        head = dummyNode.next;
    }
    public void swapPairs(){
        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;
        Node first = head;
        while(first != null && first.next != null){
            Node second = first.next;
            previous.next = second;
            first.next = second.next;
            first.next = second.next;
            second.next = first;
            previous = first;
            first = first.next;
        }
        head = dummy.next;
    }
}
