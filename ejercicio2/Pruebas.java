/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Pruebas {
    
    public static void main(String args[]){
        ArbolBin arbol;
        
        Nodo n9 = new Nodo(9);
        Nodo n15 = new Nodo(15);
        Nodo n4 = new Nodo(4);
        Nodo n20 = new Nodo(20);
        Nodo n18 = new Nodo(18);
        Nodo n55 = new Nodo(55);
        Nodo n41 = new Nodo(41);
        Nodo n14 = new Nodo(14);
        Nodo n50 = new Nodo(50);
        Nodo n40 = new Nodo(40);
        Nodo n19 = new Nodo(19);
        Nodo n10 = new Nodo(10,n15,n4);
     
        
        arbol = new ArbolBin(n10);
        arbol.add(n15,n20,0);
        arbol.add(n15,n18,1);
        arbol.add(n4,n55,1);
        arbol.add(n18,n9,1);
        arbol.add(n9,n41,0);
        arbol.add(n9,n14,1);
        arbol.add(n55,n50,0);
        arbol.add(n55,n40,1);
        arbol.add(n50,n19,0);

        System.out.println("BFS: ");
        arbol.breadthFrist();
        System.out.println("");

        System.out.println("Preorden: ");
        arbol.preFija(arbol.root);
        System.out.println("");

        System.out.println("Inorden: ");
        arbol.preFija(arbol.root);
        System.out.println("");

    }

    
}

