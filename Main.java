import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("products.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String [] products;
            while((line=br.readLine())!=null){
                products = line.split(",");
                if(isNumber(products[1])){
                    double price = Double.parseDouble(products[1]);
                    if(price>1000){
                        FileWriter fw = new FileWriter("new.csv", true);
                        fw.write(products[0]+","+products[1]+"\n");
                        System.out.println("Written Succesful");
                        fw.close();
                    }

                }
            }
            File f = new File("new.csv");
            System.out.println("Is the New file Exists : "+f.exists());
            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static boolean isNumber(String s){
        if(s.isEmpty())
            return false;
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
