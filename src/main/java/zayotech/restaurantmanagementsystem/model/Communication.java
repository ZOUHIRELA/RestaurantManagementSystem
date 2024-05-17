package zayotech.restaurantmanagementsystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Communication {

    UserDAOImpl user = new UserDAOImpl();

    public void insertMessageIntoDatabase(int id_user, String message, LocalDate date) throws SQLException {

        Connection con = user.getConnection();

        String sql = "INSERT INTO avis (ID_utilisateur, Date, Contenu) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id_user);
            statement.setDate(2, java.sql.Date.valueOf(date));
            statement.setString(3, message);

            statement.executeUpdate();
        }
    }

    public List<String[]> getAllMessagesFromDatabase() throws SQLException {
        List<String[]> messages = new ArrayList<>();
        try (Connection connection = user.getConnection()) {
            String sql = "SELECT avis.ID_utilisateur, avis.Contenu, utilisateurs.Type_utilisateur, CONCAT(utilisateurs.Nom, ' ', utilisateurs.Prenom) AS NomComplet " +
                    "FROM avis " +
                    "JOIN utilisateurs ON avis.ID_utilisateur = utilisateurs.ID_utilisateur";
            try (PreparedStatement ps = connection.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String[] message = new String[4];
                    message[0] = String.valueOf(rs.getInt("ID_utilisateur"));
                    message[1] = rs.getString("Contenu");
                    message[2] = rs.getString("Type_utilisateur");
                    message[3] = rs.getString("NomComplet");
                    messages.add(message);
                }
            }
        }
        return messages;
    }

}
