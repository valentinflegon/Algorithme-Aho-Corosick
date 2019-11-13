package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe Automaton
 */
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
    
    /**
     * Fonction qui va lire et retourner le texte stocké dans arrayText
     * via un BufferReader
     */
    public ArrayList<String> readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("c:/text.txt"));
        String line;
        while ((line = in.readLine()) != null){
            arrayText.add(line);
        }
        in.close();
        return arrayText;
    }
    
    /**
     * Fonction qui va parcourir toutes les transitions du noeudCourant
     * et les comparer avec letter
     *
     * @param letter
     * @param noeudCourant
     *
     * @return -1 si la transition n'est pas trouvé
     * ou retourne  "compteur" l'indexe dans la liste
     * des transitions si elle existe
     */
    public int findIndexOfTransition(char letter,Node currentNode) {
        int compteur = 0;
        for (int indexPosition = 0; indexPosition < currentNode.sizeArrayOfTransition(); indexPosition++) {
            if (letter != currentNode.getLetterOfTransition(indexPosition)) {
                compteur++;
            }
            else{
                return compteur;
            }
        }
        if (compteur == currentNode.sizeArrayOfTransition()) {
            return -1;
        }
        return -1;
    }
    
    /**
     * Fonction de recherche qui prend en entrée un liste contenant les lignes
     * du texte. On va parcourir chaque ligne et lui appliquer le programme expliqué
     * ci-dessous.
     * Nous allons stocker la lettre courante et lui faire se deplacer jusqu'a la fin de
     * la ligne, un appel a la methode vu juste avant findIndexOfTransition
     * va nous permettre de savoir si il existe une transition correspondant a la
     * lettreCourante ou non.
     * Si elle n'existe pas (return -1) alors le noeud courant retourne à l'etat 0
     * et nous supprimons la liste des mots valides.
     * En revanche si il existe une transition alors nous allons la stocker
     * dans la liste des mots valides et faire se deplacer le noeud courant a la
     * position du nouveau noeud, celui qui suit la transition.
     * Si ce noeud est final alors nous l'affichons et recuperons sont indexe de position
     * ainsi que sa ligne
     *
     * @param arrayText
     */
    public void search(ArrayList<String> arrayText){
        for (int indexOfLine=0;indexOfLine<arrayText.size();indexOfLine++){
            char letterCourante;
            Node noeudCourant = initialNode;
            for(int indexOfPositionLine=0;indexOfPositionLine < arrayText.get(indexOfLine).length(); indexOfPositionLine++) {
                letterCourante = arrayText.get(indexOfLine).charAt(indexOfPositionLine);
                int indexOfTransition = findIndexOfTransition(letterCourante, noeudCourant);
                if (indexOfTransition == -1){
                    noeudCourant = initialNode;
                    arrayOfValidWord.clear();
                }
                else {
                    arrayOfValidWord.add(letterCourante);
                    noeudCourant = noeudCourant.getNodeOfTransition(indexOfTransition);
                    if (noeudCourant.isFinal()) {
                        System.out.print("mot valide : ");
                        for (int j = 0; j < arrayOfValidWord.size(); j++) {
                            System.out.print(arrayOfValidWord.get(j));
                        }
                        System.out.println("");
                        int firstIndex =  indexOfPositionLine-arrayOfValidWord.size();
                        System.out.println("LIGNE : " +indexOfLine);
                        System.out.println("POSITION :" + firstIndex + " to " + indexOfPositionLine  );
                        arrayOfValidPos.add(new validPos(indexOfLine , firstIndex+1, indexOfPosition+1));
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
