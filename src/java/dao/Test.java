
package dao;

import dto.OrderDetail;
import dto.Plant;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
        ArrayList<OrderDetail> p = OrderDAO.getOrderByOrderID(2);
        System.out.println(p);
    }
   
}
