/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author f_kri
 */
public class ViewController implements Initializable {

    
    @FXML
    AnchorPane AnchorPane;
    @FXML
    SplitPane mainSplit;
    @FXML
    TableView table;
    @FXML
    TextField inputLastname;
    @FXML
    TextField inputFirstName;
    @FXML
    TextField inputEmail;
    @FXML
    Button buttonAddContact;
    @FXML
    StackPane menuPane;
    @FXML
    Pane exportPane;
    @FXML
    Pane contactPane;
    @FXML
    TextField textFieldSaveAs;
    @FXML
    Button buttonPDFSave;

    DB db = new DB();

    private final String MENU_CONTACTS = "Kontaktok";
    private final String MENU_LIST = "Lista";
    private final String MENU_EXPORT = "Export";
    private final String MENU_EXIT = "Exit";

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    @FXML
    private void addContact(ActionEvent event) {
        String email = inputEmail.getText();
        String vezetek = inputLastname.getText();
        String kereszt = inputFirstName.getText();
        if (email != null && vezetek != null && kereszt != null && email.contains("@") && email.contains(".")) {
            Person actualPerson = new Person(inputLastname.getText(), inputFirstName.getText(), email);
            data.add(actualPerson);
            db.addContact(actualPerson);
            inputLastname.clear();
            inputFirstName.clear();
            inputEmail.clear();
        } else {
            String alertMsg = "coulnd add record because of some formal error.";
            alert(alertMsg);
            System.out.println(alertMsg);
        }
    }

    @FXML
    private void exportList(ActionEvent event) {
        String fileName = textFieldSaveAs.getText();
        fileName = fileName.replaceAll("\\s+", "");

        if (fileName != null && !fileName.equals("")) {

            generatePDF generatePDF = new generatePDF();
            generatePDF.generatePDF(fileName, data);
            System.out.println("PDF successfully generated.");
        } else {
            String alertMsg = "Sorry, no PDF name given, no PDF generated.";
            alert(alertMsg);
            System.out.println(alertMsg);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Elvégezzük a demo adatok (ObservableList) felviteélt a rendszerbe,
        //illetve előtte létrehozzuk a tagolásnak megfelelő táblázatot a nézetbe,
        //a szerkesztés logikáját pedig leírjuk
        setTableData();

        setMenuData();
        

    }

    public void setTableData() {
        TableColumn lastNameCol = new TableColumn("Vezetéknév");
        lastNameCol.setMinWidth(130);
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                Person actualPerson = (Person) event.getTableView().getItems().get(event.getTablePosition().getRow());
                actualPerson.setLastName(event.getNewValue());
                db.updateContact(actualPerson);
            }
        }
        );

        TableColumn firstNameCol = new TableColumn("Keresztnév");
        firstNameCol.setMinWidth(130);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                Person actualPerson = (Person) event.getTableView().getItems().get(event.getTablePosition().getRow());
                actualPerson.setFirstName(event.getNewValue());
                db.updateContact(actualPerson);
            }
        }
        );

        TableColumn emailCOL = new TableColumn("eMail cím");
        emailCOL.setMinWidth(210);
        emailCOL.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCOL.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        emailCOL.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                Person actualPerson = (Person) event.getTableView().getItems().get(event.getTablePosition().getRow());
                actualPerson.setEmail(event.getNewValue());
                db.updateContact(actualPerson);
            }
        }
        );

        table.getColumns().addAll(lastNameCol, firstNameCol, emailCOL);
        data.addAll(db.getAllContacts());
        table.setItems(data);
    }

    public void setMenuData() {
        TreeItem<String> treeItemRoot1 = new TreeItem<>("Menü");
        TreeView<String> treeView = new TreeView<>(treeItemRoot1);
        treeView.setShowRoot(false);

        TreeItem<String> nodeItemA = new TreeItem<>(MENU_CONTACTS);
        TreeItem<String> nodeItemB = new TreeItem<>(MENU_EXIT);

        nodeItemA.setExpanded(true);

        Node contactsNode = new ImageView(new Image(getClass().getResourceAsStream("/contacts.png")));
        Node exportNode = new ImageView(new Image(getClass().getResourceAsStream("/export.png")));
        TreeItem<String> nodeItemA1 = new TreeItem<>(MENU_LIST, contactsNode);
        TreeItem<String> nodeItemA2 = new TreeItem<>(MENU_EXPORT, exportNode);

        treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB);
        nodeItemA.getChildren().addAll(nodeItemA1, nodeItemA2);

        menuPane.getChildren().addAll(treeView);

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;
                String selectedMenu;
                selectedMenu = selectedItem.getValue();

                if (null != selectedMenu) {
                    switch (selectedMenu) {
                        case MENU_CONTACTS:
                            selectedItem.setExpanded(true);
                            break;
                        case MENU_LIST:
                            contactPane.setVisible(true);
                            exportPane.setVisible(false);
                            break;
                        case MENU_EXPORT:
                            contactPane.setVisible(false);
                            exportPane.setVisible(true);
                            break;
                        case MENU_EXIT:
                            System.exit(0);
                            break;

                    }

                }

            }
        });

    }
    
    public void alert(String text) {
        
        mainSplit.setDisable(true);
        mainSplit.setOpacity(0.4);
        
        Label label = new Label(text);
        Button alertButton = new Button("OK");
        VBox vbox = new VBox(label, alertButton);
        vbox.setAlignment(Pos.CENTER);
        
        alertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
           
                mainSplit.setDisable(false);
                mainSplit.setOpacity(1);
                vbox.setVisible(false);
                 }
        });
        
        AnchorPane.getChildren().add(vbox);
        AnchorPane.setTopAnchor(vbox,300.00);
        AnchorPane.setLeftAnchor(vbox, 300.00);
        
    }

}
