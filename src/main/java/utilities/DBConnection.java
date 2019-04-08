// deprecated Method as switched to JPA


//package utilities;
//
//import java.sql.*;
//
//public class DBConnection {
//    private static Connection conn = null;
//
//    private DBConnection() {
//    }
//
//    public static Connection getInstance() {
//        try {
//            if (conn == null) {
//                Class.forName("com.mysql.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost/hearthstone", "root", "");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("DbConnection Instanzierung fehlgeschlagen");
//        } catch (SQLException e) {
//            System.out.println("SQL exception occured " + e);
//        }
//        return conn;
//    }
//}
