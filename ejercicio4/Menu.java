import java.util.Scanner;

public class Menu {

    Scanner s = new Scanner(System.in);

    public void listarMenu(){

        int op = 0;

        do{
            System.out.println("Seleccione el árbol con el que desea trabajar: ");
            System.out.println("1) Árbol Binario");
            System.out.println("2) Árbol Binario de Búsqueda");
            System.out.println("3) Salir");
            op = s.nextInt();

            switch(op){
                case 1:
                    menuArbol();
                    break;
                case 2:
                    menuArbolBusq();
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Ingresa una opción válida...");
                    break;
            }
        }while(op!=3);

    }

    public void menuArbol(){
        ArbolBin arbol = new ArbolBin();

        int op2 = 0;
       
        do{
            System.out.println("\t--------Árbol Binario--------");
            System.out.println("Seleccione una opción: ");
            System.out.println("1) Crear Árbol");
            System.out.println("2) Agregar dato");
            System.out.println("3) Eliminar dato");
            System.out.println("4) Imprimir Árbol (BFS)");
            System.out.println("5) Notación Prefija (preorden)");
            System.out.println("6) Notación Infija (inorden)");
            System.out.println("7) Notación Postfija (postorden)");
            System.out.println("8) Salir");
            op2 = s.nextInt();

            switch(op2){
                case 1:
                    System.out.println("Ingresa el valor del hijo izquierdo de la raíz: ");
                    int val = s.nextInt();
                    Nodo h1 = new Nodo(val);
                    System.out.println("Ingresa el valor del hijo derecho de la raíz: ");
                    val = s.nextInt();
                    Nodo h2 = new Nodo(val);
                    System.out.println("Ingresa el valor de la raíz: ");
                    val = s.nextInt();
                    Nodo r = new Nodo(val,h1,h2);
                    arbol = new ArbolBin(r);
                    break;
                case 2:
                    Nodo n1 = new Nodo();
                    Nodo n2 = new Nodo();
                    System.out.println("Ingresa el valor del nodo padre: ");
                    val = s.nextInt();
                    do { 
                        if(arbol.search(val)){
                            n1 = arbol.searchNode(val);
                            break;
                        }else{
                            System.out.println("Ingresa un valor presente en el árbol...");
                        }
                    } while (true);
                    System.out.println("Ingresa el valor del nodo hijo: ");
                    val = s.nextInt();
                    if(arbol.search(val)){
                        n2 = arbol.searchNode(val);
                    }else{
                        System.out.println("Ingresa un valor presente en el árbol...");
                    }
                    System.out.println("Ingresa el lado del nodo hijo (izq: 0; der: 1)");
                    int lado = s.nextInt();

                    arbol.add(n1,n2,lado);
                    break;
                case 3:
                    System.out.println("Ingresa el valor del nodo a eliminar: ");
                    arbol.breadthFrist();
                    val = s.nextInt();
                    if(arbol.search(val)){
                        Nodo n = arbol.searchNode(val);
                        System.out.println("Eliminando el nodo...");
                        arbol.eliminarNodo(n);
                    }else{
                        System.out.println("Ingresa un valor presente en el árbol...");
                    }
                    break;
                case 4:
                    arbol.breadthFrist();
                    System.out.println("");
                    break;
                case 5:
                    arbol.preFija(arbol.root);
                    System.out.println("");
                    break;
                case 6:
                    arbol.inFija(arbol.root);
                    System.out.println("");
                    break;
                case 7:
                    arbol.posFija(arbol.root);
                    break;
                case 8:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Ingresa una opción válida...");
                    break;
            }
        }while(op2!=8);
    }

    public void menuArbolBusq(){
        ArbolBinBusq arbolBusq = new ArbolBinBusq(null);
        int op3 = 0;
       
        do{
            System.out.println("\t--------Árbol Binario de Búsqueda--------");
            System.out.println("Seleccione una opción: ");
            System.out.println("1) Crear Árbol");
            System.out.println("2) Agregar dato");
            System.out.println("3) Eliminar dato");
            System.out.println("4) Buscar dato");
            System.out.println("5) Imprimir Árbol (BFS)");
            System.out.println("6) Salir");

            op3 = s.nextInt();
            switch(op3){
            case 1:
                    
                    System.out.println("Ingresa el valor de la raíz: ");
                    int val = s.nextInt();
                    Nodo r = new Nodo(val);
                    arbolBusq = new ArbolBinBusq(r);
                    break;
            case 2:
                    System.out.println("Ingresa el valor del nodo a agregar: ");
                    val = s.nextInt();
                    Nodo m = new Nodo(val);
                    arbolBusq.add(m,m,0);
                    break;
            case 3:
                    System.out.println("Ingresa el valor del nodo a eliminar: ");
                    arbolBusq.breadthFrist();
                    val = s.nextInt();
                    if(arbolBusq.search(val)){
                        Nodo n = arbolBusq.searchNode(val);
                        System.out.println("Eliminando el nodo...");
                        arbolBusq.eliminarNodo(n);
                    }else{
                        System.out.println("Ingresa un valor presente en el árbol...");
                    }
                    break;
            case 4:
                    System.out.println("Ingresa el dato a buscar:");
                    val = s.nextInt();
                    if(arbolBusq.search(val)){
                        System.out.println("El dato se encuentra en el árbol.");
                    }else{
                        System.out.println("El dato NO se encuentra en el árbol.");
                    }
                    break;
            case 5:
                    arbolBusq.breadthFrist();
                    break;
            case 6:
                    System.out.println("Hasta luego!");
                    break;
            default:
                    System.out.println("Ingresa una opción válida...");
                    break;
            }
        }while(op3!=6);
    }

}
