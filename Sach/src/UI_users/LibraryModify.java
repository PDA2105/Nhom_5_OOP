/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI_users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryModify {

    public static List<ql_sach> Connect() {
        List<ql_sach> libraryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "SELECT * FROM ql_sach ORDER BY `Tiêu Đề`, `Tác Giả`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ql_sach book = new ql_sach(
                        
                    resultSet.getString("Tiêu Đề"),
                    resultSet.getString("Tác Giả"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("Thể Loại"),
                    resultSet.getInt("STT"),
                    resultSet.getInt("Năm Xuất Bản"),
                    resultSet.getInt("Số Lượng")
                );
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

    public static void Insert(ql_sach std){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
           String sql = " INSERT INTO `library_management`.`ql_sach` (`Tiêu Đề`, `Tác Giả`, `ISBN`, `Thể Loại`, `Năm Xuất Bản`, `Số Lượng`) VALUES (?, ?, ?, ?, ?, ?)";
           statement = connection.prepareStatement(sql);
            
            statement.setString(1, std.getTieu_De());
            statement.setString(2, std.getTac_Gia());
            statement.setString(3, std.getISBN());
            statement.setString(4, std.getThe_Loai());
            statement.setInt(5, std.getNam_Xuat_Ban());
            statement.setInt(6, std.getSo_Luong());
            
            statement.execute();           
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
    }

    public static void UpDate(ql_sach std){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "UPDATE ql_sach SET `Tiêu Đề`=?, `Tác Giả`=?, `ISBN`=?, `Thể Loại`=?, `Năm Xuất Bản`=?, `Số Lượng`=? where `STT`=?";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, std.getTieu_De());
            statement.setString(2, std.getTac_Gia());
            statement.setString(3, std.getISBN());
            statement.setString(4, std.getThe_Loai());
            statement.setInt(5, std.getNam_Xuat_Ban());
            statement.setInt(6, std.getSo_Luong());
            statement.setInt(7, std.getSTT());

            
            statement.execute();           
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
    }
    
        public static void Delete(int STT){
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "DELETE FROM ql_sach where STT=? ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,STT);
            
            statement.execute();           
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
    }
    
    public static List<ql_sach> find_Sach(String Tieu_De) {
        List<ql_sach> libraryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "SELECT * FROM ql_sach WHERE `Tiêu Đề` LIKE ? ORDER BY `Tiêu Đề`, `Tác Giả`";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+ Tieu_De + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ql_sach book = new ql_sach(
                        
                    resultSet.getString("Tiêu Đề"),
                    resultSet.getString("Tác Giả"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("Thể Loại"),
                    resultSet.getInt("STT"),
                    resultSet.getInt("Năm Xuất Bản"),
                    resultSet.getInt("Số Lượng")
                );
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
    
        public static List<ql_sach> find_ISBN(String ISBN) {
        List<ql_sach> libraryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "SELECT * FROM ql_sach WHERE `ISBN` LIKE ? ORDER BY `Tiêu Đề`, `Tác Giả`";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+ ISBN + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ql_sach book = new ql_sach(
                        
                    resultSet.getString("Tiêu Đề"),
                    resultSet.getString("Tác Giả"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("Thể Loại"),
                    resultSet.getInt("STT"),
                    resultSet.getInt("Năm Xuất Bản"),
                    resultSet.getInt("Số Lượng")
                );
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
        
     public static List<ql_sach> find_Ten(String Tac_Gia) {
        List<ql_sach> libraryList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // lay tat ca danh sach sv
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "Nhom5123456");
            // gia tri tra ve danh sach
            String sql = "SELECT * FROM ql_sach WHERE `Tác Giả` LIKE ? ORDER BY `Tiêu Đề`, `Tác Giả`";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+ Tac_Gia + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ql_sach book = new ql_sach(
                        
                    resultSet.getString("Tiêu Đề"),
                    resultSet.getString("Tác Giả"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("Thể Loại"),
                    resultSet.getInt("STT"),
                    resultSet.getInt("Năm Xuất Bản"),
                    resultSet.getInt("Số Lượng")
                );
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

