import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RemoveFilmPage {

    private static GridPane root;    
    public static Scene scene;

    public static ComboBox<String> filmComboBox = new ComboBox<>();

    public static void SetUpPage(){

        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,602,348,Color.BLACK); 

        //Creating massage
        Text lbl1 = new Text("Select the film that you want to remove then click OK.");

        //Creating combobox
        for(Film film : CinemaApp.films){
            filmComboBox.getItems().add(film.getName());
        }

        //Setting promtText for combobox
        filmComboBox.setPromptText("Choose a film that you want to delete");

        //Creating buttons
        Button btn1 = new Button();
        Button btn2 = new Button();

        //Setting texts for buttons    
        btn1.setText("BACK");
        btn2.setText("OK");

        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,150, 10));

        filmComboBox.setTranslateX(70);
        filmComboBox.setTranslateY(5);

        lbl1.setTranslateX(33);

        btn1.setTranslateX(170);
        btn2.setTranslateX(-200);

        btn1.setTranslateY(20);
        btn2.setTranslateY(20);

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

        filmComboBox.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        filmComboBox.setStyle("-fx-font-weight: bold;");

        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
     
        filmComboBox.getEditor().setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
        btn2.setPrefWidth(60);

        //adding childs
        root.add(lbl1,0,0);

        root.add(filmComboBox,0,1);

        root.add(btn1,0,2);
        root.add(btn2,1,2);

        //Adding root into scene
        scene.setRoot(root);
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                WelcomeScreen.SetUpPage();
                WelcomeScreen.AdminMode(true);               
                CinemaApp.Stage.setScene(WelcomeScreen.scene);
            }
            
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) { 
                try {
                    //delete film   
                    String deleted_film = filmComboBox.getSelectionModel().getSelectedItem().toString();                   
                    Film flm = new Film();
                    for(Film film: CinemaApp.films){
                        //finding film
                        if(film.getName().equals(deleted_film)){
                            flm = film;
                        }
                    }  

                    //film deleted
                    CinemaApp.films.remove(flm);

                    //halls deleted
                    Hall tempHall = new Hall();
                    Integer hallSize = CinemaApp.halls.size();
                    for(int i = 0; i < hallSize; i++){
                        for(Hall hll: CinemaApp.halls){
                            if(hll.getFilm().getName().equals(flm.getName())){
                                tempHall = hll;
                            }
                        }
                        try {
                            CinemaApp.halls.remove(tempHall);
                        } catch (Exception e) {} 
                    }               

                    //seats deleted                
                    Seat tempSeat = new Seat();
                    Integer seatSize = CinemaApp.seats.size();
                    for(int i = 0; i < seatSize; i++){
                        for(Seat seat: CinemaApp.seats){
                            if(seat.getFilmName().equals(flm.getName())){
                                tempSeat = seat;
                            }                                     
                        }
                        try {
                                CinemaApp.seats.remove(tempSeat);
                        } catch (Exception e) {}              
                    }
                                        
                    //film deleted from combobox
                    filmComboBox.getItems().remove(filmComboBox.getSelectionModel().getSelectedItem()); 

                    //music play    
                    CinemaApp.success.play(); 
                } catch (Exception e) {
                    
                }
                        
            }          
        });
    }
}
