package com.company;

public class Transition {
    private Node next;
    private char letter;


    public Transition(Node next, char letter) {
        this.next = next;
        this.letter = letter;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void display(){
        System.out.print("transition : " + letter + " | " + "to : ");
        next.display();
    }
}
