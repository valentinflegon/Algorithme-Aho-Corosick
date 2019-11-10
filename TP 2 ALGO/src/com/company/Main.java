package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
      Automaton automate = new Automaton();
      System.out.println(automate.readText());
     /*   automate.addWord("teamjul");
        automate.addWord("karris");
        automate.addWord("teamjoel");
        automate.display();
*/
        String value = "0",texte;
        Scanner sc;
        System.out.println("Pour sortir rentrer * ");
        do {
            System.out.print("add keyword : ");
            sc = new Scanner(System.in);
            value = sc.nextLine();
            if (!value.equals("*"))
                automate.addWord(value);
        } while (!value.equals("*"));
       // automate.display();
      //  System.out.print("Rentrer un texte : ");
       // sc = new Scanner(System.in);
      //  automate.text = sc.nextLine();
        //automate.recherche(automate.text);
        automate.recherche(automate.readText());
        // retourne les mots keyword present dans le texte
    }
}
