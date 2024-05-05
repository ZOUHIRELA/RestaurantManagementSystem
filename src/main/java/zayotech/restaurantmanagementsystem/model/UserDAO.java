package zayotech.restaurantmanagementsystem.model;

import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDAO {
    Connection getConnection() throws SQLException;

    void signUp(AnchorPane signUpForm, String Nom, String Prenom, ComboBox<String> Type_utilisateur, String Email, String Mot_de_passe, ComboBox<String> Statut, ComboBox<String> question, String answer) throws SQLException;

    String signIn(String email, String password) throws SQLException;

    void signOut();

    void forgotPassword(TextField email, ComboBox<String> question, TextField answer , AnchorPane forgotPassword_side) throws SQLException;

    String getUserType(String email) throws SQLException;

    void changePassword(AnchorPane forgotPassword_side, AnchorPane login_side, TextField email, PasswordField password, PasswordField confirmePassword) throws SQLException;
}
