package zayotech.restaurantmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import zayotech.restaurantmanagementsystem.model.ChefDAOImpl;
import zayotech.restaurantmanagementsystem.model.UserDAOImpl;

import java.sql.SQLException;

public class HelloController {


    @FXML
    private TextField s_reponse;
    @FXML
    private ComboBox<String> s_question;
    @FXML
    private Button changePasswordBackBtn;

    @FXML
    private Button changePasswordBtn;

    @FXML
    private AnchorPane changePassword_side;

    @FXML
    private AnchorPane chefMenu_side;

    @FXML
    private AnchorPane chef_DimancheMenu;

    @FXML
    private Button chef_communicationBtn;

    @FXML
    private Button chef_comptabilitéBtn;

    @FXML
    private Button chef_dimancheBtn;

    @FXML
    private Label chef_diner;

    @FXML
    private Label chef_diner1;

    @FXML
    private Label chef_diner11;

    @FXML
    private Label chef_diner111;

    @FXML
    private Label chef_diner1111;

    @FXML
    private Label chef_diner11111;

    @FXML
    private Label chef_déjeuner;

    @FXML
    private Label chef_déjeuner1;

    @FXML
    private Label chef_déjeuner11;

    @FXML
    private Label chef_déjeuner111;

    @FXML
    private Label chef_déjeuner1111;

    @FXML
    private Label chef_déjeuner11111;

    @FXML
    private Button chef_employeeBtn;

    @FXML
    private TextArea chef_employee_dateEmbauche;

    @FXML
    private Button chef_employee_modifier;

    @FXML
    private TextArea chef_employee_nom;

    @FXML
    private TextArea chef_employee_poste;

    @FXML
    private TextArea chef_employee_prenom;

    @FXML
    private TextArea chef_employee_salaire;

    @FXML
    private AnchorPane chef_employee_side;

    @FXML
    private Button chef_employee_supprimer;

    @FXML
    private Button chef_jeudiBtn;

    @FXML
    private AnchorPane chef_jeudiMenu;

    @FXML
    private Button chef_lundiBtn;

    @FXML
    private AnchorPane chef_lundiMenu;

    @FXML
    private Button chef_mardiBtn;

    @FXML
    private AnchorPane chef_mardiMenu;

    @FXML
    private AnchorPane chef_menu;

    @FXML
    private Button chef_menuBtn;

    @FXML
    private AnchorPane chef_menu_side;

    @FXML
    private Button chef_mercrediBtn;

    @FXML
    private AnchorPane chef_mercrediMenu;

    @FXML
    private Button chef_modifierDimanche;

    @FXML
    private Button chef_modifierJeudi;

    @FXML
    private Button chef_modifierLundi;

    @FXML
    private Button chef_modifierMardi;

    @FXML
    private Button chef_modifierMercredi;

    @FXML
    private Button chef_modifierSamedi;

    @FXML
    private Button chef_modifierVendredi;

    @FXML
    private AnchorPane chef_restaurant_bar;

    @FXML
    private Button chef_samediBtn;

    @FXML
    private AnchorPane chef_samediMenu;

    @FXML
    private Button chef_validerDimanche;

    @FXML
    private Button chef_validerJeudi;

    @FXML
    private Button chef_validerMardi;

    @FXML
    private Button chef_validerMercredi;

    @FXML
    private Button chef_validerSamedi;

    @FXML
    private Button chef_validerVendredi;

    @FXML
    private Button chef_validerlundi;

    @FXML
    private Button chef_vendrediBtn;

    @FXML
    private AnchorPane chef_vendrediMenu;

    @FXML
    private PasswordField confirmeNewPassword;

    @FXML
    private Button createAccountBtn;

    @FXML
    private Button dejaBtn;

    @FXML
    private TextArea dimanche_dejeuner_description;

    @FXML
    private TextArea dimanche_dejeuner_dessert;

    @FXML
    private CheckBox dimanche_dejeuner_disponnible;

    @FXML
    private TextArea dimanche_dejeuner_entrees;

    @FXML
    private TextArea dimanche_dejeuner_platPrincipal;

    @FXML
    private TextArea dimanche_diner_description;

    @FXML
    private TextArea dimanche_diner_dessert;

    @FXML
    private CheckBox dimanche_diner_disponnible;

    @FXML
    private TextArea dimanche_diner_entrees;

    @FXML
    private TextArea dimanche_diner_platPrincipal;

    @FXML
    private Button f_backBtn;

    @FXML
    private TextField f_email;

    @FXML
    private Button f_sendBtn;

    @FXML
    private TextField f_verify;

    @FXML
    private Button f_verifyBtn;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private AnchorPane forgotPassword_side;

    @FXML
    private TextArea jeudi_dejeuner_description;

    @FXML
    private TextArea jeudi_dejeuner_dessert;

    @FXML
    private CheckBox jeudi_dejeuner_disponnible;

    @FXML
    private TextArea jeudi_dejeuner_entrees;

    @FXML
    private TextArea jeudi_dejeuner_platPrincipal;

    @FXML
    private TextArea jeudi_diner_description;

    @FXML
    private TextArea jeudi_diner_dessert;

    @FXML
    private CheckBox jeudi_diner_disponnible;

    @FXML
    private TextArea jeudi_diner_entrees;

    @FXML
    private TextArea jeudi_diner_platPrincipal;

    @FXML
    private TextField l_email;

    @FXML
    private PasswordField l_password;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane login_side;

    @FXML
    private TextArea lundi_dejeuner_description;

    @FXML
    private TextArea lundi_dejeuner_dessert;

    @FXML
    private CheckBox lundi_dejeuner_disponnible;

    @FXML
    private TextArea lundi_dejeuner_entrees;

    @FXML
    private TextArea lundi_dejeuner_platPrincipal;

    @FXML
    private TextArea lundi_diner_dessert;

    @FXML
    private TextArea lundi_diner_diescription;

    @FXML
    private CheckBox lundi_diner_disponnible;

    @FXML
    private TextArea lundi_diner_entrees;

    @FXML
    private TextArea lundi_diner_platPrincipal;

    @FXML
    private AnchorPane main_side;

    @FXML
    private TextArea mardi_dejeuner_description;

    @FXML
    private TextArea mardi_dejeuner_dessert;

    @FXML
    private CheckBox mardi_dejeuner_disponnible;

    @FXML
    private TextArea mardi_dejeuner_entrees;

    @FXML
    private TextArea mardi_dejeuner_platPrincipal;

    @FXML
    private TextArea mardi_diner_description;

    @FXML
    private TextArea mardi_diner_dessert;

    @FXML
    private CheckBox mardi_diner_disponnible;

    @FXML
    private TextArea mardi_diner_entrees;

    @FXML
    private TextArea mardi_diner_platPrincipal;

    @FXML
    private TextArea mercredi_dejeuner_description;

    @FXML
    private TextArea mercredi_dejeuner_dessert;

    @FXML
    private CheckBox mercredi_dejeuner_disponnible;

    @FXML
    private TextArea mercredi_dejeuner_entrees;

    @FXML
    private TextArea mercredi_dejeuner_platPrincipal;

    @FXML
    private TextArea mercredi_diner_description;

    @FXML
    private TextArea mercredi_diner_dessert;

    @FXML
    private CheckBox mercredi_diner_disponnible;

    @FXML
    private TextArea mercredi_diner_entrees;

    @FXML
    private TextArea mercredi_diner_platPrincipal;

    @FXML
    private PasswordField new_password;

    @FXML
    private TextField s_email;

    @FXML
    private TextField s_nom;

    @FXML
    private PasswordField s_password;

    @FXML
    private TextField s_prenom;

    @FXML
    private ComboBox<String> s_statut;

    @FXML
    private ComboBox<String> s_type_utilisateur;

    @FXML
    private TextArea samedi_dejeuner_description;

    @FXML
    private TextArea samedi_dejeuner_dessert;

    @FXML
    private CheckBox samedi_dejeuner_disponnible;

    @FXML
    private TextArea samedi_dejeuner_entrees;

    @FXML
    private TextArea samedi_dejeuner_platPrincipal;

    @FXML
    private TextArea samedi_diner_description;

    @FXML
    private TextArea samedi_diner_dessert;

    @FXML
    private CheckBox samedi_diner_disponnible;

    @FXML
    private TextArea samedi_diner_entrees;

    @FXML
    private TextArea samedi_diner_platPrincipal;

    @FXML
    private AnchorPane service_side;

    @FXML
    private Button signUpBtn;

    @FXML
    private AnchorPane signup_side;

    @FXML
    private TextArea vendredi_dejeuner_description;

    @FXML
    private TextArea vendredi_dejeuner_dessert;

    @FXML
    private CheckBox vendredi_dejeuner_disponnible;

    @FXML
    private TextArea vendredi_dejeuner_entrees;

    @FXML
    private TextArea vendredi_dejeuner_platPrincipal;

    @FXML
    private TextArea vendredi_diner_description;

    @FXML
    private TextArea vendredi_diner_dessert;

    @FXML
    private CheckBox vendredi_diner_disponnible;

    @FXML
    private TextArea vendredi_diner_entrees;

    @FXML
    private TextArea vendredi_diner_platPrincipal;

    @FXML
    private ComboBox<String> f_question;


    private UserDAOImpl userDAO;
    private String[] statutArray = {"Désactivé", "Activé"};
    private String[] TypeArray = {"Chef de Restaurant", "Responsable des Etudiants", "Etudiant", "Employée"};
    private String[] questions = {"le nom de votre premier animal?", "votre destination de voyage préférée ?", "le nom de votre école primaire ?", "votre plat préféré ?"};


    @FXML

    public void switchInterfaces(ActionEvent event) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        if (event.getSource() == dejaBtn) {
            signup_side.setVisible(false);
        } else if (event.getSource() == forgotPassword) {
            login_side.setVisible(false);
        } else if (event.getSource() == createAccountBtn) {
            signup_side.setVisible(true);
        } else if (event.getSource() == f_backBtn) {
            login_side.setVisible(true);
        } else if (event.getSource() == changePasswordBackBtn) {
            forgotPassword_side.setVisible(true);
        } else if (event.getSource() == f_verifyBtn) {
            userDAO.forgotPassword(f_email, f_question, f_verify, forgotPassword_side);
        } else if (event.getSource() == changePasswordBtn) {
            userDAO.changePassword(forgotPassword_side, login_side, f_email, new_password, confirmeNewPassword);
        }
    }


    @FXML
    public void initialize() {
        ObservableList<String> statutItems = FXCollections.observableArrayList(statutArray);
        s_statut.setItems(statutItems);

        ObservableList<String> typeItems = FXCollections.observableArrayList(TypeArray);
        s_type_utilisateur.setItems(typeItems);

        ObservableList<String> questionItems = FXCollections.observableArrayList(questions);
        s_question.setItems(questionItems);
        f_question.setItems(questionItems);
    }


    @FXML
    public void signUpFucntion() throws SQLException {
        userDAO = new UserDAOImpl();
        userDAO.signUp(signup_side, s_nom.getText(), s_prenom.getText(), s_type_utilisateur, s_email.getText(), s_password.getText(), s_statut, s_question, s_reponse.getText());
        s_email.clear();
        s_nom.clear();
        s_prenom.clear();
        s_password.clear();
        s_statut.getSelectionModel().clearSelection();
        s_type_utilisateur.getSelectionModel().clearSelection();
        s_question.getSelectionModel().clearSelection();
        s_reponse.clear();
    }


    @FXML
    public void signIn() throws SQLException {
        userDAO = new UserDAOImpl();
        String type = userDAO.signIn(l_email.getText(), l_password.getText());
        l_email.clear();
        l_password.clear();
        if (type.equals("Chef de Restaurant")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
        } else if (type.equals("Etudiant")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
        } else if (type.equals("Responsable des Etudiants")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
        } else if (type.equals("Employée")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
        }
    }


    @FXML
    public void getMenuRepas(ActionEvent event) throws SQLException {
        ChefDAOImpl chefDAO = new ChefDAOImpl();
        if (event.getSource() == chef_menuBtn) {
            chef_menu_side.setVisible(true);
            chefMenu_side.setVisible(true);
        } else if (event.getSource() == chef_employeeBtn) {
            chef_menu_side.setVisible(false);
            chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(true);
            chefDAO.getAllEmployees(chef_employee_nom, chef_employee_prenom, chef_employee_poste, chef_employee_salaire, chef_employee_dateEmbauche);
        }
    }




    private void valideteMenuFunction(String jour,
                                      TextArea chef_dejeuner_platPrincipal, TextArea chef_dejeuner_entrees, TextArea chef_dejeuner_dessert, TextArea chef_dejeuner_description, CheckBox chef_dejeuner_disponnible,
                                      TextArea chef_diner_menuPrincipal, TextArea chef_diner_entrees, TextArea chef_diner_dessert, TextArea chef_diner_description, CheckBox chef_diner_disponnible) throws SQLException {

        ChefDAOImpl chefDAO = new ChefDAOImpl();

        userDAO = new UserDAOImpl();

        chefDAO.modifyMenu(jour, "Déjeuner", chef_dejeuner_platPrincipal, chef_dejeuner_entrees, chef_dejeuner_dessert, chef_dejeuner_description, chef_dejeuner_disponnible);
        chefDAO.modifyMenu(jour, "Dîner", chef_diner_menuPrincipal, chef_diner_entrees, chef_diner_dessert, chef_diner_description, chef_diner_disponnible);


        userDAO.alert(Alert.AlertType.INFORMATION, "Changement", "Vous avez changé le menu de " + jour + " avec succès !");

        chefDAO.getMenu(jour, "Déjeuner", chef_dejeuner_platPrincipal, chef_dejeuner_entrees, chef_dejeuner_dessert, chef_dejeuner_description, chef_dejeuner_disponnible);
        chefDAO.getMenu(jour, "Dîner", chef_diner_menuPrincipal, chef_diner_entrees, chef_diner_dessert, chef_diner_description, chef_diner_disponnible);
    }


    @FXML
    public void valideteMenu(ActionEvent event) throws SQLException {
        if (event.getSource() == chef_validerlundi) {

            valideteMenuFunction("Lundi", lundi_dejeuner_platPrincipal, lundi_dejeuner_entrees, lundi_dejeuner_dessert, lundi_dejeuner_description, lundi_dejeuner_disponnible,
                    lundi_diner_platPrincipal, lundi_diner_entrees, lundi_diner_dessert, lundi_diner_diescription, lundi_diner_disponnible);

            modifyMenuAfterVAlidate(lundi_dejeuner_platPrincipal, lundi_dejeuner_entrees, lundi_dejeuner_dessert, lundi_dejeuner_description, lundi_dejeuner_disponnible,
                    lundi_diner_platPrincipal, lundi_diner_entrees, lundi_diner_dessert, lundi_diner_diescription, lundi_diner_disponnible);

        } else if (event.getSource() == chef_validerMardi) {

            valideteMenuFunction("Mardi", mardi_dejeuner_platPrincipal, mardi_dejeuner_entrees, mardi_dejeuner_dessert, mardi_dejeuner_description, mardi_dejeuner_disponnible,
                    mardi_diner_platPrincipal, mardi_diner_entrees, mardi_diner_dessert, mardi_diner_description, mardi_diner_disponnible);

            modifyMenuAfterVAlidate(mardi_dejeuner_platPrincipal, mardi_dejeuner_entrees, mardi_dejeuner_dessert, mardi_dejeuner_description, mardi_dejeuner_disponnible,
                    mardi_diner_platPrincipal, mardi_diner_entrees, mardi_diner_dessert, mardi_diner_description, mardi_diner_disponnible);

        } else if (event.getSource() == chef_validerMercredi) {

            valideteMenuFunction("Mercredi", mercredi_dejeuner_platPrincipal, mercredi_dejeuner_entrees, mercredi_dejeuner_dessert, mercredi_dejeuner_description, mercredi_dejeuner_disponnible,
                    mercredi_diner_platPrincipal, mercredi_diner_entrees, mercredi_diner_dessert, mercredi_diner_description, mercredi_diner_disponnible);

            modifyMenuAfterVAlidate(mercredi_dejeuner_platPrincipal, mercredi_dejeuner_entrees, mercredi_dejeuner_dessert, mercredi_dejeuner_description, mercredi_dejeuner_disponnible,
                    mercredi_diner_platPrincipal, mercredi_diner_entrees, mercredi_diner_dessert, mercredi_diner_description, mercredi_diner_disponnible);

        } else if (event.getSource() == chef_validerJeudi) {

            valideteMenuFunction("Jeudi", jeudi_dejeuner_platPrincipal, jeudi_dejeuner_entrees, jeudi_dejeuner_dessert, jeudi_dejeuner_description, jeudi_dejeuner_disponnible,
                    jeudi_diner_platPrincipal, jeudi_diner_entrees, jeudi_diner_dessert, jeudi_diner_description, jeudi_diner_disponnible);

            modifyMenuAfterVAlidate(jeudi_dejeuner_platPrincipal, jeudi_dejeuner_entrees, jeudi_dejeuner_dessert, jeudi_dejeuner_description, jeudi_dejeuner_disponnible,
                    jeudi_diner_platPrincipal, jeudi_diner_entrees, jeudi_diner_dessert, jeudi_diner_description, jeudi_diner_disponnible);

        } else if (event.getSource() == chef_validerVendredi) {

            valideteMenuFunction("Vendredi", vendredi_dejeuner_platPrincipal, vendredi_dejeuner_entrees, vendredi_dejeuner_dessert, vendredi_dejeuner_description, vendredi_dejeuner_disponnible,
                    vendredi_diner_platPrincipal, vendredi_diner_entrees, vendredi_diner_dessert, vendredi_diner_description, vendredi_diner_disponnible);

            modifyMenuAfterVAlidate(vendredi_dejeuner_platPrincipal, vendredi_dejeuner_entrees, vendredi_dejeuner_dessert, vendredi_dejeuner_description, vendredi_dejeuner_disponnible,
                    vendredi_diner_platPrincipal, vendredi_diner_entrees, vendredi_diner_dessert, vendredi_diner_description, vendredi_diner_disponnible);

        } else if (event.getSource() == chef_validerSamedi) {

            valideteMenuFunction("Samedi", samedi_dejeuner_platPrincipal, samedi_dejeuner_entrees, samedi_dejeuner_dessert, samedi_dejeuner_description, samedi_dejeuner_disponnible,
                    samedi_diner_platPrincipal, samedi_diner_entrees, samedi_diner_dessert, samedi_diner_description, samedi_diner_disponnible);

            modifyMenuAfterVAlidate(samedi_dejeuner_platPrincipal, samedi_dejeuner_entrees, samedi_dejeuner_dessert, samedi_dejeuner_description, samedi_dejeuner_disponnible,
                    samedi_diner_platPrincipal, samedi_diner_entrees, samedi_diner_dessert, samedi_diner_description, samedi_diner_disponnible);

        } else if (event.getSource() == chef_validerDimanche) {

            valideteMenuFunction("Dimanche", dimanche_dejeuner_platPrincipal, dimanche_dejeuner_entrees, dimanche_dejeuner_dessert, dimanche_dejeuner_description, dimanche_dejeuner_disponnible,
                    dimanche_diner_platPrincipal, dimanche_diner_entrees, dimanche_diner_dessert, dimanche_diner_description, dimanche_diner_disponnible);

            modifyMenuAfterVAlidate(dimanche_dejeuner_platPrincipal, dimanche_dejeuner_entrees, dimanche_dejeuner_dessert, dimanche_dejeuner_description, dimanche_dejeuner_disponnible,
                    dimanche_diner_platPrincipal, dimanche_diner_entrees, dimanche_diner_dessert, dimanche_diner_description, dimanche_diner_disponnible);
        }
    }


    private void modifyMenuFunction(TextArea chef_dejeuner_platPrincipal, TextArea chef_dejeuner_entrees, TextArea chef_dejeuner_dessert, TextArea chef_dejeuner_description, CheckBox chef_dejeuner_disponnible,
                                    TextArea chef_diner_menuPrincipal, TextArea chef_diner_entrees, TextArea chef_diner_dessert, TextArea chef_diner_description, CheckBox chef_diner_disponnible) {
        modifyMenu(chef_dejeuner_platPrincipal, chef_dejeuner_entrees, chef_dejeuner_dessert, chef_dejeuner_description, chef_dejeuner_disponnible,
                chef_diner_menuPrincipal, chef_diner_entrees, chef_diner_dessert, chef_diner_description, chef_diner_disponnible);
    }


    @FXML
    public void modifyMenu(ActionEvent event) {
        if (event.getSource() == chef_modifierLundi) {

            modifyMenuFunction(lundi_dejeuner_platPrincipal, lundi_dejeuner_entrees, lundi_dejeuner_dessert, lundi_dejeuner_description, lundi_dejeuner_disponnible,
                    lundi_diner_platPrincipal, lundi_diner_entrees, lundi_diner_dessert, lundi_diner_diescription, lundi_diner_disponnible);

        } else if (event.getSource() == chef_modifierMardi) {

            modifyMenuFunction(mardi_dejeuner_platPrincipal, mardi_dejeuner_entrees, mardi_dejeuner_dessert, mardi_dejeuner_description, mardi_dejeuner_disponnible,
                    mardi_diner_platPrincipal, mardi_diner_entrees, mardi_diner_dessert, mardi_diner_description, mardi_diner_disponnible);

        } else if (event.getSource() == chef_modifierMercredi) {

            modifyMenuFunction(mercredi_dejeuner_platPrincipal, mercredi_dejeuner_entrees, mercredi_dejeuner_dessert, mercredi_dejeuner_description, mercredi_dejeuner_disponnible,
                    mercredi_diner_platPrincipal, mercredi_diner_entrees, mercredi_diner_dessert, mercredi_diner_description, mercredi_diner_disponnible);

        } else if (event.getSource() == chef_modifierJeudi) {

            modifyMenuFunction(jeudi_dejeuner_platPrincipal, jeudi_dejeuner_entrees, jeudi_dejeuner_dessert, jeudi_dejeuner_description, jeudi_dejeuner_disponnible,
                    jeudi_diner_platPrincipal, jeudi_diner_entrees, jeudi_diner_dessert, jeudi_diner_description, jeudi_diner_disponnible);

        } else if (event.getSource() == chef_modifierVendredi) {

            modifyMenuFunction(vendredi_dejeuner_platPrincipal, vendredi_dejeuner_entrees, vendredi_dejeuner_dessert, vendredi_dejeuner_description, vendredi_dejeuner_disponnible,
                    vendredi_diner_platPrincipal, vendredi_diner_entrees, vendredi_diner_dessert, vendredi_diner_description, vendredi_diner_disponnible);

        } else if (event.getSource() == chef_modifierSamedi) {

            modifyMenuFunction(samedi_dejeuner_platPrincipal, samedi_dejeuner_entrees, samedi_dejeuner_dessert, samedi_dejeuner_description, samedi_dejeuner_disponnible,
                    samedi_diner_platPrincipal, samedi_diner_entrees, samedi_diner_dessert, samedi_diner_description, samedi_diner_disponnible);

        } else if (event.getSource() == chef_modifierDimanche) {

            modifyMenuFunction(dimanche_dejeuner_platPrincipal, dimanche_dejeuner_entrees, dimanche_dejeuner_dessert, dimanche_dejeuner_description, dimanche_dejeuner_disponnible,
                    dimanche_diner_platPrincipal, dimanche_diner_entrees, dimanche_diner_dessert, dimanche_diner_description, dimanche_diner_disponnible);

        }
    }


    private void modifyMenu(TextArea chef_dejeuner_platPrincipal, TextArea chef_dejeuner_entrees, TextArea chef_dejeuner_dessert, TextArea chef_dejeuner_description, CheckBox chef_dejeuner_disponnible
            , TextArea chef_diner_menuPrincipal, TextArea chef_diner_entrees, TextArea chef_diner_dessert, TextArea chef_diner_description, CheckBox chef_diner_disponnible) {

        chef_dejeuner_platPrincipal.setEditable(true);
        chef_dejeuner_entrees.setEditable(true);
        chef_dejeuner_dessert.setEditable(true);
        chef_dejeuner_description.setEditable(true);
        chef_dejeuner_disponnible.setDisable(false);

        chef_diner_menuPrincipal.setEditable(true);
        chef_diner_entrees.setEditable(true);
        chef_diner_dessert.setEditable(true);
        chef_diner_description.setEditable(true);
        chef_diner_disponnible.setDisable(false);
    }


    private void modifyMenuAfterVAlidate(TextArea chef_dejeuner_platPrincipal, TextArea chef_dejeuner_entrees, TextArea chef_dejeuner_dessert, TextArea chef_dejeuner_description, CheckBox chef_dejeuner_disponnible
            , TextArea chef_diner_menuPrincipal, TextArea chef_diner_entrees, TextArea chef_diner_dessert, TextArea chef_diner_description, CheckBox chef_diner_disponnible) {

        chef_dejeuner_platPrincipal.setEditable(false);
        chef_dejeuner_entrees.setEditable(false);
        chef_dejeuner_dessert.setEditable(false);
        chef_dejeuner_description.setEditable(false);
        chef_dejeuner_disponnible.setDisable(true);

        chef_diner_menuPrincipal.setEditable(false);
        chef_diner_entrees.setEditable(false);
        chef_diner_dessert.setEditable(false);
        chef_diner_description.setEditable(false);
        chef_diner_disponnible.setDisable(true);
    }


    private void changeMenu(TextArea chef_dejeuner_platPrincipal, TextArea chef_dejeuner_entrees, TextArea chef_dejeuner_dessert, TextArea chef_dejeuner_description, CheckBox chef_dejeuner_disponnible,
                            TextArea chef_diner_menuPrincipal, TextArea chef_diner_entrees, TextArea chef_diner_dessert, TextArea chef_diner_description, CheckBox chef_diner_disponnible,
                            String jour) throws SQLException {

        ChefDAOImpl chefDAO = new ChefDAOImpl();

        userDAO = new UserDAOImpl();

        chefDAO.getMenu(jour, "Déjeuner", chef_dejeuner_platPrincipal, chef_dejeuner_entrees, chef_dejeuner_dessert, chef_dejeuner_description, chef_dejeuner_disponnible);
        chefDAO.getMenu(jour, "Dîner", chef_diner_menuPrincipal, chef_diner_entrees, chef_diner_dessert, chef_diner_description, chef_diner_disponnible);

    }


    @FXML
    public void getModifyValideteMenu(ActionEvent event) throws SQLException {
        if (event.getSource() == chef_lundiBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: black;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(true);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(false);

            changeMenu(lundi_dejeuner_platPrincipal, lundi_dejeuner_entrees, lundi_dejeuner_dessert, lundi_dejeuner_description, lundi_dejeuner_disponnible,
                    lundi_diner_platPrincipal, lundi_diner_entrees, lundi_diner_dessert, lundi_diner_diescription, lundi_diner_disponnible,
                    "Lundi");

        } else if (event.getSource() == chef_mardiBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: black;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(true);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(false);

            changeMenu(mardi_dejeuner_platPrincipal, mardi_dejeuner_entrees, mardi_dejeuner_dessert, mardi_dejeuner_description, mardi_dejeuner_disponnible,
                    mardi_diner_platPrincipal, mardi_diner_entrees, mardi_diner_dessert, mardi_diner_description, mardi_diner_disponnible,
                    "Mardi");

        } else if (event.getSource() == chef_mercrediBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: black;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(true);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(false);

            changeMenu(mercredi_dejeuner_platPrincipal, mercredi_dejeuner_entrees, mercredi_dejeuner_dessert, mercredi_dejeuner_description, mercredi_dejeuner_disponnible,
                    mercredi_diner_platPrincipal, mercredi_diner_entrees, mercredi_diner_dessert, mercredi_diner_description, mercredi_diner_disponnible,
                    "Mercredi");

        } else if (event.getSource() == chef_jeudiBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: black;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(true);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(false);

            changeMenu(jeudi_dejeuner_platPrincipal, jeudi_dejeuner_entrees, jeudi_dejeuner_dessert, jeudi_dejeuner_description, jeudi_dejeuner_disponnible,
                    jeudi_diner_platPrincipal, jeudi_diner_entrees, jeudi_diner_dessert, jeudi_diner_description, jeudi_diner_disponnible,
                    "Jeudi");

        } else if (event.getSource() == chef_vendrediBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: black;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(true);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(false);

            changeMenu(vendredi_dejeuner_platPrincipal, vendredi_dejeuner_entrees, vendredi_dejeuner_dessert, vendredi_dejeuner_description, vendredi_dejeuner_disponnible,
                    vendredi_diner_platPrincipal, vendredi_diner_entrees, vendredi_diner_dessert, vendredi_diner_description, vendredi_diner_disponnible,
                    "Vendredi");

        } else if (event.getSource() == chef_samediBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: black;");
            chef_dimancheBtn.setStyle("-fx-background-color: white;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(true);
            chef_DimancheMenu.setVisible(false);

            changeMenu(samedi_dejeuner_platPrincipal, samedi_dejeuner_entrees, samedi_dejeuner_dessert, samedi_dejeuner_description, samedi_dejeuner_disponnible,
                    samedi_diner_platPrincipal, samedi_diner_entrees, samedi_diner_dessert, samedi_diner_description, samedi_diner_disponnible,
                    "Samedi");

        } else if (event.getSource() == chef_dimancheBtn) {

            chef_lundiBtn.setStyle("-fx-background-color: white;");
            chef_mardiBtn.setStyle("-fx-background-color: white;");
            chef_mercrediBtn.setStyle("-fx-background-color: white;");
            chef_jeudiBtn.setStyle("-fx-background-color: white;");
            chef_vendrediBtn.setStyle("-fx-background-color: white;");
            chef_samediBtn.setStyle("-fx-background-color: white;");
            chef_dimancheBtn.setStyle("-fx-background-color: black;");

            chef_lundiMenu.setVisible(false);
            chef_mardiMenu.setVisible(false);
            chef_mercrediMenu.setVisible(false);
            chef_jeudiMenu.setVisible(false);
            chef_vendrediMenu.setVisible(false);
            chef_samediMenu.setVisible(false);
            chef_DimancheMenu.setVisible(true);

            changeMenu(dimanche_dejeuner_platPrincipal, dimanche_dejeuner_entrees, dimanche_dejeuner_dessert, dimanche_dejeuner_description, dimanche_dejeuner_disponnible,
                    dimanche_diner_platPrincipal, dimanche_diner_entrees, dimanche_diner_dessert, dimanche_diner_description, dimanche_diner_disponnible,
                    "Dimanche");

        }
    }


}