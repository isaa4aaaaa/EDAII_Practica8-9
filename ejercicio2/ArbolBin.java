
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

    public void preFija(Nodo r){
        if(r!=null){
            visit(r);
            if(r.izq!=null){
                preFija(r.izq);
            }
            if(r.der!=null){
                preFija(r.der);
            }
        }
    }


    public void inFija(Nodo r){
        if(r!=null){
            if(r.izq!=null){
                inFija(r.izq);
            }
            visit(r);
            if(r.der!=null){
                inFija(r.der);
            }
        }

    }

     public void posFija(Nodo r){
        if(r!=null){
            if(r.izq!=null){
                posFija(r.izq);
            }
            if(r.der!=null){
                posFija(r.der);
            }
            visit(r);
        }
    }
    


}
