/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produsc;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class controllerProduSc {
    private modelProduSc model;
  
     public controllerProduSc() {
        model = new modelProduSc();
    }
     
    public DefaultTableModel getTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Jadwal");
        tableModel.addColumn("Kode Produk");
        tableModel.addColumn("Tanggal Mulai");
        tableModel.addColumn("Tanggal Selesai");
        tableModel.addColumn("Jumlah Produksi");
        tableModel.addColumn("Status");
        tableModel.addColumn("Catatan");
        tableModel.addColumn("Dibuat Oleh");

        try {
            ResultSet rs = model.getAllData();
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("id_jadwal"),
                    rs.getString("id_product"),
                    rs.getDate("tanggal_mulai"),
                    rs.getDate("tanggal_selesai"),
                    rs.getInt("jumlah_produksi"),
                    rs.getString("status"),
                    rs.getString("catatan"),
                    rs.getString("created_by")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return tableModel;
    }

    public void addData(String kodeProduk, java.sql.Date tglMulai, java.sql.Date tglSelesai, int totalProduksi, String status, String catatan, String dibuatOleh) {
    try {
        model.insertData(kodeProduk, tglMulai, tglSelesai, totalProduksi, status, catatan, dibuatOleh);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menambahkan data: " + e.getMessage());
    }
}

    public void updateData(int idJadwal, String kodeProduk, java.sql.Date tglMulai, java.sql.Date tglSelesai, int totalProduksi, String status, String catatan, String dibuatOleh) {
        try {
            model.updateData(idJadwal, kodeProduk, tglMulai, tglSelesai, totalProduksi, status, catatan, dibuatOleh);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengupdate data: " + e.getMessage());
        }
    }

    public void deleteData(int idJadwal) {
        try {
            model.deleteData(idJadwal);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
    }
    
}

