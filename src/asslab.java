import java.sql.*;

public class asslab {
    static final String DB_URL = "jdbc:mysql://localhost:3306/asslab";
    static final String USER = "root";
    static final String PASS = "Amankumar@22";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void insertEntries(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO entry (id, Name, Passing, Dribbling, Market_value) " +
                    "VALUES (1, 'Ronado', 97, 96, 900000), " +
                    "(2, 'Messi', 99, 99, 930000)";
            stmt.executeUpdate(sql);
            System.out.println("Entries inserted successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public static void retrieveEntries(Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id, Name, Passing, Dribbling, Market_value FROM entry";
            rs = stmt.executeQuery(sql);
            System.out.println("Retrieving entries...");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int passing = rs.getInt("Passing");
                int dribbling = rs.getInt("Dribbling");
                int marketValue = rs.getInt("Market_value");
                System.out.println("ID: " + id + " Name: " + name + " Passing: " + passing +
                        " Dribbling: " + dribbling + " Market_value: " + marketValue);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = getConnection();

            insertEntries(conn);

            retrieveEntries(conn);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}