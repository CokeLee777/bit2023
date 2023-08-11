package app.cust;

import app.dto.Cust;
import app.frame.DaoFrame;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class CustDaoImpl implements DaoFrame<String, Cust> {

    @Override
    public int insert(Cust cust, SqlSession session) throws Exception {
        return session.insert("cust.insert", cust);
    }

    @Override
    public int update(Cust cust, SqlSession session) throws Exception {
        return session.selectOne("cust.update", cust);
    }

    @Override
    public int deleteById(String k, SqlSession session) throws Exception {
        return session.selectOne("cust.delete", k);
    }

    @Override
    public Optional<Cust> selectById(String k, SqlSession session) throws Exception {
        return Optional.of(session.selectOne("cust.select", k));
    }

    @Override
    public List<Cust> selectAll(SqlSession session) throws Exception {
        return session.selectList("cust.selectall");
    }
}
