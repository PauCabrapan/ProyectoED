package TDAPila;

/**
 * Clase que representa una Pila enlazada e implementa Stack
 * @author Cabrapan Paula y Cabrapan Diego	
*/
public class PilaEnlazada<E> implements Stack<E>{
	protected Nodo<E> head;
	protected int size;
	
	/**
	 * Constructor de la clase PilaEnlazada
	 * Crea una pila vacía
	 */
	public PilaEnlazada() {
		head=null;
		size=0;
	}
	
	/**
	 * Ingresa un elemento a la pila.
	 * @param e elemento a agregar.
	 */
	public void push(E e) {
		Nodo<E>aux=new Nodo<E>(e);
		aux.setSig(head);
		head=aux;
		size++;
	}
	
	/**
	 * Devuelve si la pila esta vacía.
	 * @return TRUE si la pila esta vacía.
	 * @return FALSE si la pila tiene algun elemento.
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Devuelve la cantidad de elementos en la pila.
	 * @return cantidad de elementos.
	 */
	public int size() {
	return size;
	}
	
	/**
	 * Remueve el elemento que se encuentra en el tope de la pila.
	 * @return Elemento removido.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E pop() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException("Pila Vacia");
		E aux=head.getEl();
		head=head.getSig();
		size--;
		return aux;
	}
	
	/**
	 * Examina el elemento que se encuentra en el tope de la pila.
	 * @return Elemento que se encuentra en el tope de la pila.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("Pila Vacia");
		return head.getEl();
	}
}
