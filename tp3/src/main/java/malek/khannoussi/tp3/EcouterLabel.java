package malek.khannoussi.tp3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class EcouterLabel implements EventHandler<MouseEvent> {
    public Tp3 ex;
    public EcouterLabel(Tp3 tp3) {
        this.ex = tp3;
    }

    @Override
    public void handle(MouseEvent e) {

        if(e.getSource()==ex.firstName){
            Label label = (Label) e.getSource();
            if(e.getEventType()==MouseEvent.MOUSE_ENTERED){
                label.setStyle("-fx-text-fill: red");
            }
            if(e.getEventType()==MouseEvent.MOUSE_EXITED){
                label.setStyle("-fx-text-fill: black");
            }
        }
        if(e.getSource()==ex.lastName){
            Label label = (Label) e.getSource();
            if(e.getEventType()==MouseEvent.MOUSE_ENTERED){
                label.setStyle("-fx-text-fill: red");
            }
            if(e.getEventType()==MouseEvent.MOUSE_EXITED){
                label.setStyle("-fx-text-fill: black");
            }
        }
        if(e.getSource()==ex.pseudo){
            Label label = (Label) e.getSource();
            if(e.getEventType()==MouseEvent.MOUSE_ENTERED){
                label.setStyle("-fx-text-fill: red");
            }
            if(e.getEventType()==MouseEvent.MOUSE_EXITED){
                label.setStyle("-fx-text-fill: black");
            }
        }

        if(e.getClickCount()==2 && e.getSource()==ex.listView && e.getButton()== MouseButton.PRIMARY){

        } else if (e.getClickCount()==1 && e.getSource()==ex.listView && e.getButton()== MouseButton.PRIMARY){

        }


    }
}
