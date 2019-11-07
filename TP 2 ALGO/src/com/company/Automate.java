package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;

public class Automate {

   public ArrayList<Node> arrayOfNode = new ArrayList<>();
   public ArrayList<String> arrayOfKeyword = new ArrayList<>();
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


    public void readText( String text){
        //text.substring(0,1);
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
