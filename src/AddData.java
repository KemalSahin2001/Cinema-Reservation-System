import java.io.FileWriter;
import java.io.IOException;

public class AddData {
    public static void AddUser(User user){
        try(FileWriter writer = new FileWriter("assets/data/backup.dat",true)){
            writer.write("user\t" + user.getUsername() + "\t" + user.getHashedPassword() + "\t" + user.getIsClubMember() + "\t" + user.getIsAdmin() + "\n");
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }
    public static void AddFilm(Film film){
        try(FileWriter writer = new FileWriter("assets/data/backup.dat",true)){
            writer.write("film\t" + film.getName() + "\t" + film.getTrailer_path() + "\t" + film.getDuration() + "\n");
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }
    public static void Update(){
        try (FileWriter writer = new FileWriter("sassets/data/backup.dat")){
            for(User usr : CinemaApp.users){
                AddData.AddUser(usr);
            }
            for(Film flm : CinemaApp.films){
                AddData.AddFilm(flm);
            }
            for(Hall hll : CinemaApp.halls){
                AddData.AddHall(hll);             
            }
            for(Seat st : CinemaApp.seats){
                AddData.AddSeat(st);               
            }
            }
        catch(Exception e){}
    }
    public static void AddHall(Hall hall){
        try(FileWriter writer = new FileWriter("assets/data/backup.dat",true)){
            writer.write("hall\t" + hall.getFilm().getName() + "\t" + hall.getHallname() + "\t"
            + hall.getPrice_per_seat() + "\t"+ hall.getRow() + "\t" + hall.getColumn()+"\n");
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }
    public static void AddSeat(Seat st){
        try(FileWriter writer = new FileWriter("assets/data/backup.dat",true)){
            writer.write("seat\t" + st.getFilmName() + "\t" 
            + st.getHallName() + "\t" + st.getRow_of_seat() + "\t" + st.getColumn_of_seat()+ "\t"+ st.getOwner_name()+  "\t"+
             st.getPrice_that_it_has_been_bought()+ "\n");
        }
        catch (Exception e){

        }
    }
}
