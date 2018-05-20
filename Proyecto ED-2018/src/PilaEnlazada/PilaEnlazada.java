package PilaEnlazada;

public class PilaEnlazada<E> implements Stack<E>{
	protected Nodo<E> head;
	protected int size;
	
	public PilaEnlazada() {
		head=null;
		size=0;
	}
	public void push(E e) {
		Nodo<E>aux=new Nodo<E>(e);
		aux.setSig(head);
		head=aux;
		size++;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
	return size;
	}
	public E pop() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException("Pila Vacia");
		E aux=head.getEl();
		head=head.getSig();
		size--;
		return aux;
	}
	public E top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("Pila Vacia");
		return head.getEl();
	}
}
