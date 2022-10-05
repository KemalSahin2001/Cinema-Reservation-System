import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class AddFilmPage {

    private static GridPane root;
    public static Scene scene;

    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,602,348,Color.BLACK); 

        //Creating welcome massage
        Text lbl1 = new Text("Give name, relative path and the duration.");

        //Creating labels for name, duration and path
        Text namelbl = new Text("Name:");
        Text trailerPATHlbl = new Text("Trailer (Path):");
        Text durationlbl = new Text("Duration (m):");

        //Creating warning massage
        Text warning = new Text();

        //Creating text field for name, duration and path
        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");
        TextField trailerPATHInput = new TextField();
        trailerPATHInput.setPromptText("Trailer (Path)");
        TextField durationInput = new TextField();
        durationInput.setPromptText("Duration (m)");

        //Creating buttons
        Button btn1 = new Button("BACK");
        Button btn2 = new Button("OK");

        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,150, 25));

        nameInput.setMaxWidth(150);
        trailerPATHInput.setMaxWidth(150);
        durationInput.setMaxWidth(150);

        lbl1.setTranslateX(-80);

        warning.setTranslateX(-55);
        warning.setTranslateY(5);

        namelbl.setTranslateX(85);
        trailerPATHlbl.setTranslateX(85);
        durationlbl.setTranslateX(85);

        nameInput.setTranslateX(85);
        trailerPATHInput.setTranslateX(85);
        durationInput.setTranslateX(85);

        btn1.setTranslateX(240);
        btn2.setTranslateX(190);

        btn1.setTranslateY(5);
        btn2.setTranslateY(5);

        //setting up the background
        Image img = new Image("assets/icons/main-qimg-aea2b3d787a0ef1b541c188b2ef98ae7-lq.jpg");
        BackgroundImage bimg = new BackgroundImage(img, BackgroundRepeat.ROUND,  
        BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);        
        root.setBackground(new Background(bimg));

         //Text effects        
        btn1.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn2.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        nameInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        trailerPATHInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        durationInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");

        root.setStyle("-fx-font-weight:bold; -fx-font-size:15px; -fx-font-family: Verdana;");

        //adding childs
        root.add(lbl1,1,0);
        root.add(namelbl,0,1);
        root.add(trailerPATHlbl,0,2);
        root.add(durationlbl,0,3);
        root.add(nameInput,1,1);
        root.add(trailerPATHInput,1,2);
        root.add(durationInput,1,3);
        root.add(btn1,0,4);
        root.add(btn2,1,4);
        root.add(warning,1,5);

        //Adding root into scene
        scene.setRoot(root);

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Setting up Welcome Screen
                WelcomeScreen.SetUpPage();

                //Admin mode ON
                WelcomeScreen.AdminMode(true);  
                
                //Changing the scene
                CinemaApp.Stage.setScene(WelcomeScreen.scene);             
            }
            
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Creating variables
                String filmName = nameInput.getText().toString();
                String trailerPATH = trailerPATHInput.getText().toString();
                String duration = durationInput.getText().toString();

                //Controlling is there any input blank
                if(filmName.equals("")){
                    warning.setText("ERROR: Film name cannot be empty!");
                    CinemaApp.buzzer.play();
                }
                else if(trailerPATH.equals("")){
                    warning.setText("ERROR: Trailer path cannot be empty!");
                    CinemaApp.buzzer.play();
                }
                else if(duration.equals("")){
                    warning.setText("ERROR: Duration cannot be empty!");
                    CinemaApp.buzzer.play();
                }             
                else{
                    for(Film flm : CinemaApp.films){
                        if(flm.getName().equals(filmName)){
                            warning.setText("ERROR: Film name cannot be same!");
                            CinemaApp.buzzer.play();
                            return;
                        }
                    }
                    try{
                        //Controling is duration positive integer
                        if(Integer.parseInt(duration) <= 0){
                            warning.setText("ERROR: Duration has to be positive integer!");
                            CinemaApp.buzzer.play();
                            return;
                        }                 
                    } catch (Exception e) {
                        warning.setText("ERROR: Duration has to be positive integer!");
                        CinemaApp.buzzer.play();
                        return;
                    }
                    //Controling is file exists
                    File path = new File("assets/trailers/" + trailerPATH); 
                    if(!path.exists()){
                        warning.setText("ERROR: There is no such trailer!");
                        CinemaApp.buzzer.play();
                    }
                    else{
                        //Adding film
                        Film film = new Film(filmName,trailerPATH,duration);                       
                        CinemaApp.films.add(film);
                        AddData.AddFilm(film);
                        warning.setText("SUCCESS: Film added successfully!");
                        CinemaApp.success.play();
                    }
                }
            }
            
        });









    }

}
