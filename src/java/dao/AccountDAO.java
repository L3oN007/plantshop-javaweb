/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Account;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.sql.Types;
import utils.DBUtils;

/**
 *
 * @author minhn
 */
public class AccountDAO {

    public static Account getAccount(String email, String password) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                // String sql = "select accID,email,password,fullname,phone,status,role\n"
                // + "from dbo.Accounts\n"
                // + "where status=1 and email=? and password=? COLLATE Lantin1_General_CS_AS ";
                String sql = "select [accID],[email],[password],[fullname],[phone],[status],[role]\n"
                        + "from [dbo].[Accounts]\n"
                        + "where [status]=1 and [email] = ? and [password] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
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
        return acc;
    }

    public static Account getAccount(String email) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [accID], [email], [password], [fullname], [phone], [status], [role] "
                        + "FROM [dbo].[Accounts] "
                        + "WHERE [status]=1 AND [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
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
        return acc;
    }

    public static ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [accID],[email],[password],[fullname],[phone],[status],[role]\n"
                        + "from [dbo].[Accounts]";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        int accID = rs.getInt("accID");
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String fullname = rs.getString("fullname");
                        String phone = rs.getString("phone");
                        int status = rs.getInt("status");
                        int role = rs.getInt("role");
                        Account acc = new Account(accID, email, password, fullname, status, phone, role);
                        accounts.add(acc);
                    }
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
        return accounts;
    }

    public static boolean updateAccountStatus(String email, int status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts] set [status] = ? where [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, email);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
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

    public static boolean insertAccount(String newEmail, String newPassword, String newFullname,
            String newPhone, int newStatus, int newRole) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                if (checkEmail(newEmail)) {
                    return false; // Email already exists, cannot insert new account
                }
                String sql = "insert into [dbo].[Accounts]([email],[password],[fullname],[phone],[status],[role]) "
                        + "values(?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newEmail);
                pst.setString(2, newPassword);
                pst.setString(3, newFullname);
                pst.setString(4, newPhone);
                pst.setInt(5, newStatus);
                pst.setInt(6, newRole);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
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

    public static boolean updateAccount(String email, String newPassword, String newFullname, String newPhone) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[Accounts] "
                        + "set ";
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    sql += "[password]=?, ";
                }
                if (newFullname != null && !newFullname.trim().isEmpty()) {
                    sql += "[fullname]=?, ";
                }
                if (newPhone != null && !newPhone.trim().isEmpty()) {
                    sql += "[phone]=?, ";
                }
                // Remove trailing comma and space
                sql = sql.replaceAll(", $", " ");
                sql += "where [email]=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                int index = 1;
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    pst.setString(index++, newPassword);
                }
                if (newFullname != null && !newFullname.trim().isEmpty()) {
                    pst.setString(index++, newFullname);
                }
                if (newPhone != null && !newPhone.trim().isEmpty()) {
                    pst.setString(index++, newPhone);
                }
                pst.setString(index++, email);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
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

    public static boolean checkLogin(String email, String password) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Accounts] where [email]=? and [password]=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
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

    public static boolean checkPassword(String email, String password) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Accounts] where [email] = ? and [password] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
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

    public static boolean checkEmail(String email) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select * from [dbo].[Accounts] where [email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
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

    //generateToken
    private static SecureRandom random = new SecureRandom();

    public static String generateToken() {
        return new BigInteger(130, random).toString(32);
    }

    public static boolean updateAccountToken(Account account) {
        Connection cn = null;
        PreparedStatement pst = null;
        boolean success = false;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Accounts] SET [token]=? WHERE [accID]=?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, account.getToken());
                pst.setInt(2, account.getAccID());
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public static Account getAccountByToken(String token) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [accID], [email], [password], [fullname], [phone], [status], [role] "
                        + "FROM [dbo].[Accounts] "
                        + "WHERE [status] = 1 AND [token] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int accID = rs.getInt("accID");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new Account(accID, email, password, fullname, status, phone, role);
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
        return acc;
    }

    public static void deleteToken(String accID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Accounts] SET [token] = NULL WHERE [accID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, accID);
                pst.executeUpdate();
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
    }

}
