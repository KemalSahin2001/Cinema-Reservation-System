import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;

public class DataRead {
    public static void ReadData(){
        try(Scanner reader = new Scanner(new BufferedReader(new FileReader("assets/data/backup.dat")))){
            while(reader.hasNext()){
                String[] line = reader.nextLine().split("\t");
                switch (line[0]) {
                    case "user":
                        CinemaApp.users.add(new User(line[1], line[2], line[3].startsWith("t"), line[4].startsWith("t")));
                        break;
                    case "film":
                        CinemaApp.films.add(new Film(line[1], line[2],line[3]));
                        break;
                    case "hall":
                        for (Film film : CinemaApp.films) {
                            if(film.getName().equals(line[1])){
                                CinemaApp.halls.add(new Hall(film, line[2],Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5])));
                            }
                        }                        
                        break;
                    case "seat":   
                        Seat seat = new Seat(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), line[5],Double.parseDouble(line[6]));                    
                        CinemaApp.seats.add(seat);
                        for (Hall hall : CinemaApp.halls) {
                            if(hall.getHallname().equals(line[2])){                                
                                hall.getSeats().add(seat);                                                         
                            }
                        }                       
                    default:
                        break;                    
                }
                Properties prop = new Properties();
                try {
                    //load a properties file from class path, inside static method
                    prop.load(App.class.getClassLoader().getResourceAsStream("assets/data/properties.dat"));

                    LoginPage.maxCount = Integer.parseInt(prop.getProperty("maximum-error-without-getting-blocked"));
                    CinemaApp.Stage.setTitle(prop.getProperty("title"));   
                    CinemaApp.discount = Integer.parseInt(prop.getProperty("discount-percentage"));
                    LoginPage.blockTime = Integer.parseInt(prop.getProperty("block-time"));
                    
                } 
                catch (IOException ex) {
                    ex.printStackTrace();                  
                }
            }            
        }
        catch (IOException e){
            System.out.println("file not found");
            try {
                FileWriter writer = new FileWriter("assets/data/backup.dat");
                try {
                    byte[] md5Digest = MessageDigest.getInstance( "MD5" ).digest("password".getBytes(StandardCharsets.UTF_8));
                    String password = Base64.getEncoder().encodeToString(md5Digest);
                    CinemaApp.users.add(new User("admin", password, true, true));
                } catch (NoSuchAlgorithmException q) {}               
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
