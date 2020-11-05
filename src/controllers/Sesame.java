package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Sesame {
    Text TEXT1;
    VBox LAYOUT1, LAYOUT2;
    Scene SCENEE;
    Image BACKGROUND, IMG;
    BackgroundImage BACKGROUNDIMG;
    Button BUTTON1;
    boolean PERMIT, TIC;
    
    UserController TESTUSER;
    
    public boolean sesame(Stage MAINWINDOW, TextField LOGIN, PasswordField PASSWORD) throws IOException{
        PERMIT = false;
        try{
            TESTUSER = new UserController();
            if (TESTUSER.readUser(LOGIN.getText(), PASSWORD.getText())) {
                MAINWINDOW.setTitle("Signed In");
                PERMIT = true;
            }
            else{
                TIC = false;
                IsNoGood(TIC);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Not so spicy Error.");
        }    
        return PERMIT;
    }
    
    public void IsNoGood(Boolean TIC){
                Stage MINIWINDOW = new Stage();
                MINIWINDOW.getIcons().add(new Image("controller-logo.png"));
                IMG = new Image("background.png");
                BACKGROUNDIMG = new BackgroundImage(IMG,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
                    
                MINIWINDOW.initModality(Modality.APPLICATION_MODAL);
                MINIWINDOW.setMinWidth(250);
                MINIWINDOW.setMinHeight(250);
                
                TEXT1 = new Text();
                if (!TIC){
                    TEXT1.setText("Username/Password wrong or blank.");
                }else{
                    TEXT1.setText("Emails do not match");
                }
                
                BUTTON1 = new Button("Close");
                BUTTON1.setOnAction(e->{
                    MINIWINDOW.close();
                });
                
                LAYOUT1 = new VBox(30);
                LAYOUT1.getChildren().addAll(TEXT1, BUTTON1);
                LAYOUT1.setAlignment(Pos.CENTER);
                LAYOUT1.setBackground(new Background(BACKGROUNDIMG));
                
                SCENEE = new Scene(LAYOUT1);
                SCENEE.getStylesheets().add("Decor.css");
                MINIWINDOW.setScene(SCENEE);
                MINIWINDOW.showAndWait();
    }
     
}
