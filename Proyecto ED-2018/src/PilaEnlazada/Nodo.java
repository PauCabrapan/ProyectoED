package PilaEnlazada;

/**
 * Clase Nodo 
 * Representa un elemento de la lista
 * @author Cabrapan Paula y Cabrapan Diego
 */
public class Nodo<E> {
	protected Nodo<E> sig;
	protected E el;
	
	/**
	 * Constructor de la clase Nodo
	 * @param e rotulo del elemento
	 */
	public Nodo(E e) {
		sig=null;
		el=e;
	}
	/**
	 * Constructor de la clase Nodo
	 * @param e rotulo del elemento
	 * @param s Nodo siguiente
	 */
	public Nodo(E e, Nodo<E> s) {
		this(e);
		sig=s;
	}
	
	/**
	 * Metodo getter de la clase Nodo
	 * @return Nodo siguiente del nodo
	 */
	public Nodo<E> getSig() {
		return sig;
	}
	
	/**
	 * Metodo setter de la clase Nodo
	 * @param sig nuevo nodo a setear
	 */
	public void setSig(Nodo<E> sig) {
		this.sig = sig;
	}
	
	/**
	 * 
	 * @return
	 */
	public E getEl() {
		return el;
	}
	public void setEl(E el) {
		this.el = el;
	}
	
	

}
