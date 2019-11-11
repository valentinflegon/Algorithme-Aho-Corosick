package com.company;

import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Automaton automate = new Automaton();
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
        automate.recherche(automate.readText());
    }
}
