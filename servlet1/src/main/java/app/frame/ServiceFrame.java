package app.frame;

import java.util.List;

public interface ServiceFrame<K, V> {
    int register(V v) throws Exception;
    int modify(V v) throws Exception;
    int removeById(K k) throws Exception;
    V getById(K k) throws Exception;
    List<V> getAll() throws Exception;
}
