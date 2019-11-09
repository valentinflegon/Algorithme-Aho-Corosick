package com.company;

import java.util.ArrayList;

public class Node {
    private ArrayList<Transition> arrayOfTransition = new ArrayList<>();
    private boolean isFinal;
    private int indice;


    public Node(boolean isFinal, int indice) {
        this.arrayOfTransition = new ArrayList<>();
        this.isFinal = isFinal;
        this.indice = indice;
    }

    public int sizeArrayOfTransition(){
        return arrayOfTransition.size();
    }
    public void addTransition (Transition transition) {
        arrayOfTransition.add(transition);
    }

    public Transition getTransition(char letter){
        for (Transition transition : arrayOfTransition) {
            if (letter == transition.getLetter()) return transition;
        }
        return null;
    }

    public char getLetterOfTransition(int i) {
        return arrayOfTransition.get(i).getLetter();
    }

    public Node getNodeOfTransition(int i) {
        return arrayOfTransition.get(i).getNext();
    }


    public ArrayList<Transition> getArrayOfTransition() {
        return arrayOfTransition;
    }

    public void setArrayOfTransition(ArrayList<Transition> arrayOfTransition) {
        this.arrayOfTransition = arrayOfTransition;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }


    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void display(){
        System.out.print("Node n°" + getIndice() + " | ");
        if (isFinal)System.out.println("Final");
        else System.out.println("NonFinal");
    }

}

