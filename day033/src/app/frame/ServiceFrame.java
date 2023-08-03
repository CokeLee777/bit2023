package app.frame;

import java.util.List;

public interface ServiceFrame<K, V> {
	
	public void register(V v) throws Exception;
	public void modifiy(V v) throws Exception;
	public void remove(K k) throws Exception;
	public void removeAll() throws Exception;
	public V get(K k) throws Exception;
	public List<V> get() throws Exception;
}
