public class Pruebas {
    public static void main(String[] args) {
        Nodo root = new Nodo(15);
        Nodo n9 = new Nodo(9); 
        Nodo n20 = new Nodo(20); 
        Nodo n6 = new Nodo(6); 
        Nodo n14 = new Nodo(14);
        Nodo n13 = new Nodo(13);
        Nodo n17 = new Nodo(17);
        Nodo n64 = new Nodo(64);
        Nodo n26 = new Nodo(26);
        Nodo n72 = new Nodo(72);

        ArbolBinBusq arbol = new ArbolBinBusq(root); 
        arbol.add(n9, n9, 0);
        arbol.add(n20, n20, 0);
        arbol.add(n6, n6, 0);
        arbol.add(n14, n14, 0);
        arbol.add(n13, n13, 0);
        arbol.add(n17, n17, 0);
        arbol.add(n64, n64, 0);
        arbol.add(n26, n26, 0);
        arbol.add(n72, n72, 0);

        System.out.println("BFS del árbol binario de búesqueda: ");
        arbol.breadthFrist();

        System.out.println("\nEliminación de la hoja de clave 72");
        arbol.eliminarNodo(n72);
        System.out.println("BFS del árbol después de la eliminación de la hoja de clave 72");
        arbol.breadthFrist(); 

        System.out.println("\nEliminación del nodo intermedio de clave 9");
        arbol.eliminarNodo(n9);
        System.out.println("BFS del árbol después de la eliminación del nodo intermedio de clave 9");
        arbol.breadthFrist(); 

        System.out.println("\nEliminación de la raíz");
        arbol.eliminarNodo(root);
        System.out.println("BFS del árbol después de la eliminación de la raíz");
        arbol.breadthFrist(); 
        

    }
}
