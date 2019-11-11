# Algorithme Aho-Corosick Java

## Description du projet 
L'algorithme d'Aho-Corasick est un algorithme de recherche de chaîne de caractères (ou motif) dans un texte dû à Alfred Aho et Margaret Corasick et publié en 1975. L'algorithme consiste à avancer dans une structure de données abstraite appelée dictionnaire qui contient le ou les mots recherchés en lisant les lettres du texte une par une.
  Il a été demandé de mettre en place la structure de données et de programmer cet algorithmepour cela nous avons réaliser une phase de prétraitement (qui va crée un automate avec les mots clé rentés), la lecture du fichier à analyser, l’identification des motsclés (grâce au porcours de l'automate avec une methode) et une interface en JavaFX


## Explication de la structure de données Nodes / Path 


## Phase de pretraitement création des nodes etc 

## Lecture du fichier a analyser 

## Identifications des mots clés

## Affichage d’une interface conviviale
La classe "validPos" permet de sauvegarder la ligne et les positions de depart de fin des mots valides.

Le FXML "MainPane" nous permet l'affichage graphique du programme.
Le FXML est controlé par la classe "MainPane"
il est composé :
	- D'une zone de text permettant l'entrée de mots recherché par l'utilisateur.
	- D'un bouton permettant l'envoie du mots precedement ecrit vers le BackEnd.
	- D'une liste de mots recherché
	- D'une liste de ligne du ficher texte

La classe "MainPane" permet le controle du FXML. Lorsque l'utilisateur appuie sur le bouton "search" le programme effectura l'ajout du mot entrée par l'utilsateur dans un liste de mots recherché. 
Si le mots est deja present dans cette liste alors le programme effectura sa suppresion. la classe effectura egalement la lecture et l'affichage du texte dont les mots valides sont encapsulé.

* Java 8 nécessaire pour faire fonctionner le JavaFx


11/11/2019
Travail Réaliser par Matthieu Edelmann & Valentin Flegon
