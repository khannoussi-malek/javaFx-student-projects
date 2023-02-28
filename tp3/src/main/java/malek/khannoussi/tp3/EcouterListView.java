package malek.khannoussi.tp3;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;

public class EcouterListView  implements EventHandler<MouseEvent> {
    public Tp3 ex;
    public EcouterListView(Tp3 tp3) {
        this.ex = tp3;
    }

    @Override
    public void handle(MouseEvent e) {
        if(e.getClickCount()==2 && e.getSource()==ex.listView && e.getButton()== MouseButton.PRIMARY){
           Profile profile = (Profile) ex.listView.getSelectionModel().getSelectedItem();
            ex.tabPane.getTabs().add(new Tab(profile.pseudo,new MyVBox(profile)));
        }
    }
}
