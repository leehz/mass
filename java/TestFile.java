import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class TestFile{
    public static void main(String[] args){
        File file = new File("/hz/mass/java/file.test");
        int b = 0;
        PrintStream ps = null;

        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
        ps = new PrintStream(new FileOutputStream(file));
        } catch (FileNotFoundException e ){ e.printStackTrace();}

        try{
            System.out.print(">> ");
            while((b = System.in.read()) != -1){
                //ps.append(Integer.toString(b).charAt(0));
                ps.write(b);
            }
        } catch(IOException e){ e.printStackTrace();}

        System.out.println("> " + file.getAbsolutePath());
    }
}
