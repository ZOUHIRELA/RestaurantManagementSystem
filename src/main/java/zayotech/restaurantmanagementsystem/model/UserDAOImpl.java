package zayotech.restaurantmanagementsystem.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private Alert alert;

    public Alert alert(Alert.AlertType alertType, String title, String content) {
        alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
        return alert;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
    }

    private boolean emailExists(String email) throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("select count(*) from utilisateurs where Email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }

    @Override
    public void signUp(AnchorPane signUpForm, String Nom, String Prenom, ComboBox<String> Type_utilisateur, String Email, String Mot_de_passe, ComboBox<String> Statut, ComboBox<String> question, String answer) throws SQLException {
        if (Nom.isEmpty() || Prenom.isEmpty() || Type_utilisateur.getSelectionModel().getSelectedItem() == null || Email.isEmpty() || Mot_de_passe.isEmpty() || Statut.getSelectionModel().getSelectedItem() == null || question.getSelectionModel().getSelectedItem() == null || answer.isEmpty()) {
            alert(Alert.AlertType.ERROR, "Erreur de saisie", "Veuillez remplir tous les champs obligatoires.");
        } else if (Mot_de_passe.length() < 8 || !Mot_de_passe.matches(".*[A-Z].*") || !Mot_de_passe.matches(".*[a-z].*") || !Mot_de_passe.matches(".*\\d.*") || !Mot_de_passe.matches(".*[!@#$%^&*()_+{}\\[\\]|\\\\;:'\",.<>?/].*")) {
            alert(Alert.AlertType.ERROR, "Mot de passe invalide", "Le mot de passe doit avoir au moins 8 caractères et contenir des lettres majuscules, minuscules, chiffres et caractères spéciaux.");
        } else if (!Email.matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+(?:[a-zA-Z]{2,}|ac\\.ma)$")) {
            alert(Alert.AlertType.ERROR, "Email invalide", "Veuillez saisir une adresse email valide.");
        } else {
            if (emailExists(Email)) {
                alert(Alert.AlertType.ERROR, "Email existant", "L'adresse email existe déjà dans la base de données.");
            } else {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("insert into utilisateurs (Nom, Prenom, Type_utilisateur, Email, Mot_de_passe,Statut , Question , Answer) values(?,?,?,?,?,?,?,?)");
                ps.setString(1, Nom);
                ps.setString(2, Prenom);
                ps.setString(3, Type_utilisateur.getSelectionModel().getSelectedItem());
                ps.setString(4, Email);
                ps.setString(5, Mot_de_passe);
                ps.setString(6, Statut.getSelectionModel().getSelectedItem());
                ps.setString(7, question.getSelectionModel().getSelectedItem());
                ps.setString(8, answer);
                ps.executeUpdate();
                alert(Alert.AlertType.INFORMATION, "Inscription", "Votre inscription a été enregistrée avec succès.");
                signUpForm.setVisible(false);
            }
        }
    }


    @Override
    public String signIn(String email, String password) throws SQLException {
        if (email.isEmpty() || password.isEmpty()) {
            alert(Alert.AlertType.ERROR, "Ereur de saisie", "Veuillez remplir tous les champs !");
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+(?:[a-zA-Z]{2,}|ac\\.ma)$")) {
            alert(Alert.AlertType.ERROR, "Email invalide", "Veuillez saisir une adresse email valide.");
        } else if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()_+{}\\[\\]|\\\\;:'\",.<>?/].*")) {
            alert(Alert.AlertType.ERROR, "Mot de passe invalide", "Le mot de passe doit avoir au moins 8 caractères et contenir des lettres majuscules, minuscules, chiffres et caractères spéciaux.");
        } else {
            Connection con = getConnection();
            String sql = "select * from utilisateurs where Email = ? and Mot_de_passe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alert(Alert.AlertType.INFORMATION, "Connection", "Vous avez connecté avec succès !");
                return getUserType(email);
            } else {
                alert(Alert.AlertType.ERROR, "Connection", "Email ou Mote de Passe Erroné !");
            }
        }
        return email;
    }

    @Override
    public void signOut() {

    }

    @Override
    public void forgotPassword(TextField email, ComboBox<String> question, TextField answer, AnchorPane forgotPassword_side) throws SQLException {
        if (email.getText().isEmpty() || question.getSelectionModel().getSelectedItem().isEmpty() || answer.getText().isEmpty()) {
            alert(Alert.AlertType.ERROR, "Erreur de saisie", "Veuillez remplir tous les champs obligatoires.");
        } else if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+(?:[a-zA-Z]{2,}|ac\\.ma)$")) {
            alert(Alert.AlertType.ERROR, "Email invalide", "Veuillez saisir une adresse email valide.");
        } else {
            String sql = "select  Email , Question , Answer from utilisateurs where Email = ?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alert(Alert.AlertType.INFORMATION, "Changement", "Veuillez saisir votre nouveau mot de passe dans le slide !");
                forgotPassword_side.setVisible(false);
                email.clear();
                question.getSelectionModel().clearSelection();
                answer.clear();
            } else {
                alert(Alert.AlertType.ERROR, "Erreur", "Utilisateur n'est pas éxiste !");
            }
        }
    }


    @Override
    public void changePassword(AnchorPane forgotPassword_side, AnchorPane login_side, TextField email, PasswordField password, PasswordField confirmePassword) throws SQLException {
        if (password.getText().isEmpty() || confirmePassword.getText().isEmpty()) {
            alert(Alert.AlertType.ERROR, "Erreur de saisie", "Veuillez remplir tous les champs obligatoires.");
        } else if (password.getText().length() < 8 || !password.getText().matches(".*[A-Z].*") || !password.getText().matches(".*[a-z].*") || !password.getText().matches(".*\\d.*") || !password.getText().matches(".*[!@#$%^&*()_+{}\\[\\]|\\\\;:'\",.<>?/].*")) {
            alert(Alert.AlertType.ERROR, "Mot de passe invalide", "Le mot de passe doit avoir au moins 8 caractères et contenir des lettres majuscules, minuscules, chiffres et caractères spéciaux.");
        } else if (!password.getText().equals(confirmePassword.getText())) {
            alert(Alert.AlertType.ERROR, "Erreur de saisie", "Les mots de passe saisis ne correspondent pas !");
        } else {
            Connection con = getConnection();
            String updateSql = "UPDATE utilisateurs SET Mot_de_passe = ? WHERE Email = ?";
            PreparedStatement updatePs = con.prepareStatement(updateSql);
            updatePs.setString(1, password.getText());
            updatePs.setString(2, email.getText());
            updatePs.executeUpdate();
            updatePs.close();
            alert(Alert.AlertType.INFORMATION, "Changement de Mot de Passe", "Le mot de passe a été changé avec succès !");
            forgotPassword_side.setVisible(true);
            login_side.setVisible(true);
            password.clear();
            confirmePassword.clear();
        }
    }


    @Override
    public String getUserType(String email) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String userType = null;

        try {
            con = getConnection();
            String sql = "SELECT Type_utilisateur FROM utilisateurs WHERE Email = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                userType = rs.getString("Type_utilisateur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return userType;
    }
}