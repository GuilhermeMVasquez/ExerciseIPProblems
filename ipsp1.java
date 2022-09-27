import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ipsp1 {
    public static void main(String[]args){
        String[] list = new String[945];
        try {
            File myObj = new File("ips.txt");
            Scanner myReader = new Scanner(myObj);
            for (int index = 0; index < list.length; index++) {
                String data = myReader.nextLine();
                list[index] = data;
            }
            myReader.close();
        } 
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] start = new String[945];
        String[] end = new String[945];
        for(int i = 0; i < list.length; i++){
            String placeholder = list[i];
            String[] range = placeholder.split("-");
            start[i] = range[0];
            end[i] = range[1];
        }
        for(int j = 0; j < start.length; j++){
            for(int h = j + 1; h < start.length; h++){
                String aux;
                if(Long.parseLong(start[j]) > Long.parseLong(start[h])){
                    aux = start[j];
                    start[j] = start[h];
                    start[h] = aux;
                }
            }
        }
        for(int k = 0; k < end.length; k++){
            for(int u = k + 1; u < end.length; u++){
                String aux2;
                if(Long.parseLong(end[k]) > Long.parseLong(end[u])){
                    aux2 = end[k];
                    end[k] = end[u];
                    end[u] = aux2;
                }
            }
        }
        for(int p = 0; p < end.length; p++){
            long possible = 1+Long.parseLong(end[p]);
            for(int o = 0; o < start.length; o++){
                if(Long.parseLong(start[o])-1 == possible){
                    System.out.println(Long.parseLong(start[o])-1);
                    System.exit(0);
                }
            }
        }
    }
}
