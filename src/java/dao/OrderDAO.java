/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import dto.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import utils.DBUtils;

/**
 *
 * @author minhn
 */
public class OrderDAO {

    //ham nay de chen 1 record vao bang order vaf detailorder
    public static int insertOrder(int AccID, HashMap<String, Integer> cart) throws Exception {
        int kq = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            cn.setAutoCommit(false);
            String sql = "INSERT INTO Orders(OrdDate, shipdate, status, AccID) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Date d = new Date(System.currentTimeMillis());
            pst.setDate(1, d);
            pst.setNull(2, java.sql.Types.DATE);
            pst.setInt(3, 1); // 1 <-> pending
            pst.setInt(4, AccID);
            kq = pst.executeUpdate();
            if (kq > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    int orderid = rs.getInt(1);
                    if (cart != null && cart.size() > 0) {
                        for (String pid : cart.keySet()) {
                            int quantity = cart.get(pid);
                            sql = "INSERT INTO OrderDetails(OrderID, PID, quantity) VALUES (?, ?, ?)";
                            pst = cn.prepareStatement(sql);
                            pst.setInt(1, orderid);
                            pst.setString(2, pid);
                            pst.setInt(3, quantity);
                            kq = pst.executeUpdate();
                        }
                    }
                }
            }
            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
        }
        return kq;
    }

    public static ArrayList<Order> getOrderByStatus(int status) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [OrderID], [OrdDate], [shipdate], [status], [AccID] "
                    + "FROM [PlantShop].[dbo].[Orders] "
                    + "WHERE [status] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, status);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                int orderid = rs.getInt("OrderID");
                Date ordDate = rs.getDate("OrdDate");
                Date shipDate = rs.getDate("shipdate");
                int accID = rs.getInt("AccID");
                Order order = new Order(orderid, ordDate, shipDate, status, accID);
                orders.add(order);
            }
            cn.close();
        }
        return orders;
    }

    public static ArrayList<Order> getAllOrder(int accID) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [OrderID], [OrdDate], [shipdate], [status], [AccID] "
                    + "FROM [PlantShop].[dbo].[Orders] "
                    + "WHERE [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accID);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                int orderID = rs.getInt("OrderID");
                Date ordDate = rs.getDate("OrdDate");
                Date shipDate = rs.getDate("shipdate");
                int status = rs.getInt("status");
                Order order = new Order(orderID, ordDate, shipDate, status, accID);
                orders.add(order);
            }
            cn.close();
        }
        return orders;
    }

    public static ArrayList<OrderDetail> getOrderByOrderID(int orderID) throws Exception {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT od.DetailID, od.PID, od.quantity, p.PName, p.price, p.imgPath, o.status "
                    + "FROM [PlantShop].[dbo].[OrderDetails] od "
                    + "JOIN [PlantShop].[dbo].[Orders] o ON od.OrderID = o.OrderID "
                    + "JOIN [PlantShop].[dbo].[Plants] p ON od.PID = p.PID "
                    + "WHERE od.OrderID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderID);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                int detailID = rs.getInt("DetailID");
                int pid = rs.getInt("PID");
                int quantity = rs.getInt("quantity");
                String pName = rs.getString("PName");
                double price = rs.getDouble("price");
                String imgPath = rs.getString("imgPath");
                int status = rs.getInt("status");
                OrderDetail orderDetail = new OrderDetail(detailID, orderID, pid, pName, price, imgPath, quantity, status);
                orderDetails.add(orderDetail);
            }
            cn.close();
        }
        return orderDetails;
    }

    public static ArrayList<Order> getOrderByStatus(int accID, int status) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [OrderID], [OrdDate], [shipdate], [status], [AccID] "
                    + "FROM [PlantShop].[dbo].[Orders] "
                    + "WHERE [AccID] = ? AND [status] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accID);
            pst.setInt(2, status);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                int orderID = rs.getInt("OrderID");
                Date ordDate = rs.getDate("OrdDate");
                Date shipDate = rs.getDate("shipdate");
                Order order = new Order(orderID, ordDate, shipDate, status, accID);
                orders.add(order);
            }
            cn.close();
        }
        return orders;
    }

    //Rebuy function
    public static ArrayList<OrderDetail> getOrderDetailsByOrderID(int orderID) throws Exception {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT OD.[DetailID], OD.[OrderID], OD.[PID], OD.[quantity], P.[PName], P.[imgPath], P.[price] "
                    + "FROM [PlantShop].[dbo].[OrderDetails] OD "
                    + "INNER JOIN [PlantShop].[dbo].[Plants] P ON OD.[PID] = P.[PID] "
                    + "WHERE OD.[OrderID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderID);
            ResultSet rs = pst.executeQuery();
            while (rs != null && rs.next()) {
                int detailID = rs.getInt("DetailID");
                int pid = rs.getInt("PID");
                int quantity = rs.getInt("quantity");
                String pName = rs.getString("PName");
                double price = rs.getDouble("price");
                String imgPath = rs.getString("imgPath");
                OrderDetail orderDetail = new OrderDetail(detailID, orderID, pid, pName, price, imgPath, quantity);
                orderDetails.add(orderDetail);
            }
            cn.close();
        }
        return orderDetails;
    }

    public static boolean cancelOrder(String orderID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Orders] SET [status] = 3 WHERE [OrderID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, orderID);
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /////////////////////
    public static boolean reOrder(int orderID) throws Exception {
        Connection cn = null;
        boolean result = false;
        cn = DBUtils.makeConnection();
        if (cn != null) {
            int newOrderId = 0;
            cn.setAutoCommit(false);
            // Query to add new Orders row with old data
            String sql = "INSERT INTO Orders(OrdDate,status,AccID)\n"
                    + "SELECT ?,1,AccID\n"
                    + "FROM Orders\n"
                    + "WHERE OrderID=?";
            Date currentDate = new Date(System.currentTimeMillis());
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setDate(1, currentDate);
            pst.setInt(2, orderID);
            pst.executeUpdate();

            // Query to get new created OrderID
            sql = "SELECT TOP 1 OrderID\n"
                    + "FROM Orders\n"
                    + "ORDER BY OrderID DESC";
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                newOrderId = rs.getInt("OrderID");
            }

            // Query to add new OrderDetails with new OrderID
            sql = "INSERT INTO OrderDetails(OrderID,PID, quantity)\n"
                    + "SELECT ?, PID, quantity\n"
                    + "FROM OrderDetails\n"
                    + "WHERE OrderID=?";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, newOrderId);
            pst.setInt(2, orderID);
            pst.executeUpdate();

            cn.commit();
            cn.setAutoCommit(true);
            cn.close();
            return true;
        }
        return result;
    }

}
