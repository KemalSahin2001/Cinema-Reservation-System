import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class AddHall {
    private static GridPane root;
    public static Scene scene;

    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,728,485,Color.BLACK); 

        //Creating labels
        Text lbl1 = new Text(CinemaApp.playingFilm.toString());
        Text lbl2 = new Text("Row:");
        Text lbl3 = new Text("Column:");
        Text lbl4 = new Text("Name:");
        Text lbl5 = new Text("Price:");
        Text warning = new Text();

        //Creating text field for name, duration and path
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        TextField priceInput = new TextField();
        priceInput.setPromptText("price");

        //Creating buttons
        Button btn1 = new Button("BACK");
        Button btn2 = new Button("OK");     
       
        //Creating comboboxes
        ComboBox<Integer> rows = new ComboBox<>();
        ComboBox<Integer> columns = new ComboBox<>();

        //Adding items in comboboxes
        for(int i = 3; i < 11; i++){
            rows.getItems().add(i);
            columns.getItems().add(i);
        }

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
        rows.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        columns.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        nameInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        priceInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        lbl1.setFill(Paint.valueOf("ECDBBA"));
        lbl2.setFill(Paint.valueOf("ECDBBA"));
        lbl3.setFill(Paint.valueOf("ECDBBA"));
        lbl4.setFill(Paint.valueOf("ECDBBA"));
        lbl5.setFill(Paint.valueOf("ECDBBA"));
        warning.setFill(Paint.valueOf("ECDBBA"));

        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,10, 233));

        lbl1.setTranslateX(-125);
        warning.setTranslateX(-155);

        nameInput.setMaxWidth(150);
        priceInput.setMaxWidth(150);

        rows.setMaxWidth(150);
        columns.setMaxWidth(150);

        //adding childs
        root.add(lbl1,1,0);
        root.add(lbl2,0,1);
        root.add(lbl3,0,2);
        root.add(lbl4,0,3);
        root.add(lbl5,0,4);
        root.add(priceInput,1,4);
        root.add(nameInput,1,3);
        root.add(btn1,0,5);
        root.add(btn2,1,5);
        root.add(warning,1,6);
        root.add(rows,1,1);
        root.add(columns,1,2);

        //Adding root into scene
        scene.setRoot(root);

        //button func
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    if(nameInput.getText().equals("")){
                        warning.setText("ERROR: Name could not be empty!");
                        CinemaApp.buzzer.play();                       
                    }
                    else if(priceInput.getText().equals("")){
                        warning.setText("ERROR: Price could not be empty!");
                        CinemaApp.buzzer.play(); 
                    }
                    else{
                        
                        //Creating variables
                        Integer row = rows.getSelectionModel().getSelectedItem();
                        Integer column = columns.getSelectionModel().getSelectedItem();
                        String name = nameInput.getText();
                        Integer price = Integer.parseInt(priceInput.getText());
                        for(Film flm : CinemaApp.films){
                            if(flm.getName().equals(name)){
                                warning.setText("ERROR: Hall name cannot be same!");
                                CinemaApp.buzzer.play();
                                return;
                            }
                        }
                        Hall newHall = new Hall(CinemaApp.playingFilm, name, price, row, column);
                        CinemaApp.halls.add(newHall);
                        for(int i = 1; i <= row; i++){
                            for(int j = 1; j <= column; j++){
                                Seat newSeat = new Seat(CinemaApp.playingFilm.getName(), name, i, j, null, 0);
                                CinemaApp.seats.add(newSeat);                               
                                newHall.getSeats().add(newSeat);

                            }
                        }
                        CinemaApp.success.play();
                        warning.setText("SUCCESS: Hall successfully created!");
                    }
                } catch (Exception e) {
                    CinemaApp.buzzer.play();
                }
                
            }
            
        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FilmPage.SetUpPage();
                FilmPage.AdminMode(true);
                CinemaApp.Stage.setScene(FilmPage.scene);                
            }
            
        });
    }
}
