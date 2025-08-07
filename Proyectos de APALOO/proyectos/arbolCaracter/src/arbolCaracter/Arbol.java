package arbolCaracter;

import java.util.LinkedList;
import java.util.Queue;

public class Arbol {
    Nodo raiz;
    Nodo clon;
    Nodo lista;
    int i;

    // crea un arbol vacio
    public Arbol(){
        this.raiz = null;
    }

    // crea un arbol definido
    public Arbol(String s){
        i = 0;
        // evitar que truene agregando un caracter
        this.raiz = creaArbol((s + "%").toCharArray());
    }
    
    // crear arbol
    private Nodo creaArbol(char [] c){
        // hay una raiz apuntada por i
        Nodo aux = new Nodo(c[i]);
        i++; // se brinca la raiz
        // que no tenga subarboles
        if(c[i] != '('){return aux;}
        // se asume que tine por lo menos un subarbol
        i++; // brinca parentesis que abre
        // que solo tenga hijo derecho
        if(c[i] == ','){
            i++; // se brinca la coma
            aux.hder = creaArbol(c);
        } // tiene hijo izquierdo y posiblemente derecho
        else {
            aux.hizq = creaArbol(c);
            // tiene hijo derecho
            if(c[i] == ','){
                i++; // se brinca la coma
                aux.hder = creaArbol(c);
            }
        }
        i++; // brinca parentesis que cierra
        return aux;
    }

    // convertir arbol a cadena de texto
    private String toString(Nodo r){
        if(r == null){return "";}
        String aux;
        // Agrega la raiz
        aux = "" + r.info;
        if(r.hizq == null && r.hder == null){
            return aux;
        }
        // por lo menos tiene un hijo
        aux = aux + "(";
        // si tiene hijo izquierdo
        if(r.hizq != null){
            aux = aux + toString(r.hizq);
        }
        // si tiene hijo derecho
        if(r.hder != null){
        aux = aux + "," + toString(r.hder);
        }
        aux = aux + ")";
        return aux;

        

    }

    public String toString(){
        if(this.raiz == null){return "null";}
        return "altura = " + raiz.h + " " + toString(this.raiz);
    }

// tipos de ordenamiento
    private void preOrden(Nodo r){
        if(r == null){return;}
        System.out.println(r.info);
        preOrden(r.hizq);
        preOrden(r.hder);
    }

    public void preOrden(){
        preOrden(this.raiz);
    }

    private void enOrden(Nodo r){
        if(r == null){return;}
        enOrden(r.hizq);
        System.out.println(r.info);
        enOrden(r.hder);
    }

    public void enOrden(){
        enOrden(this.raiz);
    }

    private void postOrden(Nodo r){
        if(r == null){return;}
        postOrden(r.hizq);
        postOrden(r.hder);
        System.out.println(r.info);
    }

    public void postOrden(){
        postOrden(this.raiz);
    }

    // total de nodos
    private int numNodos(Nodo r){
        if(r == null){return 0;}
        return 1 + numNodos(r.hizq) + numNodos(r.hder);
    }

    public int numNodos(){
        return numNodos(this.raiz);
    }

    // altura del arbol
    private int altura(Nodo r){
        if (r == null){return 0;}
        int ahizq, ahder;
        ahizq = altura(r.hizq);
        ahder = altura(r.hder);
        return 1 + (ahizq > ahder ? ahizq : ahder);
    }

    public int altura(){
        return altura(this.raiz);
    }

    // numero de hojas del arbol
    private int numHojas(Nodo r){
        if (r == null){return 0;}
        // si es hoja
        if(r.hizq == null && r.hder == null){ return 1;}

        return numHojas(r.hizq) + numHojas(r.hder);
    }

    public int numHojas(){
        return numHojas(this.raiz);
    }

    // nodos intermedios
    private int nodosIntermedios(Nodo r){
        if(r == null) {return 0;}
        // si es hoja
        if(r.hizq == null && r.hder == null){return 0;}
        // en este punto r no es hoja
        return 1 + nodosIntermedios(r.hizq) + nodosIntermedios(r.hder);
    }

    public int nodosIntermedios(){
       return nodosIntermedios(this.raiz);
    }

    // comparar si dos nodos son iguales
    private boolean igual(Nodo original, Nodo otro){
        // ambos son nodos vacios
        
        if(original == null && otro == null){return true;}
        
        // 
        if(original == null || otro == null){return false;}

        /* if(original.info == otro.info && iguales(original.hizq, otro.hizq) && iguales(original.hder, otro.hder)){
            return true;
        } */

        return original.info == otro.info && igual(original.hizq, otro.hizq) && igual(original.hder, otro.hder);
    }

    public boolean igual(Arbol a){
        return igual(this.raiz, a.raiz);
    }

    // clonar arbol
    private Nodo clonar(Nodo a){
        if(a == null){return null;}

        Nodo b = new Nodo(a.info);

        b.hizq = clonar(a.hizq);
        b.hder = clonar(a.hder);

        return b;
    }

    public Arbol clonar(){
        Arbol clon = new Arbol();
        clon.raiz = clonar(this.raiz);

        return clon;
    }

    // sumar los datos de un arbol
    private int suma(Nodo r){
        if(r == null){return 0;}

        return r.info - '0' + suma(r.hizq) + suma(r.hder);
    }

    public int suma(){
        return suma(raiz);
    }

    // mostrar los valores de los nodos de cierto nivel
    private String nivel(Nodo r, int n){
        if(r == null){return "";}
        
        if(n == 1){
            return r.info + "";
        }

        String izq = nivel(r.hizq, n - 1);
        String der = nivel(r.hder, n - 1);

        if(izq.length() == 0 && der.length() == 0){return "";}
        if(izq.length() != 0 && der.length() != 0){
            return izq + ", " + der;
        }

        // almenos uno no es vacio
        return izq + der;


        //return nivel(r.hizq, n - 1) + nivel(r.hder, n - 1);
    }

    public String nivel(int n){
        return nivel(this.raiz, n);
    }

    // arbol degenerado
    private boolean degenrado(Nodo r){
        if(r == null){return true;}

        if(r.hizq == null && r.hder == null){return true;}
        if(r.hizq != null && r.hder != null){return false;}
       
        return degenrado(r.hizq) && degenrado(r.hder);
    }

    public boolean degenrado(){
        return degenrado(this.raiz);
    }

    private boolean degenradoE(Nodo r){
        if(r.hizq != null && r.hder == null){
            return degenradoE(r.hizq);
        }

        if(r.hizq == null && r.hder != null){
            return degenradoE(r.hizq);
        } 

        if(r.hizq != null && r.hder != null){
            return false;
        } 

        // es una hoja
        return true;
    }

    public boolean degenradoE(){
        return degenradoE(this.raiz);
    }

    // comprueba si un arbol es lleno
    private int lleno(Nodo r){
        if(r == null){return 0;}

        if(r.hizq == null && r.hder ==null){
            return 1;
        }

        int izq, der;

        izq = lleno(r.hizq);
        der = lleno(r.hder);

        if(izq == -1 || der == -1){
            return -1;
        }

        if(izq == der){
            return lleno(r.hizq) + 1;
        }

        return -1;
    }

    public boolean lleno(){
        return lleno(this.raiz) == -1 ? false : true;
    }

    // compruba si un arbol es completo
    private TipoArbol completo(Nodo r){
        TipoArbol izq, der;
        // arbol nulo
        if(r == null){return new TipoArbol('l', 0);}
        // solo la raiz
        //if (r.hizq == null && r.hder == null) {return new TipoArbol('c', 1);}
        izq = completo(r.hizq);
        der = completo(r.hder);
        // casos vacios
        if (izq.tipo == 'x' || der.tipo == 'x'){return new TipoArbol('x', 0);}
        
        // caso a
        if(izq.tipo == 'l' && der.tipo == 'c' && izq.h == der.h){
            return new TipoArbol('c', izq.h + 1);
        }

        // caso b
        if(izq.tipo == 'l' && der.tipo == 'l' && izq.h == der.h + 1){
            return new TipoArbol('c', izq.h + 1);
        }

        //caso c
        if(izq.tipo == 'c' && der.tipo == 'l' && der.h == izq.h + 1){return new TipoArbol('c', izq.h + 1);}

        // caso d
        if(izq.tipo == 'l' && der.tipo == 'l' && izq.h == der.h){
            return new TipoArbol('l', izq.h + 1);
        }
        // ningun caso
        return new TipoArbol('x', 0);
    }

    public TipoArbol completo(){
        TipoArbol aux = completo(this.raiz);
        System.out.print("El arbol ");

        switch (aux.tipo) {
            case 'l':
                System.out.println("es lleno");
                break;
        
            case 'c':
                System.out.println("es completo");
                break;
            default:
                System.out.println("no es ninguno");
        }
        return aux;
    }

    private boolean isComplete(Nodo r){
        if(r == null){return true;}
        Queue<Nodo> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(r); // push
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Nodo tmp = queue.poll(); // get
                if (tmp == null) {
                    flag = true;
                }
                else if(flag){ return false;}
                else{
                    queue.offer(tmp.hizq);
                    queue.offer(tmp.hder);
                }
            }
        }
        return true;
    }    

    public boolean isComplete(){
        return isComplete(this.raiz);
    }

//
// ordenamiento
//

    private int calculaH(Nodo r){
        if (r == null){return 0;}
        int hi, hd;
        if(r.hizq == null){hi = 0;}
        else{hi = r.hizq.h;}

        if(r.hder == null){hd = 0;}
        else{hd = r.hder.h;}

        r.h = 1 + ( hi > hd ? hi : hd);
        return hi - hd;
    }

    private Nodo casoEI(Nodo r){
        Nodo k,j,x,y,z;
        j = r;
        k = j.hizq;
        x = k.hizq;
        y = k.hder;
        z = j.hder;

        k.hder = j;
        k.hizq = x;
        j.hizq = y;
        j.hder = z;

        j.h = j.h - 2;

        return k;
    }

    private Nodo casoED(Nodo r){
        Nodo k,j,x,y,z;
        j = r;
        k = j.hder;
        x = k.hder;
        y = k.hizq;
        z = j.hizq;

        k.hizq = j;
        k.hder = x;
        j.hder = y;
        j.hizq = z;

        j.h = j.h - 2;

        return k;
    }

    private Nodo casoII(Nodo r){
        Nodo i,k,j,x,w,v,z;

        // asignacion de variables auxiliares
        j = r;
        k = j.hizq;
        x = k.hizq;
        i = k.hder;
        v = i.hizq;
        w = i.hder;
        z = j.hder;

        i.hizq = k;
        k.hizq = x;
        k.hder = v;
        i.hder = j;
        j.hizq = w;
        j.hder = z;

        k.h = k.h - 1;
        j.h = j.h - 2;
        i.h = i.h + 1;
        return i;
    }


    private Nodo casoID(Nodo r) {
        Nodo i,k,j,x,w,v,z;

        // asignacion de variables auxiliares
        j = r;
        k = j.hder;
        x = k.hder;
        i = k.hizq;
        v = i.hder;
        w = i.hizq;
        z = j.hizq;

        i.hder = k;
        k.hder = x;
        k.hizq = v;
        i.hizq = j;
        j.hder = w;
        j.hizq = z;

        k.h = k.h - 1;
        j.h = j.h - 2;
        i.h = i.h + 1;
        return i;
    }

    private Nodo balancearArbol(Nodo r){
        int factorBalance;
        factorBalance = calculaH(r);

         // determinar hay un problema de balance
         if(Math.abs(factorBalance) >= 2){
            System.out.println("Fuera de balance en " +factorBalance + " " + r.info);
            if(factorBalance > 0){
                int fbi = calculaH(r.hizq);

                if(fbi > 0){
                    r = casoEI(r);
                } else{
                    r = casoII(r);
                }
            } else {
                // los casos espejos
                int fbd = calculaH(r.hder);
                if(fbd > 0) {
                    r = casoID(r);
                } else {
                    r = casoED(r);
                }
            }
            
        }
        return r;
    }

    public Nodo balancearArbol(){
        return balancearArbol(this.raiz);
    }

    // insertar un nodo
    private Nodo insOrdenado(Nodo r, char info){
        if(r == null){return new Nodo(info);}

        if(r.info > info){
            r.hizq = insOrdenado(r.hizq, info);
        } else {
            r.hder = insOrdenado(r.hder, info);
        }
        int factorBalance;
        factorBalance = calculaH(r);

        // determinar hay un problema de balance
        if(Math.abs(factorBalance) >= 2){
            System.out.println("Fuera de balance en " +factorBalance + " " + r.info);
            if(factorBalance > 0){
                int fbi = calculaH(r.hizq);

                if(fbi > 0){
                    r = casoEI(r);
                } else{
                    r = casoII(r);
                }
            } else {
                // los casos espejos
                int fbd = calculaH(r.hder);
                if(fbd > 0) {
                    r = casoID(r);
                } else {
                    r = casoED(r);
                }
            }
            
        }
        return r;
        
    }


    public void insOrdenado(char c){
        this.raiz = insOrdenado(this.raiz, c);
    }

    // buscar un dato dentro del arbol
    // algoritmo altamente eficiente
    private boolean buscar(Nodo r, char info){
        if(r == null){return false;}
        if(r.info == info){return true;}
        if(r.info > info){return buscar(r.hizq, info);}
        return buscar(r.hder, info);
    }

    public boolean buscar(char info){
        return buscar(this.raiz, info);
    }

    private boolean esOrdenado(Nodo r, char min, char max){
        if(r == null){return true;}
        // verificar la raiz
        if(r.info < min || r.info > max){return false;}
        // llama recursivamente
        if(!esOrdenado(r.hizq, min, (char)(r.info - 1))){return false;}
        return esOrdenado(r.hder, (char)(r.info + 1), max);
    }

    public boolean esOrdenado(){
        return esOrdenado(this.raiz, Character.MIN_VALUE, Character.MAX_VALUE);
    }

    private MinMax esOrdenado2(Nodo a){
        if (a==null){return null;}
        MinMax valIzq, valDer;
        Nodo min, max;
        valIzq = esOrdenado2(a.hizq);
        valDer = esOrdenado2(a.hder);
        if (valIzq != null){
            if(!valIzq.valido) {return valIzq;}
        } if (valDer != null){ 
            if(!valDer.valido) {return valDer;} 
        } //Comparo valores de la raíz
        if (valIzq != null){
            if (a.compareTo(valIzq.max)<0) {return new MinMax(null, null, false);}
            min = valIzq.min;
        } else { min = a; }
        
        if (valDer != null){
            if (a.compareTo(valDer.min)>0) {return new MinMax(null, null, false);}
            max = valIzq.max;
        } else { max = a; }
        return new MinMax(min, max, true);
    } 
    
    public boolean esOrdenado2(){
        MinMax aux;
        aux= esOrdenado2(this.raiz);
        return aux.valido;
    }

// borrar un nodo
    private Nodo borrarR(Nodo a, Nodo b){
        if(b.hizq == null){
            a.info = b.info;
            return b.hder;
        }

        b.hizq = borrarR(a, b.hizq);
        return b;
    }

    private Nodo borrar(Nodo r){
        // vacio
        if(r == null){return null;}
        // caso 2 y 3
        if(r.hizq == null){return r.hder;}
        // caso 4
        if(r.hder == null){return r.hizq;}
        
        // caso 5 solo tine un nodo el el subarbol derecho
        if(r.hder.hizq == null){
            r.info = r.hder.info;
            r.hder = r.hder.hder;
            return r;
        }

        // recursivo
        r.hder = borrarR(r, r.hder);
        return r;

        // iterativo
        /* Nodo aux = r.hder;
        for (; aux.hizq.hizq != null; aux = aux.hizq);
        r.info = aux.hizq.info;
        aux.hizq = aux.hizq.hder;
        return r;
        */
    }

    public Nodo borrar(){
        return borrar(this.raiz);
    }

    

    private Nodo buscarYBorrar(Nodo r, char info){
        if(r == null){return null;}
        if(r.info > info){
            r.hizq = buscarYBorrar(r.hizq, info);
            return r;
        }

        r.hder = buscarYBorrar(r.hder, info);
        return r;
    }

    public void buscarYBorrar(char info){
        this.raiz = buscarYBorrar(this.raiz, info);
    }

// convertir arreglo de caracteres a arbol
    /*private Nodo convertir(char [] arreglo, int inicio, int fin){
        if(arreglo.length == 0 || inicio > fin){return null;}
     
        int mitad = inicio + (fin - inicio) / 2;
        Nodo r = new Nodo(arreglo[mitad]);

        r.hizq = convertir(arreglo, inicio, mitad - 1);
        r.hder = convertir(arreglo, mitad + 1, fin);

        return r;
    }

    public Nodo convertir(char [] arreglo){
        this.raiz = convertir(arreglo, 0, arreglo.length - 1);
        return this.raiz;
    } */

    // convertir como constructor
    private Nodo creaArbol(char [] datos, int inicio, int fin){
        // condicion base
        if(inicio > fin){return null;}
     
        // calcula la posicion de la mitad
       // int mitad = inicio + (fin - inicio) / 2;
        int mitad = (fin + inicio) / 2;

        // arbol lleno
        // int medio = (int)(Math.celt(fin + inicio / 2)); ????
     
        // crear nodo raiz con el dato de la posicion del medio
        Nodo r = new Nodo(datos[mitad]);

        r.hizq = creaArbol(datos, inicio, mitad - 1);
        r.hder = creaArbol(datos, mitad + 1, fin);

        return r;
    }

    public Arbol(char [] datos){
        this.raiz = creaArbol(datos, 0, datos.length - 1);
    }

    // dato un arbol, que le coloque las ligas
    private Nodo ponLigas(Nodo r, Nodo anterior){
        if(r == null){ return anterior; }
        anterior = ponLigas(r.hizq, anterior);
        // coloca las ligas en la raiz;
        if (anterior == null) {
            lista = r;
        } else {
            anterior.sucesor = r;
        }
        r.previo = anterior;
        r.sucesor = null;
        // sucesor del anterior? r
        //anterior.sucesor = r;
        // previo de la raiz? anterior
        // sucesesor de r? asumir null
        // Poner el atributo lista

        anterior = ponLigas(r.hder, r);
        return anterior;
    }

    public void ponLigas(){
        ponLigas(this.raiz, null);
    }

    public String recorreLista(){
        String salida = "";
        Nodo aux;
        boolean primero = true;
        for(aux = lista; aux != null; aux = aux.sucesor){
            if(primero){
                salida = salida + aux.info;
                primero = false;
            } else {
                salida = salida + "," +aux.info;
            }
        }

        return salida;
    }

    // generar arbol completo desde un arreglo dado
    /*private Nodo creaArbolCompleto(char [] datos, int inicio, int fin){
        // condicion base
        if(inicio > fin){return null;}
        // calcula la posicion de la mitad
        int n, nl, ns, nsi;
        n = fin - inicio + 1;
        nl = (int)(Math.floor(Math.log(n + 1) / Math.log(2)));
        ns = n - (int)Math.pow(2, nl) + 1;
        if(ns <= (int)Math.pow(2, nl - 1)){
            nsi = ns;
        } else {
            nsi = (int)Math.pow(2, nl - 1);
        }

        int medio = inicio + (int)Math.pow(2, nl - 1) - 1 + nsi;

        // crear nodo raiz con el dato de la posicion del medio
        Nodo aux = new Nodo(datos[medio]);
        aux.hizq = creaArbolCompleto(datos, inicio, medio - 1);
        aux.hder = creaArbolCompleto(datos, medio + 1, fin);
        return aux;
    } */

    private double evaluar(Nodo r){
        // es nulo
        if(r == null){return 0;}
        // es una hoja
        if(r.hizq == null && r.hder == null){
            return r.info - '0';
        }

        // es un nodo intermedio
        switch (r.info) {
            case '^': return (Math.pow(evaluar(r.hizq), evaluar(r.hder)));
            case '+': return (evaluar(r.hizq) + evaluar(r.hder));
            case '-': return (evaluar(r.hizq) - evaluar(r.hder));
            case '*': return (evaluar(r.hizq) * evaluar(r.hder));
            case '/': return (evaluar(r.hizq) / evaluar(r.hder));
            case 'S': return (Math.sin(evaluar(r.hder)));
            case 'C': return (Math.cos(evaluar(r.hder)));

        }

        return 0;
    }

    public double evaluar(){
        return evaluar(this.raiz);
    }

    private String pasaInfijo(Nodo r){
        if(r == null){return "";}
        if(r.hizq == null && r.hder == null){return "" + r.info;}
        String shizq,shder;
        
        if (r.info == 'S' || r.info == 'C') {
            return r.info + "(" + pasaInfijo(r.hder) + ")";
        }
        if ((r.info == '*' || r.info == '/' || r.info == '^') && (r.hizq.info == '+' || r.hizq.info == '-')) {
            shizq = "(" + pasaInfijo(r.hizq) + ")";
        } else{
            shizq = pasaInfijo(r.hizq);
        }


        if ((r.info == '*' || r.info == '/' || r.info == '^') && (r.hder.info == '+' || r.hder.info == '-') || (r.info == '-' && !(r.hder.hder == null || r.hder.hizq == null))) {
            shder = "(" + pasaInfijo(r.hder) + ")";
        } else{
            shder = pasaInfijo(r.hder);
        }

        return shizq + r.info + shder;
    }

    public String pasaInfijo(){
        return pasaInfijo(this.raiz);
    }

    private Nodo expresion(char [] e){
        Nodo signo = null;
        // manejo de signo
        if(e[i] == '+' || e[i] == '-'){
            signo = new Nodo(e[i]);
            i++;
        }

        Nodo aux = termino(e);
        // iteracion + -
        while (e[i] == '+' || e[i] == '-') {
            Nodo aux2 = new Nodo(e[i]);
            i++;
            aux2.hizq = aux;
            aux2.hder = termino(e);
            aux = aux2;
        }
        if(signo != null){
            signo.hder = aux;
            aux = signo;
        }
        return aux;
    }

    private Nodo termino(char [] e){
        Nodo aux = factor(e);
        // iteracion * /
        while (e[i] == '*' || e[i] == '/' || e[i] == '^') {
            Nodo aux2 = new Nodo(e[i]);
            i++;
            aux2.hizq = aux;
            aux2.hder = factor(e);
            aux = aux2;
        }
        return aux;
    }

    private Nodo factor(char [] e){
        if(e[i] == '('){
            i++;
            Nodo aux = expresion(e);
            i++; // parentesis que cierra
            return aux;
        }

        if (e[i] == 'S' || e[i] == 'C') {
            Nodo aux = new Nodo(e[i]);
            i++; // se brinca sen o cos
            i++;// se brinca parentesis que abre
            aux.hder = expresion(e);
            i++; // parentesis que cierra
            return aux;
        }

        // si es variable o constante
        Nodo aux = new Nodo(e[i]);
        i++;
        return aux;
    }

    public void infijoArbol(String s){
        s = s + "#";
        char [] e = s.toCharArray();
        this.raiz = expresion(e);
    }

    private Nodo derivaSuma(Nodo r, char variable){
        Nodo aux = new Nodo(r.info);
        aux.hizq = deriva(r.hizq, variable);
        aux.hder = deriva(r.hder, variable);
        return aux;
    }

    private Nodo derivaConst(Nodo r, char variable) {
        if(r.info == variable){return new Nodo('1');}
        return new Nodo('0');
    }

    private Nodo derivaMulti(Nodo r, char variable) {
        Nodo aux = new Nodo('+');
        aux.hizq = new Nodo('*');
        aux.hder = new Nodo('*');
        aux.hizq.hizq = clonar(r.hizq);
        aux.hizq.hder = deriva(r.hder, variable);
        aux.hder.hizq = deriva(r.hizq, variable);
        aux.hder.hder = clonar(r.hder);
        return aux;
    }

    // derivada division
    private Nodo derivaDivison(Nodo r, char variable){
        Nodo aux = new Nodo('/');
        // numerador 
        aux.hizq = new Nodo('-');
            aux.hizq.hizq = new Nodo('*');
                aux.hizq.hizq.hizq = clonar(r.hder);
                aux.hizq.hizq.hder = deriva(r.hizq, variable);
            aux.hizq.hder = new Nodo('*');
                aux.hizq.hder.hizq = clonar(r.hizq);
                aux.hizq.hder.hder = deriva(r.hder, variable);
        // denominador
        aux.hder = new Nodo('^');
            aux.hder.hizq = clonar(r.hder);
            aux.hder.hder = new Nodo('2');

        return aux;
    }

    private Nodo derivaSenCos(Nodo r, char variable){
        Nodo aux = new Nodo('*');
        aux.hizq = deriva(r.hder, variable);
        if(r.info == 'S'){
            aux.hder = new Nodo('C');
            aux.hder.hder = clonar(r.hder);
        } else {
            aux.hder = new Nodo('-');
            aux.hder.hder = new Nodo('S');
            aux.hder.hder.hder = clonar(r.hder);
        }

        return aux;
    }

    private Nodo derivaPotencia(Nodo r, char variable){
        Nodo aux = new Nodo('*');
        aux.hizq = deriva(r.hizq, variable);
        aux.hder = new Nodo('*');
        aux.hder.hizq = clonar(r.hder);
        aux.hder.hder = new Nodo('^');
        aux.hder.hder.hizq = clonar(r.hizq);
        aux.hder.hder.hder = new Nodo('-');
        aux.hder.hder.hder.hizq = clonar(r.hder);
        aux.hder.hder.hder.hder = new Nodo('1');
        
        return aux;
    }

    private Nodo deriva(Nodo r, char variable){
        if(r == null){return null;}

        switch (r.info) {
            case '+':
            case '-': return derivaSuma(r, variable);
            case '*': return derivaMulti(r, variable);
            case '/': return derivaDivison(r, variable);
            case 'S': 
            case 'C': return derivaSenCos(r, variable);
            case '^': return derivaPotencia(r, variable);
            default: return derivaConst(r, variable);
        }
    }

    

    public Arbol deriva(char variable){
        Arbol aux = new Arbol();
        aux.raiz = deriva(this.raiz, variable);
        return aux;
    }

    private Nodo podaSuma(Nodo r){
        if(r.hizq == null){return r.hder;}
        if(r.hizq.info == '0'){return r.hder;}
        if(r.hder.info == '0'){return r.hizq;}
        return r;
    }

    private Nodo podaResta(Nodo r){
        if(r.hder.info == '0'){return r.hizq;} 
        if(r.hizq.info == '0'){r.hizq = null;}
        return r;
    }

    private Nodo podaMulti(Nodo r){
        if(r.hizq.info == '0' || r.hder.info == '0'){return new Nodo('0');}
        if(r.hizq.info == '1'){return r.hder;}
        if(r.hder.info == '1'){return r.hizq;}
        return r;

    }

    private Nodo podaDivision(Nodo r){
        if(r.hizq.info == '0'){return new Nodo('0');} 
        if(r.hder.info == '1'){return r.hizq;}

        return r;
    }

    private Nodo poda(Nodo r){
        if(r == null){return null;}
        r.hizq = poda(r.hizq);
        r.hder = poda(r.hder);
        switch (r.info) {
            case '+': return podaSuma(r);
            case '-': return podaResta(r);
            case '*': return podaMulti(r);
            case '/': return podaDivision(r);
        }

        return r;
    }

    public void poda(){
        this.raiz = poda(this.raiz);
    }

  }
