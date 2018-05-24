package TDAMapeo;
/**
 * Clase que representa una entrada
 * @author Cabrapan Paula y Cabrapan Diego
 *
 */
public class Entrada<K, V> implements Entry<K, V> {
	protected K key;
	protected V value;
	
	/**
	 * Constructor que crea una entrada con clave K y valor V.
	 * @param k clave de la nueva entrada
	 * @param v valor de la nueva entrada
	 */
	public Entrada(K k, V v) {
		key=k;
		value=v;
	}

	/**
	 * Devuelve la clave de la entrada.
	 * @return clave
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Setea la clave de la entrada.
	 * @param key clave a setear.
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * Devuelve el valor de la entrada.
	 * @return valor de la entrada.
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Setea el valor de la entrada.
	 * @param V valor a setear.
	 */
	public void setValue(V value) {
		this.value = value;
	}
	

}
