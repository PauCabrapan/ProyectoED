package Proyecto;
import TDAMapeo.*;
import ListaSimplementeEnlazada.*;

public class Operador {
	protected Map<String,Integer> m;
	
	public Operador() {
		m=new Mapeo<String, Integer>();
	}
	public void ingresar(String c,int i) {
		if(c!=null)
			try {
				m.put(c, i);
			} catch (InvalidKeyException e) {
				System.out.println("Clave Invalida");
			}
	}
	public boolean estaVacio() {
		return m.isEmpty();
	}
	public Iterable<String> toS(){
		PositionList<String> l=new ListaSE<String>();
		for(Entry<String,Integer> e:m.entries()) {
			l.addLast(e.getKey()+": "+e.getValue()+". ");
		}
		return l;
	}
	public boolean validarOp(String s) {
		for(int i=0;i<s.length();i++)
			System.out.println(s.charAt(i));
		return true;
	}
	public int agregarOp(String s) {
		return 0;
	}
	
	
}
