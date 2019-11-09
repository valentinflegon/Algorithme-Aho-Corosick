package com.company;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Automaton {
    private ArrayList<Node> arrayOfNode;
    public ArrayList<String> arrayOfKeyword = new ArrayList<>();
    public ArrayList<String> arrayOfValidWord = new ArrayList<>();
    public String text;
    private Node initialNode;

    public Automaton(){
        arrayOfNode = new ArrayList<>();
        initialNode = new Node(false, 0);
        arrayOfNode.add(initialNode);
    }

    public void addWord(String word){
        int     currentNode = 0,
                sizeOfArrayOfNode = arrayOfNode.size();

        for (int currentLetter = 0; currentLetter != (word.length()); currentLetter++){
            // System.out.println(currentLetter +"  eee   "+ (word.length()+sizeOfArrayOfNode));
            if (isExistTransition(arrayOfNode.get(currentNode), word.charAt(currentLetter))) {
               // System.out.println( arrayOfNode.indexOf(getNextNode(arrayOfNode.get(currentNode), word.charAt(currentLetter))));
                currentNode = arrayOfNode.indexOf(getNextNode(arrayOfNode.get(currentNode), word.charAt(currentLetter)));
            }else {
                //System.out.println("is not exist");
                //System.out.println("currentNode" + currentNode + "new node"+(arrayOfNode.size()-1)+"   "+(currentLetter+1));
                arrayOfNode.add(new Node(false, currentLetter+sizeOfArrayOfNode));
                arrayOfNode.get(currentNode).addTransition(new Transition(arrayOfNode.get(arrayOfNode.size()-1), word.charAt(currentLetter)));
                currentNode = arrayOfNode.size()-1;
            }
        }
        arrayOfNode.get(currentNode).setFinal(true);
    }
    /*
    public void addWord(String word){
        int     cursor = 0,
                sizeOfArrayOfNode = arrayOfNode.size();

        for (int i = sizeOfArrayOfNode; i != (word.length()+sizeOfArrayOfNode); i++){
            // System.out.println(i +"  eee   "+ (word.length()+sizeOfArrayOfNode));
            if (isExistTransition(arrayOfNode.get(cursor), word.charAt(i))) {
                System.out.println("ise exote");
                cursor = arrayOfNode.indexOf(getNextNode(arrayOfNode.get(cursor), word.charAt(i)));
            }else {
                //if (i <= 0) i = 1;
                System.out.println("cursor" + cursor + "new node"+(arrayOfNode.size()-1)+"   "+i);
                arrayOfNode.add(new Node(false, i));
                arrayOfNode.get(cursor).addTransition(new Transition(arrayOfNode.get(i), word.charAt(i-1)));
                cursor = i;
            }
        }
    }*/

    public boolean isExistTransition(Node node, char letter){
        return node.getTransition(letter) != null;
    }

    public Node getNextNode(Node actualNode, char letter){
        return actualNode.getTransition(letter).getNext();
    }

    public void display(){
        System.out.println("initialNode :");
        for (Node node : arrayOfNode){
            node.display();
            for (Transition transition : node.getArrayOfTransition()) {
                transition.display();
            }
            System.out.println();
        }
    }
    /*

        public void readText( String text){
        
            char lettreCourante;
            Node noeudCourant = arrayOfNode().get(0);
            for(int i=0;i < text.length();i++){
                
                lettreCourante = text.charAt(i);
                
                if (lettreCourante == noeudCourant.transition ){
                   arrayOfValidWord.add(lettreCourante);
                   if (noeudCourant.isFinal){
                      //afficher l'arrayOfValidWord
                      for (int j=0; j<arrayOfValideWord.size();j++)
                      {
                           System.out.println(arrayOfValidWord.get(j));
                       }
                      if (noeudCourant.transition != text.charAt(i+1)){
                         aller sur Node etat 0
                      }
                   }
                   // on va sur la transition
                   noeudCourant = noeudCourant.transition.nextNode;
                   i++;
                }
                else {
                   noeudCourant = arrayOfNode().get(0);
                   //vider arrayOfValidKeyWord
                   arrayOfValidKeyWord.clear();
                   i++;
                }
             }
        }
    */

    public void readText( String text){
        for(int i=0;i < text.length();i++){
            text.charAt(i);

            System.out.print(text.charAt(i));
        }
    }

    public ArrayList<Node> getArrayOfNode() {
        return arrayOfNode;
    }

    public void setArrayOfNode(ArrayList<Node> arrayOfNode) {
        this.arrayOfNode = arrayOfNode;
    }

    public void addNode(Node node){
        arrayOfNode.add(node);
    }

    public void setArrayOfKeyword(String word) {
        arrayOfKeyword.add(word);
    }

    public void printArrayOfKeyword(){
        for (int i=0;i < arrayOfKeyword.size();i++){
            System.out.println(arrayOfKeyword.get(i));
        }
    }
}
