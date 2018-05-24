package Proyecto;
import TDAMapeo.*;
import TDALista.*;
import TDAArbolBinario.*;
import TDAArbolBinario.BoundaryViolationException;
import TDAArbolBinario.InvalidPositionException;

/**
 * Clase Operador 
 * Representa la parte logica del programa.
 * @author Cabrapan Paula y Cabrapan Diego
 *
 */
public class Operador {
	protected Map<String,Integer> m;
	protected BinaryTree<String> ab;
	
	/**
	 * Constructor de la clase
	 * Crea un operador.
	 */
	public Operador() {
		m=new Mapeo<String, Integer>();
		ab=new ArbolBinario<String>();
	}
	
	/**
	 * Ingresa una variable con su valor
	 * @param c Nombre de la variable.
	 * @param i valor de la variable.
	 */
	public void ingresar(String c,int i) {
		if(c!=null)
			try {
				m.put(c, i);
			} catch (InvalidKeyException e) {
				System.out.println("Clave Invalida");
			}
	}
	
	/**
	 * Devuelve si hay alguna variable guardada.
	 * @return TRUE si hay variables.
	 * @return FALSE si no hay variables.
	 */
	public boolean estaVacio() {
		return m.isEmpty();
	}
	
	/**
	 * Devuelve un iterable de las variables guardadas con sus respectivos valores.
	 * @return iterable con las variables y sus valores.
	 */
	public Iterable<String> toS(){
		PositionList<String> l=new ListaSE<String>();
		for(Entry<String,Integer> e:m.entries()) {
			l.addLast(e.getKey()+": "+e.getValue()+". ");
		}
		return l;
	}
	
	/**
	 * Devuelve el resultado de la operacion.
	 * @return resultado.
	 */
	public int resultadoR() {
		int toRet=0;
		if(!ab.isEmpty())
			try {
				toRet= resRec(ab.root());
			} catch (EmptyTreeException e) {e.printStackTrace();}
		return toRet;
	}
	private int resRec(TDAArbolBinario.Position<String> p){
		int resultado=0;
		try {
			if(ab.isExternal(p))
				resultado=m.get(p.element());
			else {
				int r1=resRec(ab.left(p));
				int r2=resRec(ab.right(p));
				switch(p.element()) {
				case "+": resultado=r1+r2;break;
				case "-": resultado=r1-r2;break;
				case "*": resultado=r1*r2; break;
				case "/": resultado=r1/r2; break;
				case "^": resultado=r1^r2; break;
				}
			}
		}catch(InvalidKeyException | InvalidPositionException | BoundaryViolationException e){System.out.println(e.getMessage());}
		return resultado;
	}
	
	
	
	
	/**
	 * Devuelve un string con la altura del arbol.
	 * @return altura.
	 */
	public String altura() {
		int toRet=0;
		if(!ab.isEmpty())
			try {
				toRet=alt(ab.root());
			} catch (EmptyTreeException e) {e.printStackTrace();}
		return "Altura:" + toRet;
	}
	private int alt(TDAArbolBinario.Position<String> p) {
		int toRet=0;
		try {
			if(ab.isExternal(p))
				toRet= 0;
			else {
				int h=0;
				for(TDAArbolBinario.Position<String> w: ab.children(p))
					h=Math.max(h, alt(w));
				toRet=1+h;
				}
		}catch(InvalidPositionException e) {System.out.println(e.getMessage());}
		return toRet;
	}
	/**
	 * Devuelve la cantidad de nodos del arbol.
	 * @return cantidad de nodos.
	 */
	public String nodos() {
		return "Nodos:"+ab.size()+'\n';			
	}
	
	/**
	 * Devuelve la cantidad de hojas del arbol.
	 * @return cantidad de hojas.
	 */
	public String hojas() {
		int c=0;
		for(TDAArbolBinario.Position<String> p:ab.positions())
			try {
				if(ab.isExternal(p))
					c++;
			} catch (InvalidPositionException e) {e.printStackTrace();}
		return "Hojas: "+c;
	}
	
	/**
	 * Devuelve la cantidad de nodos internos del arbol.
	 * @return cantidad de nodos internos.
	 */
	public String internos() {
		int c=0;
		for(TDAArbolBinario.Position<String> p:ab.positions())
			try {
				if(ab.isInternal(p))
					c++;
			} catch (InvalidPositionException e) {e.printStackTrace();}
		return "Nodos internos: "+c +'\n';
	}
}
