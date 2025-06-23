public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(10);
        System.out.println("Inicial:");
        myList.printAll();

        // Teste append
        myList.append(20);
        myList.append(30);
        System.out.println("\nApós append(20), append(30):");
        myList.printAll();

        // Teste prepend
        myList.prepend(5);
        System.out.println("\nApós prepend(5):");
        myList.printAll();

        // Teste removeFirst
        LinkedList.Node removedFirst = myList.removeFirst();
        System.out.println("\nremoveFirst(): " + removedFirst.value);
        myList.printAll();

        // Teste removeLast
        LinkedList.Node removedLast = myList.removeLast();
        System.out.println("\nremoveLast(): " + removedLast.value);
        myList.printAll();

        // Teste get e set
        System.out.println("\nget(1): " + myList.get(1).value);
        System.out.println("set(1, 99): " + myList.set(1, 99));
        myList.printAll();

        // Teste insert
        myList.insert(1, 15);
        System.out.println("\nApós insert(1, 15):");
        myList.printAll();

        // Teste remove
        LinkedList.Node removed = myList.remove(1);
        System.out.println("\nremove(1): " + removed.value);
        myList.printAll();

        // Teste reverse
        myList.reverse();
        System.out.println("\nApós reverse():");
        myList.printAll();

        // Teste findMiddleNode
        LinkedList.Node middle = myList.findMiddleNode();
        System.out.println("\nMiddle node: " + (middle != null ? middle.value : "null"));

        // Teste findKthFromEnd
        LinkedList.Node kth = myList.findKthFromEnd(1);
        System.out.println("\n1st node from end: " + (kth != null ? kth.value : "null"));

        // Teste removeDuplicates
        myList.append(99);
        myList.append(20);
        myList.append(10);
        System.out.println("\nAntes de removeDuplicates():");
        myList.printAll();
        myList.removeDuplicates();
        System.out.println("Após removeDuplicates():");
        myList.printAll();

        // Teste binaryToDecimal (criar nova lista binária)
        LinkedList binaryList = new LinkedList(1);
        binaryList.append(0);
        binaryList.append(1);
        binaryList.append(1);
        System.out.println("\nBinary to Decimal (1011): " + binaryList.binaryToDecimal());

        // Teste partitionList
        LinkedList partitionList = new LinkedList(3);
        partitionList.append(5);
        partitionList.append(8);
        partitionList.append(5);
        partitionList.append(10);
        partitionList.append(2);
        partitionList.append(1);
        System.out.println("\nAntes do partitionList(5):");
        partitionList.printAll();
        partitionList.partitionList(5);
        System.out.println("Após partitionList(5):");
        partitionList.printAll();

        // Teste reverseBetween
        LinkedList reverseList = new LinkedList(1);
        reverseList.append(2);
        reverseList.append(3);
        reverseList.append(4);
        reverseList.append(5);
        System.out.println("\nAntes de reverseBetween(1, 3):");
        reverseList.printAll();
        reverseList.reverseBetween(1, 3);
        System.out.println("Após reverseBetween(1, 3):");
        reverseList.printAll();

        // Teste swapPairs
        LinkedList swapList = new LinkedList(1);
        swapList.append(2);
        swapList.append(3);
        swapList.append(4);
        System.out.println("\nAntes de swapPairs():");
        swapList.printAll();
        swapList.swapPairs();
        System.out.println("Após swapPairs():");
        swapList.printAll();

        // Teste hasLoop (manual)
        System.out.println("\nTeste de hasLoop(): " + myList.hasLoop());
    }
}