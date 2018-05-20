package TDAMapeo;
import ListaSimplementeEnlazada.*;

public class Mapeo<K,V> implements Map<K,V> {

	protected int n;
	protected Map<K,V>[] a;
	protected int N;
	
	public Mapeo() {
		n=0;
		N=7;
		a= (Map<K,V>[]) new MapeoConLista[N];
		for(int i=0;i<N; i++)
			a[i]=new MapeoConLista<K,V>();
	}
	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public V get(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Clave invalida");
		return a[key.hashCode()%N].get(key);
	}

	public V put(K key, V value) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Clave invalida");
		V toRet= a[key.hashCode()%N].put(key, value);
		if(toRet==null)
			n++;
		return toRet;
	}

	public V remove(K key) throws InvalidKeyException {
		if(key==null)
			throw new InvalidKeyException("Clave invalida");
		V toRet=a[key.hashCode()%N].remove(key);
		if(toRet!=null)
			n--;
		return toRet;
	}

	public Iterable<K> keys() {
		PositionList<K> l=new ListaSE<K>();
		for(int i=0;i<N;i++)
			for(K p:a[i].keys())
				l.addLast(p);
		return l;
	}

	public Iterable<V> values() {
		PositionList<V> l=new ListaSE<V>();
	for(int i=0;i<N;i++)
		for(V p:a[i].values())
			l.addLast(p);
	return l;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> l=new ListaSE<Entry<K,V>>();
		for(int i=0;i<N;i++)
			for(Entry<K,V> p:a[i].entries())
				l.addLast(p);
		return l;
	}
	

}
