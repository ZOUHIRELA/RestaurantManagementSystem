package zayotech.restaurantmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import zayotech.restaurantmanagementsystem.model.ChefDAOImpl;
import zayotech.restaurantmanagementsystem.model.EmployeeDAOImpl;
import zayotech.restaurantmanagementsystem.model.ProductDAOImpl;
import zayotech.restaurantmanagementsystem.model.UserDAOImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class HelloController {


    @FXML
    private Button addEmployeBtn;

    @FXML
    private Button addProductBtn;

    @FXML
    private TextField addProduct_jour;

    @FXML
    private TextField addProduct_nom;

    @FXML
    private TextField addProduct_prix;

    @FXML
    private TextField addProduct_quantité;

    @FXML
    private TextField addProduct_quantitéMinimale;

    @FXML
    private Button button_send;

    @FXML
    private Button changePasswordBackBtn;

    @FXML
    private Button changePasswordBtn;

    @FXML
    private AnchorPane changePassword_side;

    @FXML
    private AnchorPane chef_DimancheMenu;

    @FXML
    private Button chef_communicationBtn;

    @FXML
    private Button chef_comptabilitéBtnBtn;

    @FXML
    private AnchorPane chef_comptabilité_menu;

    @FXML
    private Button chef_dimancheBtn;

    @FXML
    private Button chef_employeeBtn;

    @FXML
    private AnchorPane chef_employee_side;

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
    private AnchorPane communication_side;

    @FXML
    private PasswordField confirmeNewPassword;

    @FXML
    private Button createAccountBtn;

    @FXML
    private Button dejaBtn;

    @FXML
    private TextArea dimanche_dejeuner_description;

    @FXML
    private TextArea dimanche_dejeuner_description1;

    @FXML
    private TextArea dimanche_dejeuner_dessert;

    @FXML
    private TextArea dimanche_dejeuner_dessert1;

    @FXML
    private CheckBox dimanche_dejeuner_disponnible;

    @FXML
    private CheckBox dimanche_dejeuner_disponnible1;

    @FXML
    private TextArea dimanche_dejeuner_entrees;

    @FXML
    private TextArea dimanche_dejeuner_entrees1;

    @FXML
    private TextArea dimanche_dejeuner_platPrincipal;

    @FXML
    private TextArea dimanche_dejeuner_platPrincipal1;

    @FXML
    private TextArea dimanche_diner_description;

    @FXML
    private TextArea dimanche_diner_description1;

    @FXML
    private TextArea dimanche_diner_dessert;

    @FXML
    private TextArea dimanche_diner_dessert1;

    @FXML
    private CheckBox dimanche_diner_disponnible;

    @FXML
    private CheckBox dimanche_diner_disponnible1;

    @FXML
    private TextArea dimanche_diner_entrees;

    @FXML
    private TextArea dimanche_diner_entrees1;

    @FXML
    private TextArea dimanche_diner_platPrincipal;

    @FXML
    private TextArea dimanche_diner_platPrincipal1;

    @FXML
    private TextField dimanche_ticket;

    @FXML
    private Button dimanche_ticketBtn;

    @FXML
    private Button f_backBtn;

    @FXML
    private TextField f_email;

    @FXML
    private ComboBox<String> f_question;

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
    private TextArea jeudi_dejeuner_description1;

    @FXML
    private TextArea jeudi_dejeuner_dessert;

    @FXML
    private TextArea jeudi_dejeuner_dessert1;

    @FXML
    private CheckBox jeudi_dejeuner_disponnible;

    @FXML
    private CheckBox jeudi_dejeuner_disponnible1;

    @FXML
    private TextArea jeudi_dejeuner_entrees;

    @FXML
    private TextArea jeudi_dejeuner_entrees1;

    @FXML
    private TextArea jeudi_dejeuner_platPrincipal;

    @FXML
    private TextArea jeudi_dejeuner_platPrincipal1;

    @FXML
    private TextArea jeudi_diner_description;

    @FXML
    private TextArea jeudi_diner_description1;

    @FXML
    private TextArea jeudi_diner_dessert;

    @FXML
    private TextArea jeudi_diner_dessert1;

    @FXML
    private CheckBox jeudi_diner_disponnible;

    @FXML
    private CheckBox jeudi_diner_disponnible1;

    @FXML
    private TextArea jeudi_diner_entrees;

    @FXML
    private TextArea jeudi_diner_entrees1;

    @FXML
    private TextArea jeudi_diner_platPrincipal;

    @FXML
    private TextArea jeudi_diner_platPrincipal1;

    @FXML
    private TextField jeudi_ticket;

    @FXML
    private Button jeudi_ticketBtn;

    @FXML
    private TextArea jour_comtabilité;

    @FXML
    private TextArea jour_comtabilité_total;

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
    private TextArea lundi_dejeuner_description1;

    @FXML
    private TextArea lundi_dejeuner_dessert;

    @FXML
    private TextArea lundi_dejeuner_dessert1;

    @FXML
    private CheckBox lundi_dejeuner_disponnible;

    @FXML
    private CheckBox lundi_dejeuner_disponnible1;

    @FXML
    private TextArea lundi_dejeuner_entrees;

    @FXML
    private TextArea lundi_dejeuner_entrees1;

    @FXML
    private TextArea lundi_dejeuner_platPrincipal;

    @FXML
    private TextArea lundi_dejeuner_platPrincipal1;

    @FXML
    private TextArea lundi_diner_dessert;

    @FXML
    private TextArea lundi_diner_dessert1;

    @FXML
    private TextArea lundi_diner_diescription;

    @FXML
    private TextArea lundi_diner_diescription1;

    @FXML
    private CheckBox lundi_diner_disponnible;

    @FXML
    private CheckBox lundi_diner_disponnible1;

    @FXML
    private TextArea lundi_diner_entrees;

    @FXML
    private TextArea lundi_diner_entrees1;

    @FXML
    private TextArea lundi_diner_platPrincipal;

    @FXML
    private TextArea lundi_diner_platPrincipal1;

    @FXML
    private TextField lundi_ticket;

    @FXML
    private Button lundi_ticktBtn;

    @FXML
    private AnchorPane main_side;

    @FXML
    private TextArea mardi_dejeuner_description;

    @FXML
    private TextArea mardi_dejeuner_description1;

    @FXML
    private TextArea mardi_dejeuner_dessert;

    @FXML
    private TextArea mardi_dejeuner_dessert1;

    @FXML
    private CheckBox mardi_dejeuner_disponnible;

    @FXML
    private CheckBox mardi_dejeuner_disponnible1;

    @FXML
    private TextArea mardi_dejeuner_entrees;

    @FXML
    private TextArea mardi_dejeuner_entrees1;

    @FXML
    private TextArea mardi_dejeuner_platPrincipal;

    @FXML
    private TextArea mardi_dejeuner_platPrincipal1;

    @FXML
    private TextArea mardi_diner_description;

    @FXML
    private TextArea mardi_diner_description1;

    @FXML
    private TextArea mardi_diner_dessert;

    @FXML
    private TextArea mardi_diner_dessert1;

    @FXML
    private CheckBox mardi_diner_disponnible;

    @FXML
    private CheckBox mardi_diner_disponnible1;

    @FXML
    private TextArea mardi_diner_entrees;

    @FXML
    private TextArea mardi_diner_entrees1;

    @FXML
    private TextArea mardi_diner_platPrincipal;

    @FXML
    private TextArea mardi_diner_platPrincipal1;

    @FXML
    private TextField mardi_ticket;

    @FXML
    private Button mardi_ticketBtn;

    @FXML
    private TextArea mercredi_dejeuner_description;

    @FXML
    private TextArea mercredi_dejeuner_description1;

    @FXML
    private TextArea mercredi_dejeuner_dessert;

    @FXML
    private TextArea mercredi_dejeuner_dessert1;

    @FXML
    private CheckBox mercredi_dejeuner_disponnible;

    @FXML
    private CheckBox mercredi_dejeuner_disponnible1;

    @FXML
    private TextArea mercredi_dejeuner_entrees;

    @FXML
    private TextArea mercredi_dejeuner_entrees1;

    @FXML
    private TextArea mercredi_dejeuner_platPrincipal;

    @FXML
    private TextArea mercredi_dejeuner_platPrincipal1;

    @FXML
    private TextArea mercredi_diner_description;

    @FXML
    private TextArea mercredi_diner_description1;

    @FXML
    private TextArea mercredi_diner_dessert;

    @FXML
    private TextArea mercredi_diner_dessert1;

    @FXML
    private CheckBox mercredi_diner_disponnible;

    @FXML
    private CheckBox mercredi_diner_disponnible1;

    @FXML
    private TextArea mercredi_diner_entrees;

    @FXML
    private TextArea mercredi_diner_entrees1;

    @FXML
    private TextArea mercredi_diner_platPrincipal;

    @FXML
    private TextArea mercredi_diner_platPrincipal1;

    @FXML
    private TextField mercredi_ticket;

    @FXML
    private Button mercredi_ticketBtn;

    @FXML
    private PasswordField new_password;

    @FXML
    private TextField nom_employe;

    @FXML
    private AnchorPane pere_chefMenu_side;

    @FXML
    private TextField poste_employe;

    @FXML
    private TextField prenom_employe;

    @FXML
    private TextField s_email;

    @FXML
    private TextField s_nom;

    @FXML
    private PasswordField s_password;

    @FXML
    private TextField s_prenom;

    @FXML
    private ComboBox<String> s_question;

    @FXML
    private TextField s_reponse;

    @FXML
    private ComboBox<String> s_statut;

    @FXML
    private ComboBox<String> s_type_utilisateur;

    @FXML
    private TextField salaire_employe;

    @FXML
    private TextArea samedi_dejeuner_description;

    @FXML
    private TextArea samedi_dejeuner_description1;

    @FXML
    private TextArea samedi_dejeuner_dessert;

    @FXML
    private TextArea samedi_dejeuner_dessert1;

    @FXML
    private CheckBox samedi_dejeuner_disponnible;

    @FXML
    private CheckBox samedi_dejeuner_disponnible1;

    @FXML
    private TextArea samedi_dejeuner_entrees;

    @FXML
    private TextArea samedi_dejeuner_entrees1;

    @FXML
    private TextArea samedi_dejeuner_platPrincipal;

    @FXML
    private TextArea samedi_dejeuner_platPrincipal1;

    @FXML
    private TextArea samedi_diner_description;

    @FXML
    private TextArea samedi_diner_description1;

    @FXML
    private TextArea samedi_diner_dessert;

    @FXML
    private TextArea samedi_diner_dessert1;

    @FXML
    private CheckBox samedi_diner_disponnible;

    @FXML
    private CheckBox samedi_diner_disponnible1;

    @FXML
    private TextArea samedi_diner_entrees;

    @FXML
    private TextArea samedi_diner_entrees1;

    @FXML
    private TextArea samedi_diner_platPrincipal;

    @FXML
    private TextArea samedi_diner_platPrincipal1;

    @FXML
    private TextField samedi_ticket;

    @FXML
    private Button samedi_ticketBtn;

    @FXML
    private AnchorPane service_side;

    @FXML
    private Button signUpBtn;

    @FXML
    private AnchorPane signup_side;

    @FXML
    private ScrollPane sp_main;

    @FXML
    private AnchorPane student_MenuSide;

    @FXML
    private AnchorPane student_bar;

    @FXML
    private Button student_communicationBtn;

    @FXML
    private Button student_dimancheBtn;

    @FXML
    private AnchorPane student_dimancheMenu;

    @FXML
    private Button student_jeudiBtn;

    @FXML
    private AnchorPane student_jeudiMenu;

    @FXML
    private Button student_lundiBtn;

    @FXML
    private AnchorPane student_lundiMenu;

    @FXML
    private AnchorPane student_mardiMenu;

    @FXML
    private AnchorPane student_menu;

    @FXML
    private Button student_menuBtn;

    @FXML
    private AnchorPane student_menu_side;

    @FXML
    private Button student_mercrediBtn;

    @FXML
    private AnchorPane student_mercrediMenu;

    @FXML
    private Button student_merdiBtn;

    @FXML
    private Button student_samediBtn;

    @FXML
    private AnchorPane student_samediMenu;

    @FXML
    private Button student_vendrediBtn;

    @FXML
    private AnchorPane student_vendrediMenu;

    @FXML
    private TextField tf_message;

    @FXML
    private VBox vBox_messages;
    @FXML
    private TextArea vendredi_dejeuner_description;

    @FXML
    private TextArea vendredi_dejeuner_description1;

    @FXML
    private TextArea vendredi_dejeuner_dessert;

    @FXML
    private TextArea vendredi_dejeuner_dessert1;

    @FXML
    private CheckBox vendredi_dejeuner_disponnible;

    @FXML
    private CheckBox vendredi_dejeuner_disponnible1;

    @FXML
    private TextArea vendredi_dejeuner_entrees;

    @FXML
    private TextArea vendredi_dejeuner_entrees1;

    @FXML
    private TextArea vendredi_dejeuner_platPrincipal;

    @FXML
    private TextArea vendredi_dejeuner_platPrincipal1;

    @FXML
    private TextArea vendredi_diner_description;

    @FXML
    private TextArea vendredi_diner_description1;

    @FXML
    private TextArea vendredi_diner_dessert;

    @FXML
    private TextArea vendredi_diner_dessert1;

    @FXML
    private CheckBox vendredi_diner_disponnible;

    @FXML
    private CheckBox vendredi_diner_disponnible1;

    @FXML
    private TextArea vendredi_diner_entrees;

    @FXML
    private TextArea vendredi_diner_entrees1;

    @FXML
    private TextArea vendredi_diner_platPrincipal;

    @FXML
    private TextArea vendredi_diner_platPrincipal1;

    @FXML
    private TextField vendredi_ticket;

    @FXML
    private Button vendredi_ticketBtn;

    @FXML
    private TableView<ProductDAOImpl> lundi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> lundi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> lundi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> lundi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> lundi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> lundi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> lundi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> lundi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> mardi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> mardi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> mardi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> mardi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> mardi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mardi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mardi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mardi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> mercredi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> mercredi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> mercredi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> mercredi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> mercredi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mercredi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mercredi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> mercredi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> jeudi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> jeudi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> jeudi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> jeudi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> jeudi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> jeudi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> jeudi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> jeudi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> vendredi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> vendredi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> vendredi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> vendredi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> vendredi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> vendredi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> vendredi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> vendredi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> samedi_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> samedi_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> samedi_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> samedi_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> samedi_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> samedi_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> samedi_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> samedi_supprimerBtn;

    @FXML
    private TableView<ProductDAOImpl> dimanche_stock;

    @FXML
    private TableColumn<ProductDAOImpl, String> dimanche_productName;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> dimanche_quantité;
    @FXML
    private TableColumn<ProductDAOImpl, Integer> dimanche_qantitéMinimale;
    @FXML
    private TableColumn<ProductDAOImpl, Double> dimanche_productPrix;
    @FXML
    private TableColumn<ProductDAOImpl, Button> dimanche_modifierBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> dimanche_validerBtn;
    @FXML
    private TableColumn<ProductDAOImpl, Button> dimanche_supprimerBtn;

    @FXML
    private TableView<EmployeeDAOImpl> employesTable;
    @FXML
    private TableColumn<EmployeeDAOImpl, String> nomEmployeCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, String> prenomEmployeCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, String> posteEmployeCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, Double> salaireEmployeCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, LocalDate> dateEmbaucheCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, Button> modifierBtnCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, Button> validerBtnCol;
    @FXML
    private TableColumn<EmployeeDAOImpl, Button> supprimerBtnCol;

    @FXML
    private AnchorPane communication_side1;

    @FXML
    private ScrollPane sp_main1;

    @FXML
    private VBox vBox_messages1;

    @FXML
    private Button button_send1;

    @FXML
    private TextField tf_message1;


    //Employe
    @FXML
    private AnchorPane student_bar1;
    @FXML
    private Button student_menuBtn1;
    @FXML
    private Button student_communicationBtn1;
    @FXML
    private AnchorPane communication_side11;
    @FXML
    private ScrollPane sp_main11;
    @FXML
    private VBox vBox_messages11;
    @FXML
    private Button button_send11;
    @FXML
    private TextField tf_message11;
    @FXML
    private AnchorPane student_MenuSide1;
    @FXML
    private AnchorPane student_menu_side1;
    @FXML
    private AnchorPane student_menu1;
    @FXML
    private Button student_lundiBtn1;
    @FXML
    private Button student_merdiBtn1;
    @FXML
    private Button student_mercrediBtn1;
    @FXML
    private Button student_jeudiBtn1;
    @FXML
    private Button student_vendrediBtn1;
    @FXML
    private Button student_samediBtn1;
    @FXML
    private Button student_dimancheBtn1;
    @FXML
    private AnchorPane student_dimancheMenu1;
    @FXML
    private TextArea dimanche_dejeuner_platPrincipal11;
    @FXML
    private TextArea dimanche_diner_platPrincipal11;
    @FXML
    private TextArea dimanche_dejeuner_entrees11;
    @FXML
    private TextArea dimanche_dejeuner_dessert11;
    @FXML
    private TextArea dimanche_dejeuner_description11;
    @FXML
    private TextArea dimanche_diner_entrees11;
    @FXML
    private TextArea dimanche_diner_dessert11;
    @FXML
    private TextArea dimanche_diner_description11;
    @FXML
    private CheckBox dimanche_dejeuner_disponnible11;
    @FXML
    private CheckBox dimanche_diner_disponnible11;
    @FXML
    private AnchorPane student_samediMenu1;
    @FXML
    private TextArea samedi_dejeuner_platPrincipal11;
    @FXML
    private TextArea samedi_diner_platPrincipal11;
    @FXML
    private TextArea samedi_dejeuner_entrees11;
    @FXML
    private TextArea samedi_dejeuner_dessert11;
    @FXML
    private TextArea samedi_dejeuner_description11;
    @FXML
    private TextArea samedi_diner_entrees11;
    @FXML
    private TextArea samedi_diner_dessert11;
    @FXML
    private TextArea samedi_diner_description11;
    @FXML
    private CheckBox samedi_dejeuner_disponnible11;
    @FXML
    private CheckBox samedi_diner_disponnible11;
    @FXML
    private AnchorPane student_vendrediMenu1;
    @FXML
    private TextArea vendredi_dejeuner_platPrincipal11;
    @FXML
    private TextArea vendredi_diner_platPrincipal11;
    @FXML
    private TextArea vendredi_dejeuner_entrees11;
    @FXML
    private TextArea vendredi_dejeuner_dessert11;
    @FXML
    private TextArea vendredi_dejeuner_description11;
    @FXML
    private TextArea vendredi_diner_entrees11;
    @FXML
    private TextArea vendredi_diner_dessert11;
    @FXML
    private TextArea vendredi_diner_description11;
    @FXML
    private CheckBox vendredi_dejeuner_disponnible11;
    @FXML
    private CheckBox vendredi_diner_disponnible11;
    @FXML
    private AnchorPane student_jeudiMenu1;
    @FXML
    private TextArea jeudi_dejeuner_platPrincipal11;
    @FXML
    private TextArea jeudi_diner_platPrincipal11;
    @FXML
    private TextArea jeudi_dejeuner_entrees11;
    @FXML
    private TextArea jeudi_dejeuner_dessert11;
    @FXML
    private TextArea jeudi_dejeuner_description11;
    @FXML
    private TextArea jeudi_diner_entrees11;
    @FXML
    private TextArea jeudi_diner_dessert11;
    @FXML
    private TextArea jeudi_diner_description11;
    @FXML
    private CheckBox jeudi_dejeuner_disponnible11;
    @FXML
    private CheckBox jeudi_diner_disponnible11;
    @FXML
    private AnchorPane student_mercrediMenu1;
    @FXML
    private TextArea mercredi_dejeuner_platPrincipal11;
    @FXML
    private TextArea mercredi_diner_platPrincipal11;
    @FXML
    private TextArea mercredi_dejeuner_entrees11;
    @FXML
    private TextArea mercredi_dejeuner_dessert11;
    @FXML
    private TextArea mercredi_dejeuner_description11;
    @FXML
    private TextArea mercredi_diner_entrees11;
    @FXML
    private TextArea mercredi_diner_dessert11;
    @FXML
    private TextArea mercredi_diner_description11;
    @FXML
    private CheckBox mercredi_dejeuner_disponnible11;
    @FXML
    private CheckBox mercredi_diner_disponnible11;
    @FXML
    private AnchorPane student_mardiMenu1;
    @FXML
    private TextArea mardi_dejeuner_platPrincipal11;
    @FXML
    private TextArea mardi_diner_platPrincipal11;
    @FXML
    private TextArea mardi_dejeuner_entrees11;
    @FXML
    private TextArea mardi_dejeuner_dessert11;
    @FXML
    private TextArea mardi_dejeuner_description11;
    @FXML
    private TextArea mardi_diner_entrees11;
    @FXML
    private TextArea mardi_diner_dessert11;
    @FXML
    private TextArea mardi_diner_description11;
    @FXML
    private CheckBox mardi_dejeuner_disponnible11;
    @FXML
    private CheckBox mardi_diner_disponnible11;
    @FXML
    private AnchorPane student_lundiMenu1;
    @FXML
    private TextArea lundi_dejeuner_platPrincipal11;
    @FXML
    private TextArea lundi_diner_platPrincipal11;
    @FXML
    private TextArea lundi_dejeuner_entrees11;
    @FXML
    private TextArea lundi_dejeuner_dessert11;
    @FXML
    private TextArea lundi_dejeuner_description11;
    @FXML
    private TextArea lundi_diner_entrees11;
    @FXML
    private TextArea lundi_diner_dessert11;
    @FXML
    private TextArea lundi_diner_diescription11;
    @FXML
    private CheckBox lundi_dejeuner_disponnible11;
    @FXML
    private CheckBox lundi_diner_disponnible11;


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

    private ProductDAOImpl lundi;
    private ProductDAOImpl mardi;
    private ProductDAOImpl mercredi;
    private ProductDAOImpl jeudi;
    private ProductDAOImpl vendredi;
    private ProductDAOImpl samedi;
    private ProductDAOImpl dimanche;
    private EmployeeDAOImpl employeeDAO;

    @FXML
    public void addProduct() throws SQLException {
        userDAO = new UserDAOImpl();
        if (
                addProduct_jour.getText().isEmpty() || addProduct_nom.getText().isEmpty() || addProduct_quantité.getText().isEmpty() ||
                        addProduct_quantitéMinimale.getText().isEmpty() || addProduct_prix.getText().isEmpty()) {
            userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "veuillez remplir tous les champs !");
        }
        String jour = addProduct_jour.getText();
        switch (jour) {
            case "Lundi":
                lundi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Mardi":
                mardi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Mercredi":
                mercredi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Jeudi":
                jeudi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Vendredi":
                vendredi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Samedi":
                samedi.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            case "Dimanche":
                dimanche.ajouterProduit(jour, addProduct_nom.getText(), Integer.parseInt(addProduct_quantité.getText()), Integer.parseInt(addProduct_quantitéMinimale.getText()), Double.parseDouble(addProduct_prix.getText()));
                break;
            default:
                userDAO.alert(Alert.AlertType.ERROR, "Aucune jour trouvé", "Tapez le nom de jour avec le premier lettre est capitable !");
                break;
        }

// Nettoyage des champs après l'ajout du produit
        addProduct_jour.clear();
        addProduct_nom.clear();
        addProduct_quantité.clear();
        addProduct_prix.clear();
        addProduct_quantitéMinimale.clear();

    }

    @FXML
    public void addEmploye() {
        userDAO = new UserDAOImpl();
        if (nom_employe.getText().isEmpty() || prenom_employe.getText().isEmpty() || poste_employe.getText().isEmpty() || salaire_employe.getText().isEmpty()) {
            userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez remplir tous les champs !");
        } else {
            try {
                double salaire = Double.parseDouble(salaire_employe.getText());
                employeeDAO.ajouterEmploye(nom_employe.getText(), prenom_employe.getText(), poste_employe.getText(), salaire);

                nom_employe.clear();
                prenom_employe.clear();
                poste_employe.clear();
                salaire_employe.clear();
            } catch (NumberFormatException e) {
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Le salaire doit être un nombre valide !");
            }
        }
    }


    @FXML
    public void getComptability(ActionEvent event) throws SQLException {
        if (event.getSource() == lundi_ticktBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour lundi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Lundi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == mardi_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Mardi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Mardi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == mercredi_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Mercredi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Mercredi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == jeudi_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Jeudi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Jeudi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == vendredi_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Vendredi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Vendredi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == samedi_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Samedi !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Samedi", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        } else if (event.getSource() == dimanche_ticketBtn) {
            if (lundi_ticket.getText().isEmpty()) {
                userDAO = new UserDAOImpl();
                userDAO.alert(Alert.AlertType.ERROR, "Erreur de Saisie", "Veuillez entrer le nombre de tickets pour Dimanche !");
                return;
            }
            jour_comtabilité.clear();
            jour_comtabilité_total.clear();
            lundi.getComtability("Dimanche", lundi_ticket, jour_comtabilité, jour_comtabilité_total);
        }
    }


    @FXML
    public void initialize() throws SQLException {
        ObservableList<String> statutItems = FXCollections.observableArrayList(statutArray);
        s_statut.setItems(statutItems);

        ObservableList<String> typeItems = FXCollections.observableArrayList(TypeArray);
        s_type_utilisateur.setItems(typeItems);

        ObservableList<String> questionItems = FXCollections.observableArrayList(questions);
        s_question.setItems(questionItems);
        f_question.setItems(questionItems);


        lundi = new ProductDAOImpl(lundi_stock, lundi_productName, lundi_quantité, lundi_qantitéMinimale, lundi_productPrix, lundi_modifierBtn, lundi_validerBtn, lundi_supprimerBtn);

        mardi = new ProductDAOImpl(mardi_stock, mardi_productName, mardi_quantité, mardi_qantitéMinimale, mardi_productPrix, mardi_modifierBtn, mardi_validerBtn, mardi_supprimerBtn);

        mercredi = new ProductDAOImpl(mercredi_stock, mercredi_productName, mercredi_quantité, mercredi_qantitéMinimale, mercredi_productPrix, mercredi_modifierBtn, mercredi_validerBtn, mercredi_supprimerBtn);

        jeudi = new ProductDAOImpl(jeudi_stock, jeudi_productName, jeudi_quantité, jeudi_qantitéMinimale, jeudi_productPrix, jeudi_modifierBtn, jeudi_validerBtn, jeudi_supprimerBtn);

        vendredi = new ProductDAOImpl(vendredi_stock, vendredi_productName, vendredi_quantité, vendredi_qantitéMinimale, vendredi_productPrix, vendredi_modifierBtn, vendredi_validerBtn, vendredi_supprimerBtn);

        samedi = new ProductDAOImpl(samedi_stock, samedi_productName, samedi_quantité, samedi_qantitéMinimale, samedi_productPrix, samedi_modifierBtn, samedi_validerBtn, samedi_supprimerBtn);

        dimanche = new ProductDAOImpl(dimanche_stock, dimanche_productName, dimanche_quantité, dimanche_qantitéMinimale, dimanche_productPrix, dimanche_modifierBtn, dimanche_validerBtn, dimanche_supprimerBtn);


        lundi.getAllProducts("Lundi");

        mardi.getAllProducts("Mardi");

        mercredi.getAllProducts("Mercredi");

        jeudi.getAllProducts("Jeudi");

        vendredi.getAllProducts("Vendredi");

        samedi.getAllProducts("Samedi");

        dimanche.getAllProducts("Dimanche");

        employeeDAO = new EmployeeDAOImpl(employesTable, nomEmployeCol, prenomEmployeCol, posteEmployeCol, salaireEmployeCol, dateEmbaucheCol, modifierBtnCol, validerBtnCol, supprimerBtnCol);
        employeeDAO.getAllEmployees();


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
            chef_restaurant_bar.setVisible(false);
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            communication_side.setVisible(false);
        } else if (type.equals("Responsable des Etudiants")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
            chef_restaurant_bar.setVisible(false);
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            communication_side.setVisible(false);
        } else if (type.equals("Employée")) {
            service_side.setVisible(false);
            login_side.setVisible(false);
            forgotPassword_side.setVisible(false);
            changePassword_side.setVisible(false);
            chef_restaurant_bar.setVisible(false);
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            communication_side.setVisible(false);
            student_bar.setVisible(false);
            student_MenuSide.setVisible(false);
            communication_side1.setVisible(false);
        }
    }


    @FXML
    public void getMenuRepas(ActionEvent event) throws SQLException {
        ChefDAOImpl chefDAO = new ChefDAOImpl();
        if (event.getSource() == chef_menuBtn) {
            communication_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            chef_employee_side.setVisible(false);
            pere_chefMenu_side.setVisible(true);
        } else if (event.getSource() == chef_employeeBtn) {
            communication_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(true);
        } else if (event.getSource() == chef_comptabilitéBtnBtn) {
            communication_side.setVisible(false);
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(false);
            chef_comptabilité_menu.setVisible(true);
        } else if (event.getSource() == chef_communicationBtn) {
            pere_chefMenu_side.setVisible(false);
            chef_employee_side.setVisible(false);
            chef_comptabilité_menu.setVisible(false);
            communication_side.setVisible(true);
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