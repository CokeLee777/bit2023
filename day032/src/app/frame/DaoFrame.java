package app.frame;

import java.util.List;

public interface DaoFrame<K, V> {

	public void insert(V v);
	public void update(V v);
	public void delete(K k);
	public V select(K k);
	public List<V> select();
}
