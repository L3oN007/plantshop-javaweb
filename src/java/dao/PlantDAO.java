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
                if (searchby == null || searchby.equalsIgnoreCase("by name")) {
                    sql = sql + " where Plants.PName like ?";
                } else {
                    sql = sql + " where CateName like ?";
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

    public static ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select [PID],[PName],[price],[imgPath],[description],[status],[Plants].[CateID] as 'CateID',[Categories].[CateName]\n"
                        + "from [dbo].[Plants] join [dbo].[Categories] on [Plants].[CateID] = [Categories].[CateID]";
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
                        + " where CateName like ?";
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

}
