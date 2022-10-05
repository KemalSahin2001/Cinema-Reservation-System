import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class EditUsersPage {
    //Root   
    private static GridPane root;
    public static Scene scene;

    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        //Setting up the scene
        scene = new Scene(root,880,1237,Color.BLACK);
        
        //Name column
        TableColumn<User,String> nameColumn = new TableColumn<>("Username");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username")); 

        //Club member column
        TableColumn<User,Boolean> clubMemberColumn = new TableColumn<>("Club Member");
        clubMemberColumn.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isClubMember"));

        //Club member column
        TableColumn<User,Boolean> adminMemberColumn = new TableColumn<>("Admin");
        adminMemberColumn.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isAdmin"));

        //Creating table
        TableView<User> table = new TableView<>();
        table.setPrefSize(600, 800);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //Adding items in table
        for(User usr: CinemaApp.users){
            table.getItems().add(usr);
        }
        table.getColumns().add(nameColumn);
        table.getColumns().add(clubMemberColumn);
        table.getColumns().add(adminMemberColumn);

        //Creating buttons
        Button btn1 = new Button("Back");
        Button btn2 = new Button("Promote/Demote Club Member");
        Button btn3 = new Button("Promote/Demote Admin");       

        //Styling table
        table.setStyle("-fx-selection-bar: #D82800;");
        table.setStyle(
        "-fx-stroke: transparent;"+
        "-fx-size: 50;"+
        "-fx-alignment: CENTER;"+
        "-fx-text-alignment: center;"+
        "-fx-background-color: transparent;}"+
        "-fx-size: 50;"+
        "-fx-alignment: CENTER;"+
        "-fx-text-alignment: center;}"+
        "-fx-background-color: transparent;"+
        "-fx-text-fill: white;"+
        "-fx-fixed-cell-size: 50;"+
        "-fx-alignment: CENTER;"+
        "-fx-text-alignment: center;}"+
        "-fx-text-alignment: center;"+
        " -fx-alignment: CENTER;}" + 
        ".table-view .table-cell{" +
        "-fx-font-weight:bold;" +
        "-fx-font-size:15px; " +
        "-fx-font-family: Verdana;"        
        );

        //Setting the padding
        root.setVgap(5);
        root.setHgap(10);

        btn2.setTranslateX(220);
        btn2.setTranslateY(-44);
        btn3.setTranslateX(235);
        btn3.setPrefWidth(350);
        btn3.setTranslateY(-35);
        //Styling buttons
        
        btn1.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn2.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        btn3.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");

        root.setStyle("-fx-font-weight:bold; -fx-font-size:20px; -fx-font-family: Verdana;");
        
        //setting up the background
        Image img = new Image("assets/icons/1893099d27f96f423a4cd7f4aad26166.jpg");
        BackgroundImage bimg = new BackgroundImage(img, BackgroundRepeat.ROUND,  
        BackgroundRepeat.ROUND, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);               
        root.setBackground(new Background(bimg));

        //Adding childs
        root.add(table,0,0);
        root.add(btn1,0,1);
        root.add(btn2,0,2);
        root.add(btn3,0,3);

        //Setting scene
        scene.setRoot(root);

        //Button func
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Setting up Page
                WelcomeScreen.SetUpPage();
                //Setting Admin mode
                WelcomeScreen.AdminMode(true);
                //Changing scene
                CinemaApp.Stage.setScene(WelcomeScreen.scene);             
            }
            
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    //Finding user
                    User person = table.getSelectionModel().getSelectedItem();
                    for(User usr: CinemaApp.users){
                        //Controling user equals person
                        if(usr.getUsername().equals(person.getUsername())){                           
                            if(usr.getIsClubMember()){
                                //Chancing Club Member status
                                usr.setClubMember(false);
                                //Music
                                CinemaApp.success.play();
                                
                            }
                            else{
                                //Chancing Club Member status
                                usr.setClubMember(true);
                                //Music
                                CinemaApp.success.play();
                            }
                        }
                    }                    
                } catch (Exception e) {CinemaApp.buzzer.play();}   
                //Refreshing page
                EditUsersPage.SetUpPage();
                CinemaApp.Stage.setScene(EditUsersPage.scene);                   
            }           
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    //Finding user
                    User person = table.getSelectionModel().getSelectedItem();
                    for(User usr: CinemaApp.users){
                        //Controling user equals person
                        if(usr.getUsername().equals(person.getUsername())){                           
                            if(usr.getIsAdmin()){
                                //Chancing Admin status
                                usr.setAdmin(false);
                                //Music
                                CinemaApp.success.play();
                                
                            }
                            else{
                                //Chancing Admin status
                                usr.setAdmin(true);
                                //Music
                                CinemaApp.success.play();
                            }
                        }
                    }                    
                } catch (Exception e) {CinemaApp.buzzer.play();}  
                //Refreshing page  
                EditUsersPage.SetUpPage();
                CinemaApp.Stage.setScene(EditUsersPage.scene);                     
            }           
        });
    }
}
