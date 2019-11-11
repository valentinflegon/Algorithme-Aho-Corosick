# Algorithme Aho-Corosick Java
### Devoir n°2 
### Reconnaissance de mots-clés  

## Description du projet 
L'algorithme d'Aho-Corasick est un algorithme de recherche de chaîne de caractères (ou motif) dans un texte dû à Alfred Aho et Margaret Corasick et publié en 1975. L'algorithme consiste à avancer dans une structure de données abstraite appelée dictionnaire qui contient le ou les mots recherchés en lisant les lettres du texte une par une.
  Il a été demandé de mettre en place la structure de données et de programmer cet algorithmepour cela nous avons réaliser une phase de prétraitement (qui va crée un automate avec les mots clé rentés), la lecture du fichier à analyser, l’identification des motsclés (grâce au porcours de l'automate avec une methode) et une interface en JavaFX


## Explication de la structure de données Nodes / Path 
* La classe Node permet de représenter les Etats de l'automate, chaque noeud a pour attribut une liste de transition de type Transition qui permet de faire le lien entre chaque noeud. On peut également savoir si ses noeuds sont finaux ou non et d'un indice. 
De nombreuses méthodes sont implémentées mais elles sont plutot classique ce sont uniquement des getter & setter afin de récuperer les atttributs.

* La classe Transition représente les arcs de transitions entre chaque noeud et ont pour attribut une lettre (lettre sur laquel la transition est faite) et un Node next qui représente le noeud vers lequel va cette transition.

## Phase de pretraitement création des nodes etc 
* La classe "Automaton" possède une fonction nommée "addWord" qui prend en entrée une String qui est composé du mot a integrer dans la structure. cette fonction est composé d'un noeud courrant et d'une lettre courrante.tout d'abord le programme recherche l'existance d'un transition composé de la lettre courante a partir du noeud courrant. si lorsqu'une transition est existante alors nous ne creont pas de noeud et attribuons le prochain noeud au noeud courrant. sinon nous créont la transition composé de la lettre courrant et créont un nouveau noeud qui sera attrubuer au noeud courrant.

## Lecture du fichier a analyser 

* Pour la lecture du texte nous utilisons simplement un BufferRead et une arrayList, 
chaque ligne sera lu et ajouté à la liste, tant que cela n'est pas null.
Et retourne cette liste rempli avec le texte.

## Identifications des mots clés

* findIndexOfTransition cette fonction va parcourir toutes les transitions du noeud courant et les comparer avec la lettre courante. Retourne -1 si la transition n'est pas trouvé ou retourne  "compteur" l'indexe dans la liste des transitions si elle existe.
     

*  La méthode search cette fonction de recherche prend en entrée un liste contenant les lignes du texte. On va parcourir chaque ligne et lui appliquer le programme expliqué ci-dessous.
Nous allons stocker la lettre courante et lui faire se deplacer jusqu'a la fin de
la ligne, un appel à la methode vu juste avant findIndexOfTransition va nous permettre de savoir si il existe une transition correspondant à la lettre courante ou non.
Si elle n'existe pas (return -1) alors le noeud courant retourne à l'etat 0 et nous supprimons la liste des mots valides.
En revanche si il existe une transition alors nous allons la stocker dans la liste des mots valides et faire se deplacer le noeud courant à la position du nouveau noeud, celui qui suit la transition. Si ce noeud est final alors nous l'affichons et recuperons sont indexe de position ainsi que sa ligne.

## Affichage d’une interface conviviale

* La classe "validPos" permet de sauvegarder la ligne et les positions de depart de fin des mots valides.

Le FXML "MainPane" nous permet l'affichage graphique du programme.
Le FXML est controlé par la classe "MainPane"
il est composé :
	- D'une zone de text permettant l'entrée de mots recherché par l'utilisateur.
	- D'un bouton permettant l'envoie du mots precedement ecrit vers le BackEnd.
	- D'une liste de mots recherché
	- D'une liste de ligne du ficher texte

* La classe "MainPane" permet le controle du FXML. Lorsque l'utilisateur appuie sur le bouton "search" le programme effectura l'ajout du mot entrée par l'utilsateur dans un liste de mots recherché. 
Si le mots est deja present dans cette liste alors le programme effectura sa suppresion. la classe effectura egalement la lecture et l'affichage du texte dont les mots valides sont encapsulé.

*** Java 8 nécessaire pour faire fonctionner le JavaFx ***


11/11/2019
Travail Réaliser par Matthieu Edelmann & Valentin Flegon
