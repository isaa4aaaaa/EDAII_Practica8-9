
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
    
    public Queue<Nodo> breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    return queue;
    }

    /*public void eliminar(Nodo nodo, Nodo padre, int lado){
        if (nodo.izq == null && nodo.der == null){
            if(lado == 0){
                padre.izq = null;
            } else {
                padre.der = null;
            }
        }

        if(nodo.izq != null || nodo.der != null){
            if(nodo.der == null){
                if(lado == 0){
                    padre.izq = nodo.izq;
                } else {
                    padre.der = nodo.izq;
                }
            }
            if(nodo.izq == null){
                if(lado == 0){
                    padre.izq = nodo.der;
                } else {
                    padre.der = nodo.der;
                }
            }

            if(lado == 0){
                padre.izq = nodo.der;
            } else {
                padre.der = nodo.der;
            }

        }
    }

    public void eliminar(Nodo nodo){
        Queue<Nodo> lista = new LinkedList();
        if(nodo == this.root){
            lista = breadthFrist();
            int ind = lista.lastIndexOf(Nodo);
            Nodo temp = lista.get(ind);
            Nodo padre = lista.get(ind-ind/2);
            nodo = temp;
            padre.izq = null;
            padre.der = null;
        } else if(nodo.izq == null && nodo.der == null){

        }else if(nodo.izq != null || nodo.der != null){

        }
    }*/


}
