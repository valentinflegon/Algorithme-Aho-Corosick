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

        for (int currentLetter = 0; currentLetter != (word.length()); currentLetter++){ //parcours du mot
            if (isExistTransition(arrayOfNode.get(currentNode), word.charAt(currentLetter))) {//si transition deja existante
                currentNode = arrayOfNode.indexOf(getNextNode(arrayOfNode.get(currentNode), word.charAt(currentLetter)));//placement du curseur vers le curseur suivant
            }else {
                arrayOfNode.add(new Node(false, currentLetter+sizeOfArrayOfNode));//nouveau noeud
                arrayOfNode.get(currentNode).addTransition(new Transition(arrayOfNode.get(arrayOfNode.size()-1), word.charAt(currentLetter)));//nouvelle transition
                currentNode = arrayOfNode.size()-1;//placement du curseur vers le nouveau noeud
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
            for (Transition transition : node.getArrayOfTransition()) {//parcours des transitions
                transition.display();
            }
            System.out.println();
        }
    }

    public ArrayList<String> readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("c:/text.txt"));
        String line;
        int i=0;
        while ((line = in.readLine()) != null){
            arrayText.add(line);
        }
        in.close();
        return arrayText;
    }

    public int findIndexOfTransition(char letter, Node currentNode) {
        int p = 0;
        for (int k = 0; k < currentNode.sizeArrayOfTransition(); k++) {
            if (letter != currentNode.getLetterOfTransition(k)) {
                p++;
            }
            else{
                return p;
            }
        }
        if (p == currentNode.sizeArrayOfTransition()) {
            return -1;
        }
        return -1;
    }

    public void search(ArrayList<String> arrayText){
        for (int z=0;z<arrayText.size();z++){
            char currentLetter;
            Node currentNode = initialNode;
            for(int i=0;i < arrayText.get(z).length(); i++) {
                currentLetter = arrayText.get(z).charAt(i);
                int k = findIndexOfTransition(currentLetter, currentNode);// retourne la position dans l'arraylist de la transition si il y en a pas retourne -1
                if (k == -1){ //pas de transition
                    currentNode = initialNode;
                    arrayOfValidWord.clear();//vider arrayOfValidKeyWord
                }
                else { //transition trouvé
                    arrayOfValidWord.add(currentLetter);
                    currentNode = currentNode.getNodeOfTransition(k);
                    if (currentNode.isFinal()) {
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
