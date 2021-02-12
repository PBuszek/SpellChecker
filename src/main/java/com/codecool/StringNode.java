package com.codecool;

public class StringNode {
    private final String value;
    public StringNode next;

    StringNode(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    StringNode getNext() {
        return next;
    }

    void setNext(StringNode next) {
        this.next = next;
    }
}
