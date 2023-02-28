package malek.khannoussi.tp3;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyVBox extends VBox {
    Profile profile ;
    Label title = new Label();
    TitledPane difficultyPane = new TitledPane();
    ComboBox difficulty = new ComboBox();

    CheckBox first = new CheckBox("1");

    CheckBox second = new CheckBox("2");
    CheckBox third = new CheckBox("3");
    CheckBox fourth = new CheckBox("4");
    CheckBox fifth = new CheckBox("5");
    CheckBox sixth = new CheckBox("6");
    CheckBox seventh = new CheckBox("7");
    TitledPane options = new TitledPane();
    CheckBox option1 = new CheckBox("Emettre son");
    CheckBox option2 = new CheckBox("Afficher score");
    CheckBox option3 = new CheckBox("Plein ecran");
    CheckBox option4 = new CheckBox("Ombre");
    Button  valider = new Button("Valider");

    public MyVBox(Profile profile) {
        title.setText("Bienvenue "+profile.pseudo);
        title.setMaxWidth(Double.MAX_VALUE);
        title.setAlignment(Pos.CENTER);
        title.setMinHeight(50);
        title.setStyle("-fx-font-size: 20px;-fx-background-color: #01fd01; -fx-color-label-visible: #005301; -fx-padding: 20px;");
        difficultyPane.setText("Difficulté");
        difficultyPane.setCollapsible(false);
        difficultyPane.setAlignment(Pos.CENTER);
        difficulty.getItems().addAll(
                "Facile",
                "Moyen",
                "Difficile"
        );
        first.setDisable(true);
        first.setSelected(true);
        second.setDisable(true);
        second.setSelected(true);
        fifth.setDisable(true);
        sixth.setDisable(true);
        seventh.setDisable(true);
        VBox contentOfDifficulty = new VBox(difficulty);
        Label checkboxes = new Label("Sélectionnez la/les catégorie(s):");
        HBox checkbox = new HBox(checkboxes,first, second, third, fourth, fifth, sixth, seventh);
        contentOfDifficulty.getChildren().add(checkbox);
        difficultyPane.setContent(contentOfDifficulty);

        options.setText("Options:2");
        options.setCollapsible(false);
        options.setContent(new HBox( option1, option2, option3, option4));
        this.getChildren().addAll(title, difficultyPane,options,valider);
        this.profile =profile;
    }
}
