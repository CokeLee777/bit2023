package app.cust;

import app.dto.Cust;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CustSelect {

    @Test
    void test() {
        CustServiceImpl service = new CustServiceImpl();

        Cust data = new Cust("7", "7", "하이");
        try {
            service.register(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Cust cust;
//        try {
//            cust = service.getById("1");
//            System.out.println("cust = " + cust);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
