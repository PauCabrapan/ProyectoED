package TDAMapeo;

/**
 * Interface Entry
 * @author Cabrapan Paula y Cabrapan Diego
 *
 */
public interface Entry<K, V> {
	/**
	 * Devuelve la clave de la entrada.
	 * @return clave de la entrada.
	 */
	public K getKey();
	
	/**
	 * Setea la clave a la entrada.
	 * @param key clave a setear.
	 */
	public void setKey(K key);
	
	/**
	 * Devuelve el valor de la entrada.
	 * @return el valor de la entrada.
	 */
	public V getValue();
	
	/**
	 * Setea el valor a la entrada.
	 * @param value valor a setear.
	 */
	public void setValue(V value);

}
