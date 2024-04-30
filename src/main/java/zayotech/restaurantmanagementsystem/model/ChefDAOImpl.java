package zayotech.restaurantmanagementsystem.model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefDAOImpl implements ChefDAO {
    @Override
    public void getMenu(String jour, String typeRepas, TextArea platPrincipalTextArea, TextArea entreeTextArea, TextArea dessertTextArea, TextArea descriptionTextArea, CheckBox disponibiliteCheckBox) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();
        String sql = "SELECT Plat_principal, Entree, Dessert, Description_repas, Disponible " +
                "FROM menus WHERE Jour = ? and Type_repas = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, jour);
        ps.setString(2, typeRepas);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            platPrincipalTextArea.setText(rs.getString("Plat_principal"));
            entreeTextArea.setText(rs.getString("Entree"));
            dessertTextArea.setText(rs.getString("Dessert"));
            descriptionTextArea.setText(rs.getString("Description_repas"));

            String disponibilite = rs.getString("Disponible");
            if (disponibilite.equalsIgnoreCase("oui")) {
                disponibiliteCheckBox.setSelected(true);
            } else {
                disponibiliteCheckBox.setSelected(false);
            }
        }

        rs.close();
        ps.close();
        con.close();
    }


    @Override
    public void modifyMenu(String jour, String typeRepas, TextArea platPrincipalTextArea,
                           TextArea entreeTextArea, TextArea dessertTextArea, TextArea descriptionTextArea,
                           CheckBox disponibiliteCheckBox) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();
        String sql = "UPDATE menus SET Plat_principal=?, Entree=?, Dessert=?, Description_repas=?, Disponible=? " +
                "WHERE Jour=? AND Type_repas=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, platPrincipalTextArea.getText());
        ps.setString(2, entreeTextArea.getText());
        ps.setString(3, dessertTextArea.getText());
        ps.setString(4, descriptionTextArea.getText());
        ps.setString(5, disponibiliteCheckBox.isSelected() ? "Oui" : "Non"); // Supposons que la disponibilité est enregistrée sous forme de chaîne
        ps.setString(6, jour);
        ps.setString(7, typeRepas);

        ps.executeUpdate();
        ps.close();
        con.close();
    }

    @Override
    public void getAllEmployees(TextArea nomTextArea, TextArea prenomTextArea, TextArea posteTextArea, TextArea salaireTextArea, TextArea dateEmbaucheTextArea) throws SQLException {

        nomTextArea.clear();
        prenomTextArea.clear();
        posteTextArea.clear();
        salaireTextArea.clear();
        dateEmbaucheTextArea.clear();

        UserDAOImpl userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();
        String sql = "select ID_employe , Nom , Prenom , Poste , Salaire , Date_embauche from employes";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            nomTextArea.appendText(rs.getInt("ID_employe")+" : "+rs.getString("Nom") + "\t");
            prenomTextArea.appendText(rs.getString("Prenom") + "\t");
            posteTextArea.appendText(rs.getString("Poste") + "\t");
            salaireTextArea.appendText(rs.getString("Salaire") + "\t");
            dateEmbaucheTextArea.appendText(rs.getString("Date_embauche") + "\n");

            // Insérer une ligne horizontale après chaque employé
            nomTextArea.appendText("---------------------\n");
            prenomTextArea.appendText("---------------------\n");
            posteTextArea.appendText("-----------------------\n");
            salaireTextArea.appendText("-------------------\n");
            dateEmbaucheTextArea.appendText("------------------------\n");

        }

        nomTextArea.setEditable(false);
        prenomTextArea.setEditable(false);
        posteTextArea.setEditable(false);
        salaireTextArea.setEditable(false);
        dateEmbaucheTextArea.setEditable(false);

        rs.close();
        ps.close();
        con.close();
    }
}



