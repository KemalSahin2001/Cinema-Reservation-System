import java.io.File;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class FilmPage {
    //Root   
    private static GridPane root;
    public static Scene scene;

    //Static buttons
    private static Button addHallButton = new Button("Add Hall");
    private static Button removeHallButton = new Button("Remove Hall");
    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        //Setting up the scene
        scene = new Scene(root,1000,1000,Color.BLACK);

        //Labels
        Text lbl1 = new Text(CinemaApp.playingFilm.toString());
        lbl1.setFill(Color.WHITE);

        //Media
        MediaPlayer film = new MediaPlayer(new Media(new File("assets/trailers/" + CinemaApp.playingFilm.getTrailer_path()).toURI().toString()));
        MediaView mv = new MediaView();
        mv.setFitHeight(800);
        mv.setFitWidth(800);
        mv.setMediaPlayer(film);
        film.setVolume(0.5);

        //Combobox
        ComboBox<String> hallCombobox = new ComboBox<>();
        for(Hall hll : CinemaApp.halls){
            if(hll.getFilm().getName().equals(CinemaApp.playingFilm.getName())){
                hallCombobox.getItems().add(hll.getHallname());
            }
        }
        hallCombobox.setMinWidth(220);
        hallCombobox.setMaxWidth(220);
        hallCombobox.getStyleClass().add("center-aligned");

        //Buttons
        Button resumeButton = new Button();
        Button stopButton = new Button();
        stopButton.setVisible(false);
        Button forwardButton = new Button();
        Button backwardButton = new Button();
        Button goStartButton = new Button();
        Button backButton = new Button("BACK");
        Button okButton = new Button("OK"); 

        //Slider
        Slider volumeSlider = new Slider();
        volumeSlider.setValue(film.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                film.setVolume(volumeSlider.getValue() / 100);           
            }       
        });
        
        //Button images
        Image imgbtn1 = new Image("assets/icons/icons8-play-48.png");
        ImageView viewbtn1 = new ImageView(imgbtn1);
        viewbtn1.setFitHeight(50);
        viewbtn1.setPreserveRatio(true);

        Image imgbtn2 = new Image("assets/icons/icons8-pause-48.png");
        ImageView viewbtn2 = new ImageView(imgbtn2);
        viewbtn2.setFitHeight(50);
        viewbtn2.setPreserveRatio(true);
        
        Image imgbtn3 = new Image("assets/icons/icons8-double-left-48.png");
        ImageView viewbtn3 = new ImageView(imgbtn3);
        viewbtn3.setFitHeight(50);
        viewbtn3.setPreserveRatio(true);
        
        Image imgbtn4 = new Image("assets/icons/icons8-double-right-48 (1).png");
        ImageView viewbtn4 = new ImageView(imgbtn4);
        viewbtn4.setFitHeight(50);
        viewbtn4.setPreserveRatio(true);

        Image imgbtn5 = new Image("assets/icons/icons8-skip-to-start-48.png");
        ImageView viewbtn5 = new ImageView(imgbtn5);
        viewbtn5.setFitHeight(50);
        viewbtn5.setPreserveRatio(true);

        //Setting images
        resumeButton.setGraphic(viewbtn1);
        stopButton.setGraphic(viewbtn2);
        backwardButton.setGraphic(viewbtn3);
        forwardButton.setGraphic(viewbtn4);
        goStartButton.setGraphic(viewbtn5);
        
        //setting up the background
        Image img = new Image("assets/icons/cinema-screen-and-red-seats-background-vector-5031665.jpg");
        BackgroundImage bimg = new BackgroundImage(img, BackgroundRepeat.ROUND,  
        BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);        
        root.setBackground(new Background(bimg));

        //Text effects        
        resumeButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        stopButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        forwardButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        backwardButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        goStartButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        backButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        addHallButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        removeHallButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        okButton.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        volumeSlider.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        
        //Styling root
        root.setStyle("-fx-font-weight:bold; -fx-font-size:20px; -fx-font-family: Verdana;");

        //Setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 20,123, 10));

        volumeSlider.setRotate(-90);
        volumeSlider.setMaxWidth(150);
        volumeSlider.setTranslateX(768);
        volumeSlider.setTranslateY(-175);

        resumeButton.setTranslateY(-150);
        resumeButton.setTranslateX(-2);

        stopButton.setTranslateY(-150);
        stopButton.setTranslateX(-2);

        lbl1.setTranslateY(-260);
        lbl1.setTranslateX(80);

        forwardButton.setTranslateY(-345);
        forwardButton.setTranslateX(-2);

        backwardButton.setTranslateY(-345);
        backwardButton.setTranslateX(-2);

        goStartButton.setTranslateY(-345);
        goStartButton.setTranslateX(-2);

        hallCombobox.setTranslateX(110);
        okButton.setTranslateX(350);

        addHallButton.setTranslateX(580);
        removeHallButton.setTranslateX(725);

        root.add(lbl1,0,0);
        root.add(resumeButton,1,0);
        root.add(stopButton,1,0);
        root.add(forwardButton,1,1);
        root.add(backwardButton,1,2);
        root.add(goStartButton,1,3);
        root.add(mv,0,0);
        root.add(volumeSlider,0,2);
        root.add(backButton,0,1);
        root.add(okButton,0,1);
        root.add(removeHallButton,0,1);
        root.add(addHallButton,0,1);
        root.add(hallCombobox,0,1);

        
        //button func
        removeHallButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                RemoveHall.SetUpPage();
                CinemaApp.Stage.setScene(RemoveHall.scene);
            }
            
        });
        addHallButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                AddHall.SetUpPage();
                CinemaApp.Stage.setScene(AddHall.scene);            
                film.stop();    
            }           
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WelcomeScreen.SetUpPage();
                WelcomeScreen.AdminMode(CinemaApp.loggedInUser.getIsAdmin());
                CinemaApp.Stage.setScene(WelcomeScreen.scene);
                film.stop();
            }        
        });

        resumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film.play();
                stopButton.setVisible(true);
                resumeButton.setVisible(false);
            }    
        });
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film.pause();
                stopButton.setVisible(false);
                resumeButton.setVisible(true);
            }  
        });
        forwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film.seek(film.getCurrentTime().add(Duration.seconds(5)));             
            }          
        });
        backwardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film.seek(film.getCurrentTime().add(Duration.seconds(-5)));             
            }          
        });
        goStartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film.stop();      
                film.play();      
            }          
        });
        okButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    String inpt = hallCombobox.getSelectionModel().getSelectedItem().toString();
                    for(Hall hll : CinemaApp.halls){
                        if(hll.getHallname().equals(inpt)){
                            HallPage.SetUpPage(hll);
                        }
                    }
                    HallPage.AdminMode(CinemaApp.loggedInUser.getIsAdmin());
                    CinemaApp.Stage.setScene(HallPage.scene);
                    film.stop();
                } catch (Exception e) {
                    //TODO: handle exception
                }
               
            }
            
        });
    }
    public static void AdminMode(boolean check){
        if(check){
            //admin can see edit buttons.
            removeHallButton.setVisible(true);
            addHallButton.setVisible(true);
        }
        else{
            removeHallButton.setVisible(false);
            addHallButton.setVisible(false);
        }
    }
}
