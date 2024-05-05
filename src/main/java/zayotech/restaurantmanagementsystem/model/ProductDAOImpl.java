package zayotech.restaurantmanagementsystem.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductDAOImpl {

    private final IntegerProperty idProduit = new SimpleIntegerProperty();
    private final StringProperty nomProduit = new SimpleStringProperty();
    private final IntegerProperty quantiteDisponible = new SimpleIntegerProperty();
    private final IntegerProperty quantiteMinimaleAlerte = new SimpleIntegerProperty();
    private final DoubleProperty prixProduit = new SimpleDoubleProperty();

    private final Button modifierBtn = new Button("Modifier");
    private final Button validerBtn = new Button("Valider");
    private final Button supprimerBtn = new Button("Supprimer");

    private final TableView<ProductDAOImpl> jourStock;
    private final TableColumn<ProductDAOImpl, String> nomProduitCol;
    private final TableColumn<ProductDAOImpl, Integer> quantiteDisponibleCol;
    private final TableColumn<ProductDAOImpl, Integer> quantiteMinimaleCol;
    private final TableColumn<ProductDAOImpl, Double> prixProduitCol;
    private final TableColumn<ProductDAOImpl, Button> modifierBtnCol;
    private final TableColumn<ProductDAOImpl, Button> validerBtnCol;
    private final TableColumn<ProductDAOImpl, Button> supprimerBtnCol;

    public ProductDAOImpl(TableView<ProductDAOImpl> jourStock, TableColumn<ProductDAOImpl, String> nomProduitCol,
                          TableColumn<ProductDAOImpl, Integer> quantiteDisponibleCol, TableColumn<ProductDAOImpl, Integer> quantiteMinimaleCol,
                          TableColumn<ProductDAOImpl, Double> prixProduitCol, TableColumn<ProductDAOImpl, Button> modifierBtnCol,
                          TableColumn<ProductDAOImpl, Button> validerBtnCol, TableColumn<ProductDAOImpl, Button> supprimerBtnCol) {
        this.jourStock = jourStock;
        this.nomProduitCol = nomProduitCol;
        this.quantiteDisponibleCol = quantiteDisponibleCol;
        this.quantiteMinimaleCol = quantiteMinimaleCol;
        this.prixProduitCol = prixProduitCol;
        this.modifierBtnCol = modifierBtnCol;
        this.validerBtnCol = validerBtnCol;
        this.supprimerBtnCol = supprimerBtnCol;
        setButtonActions();
    }

    public ProductDAOImpl(int idProduit, String nomProduit, int quantiteDisponible, int quantiteMinimaleAlerte, double prixProduit,
                          TableView<ProductDAOImpl> jourStock, TableColumn<ProductDAOImpl, String> nomProduitCol, TableColumn<ProductDAOImpl, Integer> quantiteDisponibleCol,
                          TableColumn<ProductDAOImpl, Integer> quantiteMinimaleCol, TableColumn<ProductDAOImpl, Double> prixProduitCol, TableColumn<ProductDAOImpl, Button> modifierBtnCol,
                          TableColumn<ProductDAOImpl, Button> validerBtnCol, TableColumn<ProductDAOImpl, Button> supprimerBtnCol) {
        this(jourStock, nomProduitCol, quantiteDisponibleCol, quantiteMinimaleCol, prixProduitCol, modifierBtnCol, validerBtnCol, supprimerBtnCol);
        setIdProduit(idProduit);
        setNomProduit(nomProduit);
        setQuantiteDisponible(quantiteDisponible);
        setQuantiteMinimaleAlerte(quantiteMinimaleAlerte);
        setPrixProduit(prixProduit);
    }


    public int getIdProduit() {
        return idProduit.get();
    }

    public IntegerProperty idProduitProperty() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit.set(idProduit);
    }

    public String getNomProduit() {
        return nomProduit.get();
    }

    public StringProperty nomProduitProperty() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit.set(nomProduit);
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible.get();
    }

    public IntegerProperty quantiteDisponibleProperty() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible.set(quantiteDisponible);
    }

    public int getQuantiteMinimaleAlerte() {
        return quantiteMinimaleAlerte.get();
    }

    public IntegerProperty quantiteMinimaleAlerteProperty() {
        return quantiteMinimaleAlerte;
    }

    public void setQuantiteMinimaleAlerte(int quantiteMinimaleAlerte) {
        this.quantiteMinimaleAlerte.set(quantiteMinimaleAlerte);
    }

    public double getPrixProduit() {
        return prixProduit.get();
    }

    public DoubleProperty prixProduitProperty() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit.set(prixProduit);
    }

    public Button getModifierBtn() {
        return modifierBtn;
    }

    public Button getValiderBtn() {
        return validerBtn;
    }

    public Button getSupprimerBtn() {
        return supprimerBtn;
    }

    public void enableEditing() {
        jourStock.setEditable(true);
        setCellFactories();
    }

    private void setCellFactories() {
        nomProduitCol.setCellFactory(TextFieldTableCell.forTableColumn());
        quantiteDisponibleCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantiteMinimaleCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        prixProduitCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    private void setButtonActions() {
        modifierBtnCol.setCellFactory(createButtonCellFactory(this::handleModifier, "Modifier"));
        validerBtnCol.setCellFactory(createButtonCellFactory(this::handleValider, "Valider"));
        supprimerBtnCol.setCellFactory(createButtonCellFactory(this::handleSupprimer, "Supprimer"));
    }

    public void getAllProducts(String jour) throws SQLException {
        ObservableList<ProductDAOImpl> jourStockItems = FXCollections.observableArrayList();

        UserDAOImpl userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();
        String query = "SELECT * FROM stocks WHERE Jour = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, jour);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ProductDAOImpl product = new ProductDAOImpl(
                    resultSet.getInt("ID_produit"),
                    resultSet.getString("Nom_produit"),
                    resultSet.getInt("Quantite_disponible"),
                    resultSet.getInt("Quantite_minimale_alerte"),
                    resultSet.getDouble("Prix_produit"),
                    jourStock, nomProduitCol, quantiteDisponibleCol, quantiteMinimaleCol, prixProduitCol, modifierBtnCol, validerBtnCol, supprimerBtnCol
            );

            jourStockItems.add(product);
        }
        jourStock.setItems(jourStockItems);

        nomProduitCol.setCellValueFactory(cellData -> cellData.getValue().nomProduitProperty());
        quantiteDisponibleCol.setCellValueFactory(cellData -> cellData.getValue().quantiteDisponibleProperty().asObject());
        quantiteMinimaleCol.setCellValueFactory(cellData -> cellData.getValue().quantiteMinimaleAlerteProperty().asObject());
        prixProduitCol.setCellValueFactory(cellData -> cellData.getValue().prixProduitProperty().asObject());
    }

    private Callback<TableColumn<ProductDAOImpl, Button>, TableCell<ProductDAOImpl, Button>> createButtonCellFactory(ButtonHandler handler, String buttonText) {
        return param -> {
            TableCell<ProductDAOImpl, Button> cell = new TableCell<>() {
                private final Button button = new Button(buttonText);

                {
                    button.setOnAction(event -> {
                        ProductDAOImpl product = getTableRow().getItem();
                        if (product != null) {
                            handler.handle(product);
                        }
                    });
                }

                @Override
                protected void updateItem(Button item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                    }
                }
            };
            return cell;
        };
    }

    private void handleModifier(ProductDAOImpl product) {
        enableEditing();
        TableView.TableViewSelectionModel<ProductDAOImpl> selectionModel = jourStock.getSelectionModel();
        if (!selectionModel.isEmpty()) {
            int selectedIndex = selectionModel.getSelectedIndex();
            ProductDAOImpl selectedItem = selectionModel.getSelectedItem();
            jourStock.edit(selectedIndex, nomProduitCol);
            jourStock.edit(selectedIndex, quantiteDisponibleCol);
            jourStock.edit(selectedIndex, quantiteMinimaleCol);
            jourStock.edit(selectedIndex, prixProduitCol);
        }
    }


    private void handleValider(ProductDAOImpl product) {
        try {
            TableView.TableViewSelectionModel<ProductDAOImpl> selectionModel = jourStock.getSelectionModel();
            if (!selectionModel.isEmpty()) {
                ProductDAOImpl selectedItem = selectionModel.getSelectedItem();

                String nomProduit = selectedItem.getNomProduit();
                int quantiteDisponible = selectedItem.getQuantiteDisponible();
                int quantiteMinimaleAlerte = selectedItem.getQuantiteMinimaleAlerte();
                double prixProduit = selectedItem.getPrixProduit();
                int idProduit = selectedItem.getIdProduit();

                // Création de l'alerte avec deux boutons (OK et Annuler)
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de modification");
                alert.setHeaderText("Vous voulez vraiment modifier ce produit ?");
                alert.setContentText("Choisissez OK pour confirmer ou Annuler pour annuler.");

                // Personnalisation des boutons de l'alerte
                ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

                // Affichage de l'alerte et traitement du choix de l'utilisateur
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeOK) {
                    UserDAOImpl userDAO = new UserDAOImpl();
                    Connection con = userDAO.getConnection();

                    String query = "UPDATE stocks SET Nom_produit = ?, Quantite_disponible = ?, Quantite_minimale_alerte = ?, Prix_produit = ? WHERE ID_produit = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, nomProduit);
                    preparedStatement.setInt(2, quantiteDisponible);
                    preparedStatement.setInt(3, quantiteMinimaleAlerte);
                    preparedStatement.setDouble(4, prixProduit);
                    preparedStatement.setInt(5, idProduit);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        jourStock.refresh();
                    }

                    preparedStatement.close();
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void handleSupprimer(ProductDAOImpl product) {
        try {
            TableView.TableViewSelectionModel<ProductDAOImpl> selectionModel = jourStock.getSelectionModel();
            if (!selectionModel.isEmpty()) {
                ProductDAOImpl selectedItem = selectionModel.getSelectedItem();

                int idProduit = selectedItem.getIdProduit();

                // Création de l'alerte avec deux boutons (OK et Annuler)
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Vous voulez vraiment supprimer ce produit ?");
                alert.setContentText("Choisissez OK pour confirmer ou Annuler pour annuler.");

                // Personnalisation des boutons de l'alerte
                ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

                // Affichage de l'alerte et traitement du choix de l'utilisateur
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeOK) {
                    UserDAOImpl userDAO = new UserDAOImpl();
                    Connection con = userDAO.getConnection();

                    String query = "DELETE FROM stocks WHERE ID_produit = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1, idProduit);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        jourStock.getItems().remove(selectedItem);
                        jourStock.refresh();
                    }

                    preparedStatement.close();
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ajouterProduit(String jour, String nomProduit, int quantiteDisponible, int quantiteMinimaleAlerte, double prixProduit) {
        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            Connection con = userDAO.getConnection();

            String query = "INSERT INTO stocks (Nom_produit, Quantite_disponible, Quantite_minimale_alerte, Prix_produit, Jour) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nomProduit);
            preparedStatement.setInt(2, quantiteDisponible);
            preparedStatement.setInt(3, quantiteMinimaleAlerte);
            preparedStatement.setDouble(4, prixProduit);
            preparedStatement.setString(5, jour);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                userDAO.alert(Alert.AlertType.INFORMATION, "Ajouter Produit ", "Produit " + nomProduit + " ajouté avec succès dans la Table de " + jour);
                getAllProducts(jour);
            } else {
                userDAO.alert(Alert.AlertType.ERROR, "Ajouter Produit ", "Produit " + nomProduit + " n'est pas ajouté  dans la Table de " + jour);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getComtability(String jour, TextField jour_ticket, TextArea jour_comtability, TextArea jour_comtability_total) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();

        String query = "SELECT * FROM stocks WHERE Jour = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, jour);
        ResultSet resultSet = preparedStatement.executeQuery();

        int prixTotalPourTicket = 0;
        int prixTotalPourDisponible = 0;
        HashMap<String, Integer> productCountMap = new HashMap<>();

        while (resultSet.next()) {
            String remarque = "";
            String nomProduit = resultSet.getString("Nom_produit");
            int quantiteDisponible = resultSet.getInt("Quantite_disponible");
            int prixProduit = resultSet.getInt("Prix_produit");
            int prixProduitPourDisponible = prixProduit * quantiteDisponible;
            int prixProduitPourJourTicket = prixProduit * Integer.parseInt(jour_ticket.getText());

            if (quantiteDisponible > Integer.parseInt(jour_ticket.getText())) {
                remarque = "Bon, ce produit existe en stock avec une quantité de " + quantiteDisponible + " pour le jour " + jour + ", ce qui est supérieur au nombre de tickets (" + Integer.parseInt(jour_ticket.getText()) + "). Gain potentiel : " + (prixProduitPourDisponible - prixProduitPourJourTicket);
            } else if (quantiteDisponible < Integer.parseInt(jour_ticket.getText())) {
                remarque = "Ce produit n'est plus disponible en stock (quantité actuelle : " + quantiteDisponible + " pour le jour " + jour + "). Perte potentielle : " + (prixProduitPourDisponible - prixProduitPourJourTicket);
            } else {
                remarque = "Ce produit est disponible en stock (" + quantiteDisponible + ") pour le jour " + jour + " selon le nombre de tickets (" + Integer.parseInt(jour_ticket.getText()) + "). Il est recommandé d'acheter les produits pour la semaine prochaine.";
            }

            productCountMap.put(nomProduit, productCountMap.getOrDefault(nomProduit, 0) + 1);
            prixTotalPourTicket += prixProduitPourJourTicket;
            prixTotalPourDisponible += prixProduitPourDisponible;

            jour_comtability.appendText("Nom du produit : " + nomProduit + "\n" +
                    "Prix du produit : " + prixProduit + "\n" +
                    "Quantité disponible : " + quantiteDisponible + "\n" +
                    "Prix total selon le nombre de tickets : " + prixProduitPourJourTicket + "\n" +
                    "Remarque : " + remarque + "\n\n");
        }

        for (Map.Entry<String, Integer> entry : productCountMap.entrySet()) {
            jour_comtability.appendText("Nombre de fois que " + entry.getKey() + " apparaît : " + entry.getValue() + "\n");
        }

        String remarqueTotal = "";
        if (prixTotalPourDisponible > prixTotalPourTicket) {
            remarqueTotal = "Nous avons gagné de l'argent pour ce jour : " + (prixTotalPourDisponible - prixTotalPourTicket);
        } else if (prixTotalPourDisponible < prixTotalPourTicket) {
            remarqueTotal = "Nous avons perdu de l'argent pour ce jour : " + (prixTotalPourDisponible - prixTotalPourTicket);
        } else {
            remarqueTotal = "Il n'y a ni perte ni gain d'argent pour ce jour.";
        }

        jour_comtability_total.setText("Prix total pour le jour " + jour + " : " + prixTotalPourTicket + "\n" +
                "Prix pour les produits existants dans ce jour : " + prixTotalPourDisponible + "\n" +
                remarqueTotal);

        preparedStatement.close();
        con.close();
    }


    @FunctionalInterface
    private interface ButtonHandler {
        void handle(ProductDAOImpl product);
    }
}