package Controllers;

    import Modules.Item;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.LineNumberReader;
    import java.util.Scanner;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.scene.control.ChoiceBox;
    import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
    import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuFiller {
    Scanner READER;
    Integer POS, IN;
    String MINILINE, MEPIC;
    Image[] IMG;
    Item[] ITEM;
    MenuBar MYMENU;
    
    public MenuFiller(String FILEME,Stage MAINWINDOW) throws FileNotFoundException, IOException{
        READER = new Scanner(new File(FILEME));
    }

    MenuFiller() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void BoxFiller(String FILEME, ChoiceBox POWER) throws IOException{
        try{
            READER = new Scanner (new File(FILEME));
            while(READER.hasNextLine()){
                POWER.getItems().add(READER.nextLine());
            }
        }
        catch (IOException ex){
            System.out.println("ERROR");
        }
    }
    
    public void BoxFiller2(String FILEME, ComboBox BOXME2) throws IOException {
        ObservableList<Item> LISTM = Dico(FILEME);
        BOXME2.setItems(LISTM);
        BOXME2.setButtonCell(new ComboTop());
        BOXME2.setCellFactory(listView -> new ComboBottom());
    }
    
    public ObservableList<Item> Dico(String FILEME) throws IOException {
        Scanner READER;
        
        IN = 0;
        ITEM = new Item[FileMeasure(FILEME)];
        IMG = new Image[FileMeasure(FILEME)];
        for (int i = 0; i < FileMeasure(FILEME); i++) {
            MEPIC = "H"+Integer.toString(i)+".jpg";
            IMG[i] = new Image(MEPIC);
        }
        
        try {
            READER = new Scanner (new File(FILEME));
            while (READER.hasNextLine()) {
                MINILINE = READER.nextLine();
                ITEM[IN] = new Item(MINILINE,IMG[IN]);
                IN = IN + 1;
            }
        }
        catch (IOException ex) {
            System.out.println("error");
        }
        ObservableList<Item> LISTM = FXCollections.observableArrayList(ITEM);
        return LISTM;
    }
    
    public Integer FileMeasure(String FILEME) throws FileNotFoundException, IOException{
        LineNumberReader LNR;
        FileReader FIREADER;
        
        POS = 0;
        FIREADER = new FileReader(FILEME);
        LNR = new LineNumberReader(FIREADER);
        while (LNR.readLine() != null){
            POS++;
        }
        LNR.close();
        return POS;
    }

    public void BoxFiller3(String testmaterialstxt, ComboBox boxme2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MenuBar getMenuBar(){
        return MYMENU;
    }
}
