package ia;

import Scenes.MyNewClass;
import Scenes.Mainwindow;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IA extends Application{
    Stage MAINWINDOW;
    Mainwindow MAINONE;
    MyNewClass MAINTWO;
    
    @Override
    public void start(Stage primaryStage)throws Exception {
        MAINWINDOW = primaryStage;
        
        MAINONE = new Mainwindow(MAINWINDOW);
        
        MAINWINDOW.setHeight(760);
        MAINWINDOW.setWidth(1280);
        MAINWINDOW.centerOnScreen();
        MAINWINDOW.setTitle("GAME MANAGEMENT |--> PORTAL"); 
        MAINWINDOW.getIcons().add(new Image("controller-logo.png"));        
        MAINWINDOW.setResizable(false);
       
// Display the main window called via class MainClickMe
        MAINWINDOW.setScene(MAINONE.getScreen());
        MAINWINDOW.show();
    }
    public static void main(String[] args) {
        launch(args);
    } 
}
