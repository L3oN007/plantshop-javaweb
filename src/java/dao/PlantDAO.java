/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Plant;
import utils.DBUtils;

/**
 *
 * @author minhn
 */
public class PlantDAO {

    public static ArrayList<Plant> getPlants(String keyword, String searchby) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [PID],[PName],[price],[imgPath],[description],[status],[Plants].[CateID] as 'CateID',[Categories].[CateName]\n"
                        + "from [dbo].[Plants] join [dbo].[Categories] on [Plants].[CateID] = [Categories].[CateID]";
                if (searchby == null || searchby.equalsIgnoreCase("by name") || searchby.trim().isEmpty()) {
                    sql = sql + " where Plants.PName like ? AND Plants.status = 1 ";
                } else {
                    sql = sql + " where CateName like ? AND Plants.status = 1  ";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + keyword + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgpath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public static ArrayList<Plant> searchManagePlant(String PlantName) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [PID],[PName],[price],[imgPath],[description],[status],[Plants].[CateID] as 'CateID',[Categories].[CateName]\n"
                        + "from [dbo].[Plants] join [dbo].[Categories] on [Plants].[CateID] = [Categories].[CateID]\n"
                        + " where Plants.PName like ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + PlantName + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgpath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public static ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [PID],[PName],[price],[imgPath],[description],[status],[Plants].[CateID] AS 'CateID',[Categories].[CateName]\n"
                        + "FROM [dbo].[Plants] JOIN [dbo].[Categories] ON [Plants].[CateID] = [Categories].[CateID]";

                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgpath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public static ArrayList<Plant> getPlantByCate(String category) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [PID],[PName],[price],[imgPath],[description],[status],[Plants].[CateID] as 'CateID',[Categories].[CateName]\n"
                        + "from [dbo].[Plants] join [dbo].[Categories] on [Plants].[CateID] = [Categories].[CateID]"
                        + " where CateName like ? AND Plants.status = 1";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + category + "%");
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgpath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Plant getPlant(String id) throws Exception {
        Plant plant = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [PID], [PName], [price], [imgPath], [description], [status], [Plants].[CateID] AS 'CateID', [Categories].[CateName]\n"
                    + "FROM [dbo].[Plants] JOIN [dbo].[Categories] ON [Plants].[CateID] = [Categories].[CateID]\n"
                    + "WHERE Plants.PID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                int plantId = rs.getInt("PID");
                String name = rs.getString("PName");
                int price = rs.getInt("price");
                String imgpath = rs.getString("imgPath");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                int cateid = rs.getInt("CateID");
                String catename = rs.getString("CateName");
                plant = new Plant(plantId, name, price, imgpath, description, status, cateid, catename);
            }
            cn.close();
        }
        return plant;
    }

    public static boolean updatePlant(int PID, String newName, String newPrice, String newImgPath, String newDescription, String newCateID) {
        boolean success = false;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Plants] SET ";
                if (newName != null && !newName.trim().isEmpty()) {
                    sql += "[PName] = ?, ";
                }
                if (newPrice != null && !newPrice.trim().isEmpty()) {
                    sql += "[price] = ?, ";
                }
                if (newImgPath != null && !newImgPath.trim().isEmpty()) {
                    sql += "[imgPath] = ?, ";
                }
                if (newDescription != null && !newDescription.trim().isEmpty()) {
                    sql += "[description] = ?, ";
                }
                if (newCateID != null && !newCateID.trim().isEmpty()) {
                    sql += "[CateID] = ?, ";
                }
                sql = sql.replaceAll(", $", " ") + "WHERE [PID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                int index = 1;
                if (newName != null && !newName.trim().isEmpty()) {
                    pst.setString(index++, newName);
                }
                if (newPrice != null && !newPrice.trim().isEmpty()) {
                    pst.setString(index++, newPrice);
                }
                if (newImgPath != null && !newImgPath.trim().isEmpty()) {
                    pst.setString(index++, newImgPath);
                }
                if (newDescription != null && !newDescription.trim().isEmpty()) {
                    pst.setString(index++, newDescription);
                }
                if (newCateID != null && !newCateID.trim().isEmpty()) {
                    pst.setString(index++, newCateID);
                }
                pst.setInt(index++, PID);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
                cn.close();
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
        return success;
    }

    public static boolean updatePlantStatus(int PID, int newStatus) {
        boolean success = false;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Plants] SET [status] = ? WHERE [PID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, newStatus);
                pst.setInt(2, PID);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
                cn.close();
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
        return success;
    }

    public static boolean updateCategory(int CateID, String newCateName) {
        boolean success = false;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Categories] SET ";
                if (newCateName != null && !newCateName.trim().isEmpty()) {
                    sql += "[CateName] = ? ";
                }
                sql += "WHERE [CateID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                if (newCateName != null && !newCateName.trim().isEmpty()) {
                    pst.setString(1, newCateName);
                    pst.setInt(2, CateID);
                } else {
                    pst.setInt(1, CateID);
                }
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    success = true;
                }
                cn.close();
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
        return success;
    }

    public static ArrayList<Plant> getAllCategory() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [CateID],[CateName]\n"
                        + "  FROM [PlantShop].[dbo].[Categories]";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CateID = rs.getInt("CateID");
                        String CateName = rs.getString("CateName");
                        Plant plant = new Plant(CateID, CateName);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public static ArrayList<Plant> searchCategoryByCateName(String CateName) {
        ArrayList<Plant> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [CateID],[CateName]\n"
                        + "  FROM [PlantShop].[dbo].[Categories] WHERE [CateName] like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" +  CateName + "%" );
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CateID = rs.getInt("CateID");
                        String categoryName = rs.getString("CateName");
                        Plant plant = new Plant(CateID, categoryName);
                        result.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
