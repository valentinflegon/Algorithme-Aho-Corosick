package com.company;

import java.util.ArrayList;

public class Node {
    private ArrayList<Path> pathArrayList = new ArrayList<>();
    private boolean isFinal;
    private int indice;


    public Node(boolean isFinal, int indice) {
        this.pathArrayList = new ArrayList<>();
        this.isFinal = isFinal;

    }

    public void addPath(Path path){
        pathArrayList.add(path);
    }

    public ArrayList<Path> getPathArrayList() {
        return pathArrayList;
    }

    public void setPathArrayList(ArrayList<Path> pathArrayList) {
        this.pathArrayList = pathArrayList;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }


    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }


}
