package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Path p0 = new Path(n0, n1,'a');
        Path p1 = new Path(n1, n2,'b');
        
        System.out.println( p1.getPrevious().getIndice());
        System.out.println( p1.getValue());
        System.out.println( p1.getNext().getIndice());

        String value;
        Scanner sc;
        do {
            System.out.println();
            System.out.println();
            System.out.print("ajouter valeur : ");
            sc = new Scanner(System.in);
            value = sc.nextLine();
        }while (true);
    }
}

