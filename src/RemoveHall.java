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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
public class RemoveHall {
    //Root   
    private static VBox root;
    public static Scene scene;

    public static void SetUpPage(){
        //creating root
        root = new VBox();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,728,485,Color.BLACK); 

        //Creating labels
        Text lbl1 = new Text("Select the hall you want to remove from " + CinemaApp.playingFilm.getName());

        //Creating combobox
        ComboBox<String> halls = new ComboBox<>();

        //Adding items in combobox
        for(Hall hll: CinemaApp.halls){
            if(hll.getFilm().getName().equals(CinemaApp.playingFilm.getName())){
                halls.getItems().add(hll.getHallname());
            }
        }
        //Creating buttons
        Button btn1 = new Button("BACK");
        Button btn2 = new Button("OK");  

        //setting up the background
        Image img = new Image("assets/icons/red-chair-room-the-ranks-wallpaper-preview.jpg");
        BackgroundImage bimg = new BackgroundImage(img, BackgroundRepeat.ROUND,  
        BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);        
        root.setBackground(new Background(bimg));

        //Setting root style
        root.setStyle("-fx-font-weight:bold; -fx-font-size:20px; -fx-font-family: Verdana;");

        //Text effects        
        btn1.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn2.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        halls.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        lbl1.setFill(Paint.valueOf("ECDBBA"));

        //setting the padding
        root.setMargin(btn1, new Insets(5, 80, 10, 0));
        root.setMargin(btn2, new Insets(-49, 0, 0, 100));

        halls.setMaxWidth(200); 
        halls.setMaxWidth(200);

       

        root.getChildren().addAll(lbl1,halls,btn1,btn2);

        //Adding root into scene
        scene.setRoot(root);

        //Button func
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FilmPage.SetUpPage();
                FilmPage.AdminMode(true);
                CinemaApp.Stage.setScene(FilmPage.scene); 
            }
            
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    //delete hall
                    String deleted_hall = halls.getSelectionModel().getSelectedItem().toString();                   
                    Hall hll = new Hall();
                    for(Hall hall: CinemaApp.halls){
                        //finding hall
                        if(hall.getHallname().equals(deleted_hall)){
                            hll = hall;
                        }
                    }  

                    //film deleted
                    CinemaApp.halls.remove(hll);

                    //seats deleted                
                    Seat tempSeat = new Seat();
                    Integer seatSize = CinemaApp.seats.size();
                    for(int i = 0; i < seatSize; i++){
                        for(Seat seat: CinemaApp.seats){
                            if(seat.getHallName().equals(hll.getHallname())){
                                tempSeat = seat;
                            }                                     
                        }
                        try {CinemaApp.seats.remove(tempSeat);} 
                        catch (Exception e) {}              
                    }
                    
                    RemoveHall.SetUpPage(); 
                    CinemaApp.Stage.setScene(RemoveHall.scene);              
                    CinemaApp.success.play();
                } catch (Exception e) {
                    CinemaApp.buzzer.play();
                }
                
            }
            
        });
    }
}
