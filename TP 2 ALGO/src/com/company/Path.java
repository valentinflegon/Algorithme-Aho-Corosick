package com.company;

public class Path {
    private Node previous, next;
    private char value;


    public Path(Node previous, Node next, char value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
        previous.addPath(this);
        next.addPath(this);
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
