package TDAArbolBinario;
import java.util.Iterator;

import ListaSimplementeEnlazada.*;

public class ArbolBinario<E> implements BinaryTree<E> {
	protected BTPosition<E> raiz;
	protected int size;
	
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException{
		BTPosition<E> n=checkposition(v);
		BTPosition<E> l=n.getLeft();
		if(l==null)
			throw new BoundaryViolationException("No tiene izquierdo");
		return l;
	}
	public Position<E> right(Position<E> v)throws InvalidPositionException, BoundaryViolationException{
		BTPosition<E> n=checkposition(v);
		BTPosition<E> r=n.getRight();
		if(r==null)
			throw new BoundaryViolationException("No tiene derecho");
		return r;
	}
	public boolean hasLeft(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		return n.getLeft()!=null;
	}
	public boolean hasRight(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		return n.getRight()!=null;
	}
	public Position<E> createRoot(E r) throws InvalidOperationException{
		if(raiz!=null)
			throw new InvalidOperationException("Ya existe raiz");
		raiz=new BTNodo<E>(null,null,null,r);
		size=1;
		return raiz;
	}
	public Position<E> addLeft(Position<E> v, E r) throws InvalidOperationException, InvalidPositionException{
		BTPosition<E> padre=checkposition(v);
		if (padre.getLeft()!=null)
			throw new InvalidOperationException("Ya tiene izquierdo");
		BTPosition<E> n=new BTNodo<E>(null,null,padre,r);
		padre.setLeft(n);
		size++;
		return n;
	}
	public Position<E> addRight(Position<E> v, E r) throws InvalidOperationException,InvalidPositionException{
		BTPosition<E> padre=checkposition(v);
		if (padre.getRight()!=null)
			throw new InvalidOperationException("Ya tiene derecho");
		BTPosition<E> n=new BTNodo<E>(null,null,padre,r);
		padre.setRight(n);
		size++;
		return n;
	}
	public E remove(Position<E> v) throws InvalidOperationException, InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		E toRet=n.element();
		BTPosition<E> p=n.getParent();
		if(n.getLeft()!=null && n.getRight()!=null)
			throw new InvalidOperationException("No se puede eliminar si tiene mas de un hijo");
		if(n==raiz) {
			if(n.getLeft()!=null)
				raiz=n.getLeft();
			else
				raiz=n.getRight();
			size--;
		}
		else 
			if(n.getLeft()==null && n.getRight()==null) { //Es una hoja
				if(p.getLeft()==n)
					p.setLeft(null);
				else
					p.setRight(null);
				size--;
			}
			else {//Es interno
				if(p.getLeft()==n)
					if(n.getLeft()!=null)
						p.setLeft(n.getLeft());
					else
						p.setLeft(n.getRight());
				else
					if(n.getLeft()!=null)
						p.setRight(n.getLeft());
					else
						p.setRight(n.getRight());
				size--;
			}
		return toRet;
	}
	public void Attach(Position<E> r, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException{
		BTPosition<E> n=checkposition(r);
		if(n.getLeft()!=null && n.getRight()!=null)
			throw new InvalidPositionException("Posicion invalida");
		try {
			n.setLeft(checkposition(T1.root()));
			n.setRight(checkposition(T2.root()));
			size=size+T1.size()+T2.size();
		} catch (EmptyTreeException e) {System.out.println(e.getMessage());}
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public boolean isRoot(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		return n==raiz;
	}
	public boolean isExternal(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		boolean es=false;
		if(n.getLeft()==null && n.getRight()==null)
			es=true;
		return es;
	}
	public boolean isInternal(Position<E> v) throws InvalidPositionException{
		return !isExternal(v);
	}
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException{
		BTPosition<E> n=checkposition(v);
		if(n==raiz)
			throw new BoundaryViolationException("La raiz no tiene padre");
		return n.getParent();
	}
	public Position<E> root() throws EmptyTreeException{
		if(size==0)
			throw new EmptyTreeException("Arbol vacio");
		return raiz;
	}
	public E replace(Position<E> v, E e) throws InvalidPositionException{
		BTPosition<E> n=checkposition(v);
		E aux=v.element();
		n.setElement(e);
		return aux;		
	}
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
		PositionList<Position<E>> l=new ListaSE<Position<E>>();
		BTPosition<E> n=checkposition(v);
		if(hasLeft(n))
			l.addLast(n.getLeft());
		if(hasRight(n))
			l.addLast(n.getRight());			
		return l;
	}
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l=new ListaSE<Position<E>>();
		try {
			if(size!=0)
				preorderposition(raiz,l);
		} catch (InvalidPositionException e) {System.out.println(e.getMessage());}
		return l;
	}
	public Iterator<E> iterator(){
		PositionList<E> l=new ListaSE<E>();
		for(Position<E> p:positions())
			l.addLast(p.element());
		return l.iterator();
	}	
	private void preorderposition(Position<E> v, PositionList<Position<E>> l) throws InvalidPositionException{
		l.addLast(v);
		BTPosition<E> n=checkposition(v);
		if(hasLeft(v))
			preorderposition(n.getLeft(),l);
		if(hasRight(v))
			preorderposition(n.getRight(),l);
	}
	private BTPosition<E> checkposition(Position<E> p) throws InvalidPositionException{
		if(p==null || size==0)
			throw new InvalidPositionException("Posicion Invalida");
		BTPosition<E> toret=null;
		try {
			toret=(BTPosition<E>)p;
		}catch(ClassCastException e) {System.out.println(e.getMessage());}
		return toret;
	}
}
