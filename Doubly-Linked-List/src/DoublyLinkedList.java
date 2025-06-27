import javax.swing.event.DocumentEvent;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value = value;
        }
    }
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }
    public Node removeLast(){
        if(length == 0) return null;
        Node temp = tail;
        if(length == 0){
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length --;
        return temp;
    }
    public void prepend (int value){
        Node newNode =new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }
        else{
            temp = tail;
            for (int i = length - 1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }
    public boolean set (int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert (int index, int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        Node newNode = new Node (value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index < 0 || index > length) return null;
        if(index == 0) removeFirst();
        if(index == length) return removeFirst();
        if(index == length - 1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;

        length --;
        return temp;
    }
    public boolean isPalindrome(){
        if(length <= 1)return true;
        Node fowardNode = head;
        Node backwardNode = tail;
        for(int i = 0; i < length/2; i++){
            if(fowardNode.value != backwardNode.value) return false;
            fowardNode = fowardNode.next;
            backwardNode = backwardNode = backwardNode.prev;
        }
        return true;
    }
    public void reverse(){
        Node current = head;
        Node temp = null;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;

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
                prev1.next =  current;
                current.prev = prev1;
                prev1 = current;
            }
            else{
                prev2.next = current;
                current.prev = prev2;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        if(dummy2.next != null){
            dummy2.next.prev  = prev1;
        }
        head = dummy1.next;
        if(head != null){
            head.prev = null;
        }
    }

    public void reverseBetween(int startIndex, int endIndex){
        if(head == null || startIndex == endIndex) return;
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;
        for(int i = 0; i < startIndex; i++){
            prev = prev.next;
        }
        Node current = prev.next;
        for(int i = 0; i < endIndex - startIndex; i++){
            Node nodeToMove = current.next;
            current.next = nodeToMove.next;
            if(nodeToMove.next != null){
                nodeToMove.next.prev = current;
            }
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }
        head = dummy.next;
        head.prev = null;
    }

    public void swapPairs(){
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
        while(head != null && head.next != null){
            Node firstNode = head;
            Node secondNode = head.next;
            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            secondNode.prev = previousNode;
            firstNode.prev = secondNode;
            if(firstNode.next != null){
                firstNode.next.prev = firstNode;
            }
            head = firstNode.next;
            previousNode = firstNode;


        }
        head = dummyNode.next;
        if(head != null){
            head.prev = null;
        }

    }


}
