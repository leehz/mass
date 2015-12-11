import java.io.File;


public class TreeView{
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Usage: TreeView [Dir] " + args.length + args[0]);
            System.out.println(" @CopyRight 2015 Hz Lee");
            return;
        }

        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("Error: no Such Directory.");
            return;
        }

        System.out.println(file.getName() +" ");
        index_file(file);

    }


    public static int index_file(File file){
        int rtn = 0;
        if(file.isFile()){
            System.out.println("\t|" + file.getName());
            return rtn;
        }
        if(file.isDirectory()){
            File[] files = file.listFiles();
            int i = 0;
            for (; i < files.length; i++){
                index_file(files[i]);
            }
            return i;
        }
        return -1;
    }
}

