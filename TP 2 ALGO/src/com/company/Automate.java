package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;

public class Automate {

   public ArrayList<Node> arrayOfNode = new ArrayList<>();
   public ArrayList<String> arrayOfKeyword = new ArrayList<>();
   public ArrayList<String> arrayOfValidWord = new ArrayList<>();
    public String text;



    public Automate() {
        this.arrayOfNode = null;
    }



    public void buildTrie(ArrayList<String> arrayOfKeyword){
        for ( String word:arrayOfKeyword){
            //addWord(word)

        }
    }

    public char curseurNode(ArrayList<Node> nodes,char c){

    }

/*
methode de lecture de text mais qui a chaque fois q'un char n'est pas bon retourne a l'etat 0
il faudra ameliorer ca 

    public void readText( String text){
        for(int i=0;i < text.length();i++){
            if (text.charAt(i) == actualNodeTransition){
               arrayOfValidWord.add(text.charAt(i));
               if (actualNode.isFinal){
                  afficher l'arrayOfValidWord
                  if (actualNodeTransition != text.charAt(i+1)){
                     aller sur Node etat 0
                  }
               }
               i++;
            }
            else {
               aller sur Node etat 0 
               vider arrayOfValidKeyWord;
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


    public void setArrayOfKeyword(String word) {
        arrayOfKeyword.add(word);
    }

    public ArrayList<Node> getArrayOfNode() {
        return arrayOfNode;
    }

    public void printArrayOfKeyword(){
        for (int i=0;i < arrayOfKeyword.size();i++){
            System.out.println(arrayOfKeyword.get(i));
        }
    }
}
