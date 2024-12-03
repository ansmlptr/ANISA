/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produsc;

import java.sql.*;

public class modelProduSc {
    private Connection conn;

    public modelProduSc() {
        try {
            String url = "jdbc:mysql://localhost:3306/produsc";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return conn;
    }

    public ResultSet getAllData() throws SQLException {
        String query = "SELECT * FROM jadwal_produksi";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void insertData(String kodeProduk, java.sql.Date tglMulai, java.sql.Date tglSelesai, int totalProduksi, String status, String catatan, String dibuatOleh) throws SQLException {
        String query = "INSERT INTO jadwal_produksi (id_product, tanggal_mulai, tanggal_selesai, jumlah_produksi, status, catatan, created_by) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, kodeProduk);
        pstmt.setDate(2, tglMulai);
        pstmt.setDate(3, tglSelesai);
        pstmt.setInt(4, totalProduksi);
        pstmt.setString(5, status);
        pstmt.setString(6, catatan);
        pstmt.setString(7, dibuatOleh);
        pstmt.executeUpdate();

}


    public void updateData(int idJadwal, String kodeProduk, java.sql.Date tglMulai, java.sql.Date tglSelesai, int totalProduksi, String status, String catatan, String dibuatOleh) throws SQLException {
        String query = "UPDATE jadwal_produksi SET id_product=?, tanggal_mulai=?, tanggal_selesai=?, jumlah_produksi=?, status=?, catatan=?, created_by=? WHERE id_jadwal=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, kodeProduk);
        pstmt.setDate(2, tglMulai);
        pstmt.setDate(3, tglSelesai);
        pstmt.setInt(4, totalProduksi);
        pstmt.setString(5, status);
        pstmt.setString(6, catatan);
        pstmt.setString(7, dibuatOleh);
        pstmt.setInt(8, idJadwal);
        pstmt.executeUpdate();
    }

    public void deleteData(int idJadwal) throws SQLException {
        String query = "DELETE FROM jadwal_produksi WHERE id_jadwal=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idJadwal);
        pstmt.executeUpdate();
    }
}
