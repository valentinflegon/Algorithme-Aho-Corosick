package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Automaton {
    private ArrayList<Node> arrayOfNode;
    public ArrayList<Character> arrayOfValidWord = new ArrayList<>();
    public ArrayList<String> arrayText = new ArrayList<>();
    private ArrayList<validPos> arrayOfValidPos;
    private Node initialNode;

    public Automaton(){
        arrayOfNode = new ArrayList<>();
        arrayOfValidPos = new ArrayList<>();
        initialNode = new Node(false, 0);
        arrayOfNode.add(initialNode);
    }

    public void addWord(String word){
        int     currentNode = 0,
                sizeOfArrayOfNode = arrayOfNode.size();

        for (int currentLetter = 0; currentLetter != (word.length()); currentLetter++){ //parcours du mots
            if (isExistTransition(arrayOfNode.get(currentNode), word.charAt(currentLetter))) {
                currentNode = arrayOfNode.indexOf(getNextNode(arrayOfNode.get(currentNode), word.charAt(currentLetter)));
            }else {
                arrayOfNode.add(new Node(false, currentLetter+sizeOfArrayOfNode));
                arrayOfNode.get(currentNode).addTransition(new Transition(arrayOfNode.get(arrayOfNode.size()-1), word.charAt(currentLetter)));
                currentNode = arrayOfNode.size()-1;
            }
        }
        arrayOfNode.get(currentNode).setFinal(true);
    }

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

    public ArrayList<String> readText() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("c:/text.txt"));
        String line;
        int i=0;
        while ((line = in.readLine()) != null){
            arrayText.add(line);
        }
        in.close();
        return arrayText;
    }

    public int findIndexOfTransition(char l,Node noeudCourant) {
        int p = 0;
        for (int k = 0; k < noeudCourant.sizeArrayOfTransition(); k++) {
            if (l != noeudCourant.getLetterOfTransition(k)) {
                p++;
            }
            else{
                return p;
            }
        }
        if (p == noeudCourant.sizeArrayOfTransition()) {
            return -1;
        }
        return -1;
    }

    public void search(ArrayList<String> arrayText){
        for (int z=0;z<arrayText.size();z++){
            char lettreCourante;
            Node noeudCourant = initialNode;
            for(int i=0;i < arrayText.get(z).length(); i++) {
                lettreCourante = arrayText.get(z).charAt(i);
                int k = findIndexOfTransition(lettreCourante, noeudCourant);// retourne la position dans l'arraylist de la transition si il y en a pas retourne -1
                if (k == -1){ //pas de transition
                    noeudCourant = initialNode;
                    arrayOfValidWord.clear();//vider arrayOfValidKeyWord
                }
                else { //transition trouvé
                    arrayOfValidWord.add(lettreCourante);
                    noeudCourant = noeudCourant.getNodeOfTransition(k);
                    if (noeudCourant.isFinal()) {
                        System.out.print("mot valide : ");
                        for (int j = 0; j < arrayOfValidWord.size(); j++) { //afficher l'arrayOfValidWord
                            System.out.print(arrayOfValidWord.get(j));
                        }
                        System.out.println("");
                        int firstIndex =  i-arrayOfValidWord.size();
                        System.out.println("LIGNE : " +z);
                        System.out.println("POSITION :" + firstIndex + " to " + i  );
                        arrayOfValidPos.add(new validPos(z, firstIndex+1, i+1));
                    }
                }
            }
        }
        display();
    }

    public ArrayList<validPos> getArrayOfValidPos() {
        return arrayOfValidPos;
    }
}
