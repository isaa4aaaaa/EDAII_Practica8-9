import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinBusq extends ArbolBin{
    public ArbolBinBusq(Nodo root){
        super(root); 
    }

    @Override
    public void add(Nodo nodoInsertar, Nodo parNoNecesario, int parNoNecesario2) {
        //Se busca la posición del nuevo nodo siguiendo la lógica de un árbol binario de búsqueda
        //El hijo izquierdo de un nodo es menor y el hijo derecho es mayor

        Queue<Nodo> queue = new LinkedList<>();
        queue.add(root); 
        
        while(!queue.isEmpty()) {
            Nodo aux = queue.poll(); 
            if(aux.getValor() > nodoInsertar.getValor()) {
                //si el valor a insertar es menor al nodo y este no tiene hijo izquierdo se inserta en esa posición
                if(aux.izq == null) aux.setIzq(nodoInsertar);
                else {
                    //en caso contrario se continúa avanzando hasta llegar a la posición del nodo a insertar
                    queue.add(aux.izq); 
                }
            }
            else if(aux.getValor() < nodoInsertar.getValor()) {
                //si el valor a insertar es mayor al nodo y este no tiene hijo derecho se inserta en esa posición
                if(aux.der == null) aux.setDer(nodoInsertar);
                else {
                    //en caso contrario se continúa avanzando hasta llegar a la posición del nodo a insertar
                    queue.add(aux.der); 
                }
            }
            //si el valor del nodo a insertar es igual a uno que ya existe en el árbol no se realiza la inserción
            else {
                return; 
            }
        }
    }

    @Override
    public void eliminarNodo(Nodo nodoAEliminar) {
        Nodo padre = getPadreNodo(nodoAEliminar);

        //si el nodo es una hoja se elimina directamente
        if(nodoAEliminar.izq == null && nodoAEliminar.der == null) {
            if(padre.izq == nodoAEliminar) padre.izq = null; 
            else padre.der = null; 
        }
        //si el nodo es un nodo intermedio se remplaza por el nodo más a la derecha del subárbol izquiero
        // o el nodo más a la izquierda del subárbol derecho según convenga 
        else {
            Nodo nodoMasDerecha = getNodoMasDerecha(nodoAEliminar); 
            Nodo nodoMasIzquierda = getNodoMasIzquierda(nodoAEliminar); 


            //Si alguno de los nodos es una hoja se sistituye por esa para facilitar la eliminación
            if(nodoMasDerecha.izq == null && nodoMasDerecha.der == null) {
                Nodo padreNodoMasDerecha = getPadreNodo(nodoMasDerecha);

                //Se remplaza el nodo a eliminar con el nodo sustituto 
                if(nodoAEliminar == root) {
                    nodoMasDerecha.setIzq(root.izq);
                    nodoMasDerecha.setDer(root.der);
                    root = nodoMasDerecha; 
                }
                else if(padre.der == nodoAEliminar) {
                    nodoMasDerecha.setIzq(padre.der.izq);
                    nodoMasDerecha.setDer(padre.der.der);
                    padre.der = nodoMasDerecha; 
                }
                else {
                    nodoMasDerecha.setIzq(padre.izq.izq);
                    nodoMasDerecha.setDer(padre.izq.der);
                    padre.izq = nodoMasDerecha;
                }  
                if(nodoMasDerecha == nodoMasDerecha.izq) nodoMasDerecha.izq = null; 
                if(nodoMasDerecha == nodoMasDerecha.der) nodoMasDerecha.der = null; 

                //Se elimina el nodo hoja sustituto 
                if(padreNodoMasDerecha.izq == nodoMasDerecha) padreNodoMasDerecha.izq = null; 
                else padreNodoMasDerecha.der = null;    
            }
            else if (nodoMasIzquierda.izq == null && nodoMasIzquierda.der == null) {
                Nodo padreNodoMasIzquierda = getPadreNodo(nodoMasIzquierda);

                if(nodoAEliminar == root){
                    nodoMasIzquierda.setIzq(root.izq);
                    nodoMasIzquierda.setDer(root.der);
                    root = nodoMasIzquierda;
                }
                else if(padre.der == nodoAEliminar){
                    nodoMasIzquierda.setIzq(padre.der.izq);
                    nodoMasIzquierda.setDer(padre.der.der);
                    padre.der = nodoMasIzquierda;
                }
                else {
                    nodoMasIzquierda.setIzq(padre.izq.izq);
                    nodoMasIzquierda.setDer(padre.izq.der);
                    padre.izq = nodoMasIzquierda;
                }

                if(nodoMasIzquierda == nodoMasIzquierda.izq) nodoMasIzquierda.izq = null; 
                if(nodoMasIzquierda == nodoMasIzquierda.der) nodoMasIzquierda.der = null; 

                //Se elimina la hoja sustituta 
                if(padreNodoMasIzquierda.izq == nodoMasIzquierda) padreNodoMasIzquierda.izq = null;
                else padreNodoMasIzquierda.der = null;
            }
            //Si ninguno de los nodos es una hoja se sustituye por el nodo del subárbol izquierdo  
            //más derecha y se realiza una llamada recursiva para eliminar el nodo que fue usado
            //para sustituir 
            else {
                nodoAEliminar = nodoMasDerecha;
                eliminarNodo(nodoMasDerecha);
            }
        }
    }
}