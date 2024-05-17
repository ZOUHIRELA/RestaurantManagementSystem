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
        ps.setString(5, disponibiliteCheckBox.isSelected() ? "Oui" : "Non");
        ps.setString(6, jour);
        ps.setString(7, typeRepas);

        ps.executeUpdate();
        ps.close();
        con.close();
    }

}



