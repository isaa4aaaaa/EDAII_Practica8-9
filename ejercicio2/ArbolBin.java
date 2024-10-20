
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.print(n.valor+" ");
    }	
    
    public void breadthFrist(){
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
    }

    
    /*
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

    public void preFija(Nodo r){
        boolean visitado = false;
        if(r.izq != null){
            if(!visitado){
                visit(r);
                visitado = true;
            }

            preFija(r.izq);
        }
        if(r.der != null){
            if(!visitado){
                visit(r);
                visitado = true;
            }

            preFija(r.der);
        }
        if(r.izq == null && r.der == null){
            if(!visitado){
                visit(r);
                visitado = true;
            }
        }
    }

    public void inFija(Nodo r){
        Queue<Nodo> pila = new LinkedList();

        pila.add(r);

        while(!pila.isEmpty()){
            if(r.izq != null){
                inFija(r.izq);
            }else if(r.izq == null && r.der == null){
                Nodo v = (Nodo)pila.poll();
                visit(v);
            }else if(r.der != null){
                inFija(r.der);
            }
        }
    }

    public void posFija(){
        

        
    }


}
