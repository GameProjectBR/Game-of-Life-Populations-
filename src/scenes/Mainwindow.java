package Scenes;
import Controllers.RecordMe;
import Controllers.Sesame;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Mainwindow {
    Button LIBUTTON, SUBUTTON, EXIT;
    Image IMAGE;
    BackgroundImage BACKGROUNDIMAGE;
    Text TITLE1,TITLE2,TITLE3;
    TextField EXAMPLENAME,EXAMPLEMAIL,EXAMPLECONFIRMMAIL;
    PasswordField EXPASS;
    Label USERNAME, PASSWORD, EMAIL;
    String USER;
    HBox TOP,BOTTOM;
    VBox MID,TEST;
    BorderPane PANE;
    Scene ENTRY;

    Sesame HEYHO,HEYHO2;
    MyNewClass HOME;
    RecordMe SIGNUP;
    
    public Mainwindow(Stage MAINWINDOW) {
        IMAGE = new Image("background.png");
        BACKGROUNDIMAGE = new BackgroundImage(IMAGE,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        MAINWINDOW.setTitle("Login");
        
        TITLE1 = new Text();
        TITLE1.setText("Login");
        TITLE1.setId("mytitle");
        TITLE1.setEffect(new GaussianBlur());

        
        TITLE2 = new Text();
        TITLE2.setText("Login");
        TITLE2.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        USERNAME = new Label("Username:");
        USERNAME.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        USERNAME.setMaxWidth(400);
        USERNAME.setMaxHeight(400);
        USERNAME.setTextFill(Color.BLACK);
        
        EXAMPLENAME = new TextField();
        EXAMPLENAME.setMaxWidth(400);
        EXAMPLENAME.setPrefHeight(40);
        EXAMPLENAME.setPromptText("Your Username");
        
        EMAIL = new Label("Email:");
        EMAIL.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        EMAIL.setMaxWidth(400);
        EMAIL.setMaxHeight(400);
        EMAIL.setTextFill(Color.BLACK);
        
        EXAMPLEMAIL = new TextField();
        EXAMPLEMAIL.setMaxWidth(400);
        EXAMPLEMAIL.setPrefHeight(40);
        EXAMPLEMAIL.setPromptText("E-Mail");
        
        EXAMPLECONFIRMMAIL = new TextField();
        EXAMPLECONFIRMMAIL.setMaxWidth(400);
        EXAMPLECONFIRMMAIL.setPrefHeight(40);
        EXAMPLECONFIRMMAIL.setPromptText("Confirm E-Mail");
        
        
        PASSWORD = new Label("Password: ");
        PASSWORD.setFont(Font.font("arial",FontWeight.BOLD, FontPosture.REGULAR, 20));
        PASSWORD.setMaxWidth(400);
        PASSWORD.setMaxHeight(400);
        PASSWORD.setTextFill(Color.BLACK);
        
        EXPASS = new PasswordField();
        EXPASS.setMaxWidth(400);
        EXPASS.setPrefHeight(40);
        EXPASS.setPromptText("Your Password");
    
        LIBUTTON = new Button("Sign In");
        LIBUTTON.setOnAction(e->{
            try{
                HEYHO = new Sesame();
                if (HEYHO.sesame(MAINWINDOW,EXAMPLENAME,EXPASS)) {
                    USER = EXAMPLENAME.getText();
                    EXAMPLENAME.clear();
                    EXPASS.clear();
                    HOME = new MyNewClass(MAINWINDOW);
                    MAINWINDOW.setScene(HOME.getScreen());
                }
            } catch (IOException ex){
                System.out.println("Not so Spicy Error.");
            }
        });
        
        SUBUTTON = new Button("Sign Up");
        SUBUTTON.setOnAction(e->{
            MAINWINDOW.setTitle("");
            MID.getChildren().addAll(EMAIL,EXAMPLEMAIL,EXAMPLECONFIRMMAIL);
            SUBUTTON.setOnAction(f->{
                try{
                    if (EXAMPLEMAIL.getText().equals(EXAMPLECONFIRMMAIL.getText())){
                        SIGNUP = new RecordMe();
                        SIGNUP.NewMe(EXAMPLENAME.getText(),EXPASS.getText(),EXAMPLEMAIL.getText());
                        HOME = new MyNewClass(MAINWINDOW);
                        MAINWINDOW.setScene(HOME.getScreen());
                    }else{
                        HEYHO2 = new Sesame();
                        HEYHO2.IsNoGood(true);
                    }
                }catch (IOException ex){
                    System.out.println("Not so Spicy Error.");
            }
            });
        });
        
        EXIT = new Button("Exit");
        EXIT.setOnAction(e->{
           MAINWINDOW.close(); 
        });

        TOP = new HBox();
        TOP.getChildren().add(TITLE1);
        TOP.setPadding(new Insets(0,0,0,0));
        TOP.setAlignment(Pos.TOP_CENTER);
        
        BOTTOM = new HBox(20);
        BOTTOM.getChildren().addAll(LIBUTTON,SUBUTTON,EXIT);
        BOTTOM.setPadding(new Insets(0,0,0,0));
        BOTTOM.setAlignment(Pos.CENTER);
        
        TEST = new VBox(20);
        TEST.getChildren().addAll(BOTTOM);
        TEST.setAlignment(Pos.CENTER);
        TEST.setPadding(new Insets(0,0,100,0));
        
        MID = new VBox(10);
        MID.getChildren().addAll(TITLE2,USERNAME,EXAMPLENAME,PASSWORD,EXPASS);
        MID.setAlignment(Pos.CENTER);
        MID.setPadding(new Insets(0,0,0,0));
        
        PANE = new BorderPane();
        PANE.setTop(TOP);
        PANE.setCenter(MID);
        PANE.setBottom(TEST);
        PANE.setBackground(new Background(BACKGROUNDIMAGE));
        
        ENTRY = new Scene(PANE,800,1400,Color.AQUA);
        ENTRY.getStylesheets().add("Decor.css");
    }
    public Text getTITLE(){
        return TITLE1;
    }
    public Scene getScreen(){
        return ENTRY;
    }
}
