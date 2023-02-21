package malek.khannoussi.tp3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Tp3 extends Application {

    public  BorderPane root;
    public   static  Scene scene;
    public  HBox top;
    Label firstName ;
    public  Label lastName ;
    public  Label pseudo ;
    public  TextField firstNameField;
    public  TextField lastNameField;
    public  TextField pseudoField;
    public  Button validateButton;
    public  HBox bottom;
    public  Label helper;
    public  SplitPane splitPane;
    public  ListView listView;
    public  ObservableList<Profile> items = FXCollections.observableArrayList();
    public  TabPane tabPane;
    public   ContextMenu contextMenu;
    public  MenuItem delete;
    public  MenuItem deleteAll;
    public  MenuItem edit;


    @Override
    public void start(Stage stage) throws IOException {
        root = new BorderPane();
        top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setSpacing(10);
        firstName = new Label("Nom");
        lastName = new Label("Prénom");
        pseudo = new Label("Pseudo");
        firstNameField = new TextField();
        firstNameField.setPromptText("Tappez votre nom ici");
        lastNameField = new TextField();
        lastNameField.setPromptText("Tappez votre prénom ici");
        pseudoField = new TextField();
        pseudoField.setPromptText("Tappez votre pseudo ici");
        validateButton = new Button("Valider");
        top.getChildren().addAll(firstName, firstNameField, lastName, lastNameField, pseudo, pseudoField, validateButton);
        root.setTop(top);
        bottom = new HBox();
        helper = new Label("helper:");
        bottom.getChildren().add(helper);
        root.setBottom(bottom);
        splitPane = new SplitPane();
        listView = new ListView();
        listView.setItems(items);
        tabPane = new TabPane();
        splitPane.getItems().addAll(listView, tabPane);
        splitPane.setDividerPositions(0.2);
        root.setCenter(splitPane);
        validateButton.setOnAction(event -> {
            helper.setStyle("-fx-text-fill: red;");
            helper.setPadding(new javafx.geometry.Insets(5, 5, 0, 10));
            if(firstNameField.getText().isEmpty()){
                helper.setText("Veuillez entrer votre nom");
                return;
            }else{
                if(lastNameField.getText().isEmpty()){
                    helper.setText("Veuillez entrer votre prénom");
                    return;}
                else{
                    if(pseudoField.getText().isEmpty()){
                        helper.setText("Veuillez entrer votre pseudo");
                        return;
                    }else{
                        items.add(new Profile(firstNameField.getText(),lastNameField.getText(),pseudoField.getText()));
                        firstNameField.clear();
                        lastNameField.clear();
                        pseudoField.clear();
                    }

                }
            }
        });
        contextMenu = new ContextMenu();
        delete = new MenuItem("Supprimer");
        deleteAll = new MenuItem("Supprimer tout");
        edit = new MenuItem("Modifier");
        delete.setOnAction(event -> {
            items.remove(listView.getSelectionModel().getSelectedItem());
        });
        deleteAll.setOnAction(event -> {
            items.clear();
        });
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });


        contextMenu.getItems().addAll(delete, deleteAll, edit);
        listView.setContextMenu(contextMenu);
        listView.setOnMouseClicked(new EcouterListView(this));

        scene = new Scene(root, 1000, 480);
        stage.setTitle("TP3");
        stage.setScene(scene);
        stage.show();

        firstName.setOnMouseEntered(new EcouterLabel(this));
        firstName.setOnMouseExited(new EcouterLabel(this));
        lastName.setOnMouseEntered(new EcouterLabel(this));
        lastName.setOnMouseExited(new EcouterLabel(this));
        pseudo.setOnMouseEntered(new EcouterLabel(this));
        pseudo.setOnMouseExited(new EcouterLabel(this));

        lastNameField.setOnMouseEntered(new EcouterLabel(this));


    }

    public static void main(String[] args) {
        launch();
    }
}