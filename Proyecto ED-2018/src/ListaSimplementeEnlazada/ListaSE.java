package ListaSimplementeEnlazada;

import java.util.Iterator;
/**
 * Clase Lista que representa una lista simplemente enlazada
 */

public class ListaSE<E> implements PositionList<E> {
	protected Nodo<E> head;
	protected Nodo<E> tail;
	protected int size;

	/**
	 * Constructor de Lista
	 */
	public ListaSE() {
		head= new Nodo<E>();
		tail=new Nodo<E>();
		size=0;
	}
	/**
	 * Consulta la cantidad de elementos de la lista.
	 * @return Cantidad de elementos de la lista.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Consulta si la lista est� vac�a.
	 * @return Verdadero si la lista est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Devuelve la posici�n del primer elemento de la lista. 
	 * @return Posici�n del primer elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 */
	public Position<E> first() throws EmptyListException{
		if(size==0)
			throw new EmptyListException("Lista vacia");
		return head;
	}
	
	/**
	 * Devuelve la posici�n del �ltimo elemento de la lista. 
	 * @return Posici�n del �ltimo elemento de la lista.
	 * @throws EmptyListException si la lista est� vac�a.
	 * 
	 */
	public Position<E> last() throws EmptyListException{
		if(size==0)
			throw new EmptyListException("Lista Vacia");
		return tail;
	}
	
	/**
	 * Inserta un elemento al final de la lista.
	 * @param element Elemento a insertar al final de la lista.
	 */
	public void addLast(E el) {
		Nodo<E> aux= new Nodo<E> (el);
		if (size==0)
			head=aux;
		else
			tail.setSig(aux);
		tail=aux;
		size++;
	}
	
	/**
	 * Inserta un elemento al principio de la lista.
	 * @param element Elemento a insertar al principio de la lista.
	 */
	public void addFirst(E el) {
		Nodo<E> aux=new Nodo<E>(el);
		if(size==0)
			tail=aux;
		else
			aux.setSig(head);
		head=aux;
		size++;
	}
	
	/**
	 * Inserta un elemento antes de la posici�n pasada como par�metro.
	 * @param p Posici�n en cuya posici�n anterior se insertar� el elemento pasado por par�metro. 
	 * @param element Elemento a insertar antes de la posici�n pasada como par�metro.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */
	public void addBefore(Position<E> pos, E e) throws InvalidPositionException{
		Nodo<E> p=checkposition(pos);
		if(p==head)
			addFirst(e);
		else {
			Nodo<E> n=head;
			while(n.getSig()!=p)
				n=n.getSig();
			Nodo<E> aux= new Nodo<E>(e,p);
			n.setSig(aux);
			size++;
		}
	}
	
	/**
	 * Inserta un elemento luego de la posici�n pasada por par�matro.
	 * @param p Posici�n en cuya posici�n siguiente se insertar� el elemento pasado por par�metro.
	 * @param element Elemento a insertar luego de la posici�n pasada como par�metro.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */
	public void addAfter(Position<E> pos, E e) throws InvalidPositionException{
		Nodo<E> p=checkposition(pos);
		if(tail==p)
			addLast(e);
		else {
			Nodo<E> aux=new Nodo<E> (e, p.getSig());
			p.setSig(aux);
			size++;
		}
	}
	
	/**
	 * Devuelve la posici�n del elemento siguiente a la posici�n pasada por par�metro.
	 * @param p Posici�n a obtener su elemento siguiente.
	 * @return Posici�n del elemento siguiente a la posici�n pasada por par�metro.
	 * @throws InvalidPositionException si el posici�n pasada por par�metro es inv�lida o la lista est� vac�a.
	 * @throws BoundaryViolationException si la posici�n pasada por par�metro corresponde al �ltimo elemento de la lista.
	 */
	public Position<E> next(Position<E> pos) throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> p= checkposition(pos);
		if(p==tail)
			throw new BoundaryViolationException("No tiene siguiente");
		return p.getSig();			
	}
	
	/**
	 * Devuelve la posici�n del elemento anterior a la posici�n pasada por par�metro.
	 * @param p Posici�n a obtener su elemento anterior.
	 * @return Posici�n del elemento anterior a la posici�n pasada por par�metro.
	 * @throws InvalidPositionException si la posici�n pasada por par�metro es inv�lida o la lista est� vac�a.
	 * @throws BoundaryViolationException si la posici�n pasada por par�metro corresponde al primer elemento de la lista.
	 */
	public Position<E> prev(Position<E> pos) throws InvalidPositionException, BoundaryViolationException{
		Nodo<E> p=checkposition(pos);
		if(p==head)
			throw new BoundaryViolationException("No tiene prev");
		Nodo<E> aux=head;
		while(aux.getSig()!=p && aux.getSig()!=null)
			aux=aux.getSig();
		if(aux.getSig()==null)
			throw new InvalidPositionException("Posicion Invalida");
		return aux;
	}
	
	/**
	 * Remueve el elemento que se encuentra en la posici�n pasada por par�metro.
	 * @param p Posici�n del elemento a eliminar.
	 * @return element Elemento removido.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.
	 */	
	public E remove(Position<E> pos) throws InvalidPositionException{
		Nodo<E> p=checkposition(pos);
		try {
		if(p==head) {//Borrar primero
			head=p.getSig();
			if (p==tail) //Hay un unico elemento
				tail=null;
		}
		else
			if (p==tail) {//Borrar el ultimo
				tail=checkposition(prev(p));
				tail.setSig(null);
			}
			else {//Borrar al medio
				(checkposition(prev(pos))).setSig(checkposition(next(pos)));
			}
		}catch(BoundaryViolationException e) {throw new InvalidPositionException("Posicion Invalida");}
		p.setSig(null);
		E aux=p.element();
		p.setElement(null);
		size--;
		return aux;
	}
	
	/**	
	 * Establece el elemento en la posici�n pasados por par�metro. Reemplaza el elemento que se encontraba anteriormente en esa posici�n y devuelve el elemento anterior.
	 * @param p Posici�n a establecer el elemento pasado por par�metro.
	 * @param element Elemento a establecer en la posici�n pasada por par�metro.
	 * @return Elemento anterior.
	 * @throws InvalidPositionException si la posici�n es inv�lida o la lista est� vac�a.	 
	 */
	public E set(Position<E> pos, E e) throws InvalidPositionException{
		Nodo<E> p=checkposition(pos);
		E aux=pos.element();
		p.setElement(e);
		return aux;
	}
	
	/**
	 * Devuelve un un iterador de todos los elementos de la lista.
	 * @return Un iterador de todos los elementos de la lista.
	 */
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	

	/**
	 * Devuelve una colecci�n iterable de posiciones.
	 * @return Una colecci�n iterable de posiciones.
	 */
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l=new ListaSE<Position<E>>();
		Position<E> p=null;
		try {
			if(size!=0)
				p=first();
			while(p!=null) {
				l.addLast(p);
				p=p!=last()?next(p):null;
			}		 
		}catch(InvalidPositionException|EmptyListException | BoundaryViolationException e) {System.out.println(e.getMessage());}
		return l;
	}
	
	private Nodo<E> checkposition(Position<E> p) throws InvalidPositionException{
		try {
			if(p==null || size==0)
				throw new InvalidPositionException("Posicion vacia");
			return (Nodo<E>)p;
		}catch(ClassCastException e) {
			throw new InvalidPositionException("Posicion Invalida");
		}
		
	}

}
