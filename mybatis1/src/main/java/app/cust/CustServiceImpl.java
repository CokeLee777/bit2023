package app.cust;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.GetSessionFactory;
import app.frame.ServiceFrame;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class CustServiceImpl implements ServiceFrame<String, Cust> {

    private final DaoFrame<String, Cust> dao;
    private final SqlSession session;

    public CustServiceImpl() {
        dao = new CustDaoImpl();
        session = GetSessionFactory.getInstance().openSession();
    }

    @Override
    public int register(Cust cust) throws Exception {
        int insertedRow;
        try {
            insertedRow = dao.insert(cust, session);
            session.commit();
        } catch(Exception e) {
            session.rollback();
            throw new Exception("ERR-0001");
        } finally {
            session.close();
        }

        return insertedRow;
    }

    @Override
    public int modify(Cust cust) throws Exception {
        int updatedRow;
        try {
            updatedRow = dao.update(cust, session);
            session.commit();
        } catch(Exception e) {
            session.rollback();
            throw new Exception("ERR-0002");
        } finally {
            session.close();
        }

        return updatedRow;
    }

    @Override
    public int removeById(String k) throws Exception {
        int deletedRow;
        try {
            deletedRow = dao.deleteById(k, session);
            session.commit();
        } catch(Exception e) {
            session.rollback();
            throw new Exception("ERR-0002");
        } finally {
            session.close();
        }

        return deletedRow;
    }

    @Override
    public Cust getById(String k) throws Exception {
        Optional<Cust> cust;
        try {
            cust = dao.selectById(k, session);
        } catch(Exception e) {
            throw new Exception("ERR-0003");
        }

        return cust.orElse(new Cust());
    }

    @Override
    public List<Cust> getAll() throws Exception {
        List<Cust> cust;
        try {
            cust = dao.selectAll(session);
        } catch(Exception e) {
            throw new Exception("ERR-0003");
        }

        return cust;
    }
}
