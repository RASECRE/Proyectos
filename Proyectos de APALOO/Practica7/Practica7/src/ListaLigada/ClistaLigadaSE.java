package ListaLigada;
public class ClistaLigadaSE {
	private nodo p;
	private int nElementos;
	ClistaLigadaSE(nodo p, int edad){
		p = null;
		nElementos = 0;
	}
	private class nodo{
		double dato;
		nodo sigte;
		nodo(){
		}
	}
		int tamaño() {
			return nElementos;
		}
			void añadirAlPrincipio(double n) {
				nodo q = new nodo();
				q.dato = n;
				q.sigte = p;
				p = q;
				nElementos++;
			}
			void eliminarDelPrincipio() {
				if(p!=null) {
					nodo aux = p;
					aux.sigte=null;
					System.out.println("Se elimino el valor: " + aux.dato);
					aux = null;
					nElementos--;
					}
			}
			double obtener(int n) {
				if(p==null) {
					System.out.println("Lista vacia");
				}
					nodo q=p;
				if(n>0) {
					for(int i=0; (q!=null)&&(i<n);i++);
							q=q.sigte;
						if(q!=null)
							return q.dato;
				}
				return n;
			}
			boolean buscar(double x) {
				nodo aux;
				aux=p;
				while((aux!=null)&&(aux.dato!=x)) {
					aux = aux.sigte;
				}
				if(aux!=null) {
					return true;
				}
				else {
					return false;
					}
			}
			void imprimirLista() {
				nodo aux=p;
				while(aux!=null) {
					System.out.println(aux.dato);
					aux=aux.sigte;
				}
				System.out.println();
			}
			void eliminarLista() {
				nodo aux;
				aux=p;
				while(aux!=null) {
					p=p.sigte;
					aux.sigte=null;
					aux=p;
				}
				nElementos=0;
			}
}