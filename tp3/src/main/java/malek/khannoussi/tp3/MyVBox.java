package malek.khannoussi.tp3;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MyVBox extends VBox {
    Label title = new Label("Bienvenue");
    public MyVBox() {
        this.getChildren().add(title);
    }
}
