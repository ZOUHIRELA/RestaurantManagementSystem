package zayotech.restaurantmanagementsystem.model;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

public interface ChefDAO {
    public void getMenu(String jour, String typeRepas, TextArea platPrincipalTextArea, TextArea entreeTextArea, TextArea dessertTextArea, TextArea descriptionTextArea, CheckBox disponibiliteCheckBox) throws SQLException;

    public void modifyMenu(String jour, String typeRepas, TextArea platPrincipalTextArea, TextArea entreeTextArea, TextArea dessertTextArea, TextArea descriptionTextArea, CheckBox disponibiliteCheckBox) throws SQLException;

}
