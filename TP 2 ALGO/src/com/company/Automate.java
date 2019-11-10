package com.company;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Automaton {
    private ArrayList<Node> arrayOfNode;
    public ArrayList<String> arrayOfKeyword = new ArrayList<>();
    public ArrayList<Character> arrayOfValidWord = new ArrayList<>();
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
    
    public String readText() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("c:/text.txt"));
    String line;
    while ((line = in.readLine()) != null)
    {
        return line;
        // Afficher le contenu du fichier
      //  System.out.println (line);
    }
    in.close();
    return line;
}

    public int findIndexOfTransition(char l,Node noeudCourant) {
        int p = 0;
        for (int k = 0; k < noeudCourant.sizeArrayOfTransition(); k++) {
            if (l != noeudCourant.getLetterOfTransition(k)) {
                //System.out.println(p);
                p++;
            }
            else{
                //System.out.println(p);
                return p;
            }
        }
        if (p == noeudCourant.sizeArrayOfTransition()) {
            //System.out.println("pas de transition");
            return -1;
        }
        return -1;

    }

    public void recherche( String text){
        char lettreCourante;
        Node noeudCourant = initialNode;
        for(int i=0;i < text.length(); i++) {
            //System.out.println("i : "+i);
            lettreCourante = text.charAt(i);
            //System.out.println(" lettre courante : " + lettreCourante);
            int k = findIndexOfTransition(lettreCourante, noeudCourant);// retourne la position dans l'arraylist de la transition si il y en a pas retourne -1
             if (k == -1){ //pas de transition
                 noeudCourant = initialNode;
                 //System.out.println("index node : "+ noeudCourant.getIndice());
                 arrayOfValidWord.clear();                 //vider arrayOfValidKeyWord
             }
             else { //transition trouvé
                 //System.out.println("transion de la lettre courante : "+ noeudCourant.getLetterOfTransition(k));
                     arrayOfValidWord.add(lettreCourante);
                     noeudCourant = noeudCourant.getNodeOfTransition(k);
                     if (noeudCourant.isFinal()) {
                         System.out.print("mot valide : ");
                         for (int j = 0; j < arrayOfValidWord.size(); j++) { //afficher l'arrayOfValidWord
                             System.out.print(arrayOfValidWord.get(j));

                         }
                         /*if(findIndexOfTransition(lettreCourante,noeudCourant)==-1){
                             noeudCourant = initialNode;
                             System.out.println("ici");
                         }*/
                         System.out.println("");
                         int firstIndex =  i-arrayOfValidWord.size();
                         System.out.println("POSITION :" + firstIndex + " to " + i  );
                 }
             }
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

