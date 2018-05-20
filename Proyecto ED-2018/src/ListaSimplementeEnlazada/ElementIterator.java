package ListaSimplementeEnlazada;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> pl) {
		list=pl;
		try {
			cursor=list.isEmpty()?null:list.first();
		}catch(EmptyListException e) {System.out.println(e.getMessage());
		}
	}
	public boolean hasNext() {
		return cursor!=null;
	}
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