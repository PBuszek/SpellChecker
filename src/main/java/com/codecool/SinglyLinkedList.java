package com.codecool;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class SinglyLinkedList {
    private StringNode head;

    public SinglyLinkedList() {
    }

    public String access(int index) {
        StringNode node = getNodeAtIndex(index);
        return node.getValue();
    }

    private StringNode getNodeAtIndex(int index){
        StringNode node = head;
        for (int i = index; i > 0; i--){
            node = node.getNext();
        }
        return node;
    }

    public int search(String value) {
        if (head == null) return -1;
        StringNode node = head;
        int index = 0;
        if (node.getValue().equals(value)) {
            return index;
        }
        while (node.getValue().equals(value)) {
            node = node.getNext();
            index++;
            if (node.getValue().equals(value)) {
                return index;
            }
        }
        return -1;
    }

    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        StringNode elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        StringNode elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    public void insert(String value) {
        if (head == null) {
            head = new StringNode(value);
        } else {
            StringNode previousNode = getLastElement();
            StringNode node = new StringNode(value);
            node.setNext(previousNode.getNext());
            previousNode.setNext(node);
        }
    }

    private StringNode getLastElement(){
        StringNode node = head;
        while (!(node.next == null)){
            node = node.getNext();
        }
        return node;
    }

    public void insert(int index, String value) {
        if (head == null) {
            head = new StringNode(value);
        } else if (index == 0) {
            StringNode second = head;
            head = new StringNode(value);
            head.setNext(second);
        } else {
            StringNode previousNode = getNodeAtIndex(index - 1);
            StringNode node = new StringNode(value);
            node.setNext(previousNode.getNext());
            previousNode.setNext(node);
        }
    }
}
