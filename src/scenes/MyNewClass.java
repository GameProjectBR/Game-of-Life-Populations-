package Scenes;

import Controllers.MenuFiller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modules.Test;

public class MyNewClass {
    Button ACCOUNT,CREATE;
    Scene ENTRANCE2;
    BorderPane PANE,TOPPANE;
    Image IMAGE;
    BackgroundImage BACKGROUNDIMAGE;
    HBox TOP,MID,TOP1,TOP2,RBUTTONS;
    VBox MAINRIGHT,MAIN;
    Text WELCOME, HOME,TITLE,TITLE2,TITLE3;
    TextField NAME;
    RadioButton CONDITIONS;
    ComboBox CLASS;
    MenuFiller OPTIONS;
    ChoiceBox BOXME;
    ComboBox BOXME2;
    Test TEST;
    
    public MyNewClass(Stage MAINWINDOW) throws IOException{
        MAINWINDOW.setTitle("GAME MANAGEMENT |--> HOMEPAGE");
        
        
        IMAGE = new Image("background2.png");
        BACKGROUNDIMAGE = new BackgroundImage(IMAGE,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        WELCOME = new Text();
        WELCOME.setText("Welcome to Your Homepage!");
        WELCOME.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        HOME = new Text();
        HOME.setText("HOME");
        HOME.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
                
        ACCOUNT = new Button("Account");
        ACCOUNT.setId("MENUITEMS");
        
        TITLE = new Text();
        TITLE.setText("Homepage:");
        TITLE.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        TITLE2 = new Text();
        TITLE2.setText("");
        
        TITLE3 = new Text();
        TITLE3.setText("");
        
        BOXME = new ChoiceBox();
        BOXME.setPrefWidth(500);
        BOXME.setPrefHeight(40);
        Platform.runLater(() -> {
            SkinBase<ChoiceBox<String>> skin = (SkinBase<ChoiceBox<String>>) BOXME.getSkin();
            // children contain only "Label label" and "StackPane openButton"
            for (Node child : skin.getChildren()) {
                if (child instanceof Label) {
                    Label label = (Label) child;
                    if (label.getText().isEmpty()) {
                        label.setText("Favourite Game Genre");
                    }
                    return;
                }
            }
        });
        
        BOXME2 = new ComboBox();
        BOXME2.setPrefWidth(500);
        BOXME2.setPrefHeight(40);
        BOXME2.setPromptText("Choose an Image");
        
        OPTIONS = new MenuFiller("test/menus.txt",MAINWINDOW);
        OPTIONS.BoxFiller("test/menus.txt",BOXME);
        OPTIONS.BoxFiller2("test/Headshots2.txt", BOXME2);
        
        NAME = new TextField();
        NAME.setMaxWidth(500);
        NAME.setPrefHeight(40);
        NAME.setPromptText("Favourite Game Name");
        
        CONDITIONS = new RadioButton();
        CONDITIONS.setText("Accept to terms and conditions.");
        
        CREATE = new Button("Create");
        
        CREATE.setOnAction(e->{
            System.out.println("Action Create.");
            try {
                TEST = new Test(MAINWINDOW);
            } catch (IOException ex) {
                Logger.getLogger(MyNewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            MAINWINDOW.setScene(TEST.getScreen());
        });
        
        RBUTTONS = new HBox(30);
        RBUTTONS.getChildren().addAll(CONDITIONS);
        RBUTTONS.setAlignment(Pos.BOTTOM_CENTER);       
       
        TOP = new HBox(20);
        TOP.getChildren().addAll(WELCOME);
        TOP.setPadding(new Insets(20,20,20,20));
        TOP.setAlignment(Pos.CENTER);
        
        TOP1 = new HBox(20);
        TOP1.getChildren().addAll(ACCOUNT);
        TOP1.setPadding(new Insets(20,20,20,20));
        TOP1.setAlignment(Pos.CENTER_RIGHT);
        
        TOP2 = new HBox(20);
        TOP2.getChildren().addAll(HOME);
        TOP2.setPadding(new Insets(20,20,20,20));
        TOP2.setAlignment(Pos.CENTER);
        
        TOPPANE = new BorderPane();
        TOPPANE.setBackground(new Background(new BackgroundFill(Color.CYAN,CornerRadii.EMPTY,Insets.EMPTY)));
        TOPPANE.setLeft(TOP);
        TOPPANE.setRight(TOP1);
        
        
        MAIN = new VBox(15);
        MAIN.setPrefWidth(500);
        MAIN.getChildren().addAll(TITLE,NAME,BOXME2,BOXME,RBUTTONS,CREATE);
        MAIN.setPadding(new Insets(0,0,0,0));
        MAIN.setAlignment(Pos.CENTER);
        
        MID = new HBox(10);
        MID.getChildren().addAll(MAIN);
        MID.setPadding(new Insets(0,0,10,0));
        MID.setAlignment(Pos.CENTER);
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BACKGROUNDIMAGE));
        PANE.setTop(TOPPANE);
        PANE.setCenter(MID);
        
        ENTRANCE2 = new Scene(PANE,800,1400);
        ENTRANCE2.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE2;
    }
}
