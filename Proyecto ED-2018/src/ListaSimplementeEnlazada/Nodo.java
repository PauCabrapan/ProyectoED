package ListaSimplementeEnlazada;

/**
 * Clase Nodo que implementa clase Position
 * @author Cabrapan Paula y Cabrapan Diego
 */
public class Nodo<E> implements Position<E> {
	protected E element;
	protected Nodo<E> sig;
	
	/**
	 * Constructor de la clase nodo sin parametros
	 */
	public Nodo() {
		element=null;
		sig=null;
	}
	
	/**
	 * Constructor de la clase Nodo
	 * @param e rotulo
	 * @param s Nodo siguiente
	 */
	public Nodo(E e,Nodo<E> s) {
		element=e;
		sig=s;
	}
	
	/**
	 * Constructor de la clase Nodo
	 * @param e Rotulo
	 */
	public Nodo(E e) {
		element=e;
		sig=null;
	}
	
	/**
	 * Metodo element
	 * @return rotulo de nodo
	 */
	public E element() {
		return element;
	}
	
	/**
	 * Metodo setElement setea un rotulo
	 * @param element rotulo nuevo
	 */
	public void setElement(E element) {
		this.element = element;
	}
	
	/**
	 * Metodo getSig
	 * @return Nodo siguiente
	 */
	public Nodo<E> getSig() {
		return sig;
	}
	
	/**
	 * Metodo setSig setea nodo siguiente 
	 * @param sig Nodo siguiente
	 */
	public void setSig(Nodo<E> sig) {
		this.sig = sig;
	}
	
	
}
