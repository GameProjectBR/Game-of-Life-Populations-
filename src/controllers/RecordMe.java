package Controllers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RecordMe {
    RandomAccessFile WRITER;
    PrintWriter PRINTER;
    String READER;
 
    public RecordMe(){
        
    }
    
    public void RecordMe(String DATA, long position) throws IOException{
        WRITER = new RandomAccessFile("test/users2.txt", "rw");
        WRITER.write(DATA.getBytes("HELLO"),CountMe("test/users2.txt")-2,5);
        System.out.println("Updated Login Details Saved");
        WRITER.close();
    }
    
    public int CountMe(String TEXTFILE) throws FileNotFoundException, IOException{
        return 0;
    }
    
    public void NewMe(String AN, String PS, String EMAIL) throws IOException{
        PRINTER = new PrintWriter(new FileWriter("test/users.txt",true));
        PRINTER.write(AN+","+PS+","+EMAIL+"\n");
        PRINTER.close();
    }

}
