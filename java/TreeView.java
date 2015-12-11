import java.io.File;


public class TreeView{
    static int levels = 0;
    static int fls = 0;
    static int dirs = 0 - 1;
    static boolean last = false;

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

        System.out.println(file.getName());
        index_file(file, levels);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print(" Files: " + fls + "\t");
        System.out.print(" Dirs: " + dirs + "\t");
        System.out.println(" Levels: " + levels);

    }


    public static int index_file(File file, int level){
        //System.out.print("\t");
        for(int i = 1; i < level; i++)
        System.out.print("│  ");
        //System.out.println("├──" + file.getName());
        if(file.isFile()){
            fls++;
            System.out.println("└──" + file.getName());
            return level;
        }
        if(file.isDirectory()){
            dirs++;
            File[] files = file.listFiles();
            if(level != 0){
                System.out.println("├──" + file.getName());
            }
            if(files.length > 0 && level >= levels){
                levels = level + 1;
            }

            for (int i = 0; i < files.length; i++){
                index_file(files[i], level + 1);
            }
        }
    return level;
    }
}

