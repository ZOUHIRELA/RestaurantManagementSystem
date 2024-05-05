package zayotech.restaurantmanagementsystem.model;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public interface ProductDAO {
    void getAllProducts(String jour, TableView<ProductDAOImpl> Jour_stock, TableColumn<ProductDAOImpl, String> Jour_productName,
                        TableColumn<ProductDAOImpl, Integer> Jour_quantité, TableColumn<ProductDAOImpl, Integer> Jour_qantitéMinimale,
                        TableColumn<ProductDAOImpl, Double> Jour_productPrix, TableColumn<ProductDAOImpl, Button> Jour_modifierBtn,
                        TableColumn<ProductDAOImpl, Button> Jour_validerBtn, TableColumn<ProductDAOImpl, Button> Jour_supprimerBtn) throws SQLException;


}
