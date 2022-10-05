import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class CinemaApp extends Application{

    public static ArrayList<Film> films = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Hall> halls = new ArrayList<>();
    public static ArrayList<Seat> seats = new ArrayList<>();
    public static Film playingFilm;
    public static AudioClip buzzer;
    public static AudioClip success;
    public static User loggedInUser;
    public static Stage Stage;
    public static Integer discount;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //creating sounds
        buzzer = new AudioClip(getClass().getResource("assets/effects/Computer Error sound effect.mp3").toExternalForm());
        success = new AudioClip(getClass().getResource("assets/effects/Apple Pay Success Sound Effect.mp3").toExternalForm());

        CinemaApp.Stage = primaryStage;

        //Adding data
        DataRead.ReadData();

        //adjust voices
        buzzer.setVolume(0.1);
        hi.setVolume(0.1);   

        //setting up GUI
        LoginPage.SetUpPage();
        primaryStage.setScene(LoginPage.scene);
        primaryStage.setResizable(false);

        //Setting image
        primaryStage.getIcons().add(new Image("assets/icons/logo.png")); 
        
        //Show
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            AddData.Update();
        });
    }
}
