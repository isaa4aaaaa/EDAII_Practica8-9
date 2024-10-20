
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    Nodo root;
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	
    
    public void breadthFrist(){
        Nodo r = root;

	    Queue<Nodo> queue = new LinkedList<>();

	    if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                visit(r);
                if(r.izq!=null) queue.add(r.izq);
                if(r.der!=null) queue.add(r.der);
            }
	    }
    }

    public Nodo getPadreNodo(Nodo nodo){
        Nodo r = root;

	    Queue<Nodo> queue = new LinkedList<>();

	    if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                
                //se verifica si r es el padre del nodo 

                if(r.izq!=null) {
                    queue.add(r.izq);
                    if(r.izq == nodo) return r; 
                }
                if(r.der!=null) {
                    queue.add(r.der);
                    if(r.der == nodo) return r; 
                }
            }
	    }

        //si no se encuentra el nodo padre se regresa el mismo nodo
        return nodo; 
    }

    public static Nodo getNodoMasDerecha(Nodo nodo){
        //se busca en el subárbol izquierdo el nodo más a la derecha 
        Nodo r = nodo.izq;

       Queue<Nodo> queue = new LinkedList<>();

       if(r!=null){
           queue.add(r);
           while(!queue.isEmpty()){
                r = (Nodo)queue.poll();

               if(r.der != null) queue.add(r.der); 
               //else if (r.izq != null) queue.add(r.izq); 
           }
       }

       //si no se encuentra el nodo padre se regresa el mismo nodo
       return r; 
   }


   public static Nodo getNodoMasIzquierda(Nodo nodo){
        //se busca en el subárbol izquierdo el nodo más a la derecha 
        Nodo r = nodo.der;

        Queue<Nodo> queue = new LinkedList<>();

        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                    r = (Nodo)queue.poll();

                if(r.izq != null) queue.add(r.izq); 
                //else if (r.der != null) queue.add(r.der); 
            }
        }

        //si no se encuentra el nodo padre se regresa el mismo nodo
        return r;    
    }   

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
                    padre.izq = nodoMasIzquierda;
                }  

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

    /**
     * 
     * @param x: el número a buscar. 
     * @return true, si x está contenido en el árbol o false si x no está contenido en el árbol. 
     */
    public Boolean search(int  x) {
        Boolean xFound = false;  
        Nodo r = root;

	    Queue<Nodo> queue = new LinkedList<>();

	    if(r!=null){
            queue.add(r);
            while(!queue.isEmpty() ){
                r = (Nodo)queue.poll();
                if(r.valor == x) return true; 
                if(r.izq!=null) queue.add(r.izq);
                if(r.der!=null) queue.add(r.der);
            }
	    }
        return xFound; 
    }

}
