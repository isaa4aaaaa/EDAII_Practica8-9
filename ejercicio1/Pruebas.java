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
        
        //Se crea la estructura del árbol 
        Nodo n5 = new Nodo(5); 
        Nodo n2 = new Nodo(2); 
        Nodo n3 = new Nodo(3, n5, n2);
        Nodo n4 = new Nodo(4);
        Nodo root = new Nodo(5, n3, n4); 

        //Se crea el árbol con la estructura de nodos creada 
        ArbolBin arbol = new ArbolBin(root);

        //PRUEBAS EN EL PRIMER ÁRBOL 
        System.out.println("BFS en el primer árbol de prueba");
        arbol.breadthFrist();

        /*//Se busca un valor en el árbol
        int x = 10; 
        System.out.println("\nBuscando el valor " + x + " en el árbol binario\n");
        if(arbol.search(x)) System.out.println(x  + " se encuentra contenido en el árbol");
        else System.out.println(x + " no se encuentra contenido en el árbol binario\n");*/

        //Se elimina el nodo hoja 5
        arbol.eliminarNodo(n5);
        System.out.println("BFS en el primer árbol de prueba después de eliminar el nodo hoja 5");
        arbol.breadthFrist();

        //Se elimina el nodo raíz
        arbol.eliminarNodo(root);
        System.out.println("BFS en el primer árbol de prueba después de eliminar la raíz");
        arbol.breadthFrist();




        //Se crea un segundo árbol con más nodos para hacer más pruebas 
        Nodo N72 = new Nodo(72); 
        Nodo N73 = new Nodo(73); 
        Nodo N66 = new Nodo(66);
        N66.setDer(N73);
        Nodo N85 = new Nodo(85); 
        N73.setDer(N72);
        Nodo N75 = new Nodo(75, N66, N85); 
        Nodo N2 = new Nodo(2); 
        Nodo N14 = new Nodo(14); 
        N14.setIzq(N2);
        Nodo N54 = new Nodo(54); 
        Nodo N42 = new Nodo(42, N14, N54); 
        Nodo ROOT = new Nodo(60, N42, N75); 

        ArbolBin arbol2 = new ArbolBin(ROOT); 


        //PRUEBAS CON EL SEGUNDO ARBOL
        System.out.println("PRUEBAS EN EL SEGUNDO ÁRBOL");
        arbol2.breadthFrist();
        System.out.println("BFS en el segundo árbol de prueba después de eliminar la raíz");
        arbol2.eliminarNodo(ROOT);
        arbol2.breadthFrist();

        System.out.println("Búsqueda del valor 85 en el árbol: " + arbol2.search(85));
        System.out.println("Búsqueda del valor 23 en el árbol: " + arbol2.search(23));
        

    }

    
}

