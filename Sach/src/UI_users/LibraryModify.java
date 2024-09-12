/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryModify {

    public static List<ql_sach> findALL() {
        List<ql_sach> libraryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "");
            // gia tri tra ve danh sach
            String sql = "SELECT * FROM ql_sach ORDER BY Tieu_De,So_Luong";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ql_sach book = new ql_sach(
                    resultSet.getInt("STT"),
                    resultSet.getString("Tiêu Đề"),
                    resultSet.getString("Tác Giả"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("Thể Loại"),                        
                    resultSet.getInt("Năm Sáng Tác"),
                    resultSet.getInt("Số Lượng"));
                libraryList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return libraryList;
    }
}


