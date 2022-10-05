import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HallPage {
    private static VBox root;
    public static Scene scene;
    //Selected seat
    private static Seat selectedSeat = new Seat();
    private static User selectedUser = new User();

    //Combobox
    private static ComboBox<User> userComboBox;

    public static void SetUpPage(Hall hall){
        root = new VBox();
        scene = new Scene(root,1000,1000);

        //setting the padding
        root.setPadding(new Insets(100, 10,10, 10));

        //Setting root style
        root.setStyle("-fx-font-weight:bold; -fx-font-size:20px; -fx-font-family: Verdana;");   
        root.setAlignment(Pos.TOP_CENTER);

        
        //Creating massage       
        Text lbl1 = new Text(CinemaApp.playingFilm.toString() + " Hall: " +  hall.getHallname());
        lbl1.setFill(Paint.valueOf("ECDBBA"));
        lbl1.setTranslateY(-70);
        
        Text lbl2 = new Text();
        lbl2.setFill(Paint.valueOf("ECDBBA"));
        lbl2.setTranslateY(-30);

        Text lbl3 = new Text();
        lbl3.setFill(Paint.valueOf("ECDBBA"));
        lbl3.setTranslateY(-20);
        
        //Creating combobox
        userComboBox = new ComboBox<>();
        for(User usr : CinemaApp.users){
            userComboBox.getItems().add(usr);
        }     
        userComboBox.getSelectionModel().selectFirst();
          
        userComboBox.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        userComboBox.setTranslateY(-40);
        
        //back button
        Button Backbtn = new Button("BACK");
        Backbtn.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        Backbtn.setTranslateX(-450);
        Backbtn.setTranslateY(-50);
        
        //setting up the background
        Image img = new Image("assets/icons/cinema-seats-seamless-background-vector-5457039.jpg");
        BackgroundImage bimg = new BackgroundImage(img, BackgroundRepeat.ROUND,  
        BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);        
        root.setBackground(new Background(bimg));
       
        //Creating seat buttons
        HBox seats = new HBox();
        seats.setTranslateY(-50);
        seats.setAlignment(Pos.CENTER);
        for(int i = 0; i < hall.getRow(); i++){
            VBox vbox = new VBox();
            for(int j = 0; j < hall.getColumn(); j++){
                //Creating button
                Button btn = new Button();
                btn.setText(i + " " + j);
                btn.setFont(Font.font(0));

                btn.setMinSize(70, 70);

                //Button images
                Image imgbtn1 = new Image("assets/icons/empty_seat.png");
                ImageView viewbtn1 = new ImageView(imgbtn1);               
                viewbtn1.setFitHeight(50);
                viewbtn1.setPreserveRatio(true);

                Image imgbtn2 = new Image("assets/icons/reserved_seat.png");
                ImageView viewbtn2 = new ImageView(imgbtn2);               
                viewbtn2.setFitHeight(50);
                viewbtn2.setPreserveRatio(true);

                //button style
                btn.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
                "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
                "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");

                  
                //Selected seat
                for(Seat st: CinemaApp.seats){
                    if(st.getRow_of_seat() == i && st.getColumn_of_seat() == j && st.getHallName().equals(hall.getHallname())){
                        selectedSeat = st;
                    }
                } 
                //Setting default image        
                if(selectedSeat.getIsBought()){
                    btn.setGraphic(viewbtn2);
                    if(!CinemaApp.loggedInUser.getUsername().equals(selectedSeat.getOwner_name()) && !CinemaApp.loggedInUser.getIsAdmin()){
                       btn.setDisable(true);
                    } 
                    else{
                        btn.setDisable(false);
                    }                                    
                }     
                else{                  
                    btn.setGraphic(viewbtn1);
                }                
                
                //Setting margin 
                vbox.setMargin(btn, new Insets(5, 5, 5, 5));

                //button func                         
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //Selected seat
                        String[] rowColumString = btn.getText().split(" ");
                        for(Seat st: hall.getSeats()){
                            if(st.getRow_of_seat() == Integer.parseInt(rowColumString[0]) && st.getColumn_of_seat() == Integer.parseInt(rowColumString[1])){
                                selectedSeat = st;
                            }
                        }

                        //Finding selected user from combobox                       
                        selectedUser = userComboBox.getSelectionModel().getSelectedItem();

                        //Not bought                  
                        if(btn.getGraphic().equals(viewbtn1)){
                            selectedSeat.setIsBought(true);
                            btn.setGraphic(viewbtn2);
                            //user is admin or not
                            if(CinemaApp.loggedInUser.getIsAdmin()){
                                
                                    //Setting seat details                                                                                                                          
                                    selectedSeat.setOwner_name(selectedUser.getUsername()); 

                                    //Club member
                                    if(selectedUser.getIsClubMember()){        
                                        //Setting price  
                                        selectedSeat.setPrice_that_it_has_been_bought((double)(hall.getPrice_per_seat() * ((double)(100  - CinemaApp.discount) / 100)));
                                        //writing label
                                        lbl3.setText("Seat at " + (selectedSeat.getRow_of_seat() + 1) + "-" + (selectedSeat.getColumn_of_seat() + 1) + " is bought for " + 
                                        selectedUser.getUsername() + " for " + (double)(hall.getPrice_per_seat() * ((double)(100  - CinemaApp.discount) / 100)) + " TL succesfully");
                                    }
                                    //Not club member
                                    else{
                                        //Setting price 
                                        selectedSeat.setPrice_that_it_has_been_bought(hall.getPrice_per_seat());
                                        //writing label
                                        lbl3.setText("Seat at " + (selectedSeat.getRow_of_seat() + 1) + "-" + (selectedSeat.getColumn_of_seat() + 1) + " is bought for " + 
                                        selectedUser.getUsername() + " for " + hall.getPrice_per_seat() + " TL succesfully");
                                    }                                                                                 
                            }
                            else{  
                                    //Setting seat details                  
                                    selectedSeat.setOwner_name(CinemaApp.loggedInUser.getUsername());

                                    //Club member
                                    if(CinemaApp.loggedInUser.getIsClubMember()){
                                        selectedSeat.setPrice_that_it_has_been_bought((double)(hall.getPrice_per_seat() * ((double)(100  - CinemaApp.discount) / 100)));
                                        lbl3.setText("Seat at " + (selectedSeat.getRow_of_seat() + 1) + "-" + (selectedSeat.getColumn_of_seat() + 1) + " is bought for " 
                                        + (double)(hall.getPrice_per_seat() * ((double)(100  - CinemaApp.discount) / 100)) + " TL succesfully");
                                    }
                                    //Not club member
                                    else{
                                        selectedSeat.setPrice_that_it_has_been_bought(hall.getPrice_per_seat());
                                        lbl3.setText("Seat at " + (selectedSeat.getRow_of_seat() + 1) + "-" + (selectedSeat.getColumn_of_seat() + 1) + " is bought for " 
                                            + hall.getPrice_per_seat() + " TL succesfully");                                                   
                                    }                                  
                                }                                         
                        }                                                                                                                                                                                         
                        //Bought
                        else{
                            selectedSeat.setIsBought(false);
                            selectedSeat.setOwner_name(null);
                            selectedSeat.setPrice_that_it_has_been_bought(0);
                            lbl3.setText("Seat at " + (selectedSeat.getRow_of_seat() + 1) + "-" + (selectedSeat.getColumn_of_seat() + 1) + " refunded successfully!");
                            btn.setGraphic(viewbtn1);  
                        }                                                                                                                                                                                                                         
                    }                        
                });
                btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                    //Selected seat
                    String[] rowColumString = btn.getText().split(" ");
                    for(Seat st: hall.getSeats()){
                        if(st.getRow_of_seat() == Integer.parseInt(rowColumString[0]) && st.getColumn_of_seat() == Integer.parseInt(rowColumString[1])){
                            selectedSeat = st;
                        }
                    }
                    if(btn.getGraphic().equals(viewbtn1)){
                        lbl2.setText("Not bought yet!");
                    }
                    else{                       
                        lbl2.setText("Bought by " + selectedSeat.getOwner_name() + " for " + selectedSeat.getPrice_that_it_has_been_bought() + " TL!");
                    }
                  }
                });


                btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                    lbl2.setText("");
                  }
                });               
                //Adding to temp root
                vbox.getChildren().add(btn);               
            }           
            seats.getChildren().add(vbox);
        } 
        Backbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) { 
                //Setting up the scene
                FilmPage.SetUpPage();
                //Checking admin mode
                if(CinemaApp.loggedInUser.getIsAdmin()){
                    FilmPage.AdminMode(true);
                }
                else{
                    FilmPage.AdminMode(false);
                }   
                //Chancing scene
                CinemaApp.Stage.setScene(FilmPage.scene);                 
            }
            
        });
        //Adding to root  
        root.getChildren().addAll(lbl1,seats,userComboBox,lbl2,lbl3,Backbtn);    
    }
    public static void AdminMode(Boolean check){
        if(check){
            userComboBox.setVisible(true);
        }
        else{
            userComboBox.setVisible(false);
        }
    }
}
