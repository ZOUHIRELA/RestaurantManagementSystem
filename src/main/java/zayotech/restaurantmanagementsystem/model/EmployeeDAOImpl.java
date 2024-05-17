package zayotech.restaurantmanagementsystem.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class EmployeeDAOImpl {

    private final IntegerProperty idEmploye = new SimpleIntegerProperty();
    private final StringProperty nomEmploye = new SimpleStringProperty();
    private final StringProperty prenomEmploye = new SimpleStringProperty();
    private final StringProperty posteEmploye = new SimpleStringProperty();
    private final DoubleProperty salaireEmploye = new SimpleDoubleProperty();
    private final ObjectProperty<LocalDate> dateEmbauche = new SimpleObjectProperty<>();

    private final Button modifierBtn = new Button("Modifier");
    private final Button validerBtn = new Button("Valider");
    private final Button supprimerBtn = new Button("Supprimer");


    private final TableView<EmployeeDAOImpl> employesTable;
    private final TableColumn<EmployeeDAOImpl, String> nomEmployeCol;
    private final TableColumn<EmployeeDAOImpl, String> prenomEmployeCol;
    private final TableColumn<EmployeeDAOImpl, String> posteEmployeCol;
    private final TableColumn<EmployeeDAOImpl, Double> salaireEmployeCol;
    private final TableColumn<EmployeeDAOImpl, LocalDate> dateEmbaucheCol;

    private final TableColumn<EmployeeDAOImpl, Button> modifierBtnCol;
    private final TableColumn<EmployeeDAOImpl, Button> validerBtnCol;
    private final TableColumn<EmployeeDAOImpl, Button> supprimerBtnCol;


    public EmployeeDAOImpl(TableView<EmployeeDAOImpl> employesTable, TableColumn<EmployeeDAOImpl, String> nomEmployeCol,
                           TableColumn<EmployeeDAOImpl, String> prenomEmployeCol, TableColumn<EmployeeDAOImpl, String> posteEmployeCol,
                           TableColumn<EmployeeDAOImpl, Double> salaireEmployeCol, TableColumn<EmployeeDAOImpl, LocalDate> dateEmbaucheCol,
                           TableColumn<EmployeeDAOImpl, Button> modifierBtnCol, TableColumn<EmployeeDAOImpl, Button> validerBtnCol,
                           TableColumn<EmployeeDAOImpl, Button> supprimerBtnCol) {
        this.employesTable = employesTable;
        this.nomEmployeCol = nomEmployeCol;
        this.prenomEmployeCol = prenomEmployeCol;
        this.posteEmployeCol = posteEmployeCol;
        this.salaireEmployeCol = salaireEmployeCol;
        this.dateEmbaucheCol = dateEmbaucheCol;

        this.modifierBtnCol = modifierBtnCol;
        this.validerBtnCol = validerBtnCol;
        this.supprimerBtnCol = supprimerBtnCol;

        setButtonActions();
    }


    public EmployeeDAOImpl(int idEmploye, String nomEmploye, String prenomEmploye, String posteEmploye, double salaireEmploye,
                           LocalDate dateEmbauche, TableView<EmployeeDAOImpl> employesTable, TableColumn<EmployeeDAOImpl, String> nomEmployeCol,
                           TableColumn<EmployeeDAOImpl, String> prenomEmployeCol, TableColumn<EmployeeDAOImpl, String> posteEmployeCol,
                           TableColumn<EmployeeDAOImpl, Double> salaireEmployeCol, TableColumn<EmployeeDAOImpl, LocalDate> dateEmbaucheCol,
                           TableColumn<EmployeeDAOImpl, Button> modifierBtnCol, TableColumn<EmployeeDAOImpl, Button> validerBtnCol,
                           TableColumn<EmployeeDAOImpl, Button> supprimerBtnCol) {
        this(employesTable, nomEmployeCol, prenomEmployeCol, posteEmployeCol, salaireEmployeCol, dateEmbaucheCol, modifierBtnCol, validerBtnCol, supprimerBtnCol);
        setIdEmploye(idEmploye);
        setNomEmploye(nomEmploye);
        setPrenomEmploye(prenomEmploye);
        setPosteEmploye(posteEmploye);
        setSalaireEmploye(salaireEmploye);
        setDateEmbauche(dateEmbauche);
    }

    public int getIdEmploye() {
        return idEmploye.get();
    }

    public IntegerProperty idEmployeProperty() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye.set(idEmploye);
    }

    public String getNomEmploye() {
        return nomEmploye.get();
    }

    public StringProperty nomEmployeProperty() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye.set(nomEmploye);
    }

    public String getPrenomEmploye() {
        return prenomEmploye.get();
    }

    public StringProperty prenomEmployeProperty() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye.set(prenomEmploye);
    }

    public String getPosteEmploye() {
        return posteEmploye.get();
    }

    public StringProperty posteEmployeProperty() {
        return posteEmploye;
    }

    public void setPosteEmploye(String posteEmploye) {
        this.posteEmploye.set(posteEmploye);
    }

    public double getSalaireEmploye() {
        return salaireEmploye.get();
    }

    public DoubleProperty salaireEmployeProperty() {
        return salaireEmploye;
    }

    public void setSalaireEmploye(double salaireEmploye) {
        this.salaireEmploye.set(salaireEmploye);
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche.get();
    }

    public ObjectProperty<LocalDate> dateEmbaucheProperty() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche.set(dateEmbauche);
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
        employesTable.setEditable(true);
        setCellFactories();
    }

    private void setCellFactories() {
        nomEmployeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomEmployeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        posteEmployeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        salaireEmployeCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    private void setButtonActions() {
        modifierBtnCol.setCellFactory(createButtonCellFactory(this::handleModifier, "Modifier"));
        validerBtnCol.setCellFactory(createButtonCellFactory(this::handleValider, "Valider"));
        supprimerBtnCol.setCellFactory(createButtonCellFactory(this::handleSupprimer, "Supprimer"));
    }

    public void getAllEmployees() throws SQLException {
        ObservableList<EmployeeDAOImpl> employeesList = FXCollections.observableArrayList();

        UserDAOImpl userDAO = new UserDAOImpl();
        Connection con = userDAO.getConnection();
        String query = "SELECT * FROM employes";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            EmployeeDAOImpl employee = new EmployeeDAOImpl(
                    resultSet.getInt("ID_employe"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Poste"),
                    resultSet.getDouble("Salaire"),
                    resultSet.getDate("Date_embauche").toLocalDate(),
                    employesTable, nomEmployeCol, prenomEmployeCol, posteEmployeCol, salaireEmployeCol, dateEmbaucheCol,
                    modifierBtnCol, validerBtnCol, supprimerBtnCol
            );

            employeesList.add(employee);
        }
        employesTable.setItems(employeesList);

        nomEmployeCol.setCellValueFactory(cellData -> cellData.getValue().nomEmployeProperty());
        prenomEmployeCol.setCellValueFactory(cellData -> cellData.getValue().prenomEmployeProperty());
        posteEmployeCol.setCellValueFactory(cellData -> cellData.getValue().posteEmployeProperty());
        salaireEmployeCol.setCellValueFactory(cellData -> cellData.getValue().salaireEmployeProperty().asObject());
        dateEmbaucheCol.setCellValueFactory(cellData -> cellData.getValue().dateEmbaucheProperty());
    }

    private Callback<TableColumn<EmployeeDAOImpl, Button>, TableCell<EmployeeDAOImpl, Button>> createButtonCellFactory(ButtonHandler handler, String buttonText) {
        return param -> {
            TableCell<EmployeeDAOImpl, Button> cell = new TableCell<>() {
                private final Button button = new Button(buttonText);

                {
                    button.setOnAction(event -> {
                        EmployeeDAOImpl employee = getTableRow().getItem();
                        if (employee != null) {
                            handler.handle(employee);
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

    private void handleModifier(EmployeeDAOImpl employee) {
        enableEditing();
        TableView.TableViewSelectionModel<EmployeeDAOImpl> selectionModel = employesTable.getSelectionModel();
        if (!selectionModel.isEmpty()) {
            int selectedIndex = selectionModel.getSelectedIndex();
            employesTable.edit(selectedIndex, nomEmployeCol);
            employesTable.edit(selectedIndex, prenomEmployeCol);
            employesTable.edit(selectedIndex, posteEmployeCol);
            employesTable.edit(selectedIndex, salaireEmployeCol);
        }
    }

    private void handleValider(EmployeeDAOImpl employee) {
        try {
            TableView.TableViewSelectionModel<EmployeeDAOImpl> selectionModel = employesTable.getSelectionModel();
            if (!selectionModel.isEmpty()) {
                EmployeeDAOImpl selectedItem = selectionModel.getSelectedItem();

                String nomEmploye = selectedItem.getNomEmploye();
                String prenomEmploye = selectedItem.getPrenomEmploye();
                String posteEmploye = selectedItem.getPosteEmploye();
                double salaireEmploye = selectedItem.getSalaireEmploye();
                LocalDate dateEmbauche = selectedItem.getDateEmbauche();
                int idEmploye = selectedItem.getIdEmploye();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de modification");
                alert.setHeaderText("Vous voulez vraiment modifier cet employé ?");
                alert.setContentText("Choisissez OK pour confirmer ou Annuler pour annuler.");


                ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);


                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == buttonTypeOK) {
                    UserDAOImpl userDAO = new UserDAOImpl();
                    Connection con = userDAO.getConnection();

                    String query = "UPDATE employes SET Nom = ?, Prenom = ?, Poste = ?, Salaire = ?, Date_embauche = ? WHERE ID_employe = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, nomEmploye);
                    preparedStatement.setString(2, prenomEmploye);
                    preparedStatement.setString(3, posteEmploye);
                    preparedStatement.setDouble(4, salaireEmploye);
                    preparedStatement.setDate(5, java.sql.Date.valueOf(dateEmbauche));
                    preparedStatement.setInt(6, idEmploye);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        employesTable.refresh();
                    }

                    preparedStatement.close();
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleSupprimer(EmployeeDAOImpl employee) {
        try {
            TableView.TableViewSelectionModel<EmployeeDAOImpl> selectionModel = employesTable.getSelectionModel();
            if (!selectionModel.isEmpty()) {
                EmployeeDAOImpl selectedItem = selectionModel.getSelectedItem();

                int idEmploye = selectedItem.getIdEmploye();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Vous voulez vraiment supprimer cet employé ?");
                alert.setContentText("Choisissez OK pour confirmer ou Annuler pour annuler.");


                ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

                // Affichage de l'alerte et traitement du choix de l'utilisateur
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeOK) {
                    UserDAOImpl userDAO = new UserDAOImpl();
                    Connection con = userDAO.getConnection();

                    String query = "DELETE FROM employes WHERE ID_employe = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1, idEmploye);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        employesTable.getItems().remove(selectedItem);
                        employesTable.refresh();
                    }

                    preparedStatement.close();
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterEmploye(String nom, String prenom, String poste, double salaire) {
        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            Connection con = userDAO.getConnection();

            String query = "INSERT INTO employes (Nom, Prenom, Poste, Salaire, Date_embauche) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, poste);
            preparedStatement.setDouble(4, salaire);
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                userDAO.alert(Alert.AlertType.INFORMATION, "Ajouter Employé", "Employé " + nom + " " + prenom + " ajouté avec succès");
                getAllEmployees();
            } else {
                userDAO.alert(Alert.AlertType.ERROR, "Ajouter Employé", "Erreur lors de l'ajout de l'employé " + nom + " " + prenom);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface ButtonHandler {
        void handle(EmployeeDAOImpl employee);
    }
}
