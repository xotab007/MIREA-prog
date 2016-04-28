import java.sql.*;

/**
 * Created by MikhailKovalenko on 28.04.16.
 */
public class TestDB {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO TODO (TEXT) VALUES (?)")) {
                st.setString(1, "Создать пример JDBC");
                st.execute();
            }
            try (PreparedStatement st = conn.prepareStatement("SELECT ID, TEXT FROM TODO ORDER BY ID DESC")){
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()){
                        int id = rs.getInt(1);
                        String text = rs.getString(2);
                        System.out.println(id + "; " + text);
                    }
                }
            }
            try (PreparedStatement st = conn.prepareStatement("DELETE FROM TODO WHERE ID = ?")){
                st.setInt(1, 2);
                st.execute();
            }
        }
    }
}
