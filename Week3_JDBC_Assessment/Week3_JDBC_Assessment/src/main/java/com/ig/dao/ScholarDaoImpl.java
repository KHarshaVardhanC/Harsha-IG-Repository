package com.ig.dao;

import com.ig.exception.ScholarNotFoundException;
import com.ig.model.Scholar;
import com.ig.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScholarDaoImpl implements ScholarDao {

    @Override
    public void addScholar(Scholar scholar) {
        String sql = "INSERT INTO Scholar (Name, Email, Mobile) VALUES (?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, scholar.getName());
            ps.setString(2, scholar.getEmail());
            ps.setString(3, scholar.getMobile());
            ps.executeUpdate();
            System.out.println("Scholar added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Scholar> listAllScholars() {
        List<Scholar> scholars = new ArrayList<>();
        String sql = "SELECT * FROM Scholar";
        try (Connection conn = DbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                scholars.add(new Scholar(rs.getInt("scholarId"), rs.getString("Name"),
                        rs.getString("Email"), rs.getString("Mobile")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scholars;
    }

    @Override
    public Scholar getOneScholar(int scholarId) throws ScholarNotFoundException {
        String sql = "SELECT * FROM Scholar WHERE scholarId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, scholarId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Scholar(rs.getInt("scholarId"), rs.getString("Name"),
                        rs.getString("Email"), rs.getString("Mobile"));
            } else {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ScholarNotFoundException("Database error.");
        }
    }

    @Override
    public void updateScholarEmail(int scholarId, String email) throws ScholarNotFoundException {
        String sql = "UPDATE Scholar SET Email = ? WHERE scholarId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setInt(2, scholarId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteScholarById(int scholarId) throws ScholarNotFoundException {
        String sql = "DELETE FROM Scholar WHERE scholarId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, scholarId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new ScholarNotFoundException("Scholar with ID " + scholarId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
