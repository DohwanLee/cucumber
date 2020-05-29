package RDS;
import java.sql.*;

public class RdsConnector {
    private static Connection con = null; // 데이터 베이스와 연결을 위한 객체
    private Statement stmt = null; // SQL 문을 데이터베이스에 보내기위한 객체
    private ResultSet rs = null; // SQL 질의에 의해 생성된 테이블을 저장하는 객체

    // AWS RDS Connect
    public static void connect() {
        String server = "database-fota.cgmpyx1k7gl4.ap-northeast-2.rds.amazonaws.com:3306"; // MySQL 서버 주소
        String database = "test"; // MySQL DATABASE 이름
        String user_name = "admin"; //  MySQL 서버 아이디
        String password = "hmG190221!"; // MySQL 서버 비밀번호

        // 1.Load JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.Connect to RDS
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }
    }

//    public static void connect() {
//        String server = "database-fota.cgmpyx1k7gl4.ap-northeast-2.rds.amazonaws.com:3306"; // MySQL 서버 주소
//        String database = "test"; // MySQL DATABASE 이름
//        String user_name = "admin"; //  MySQL 서버 아이디
//        String password = "hmG190221!"; // MySQL 서버 비밀번호
//
//        // 1.Load JDBC
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        // 2.Connect to RDS
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
//            System.out.println("정상적으로 연결되었습니다.");
//        } catch (SQLException e) {
//            System.err.println("con 오류:" + e.getMessage());
//            e.printStackTrace();
//        }
//    }

    // AWS RDS Disconnect
    public static void disconnect() {
        try {
            if (con != null) {
                con.close();
                System.out.println("정상적으로 해제되었습니다.");
            }
        } catch (SQLException e) {
        }
    }
}
