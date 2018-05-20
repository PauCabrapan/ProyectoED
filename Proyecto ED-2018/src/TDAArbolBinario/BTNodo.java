package TDAArbolBinario;

public class BTNodo<E> implements BTPosition<E>{
	protected E el;
	protected BTPosition<E> left,right,parent;
	
	
	public BTNodo(BTPosition<E> l, BTPosition<E> r,BTPosition<E> p, E el){
		left=l;
		right=r;
		parent=p;
		this.el=el;
	}
	
	public E element() {
		return el;
	}
	public void setElement(E el) {
		this.el = el;
	}
	public BTPosition<E> getLeft() {
		return left;
	}
	public void setLeft(BTPosition<E> left) {
		this.left = left;
	}
	public BTPosition<E> getRight() {
		return right;
	}
	public void setRight(BTPosition<E> right) {
		this.right = right;
	}
	public BTPosition<E> getParent() {
		return parent;
	}
	public void setParent(BTPosition<E> parent) {
		this.parent = parent;
	}
	
	

}
