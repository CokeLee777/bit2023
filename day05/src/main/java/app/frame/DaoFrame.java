package app.frame;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface DaoFrame<K,V> {
	public int insert(V v, SqlSession session) throws Exception;
	public int update(V v, SqlSession session) throws Exception;
	public int delete(K k, SqlSession session) throws Exception;
	public V select(K k, SqlSession session) throws Exception;
	public List<V> select(SqlSession session) throws Exception;
}
