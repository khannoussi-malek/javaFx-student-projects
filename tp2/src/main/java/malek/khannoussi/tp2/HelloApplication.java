package malek.khannoussi.tp2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void init() throws Exception {
        // run before start()
        super.init();
    }

    Label lb_title;
    VBox vb_root;
    TitledPane tp_generalInfo;
    TitledPane tp_TechSkills;
    CheckBox cb_save;
    Button bt_send;
    Button bt_cancel;
    HBox hb_buttons;
    HBox hb_generalInfo;

    HBox hb_TechSkills;
    GridPane gp_generalInfo;
    GridPane gp_skills;
    Image img_photo;
    ImageView iv_photo;

    Label lb_FullName;
    TextField tf_FullName;
    Label lb_email;
    TextField tf_email;
    Label lb_phone;
    TextField tf_phone;
    Label lb_dateOfBirth;
    ComboBox cb_dateOfBirthDay;
    ComboBox cb_dateOfBirthMonth;
    ComboBox cb_dateOfBirthYear;
    HBox hb_dateOfBirth;
    Label lb_gender;
    RadioButton rb_genderMale;
    RadioButton rb_genderFemale;
    HBox hb_gender;
    Label lb_formation;
    ComboBox cb_formation;
    Label lb_java;
    ComboBox cb_java;
    Label lb_python;
    ComboBox cb_python;
    Label lb_machineLearning;
    ComboBox cb_machineLearning;
    Label lb_comment;
    TextArea ta_comment;



    @Override
    public void start(Stage stage) throws IOException {
        lb_title = new Label("Curriculum vitae");
        lb_title.setFont(Font.font("Arial",28));
        lb_title.setTextFill(Paint.valueOf("purple"));
        lb_title.setPadding(new Insets(10, 10, 10, 10));

        vb_root = new VBox();
        vb_root.getChildren().add(lb_title);
        vb_root.setAlignment(Pos.CENTER);

        tp_generalInfo = new TitledPane();
        tp_generalInfo.setText("Informations générales");

        vb_root.getChildren().add(tp_generalInfo);

        tp_TechSkills = new TitledPane();
        tp_TechSkills.setText("Compétences techniques");

        vb_root.getChildren().add(tp_TechSkills);

        cb_save = new CheckBox("Enregistrer une version pdf de la candidature avant d'envoyer");
        cb_save.setTextFill(Paint.valueOf("purple"));
        cb_save.setPadding(new Insets(10, 10, 10, 10));

        vb_root.getChildren().add(cb_save);

        bt_send = new Button("Envoyer");
        bt_cancel = new Button("Annuler");
        hb_buttons = new HBox();
        hb_buttons.getChildren().addAll(bt_send, bt_cancel);
        hb_buttons.setAlignment(Pos.CENTER);
        hb_buttons.setSpacing(10);
        hb_buttons.setPadding(new Insets(10, 10, 10, 10));
        vb_root.getChildren().add(hb_buttons);

        // general info
        hb_generalInfo = new HBox();
        hb_generalInfo.setPadding(new Insets(10, 10, 10, 10));
        hb_generalInfo.setSpacing(10);
        // form general info
        lb_FullName = new Label("Nom et prénom");
        tf_FullName = new TextField();
        lb_email = new Label("Email");
        tf_email = new TextField();
        lb_phone = new Label("Tél");
        tf_phone = new TextField();

        // add image
        img_photo = new Image("file:src/main/resources/malek/khannoussi/tp2/user.png");
        iv_photo = new ImageView();
        iv_photo.setImage(img_photo);
        iv_photo.setFitHeight(120);
        iv_photo.setFitWidth(120);
        // add form to the grid
        gp_generalInfo = new GridPane();
        gp_generalInfo.setPadding(new Insets(10, 10, 10, 10));
        gp_generalInfo.setVgap(10);
        gp_generalInfo.setHgap(10);
        lb_FullName = new Label("Nom et prénom");
        tf_FullName = new TextField();
        lb_email = new Label("Email");
        tf_email = new TextField();
        lb_phone = new Label("Tél");
        tf_phone = new TextField();


        gp_generalInfo.add(lb_FullName, 0, 0);
        gp_generalInfo.add(tf_FullName, 1, 0);
        gp_generalInfo.add(lb_email, 0, 1);
        gp_generalInfo.add(tf_email, 1, 1);
        gp_generalInfo.add(lb_phone, 0, 2);
        gp_generalInfo.add(tf_phone, 1, 2);

        //birth date
        lb_dateOfBirth = new Label("Date de naissance");
        cb_dateOfBirthDay = new ComboBox();
        for (int i = 1; i <= 31; i++) {
            cb_dateOfBirthDay.getItems().add(i);
        }

        cb_dateOfBirthMonth = new ComboBox();
        for (int i = 1; i <= 12; i++) {
            cb_dateOfBirthMonth.getItems().add(i);
        }
        cb_dateOfBirthYear = new ComboBox();
        for (int i = 2023; i <=1900 ; i--) {
            cb_dateOfBirthYear.getItems().add(i);
        }
        cb_dateOfBirthYear.setPlaceholder(new Label("Année"));
        cb_dateOfBirthMonth.setPlaceholder(new Label("Mois"));
        cb_dateOfBirthDay.setPlaceholder(new Label("Jour"));

        hb_dateOfBirth = new HBox();
        hb_dateOfBirth.getChildren().addAll(cb_dateOfBirthDay, cb_dateOfBirthMonth, cb_dateOfBirthYear);
        hb_dateOfBirth.setSpacing(10);
        gp_generalInfo.add(lb_dateOfBirth, 0, 3);
        gp_generalInfo.add(hb_dateOfBirth, 1, 3);

        // gender
        lb_gender = new Label("Genre");
        ToggleGroup tg = new ToggleGroup();
        rb_genderMale = new RadioButton("Homme");
        rb_genderFemale = new RadioButton("Femme");
        rb_genderMale.setToggleGroup(tg);
        rb_genderFemale.setToggleGroup(tg);
        hb_gender = new HBox();
        hb_gender.setSpacing(10);
        hb_gender.getChildren().addAll(rb_genderMale,rb_genderFemale);
        gp_generalInfo.add(lb_gender, 0, 4);
        gp_generalInfo.add(hb_gender, 1, 4);

        // Formation
        lb_formation = new Label("Formation");
        cb_formation = new ComboBox();
        cb_formation.getItems().addAll("Bac", "Ingénieur", "Master", "Doctorat", "Licence");
        gp_generalInfo.add(lb_formation, 0, 5);
        gp_generalInfo.add(cb_formation, 1, 5);



        // add image and form to the general info
        hb_generalInfo.getChildren().addAll(gp_generalInfo,iv_photo);
        hb_generalInfo.setAlignment(Pos.CENTER);
        tp_generalInfo.setContent(hb_generalInfo);

        // skills
        HBox hb_skills = new HBox();
        hb_skills.setPadding(new Insets(10, 10, 10, 10));
        hb_skills.setSpacing(10);
        hb_skills.setAlignment(Pos.CENTER);
        // form skills
        lb_java = new Label("java");
        lb_python = new Label("python");
        lb_machineLearning = new Label("Machine Learning");
        cb_java = new ComboBox();
        cb_java.getItems().addAll("Débutant", "Intermédiaire", "Avancé");
        cb_python = new ComboBox();
        cb_python.getItems().addAll("Débutant", "Intermédiaire", "Avancé");
        cb_machineLearning = new ComboBox();
        cb_machineLearning.getItems().addAll("Débutant", "Intermédiaire", "Avancé");
        // add form to the grid
        gp_skills = new GridPane();
        gp_skills.setPadding(new Insets(10, 10, 10, 10));
        gp_skills.setVgap(10);
        gp_skills.setHgap(10);
        gp_skills.add(lb_java, 0, 0);
        gp_skills.add(cb_java, 1, 0);
        gp_skills.add(lb_python, 0, 1);
        gp_skills.add(cb_python, 1, 1);
        gp_skills.add(lb_machineLearning, 0, 2);
        gp_skills.add(cb_machineLearning, 1, 2);
        HBox vb_skills = new HBox();
        vb_skills.setPadding(new Insets(10, 10, 10, 10));
        vb_skills.setSpacing(10);
        vb_skills.setAlignment(Pos.CENTER);
        VBox vb_comment = new VBox();
        vb_comment.setPadding(new Insets(10, 10, 10, 10));
        vb_comment.setSpacing(10);
        vb_comment.setAlignment(Pos.CENTER);
        lb_comment = new Label("Commentaire");
        ta_comment = new TextArea();
        ta_comment.setPrefSize(200, 200);
        vb_comment.getChildren().addAll(lb_comment, ta_comment);

        vb_skills.getChildren().addAll(gp_skills,vb_comment);
        hb_skills.getChildren().addAll(vb_skills);
        tp_TechSkills.setContent(hb_skills);








        // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(vb_root, 800, 600);
        // change the background of the seane
        scene.setFill(Paint.valueOf("blue"));
        stage.setTitle("Convertir la température");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
        bt_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                    File f = new File("file:src/main/resources/malek/khannoussi/tp2/index.html");
                FileWriter fw = null;
                try {
                    fw = new FileWriter(f,false);
                    fw.write("<html> <head> <title> CV </title> </head> <body> <h1> CV </h1> <h2> Informations générales </h2> <p> Nom Prenom : " + tf_FullName.getText() + "</p> <p> Date de naissance : " + cb_dateOfBirthDay.getValue() + "/" + cb_dateOfBirthMonth.getValue() + "/" + cb_dateOfBirthYear.getValue() + "</p> <p> Genre : " + tg.getSelectedToggle().getUserData() + "</p> <p> Formation : " + cb_formation.getValue() + "</p> <h2> Compétences </h2> <p> Java : " + cb_java.getValue() + "</p> <p> Python : " + cb_python.getValue() + "</p> <p> Machine Learning : " + cb_machineLearning.getValue() + "</p> <p> Commentaire : " + ta_comment.getText() + "</p> </body> </html>");
                    fw.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        bt_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

    }

    @Override
    public void stop() throws Exception {
        // run after start()
        super.stop();
    }


    public static void main(String[] args) {
        launch();
    }
}