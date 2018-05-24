package TDAMapeo;
import TDALista.*;

public class MapeoConLista<K, V> implements Map<K, V> {

	protected PositionList<Entrada<K,V>> l;
 
	public MapeoConLista() {
		l=new ListaSE<Entrada<K,V>>();
	}
	public int size() {
		return l.size();
	}

	public boolean isEmpty() {
		return l.isEmpty();
	}

	public V get(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Clave invalida");
		V toRet=null;
		for(Position<Entrada<K,V>> p:l.positions())
			if(p.element().getKey().equals(key))
				toRet=p.element().getValue();
		return toRet;
	}

	public V put(K key, V value) throws InvalidKeyException {
		V toRet=null;
		if(key==null)
			throw new InvalidKeyException("Clave Invalida");
		boolean enc=false;
		for(Position<Entrada<K,V>> p:l.positions())
			if(p.element().getKey().equals(key)) {
				toRet=p.element().getValue();
				p.element().setValue(value);
				enc=true;
			}
		if(!enc)
			l.addLast(new Entrada<K,V>(key,value));
		return toRet;		
	}

	public V remove(K key) throws InvalidKeyException {
		V toRet=null;
		if(key==null)
			throw new InvalidKeyException("Clave Invalida");
		for(Position<Entrada<K,V>> p:l.positions())
			if(p.element().getKey().equals(key)){
				toRet=p.element().getValue();
				try {
					l.remove(p);
				} catch (InvalidPositionException e) {System.out.println(e.getMessage());}
			}
		return toRet;
			
	}

	public Iterable<K> keys() {
		PositionList<K> k=new ListaSE<K>();
		for(Position<Entrada<K,V>> p:l.positions())
			k.addLast(p.element().getKey());
		return k;
	}

	public Iterable<V> values() {
		PositionList<V> v=new ListaSE<V>();
		for(Position<Entrada<K,V>> p:l.positions())
			v.addLast(p.element().getValue());
		return v;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> li=new ListaSE<Entry<K,V>>();
		for(Position<Entrada<K,V>> p:l.positions())
			li.addLast(p.element());
		return li;
	}

}
