package modules;

import Controllers.MenuFiller;
import Controllers.RadioButtonFiller;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test {
    MenuFiller OPTIONS;
    HBox BOXOPTIONS;
    ComboBox BOXME2;
    ChoiceBox BOXME;
    Scene ENTRANCE3;
    BorderPane PANE;
    Image IMG;
    BackgroundImage BCIMG;
    HBox RIGHTBOX;
    VBox IMGBOX,RADIOBOX;
    RadioButtonFiller DING;
    ImageView IVIMG;
    
    public Test(Stage MAINWINDOW) throws FileNotFoundException, IOException{
        MAINWINDOW.setTitle("ClaudeTest");
        
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        BOXME = new ChoiceBox();
        BOXME.setPrefWidth(500);
        BOXME.setPrefHeight(40);
        
        BOXME2 = new ComboBox();
        BOXME2.setPrefWidth(500);
        BOXME2.setPrefHeight(40);
        BOXME2.setPromptText("Pick up the item");
        
        BOXOPTIONS = new HBox();
        OPTIONS = new MenuFiller("test/menus.txt",MAINWINDOW);
        OPTIONS.BoxFiller("test/menus.txt",BOXME);
        BOXOPTIONS.getChildren().add(OPTIONS.getMenuBar());
        OPTIONS.BoxFiller2("test/Headshots2.txt",BOXME2);
        
        IVIMG = new ImageView();
        IVIMG.setImage(null);
        IVIMG.setFitWidth(75);
        IVIMG.setFitHeight(100);
        IVIMG.setPreserveRatio(true);
        IVIMG.setSmooth(true);
        IVIMG.setCache(true);
        
        IMGBOX = new VBox(20);
        IMGBOX.getChildren().addAll(IVIMG);
        RADIOBOX = new VBox(10);
        
        RIGHTBOX = new HBox(10);
        RIGHTBOX.setPadding(new Insets(70,200,0,0));
        RIGHTBOX.getChildren().addAll(IMGBOX,RADIOBOX);
        
        DING = new RadioButtonFiller();
        DING.RadioMe(RADIOBOX,IVIMG);
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(BOXOPTIONS);
        PANE.setLeft(BOXME);
        PANE.setRight(BOXME2);
        PANE.setBottom(RIGHTBOX);
        
        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    
    public Scene getScreen(){
        return ENTRANCE3;
    }
}
