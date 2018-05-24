package TDALista;
import java.util.Iterator;
/**
 * Clase ElementIterator que implementa a Iterator
 * @author Cabrapan Paula y Cabrapan Diego
 */
import java.util.NoSuchElementException;
public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Constructor de la clase que crea un elemento iterador de la lista recibida.
	 * @param pl lista a iterar.
	 */
	public ElementIterator(PositionList<E> pl) {
		list=pl;
		try {
			cursor=list.isEmpty()?null:list.first();
		}catch(EmptyListException e) {System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Devuelve si queda algun elemento para recorrer.
	 * @return TRUE si queda un elemento
	 * @return FALSE si no queda elemento.
	 */
	public boolean hasNext() {
		return cursor!=null;
	}
	
	/**
	 * Devuelve el elemento siguiente para poder recorrer.
	 * @return elemento siguiente.
	 * @throws NoSuchElementException si no hay siguiente elemento.
	 */
	public E next() throws NoSuchElementException{
		if (cursor==null)
			throw new NoSuchElementException("No hay elemento siguiente");
		E tor=cursor.element();
		try {
			cursor=cursor==list.last()?null: list.next(cursor);
		}catch(InvalidPositionException | BoundaryViolationException |EmptyListException e) {System.out.println(e.getMessage());}
		return tor;
		
	}
}