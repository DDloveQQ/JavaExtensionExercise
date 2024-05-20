package LinkedList;

import java.util.Iterator;

public class Task01 {
    public static void main(String[] args) {
        //高内聚低耦合
        SingleLinked link = new SingleLinked();
        link.add("张三");
        link.add("李四");
        link.add("王五");
        link.add("赵六");

        for (Object o : link) {
            System.out.println(o);
        }
        System.out.println("---------");

        link.reverse();

        for (Object o : link) {
            System.out.println(o);
        }
    }
}

class SingleLinked implements Iterable {
    private class Node {
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node first;

    public void add(Object element) {
        Node node = new Node(element, null);
        if (first == null) {
            first = node;
            return;
        }
        Node tempNode = first;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = node;
    }

    public void reverse() {
        Node curNode = first;
        Node preNode = null;
        Node temp;

        while (curNode != null) {
            temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }
        first = preNode;
    }

    private class ltr implements Iterator {
        Node node = first;
        @Override
        public boolean hasNext() {
            if (node != null) return true;
            return false;
        }

        @Override
        public Object next() {
            Object val = node.data;
            node = node.next;
            return val;
        }
    }

    @Override
    public Iterator iterator() {
        return new ltr();
    }
}