package app.frame;

import java.util.List;

public interface ServiceFrame<K, V> {
	
	public void register(V v);
	public void modifiy(V v);
	public void remove(K k);
	public V get(K k);
	public List<V> get();
}
