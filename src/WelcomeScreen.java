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

public class WelcomeScreen {

    private static GridPane root;
    public static Scene scene;

    //for admin
    private static Button btn3 = new Button();              
    private static Button btn4 = new Button();
    private static Button btn5 = new Button();
    private static Text lbl2 = new Text("Select a film and then click OK to continue.");
    public static ComboBox<String> filmComboBox;

    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,602,348,Color.BLACK); 
        
        //Creating welcome massage
        Text lbl1 = new Text("Welcome " + CinemaApp.loggedInUser.getUsername() + "!");

        //Creating combobox
        filmComboBox = new ComboBox<>();
        for(Film film : CinemaApp.films){
            filmComboBox.getItems().add(film.getName());
        }

        //Setting promtText for combobox
        filmComboBox.setPromptText("Choose a film that you want to watch");

        //Creating buttons

         //For user
        Button btn1 = new Button();
        Button btn2 = new Button();

        //Setting texts for buttons    
        btn1.setText("OK");
        btn2.setText("LOG OUT");
        btn3.setText("Add Film");
        btn4.setText("Remove Film");
        btn5.setText("Edit Users");

       
        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,150, 25));

        lbl1.setTranslateX(130);
        lbl2.setTranslateX(45);

        filmComboBox.setTranslateX(43);
        filmComboBox.setTranslateY(7);

        btn1.setTranslateX(40);
        btn2.setTranslateX(-270);
        btn3.setTranslateX(210);
        btn4.setTranslateX(310);
        btn5.setTranslateX(260);

        btn1.setTranslateY(20);
        btn2.setTranslateY(20);
        btn3.setTranslateY(20);
        btn4.setTranslateY(20);
        btn5.setTranslateY(-15);

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
        btn3.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn4.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn5.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");

        filmComboBox.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        filmComboBox.setStyle("-fx-font-weight: bold;");

        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lbl2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        filmComboBox.getEditor().setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        btn3.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        btn4.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        btn5.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        
        btn1.setPrefWidth(60);

        //adding childs
        root.add(lbl1,0,0);
        root.add(lbl2,0,1);    

        root.add(filmComboBox,0,2);

        root.add(btn1,0,3);
        root.add(btn2,1,3);
        root.add(btn3,0,4);
        root.add(btn4,0,4);
        root.add(btn5,0,4);

        //setting not visible admin buttons for user

        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);

        //Adding root into scene
        scene.setRoot(root);

        //button func
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {            
                try {
                    //Setting the playing film
                    String inpt = filmComboBox.getSelectionModel().getSelectedItem().toString();
                    for(Film film : CinemaApp.films){
                        if(film.getName().equals(inpt)){
                            CinemaApp.playingFilm = film;
                        }
                    }  
                    //Setting up the scene
                    FilmPage.SetUpPage();
                    //Checking admin mode
                    FilmPage.AdminMode(CinemaApp.loggedInUser.getIsAdmin());
                    //Chancing scene
                    CinemaApp.Stage.setScene(FilmPage.scene); 
                } catch (Exception e) {
                }                        
            }   
                  
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Setting up the scene
                EditUsersPage.SetUpPage();
                //Chancing scene
                CinemaApp.Stage.setScene(EditUsersPage.scene);
                
            }
            
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Setting up the scene
                AddFilmPage.SetUpPage();
                //Chancing scene
                CinemaApp.Stage.setScene(AddFilmPage.scene);                
            }       
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                RemoveFilmPage.SetUpPage();
                CinemaApp.Stage.setScene(RemoveFilmPage.scene);
            }
            
        });      
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginPage.SetUpPage();
                CinemaApp.Stage.setScene(LoginPage.scene);
                filmComboBox.valueProperty().set(null);
            }           
        });
    }
    public static void AdminMode(boolean check){
        if(check){
            //admin can see edit buttons.
            btn3.setVisible(true);
            btn4.setVisible(true);
            btn5.setVisible(true);
            WelcomeScreen.lbl2.setText("You can either select film below or do edits.");
        }
        else{
            btn3.setVisible(false);
            btn3.setVisible(false);
            btn3.setVisible(false);
            WelcomeScreen.lbl2.setText("Select a film and then click OK to continue.");
        }
    }
    public static void UpdateCombobox(){
        filmComboBox.getItems().removeAll();
        for(Film film : CinemaApp.films){
            filmComboBox.getItems().add(film.getName());
        }
    }
}