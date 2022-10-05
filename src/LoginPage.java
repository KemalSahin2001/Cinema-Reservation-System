import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


public class LoginPage{
    //Root   
    private static GridPane root;

    //Time control 
    private static boolean control = false;
    private static Integer count = 0;
    public static Integer maxCount;
    public static Integer blockTime;
    public static Scene scene;

    public static void SetUpPage(){
        //creating root
        root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Setting up the scene
        scene = new Scene(root,1000,824,Color.BLACK); 

        //Creating welcome massage       
        Text lbl1 = new Text("Welcome to the HUCS Cinema Reservation System!");
        Text lbl2 = new Text("Please enter your credentials below and click LOGIN");
        Text lbl3 = new Text("You can create a new account by clicking SIGN UP button");     
        Text warning = new Text();

        //Creating label username
        Text usernameLabel = new Text("Username:");

        //creating label password
        Text passwordLabel = new Text("Password:");

        //Creating text field for username
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");

        //Creating text field for password
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("password");

        //Creating buttons
        Button btn1 = new Button("LOG IN");
        Button btn2 = new Button("SIGN UP");
              

        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,270, -30));

        usernameInput.setMaxWidth(150);
        usernameInput.setTranslateX(250);
        passwordInput.setMaxWidth(150);
        passwordInput.setTranslateX(250);

        usernameLabel.setTranslateX(250);
        passwordLabel.setTranslateX(250);

        warning.setTranslateX(60);

        btn1.setTranslateX(250);
        btn2.setTranslateX(255);

        lbl1.setTranslateX(5);   
        lbl3.setTranslateX(-20);

        //setting up the background
        Image img = new Image("assets/icons/loginPageBackGround.jpg");
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
        usernameInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        passwordInput.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        

        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lbl2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lbl3.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        warning.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        usernameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        usernameInput.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordInput.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));



        //adding childs
        root.add(lbl1,1,0);
        root.add(lbl2,1,1);
        root.add(lbl3,1,2);       

        root.add(warning,1,7);

        root.add(usernameLabel,0,4);
        root.add(passwordLabel,0,5);

        root.add(usernameInput,1,4);
        root.add(passwordInput,1,5);

        root.add(btn1,0,6);
        root.add(btn2,1,6);
        
        //Adding root into scene
        scene.setRoot(root);
    
        //Button func
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               SwitchScene(usernameInput,passwordInput,warning);
               usernameInput.clear();
               passwordInput.clear();
        }                        
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                SignUpPage.SetUpPage();
                CinemaApp.Stage.setScene(SignUpPage.scene);
                usernameInput.clear();
                passwordInput.clear();
            }
            
        });
    }  
    private static void Timer(){
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                LoginPage.count = 0;
                LoginPage.control = false;
            }
        }, 
        LoginPage.blockTime * 1000 
);
    } 
    private static void SwitchScene(TextField usernameInput, PasswordField passwordInput, Text warning){
         //To control wrong password spamming
         if(!control){

            //Creating variables
            String username = usernameInput.getText(); 
            String password = Base64.getEncoder().encodeToString(passwordInput.getText().getBytes(StandardCharsets.UTF_8));
            try {
				byte[] md5Digest = MessageDigest.getInstance( "MD5" ).digest(passwordInput.getText().getBytes(StandardCharsets.UTF_8));
                password = Base64.getEncoder().encodeToString(md5Digest);
			} catch (NoSuchAlgorithmException e) {}
            
            //Is username empty
            if(username.equals("")){
                warning.setText("ERROR: Username cannot be empty!");                   
                CinemaApp.buzzer.play();
            }
            //Is password empty
            else if(password.equals("")){
                warning.setText("ERROR: Password cannot be empty!");
                CinemaApp.buzzer.play();              
            }
            else{
                //Searching for user
                for(User user: CinemaApp.users){
                    if(user.getUsername().equals(username) && 
                    user.getHashedPassword().equals(password)){

                        //Changing logged in user
                        CinemaApp.loggedInUser = user;

                        //Setting up Welcome screen
                        WelcomeScreen.SetUpPage(); 
                        
                        //Controling is user admin or not
                        WelcomeScreen.AdminMode(user.getIsAdmin());        

                        //Chancing the scene
                        CinemaApp.Stage.setScene(WelcomeScreen.scene);  
                        CinemaApp.success.play();

                        count = 0;
                        return;                      
                    }
                }
                warning.setText("ERROR: There is no such user!"); 
                passwordInput.clear();
                CinemaApp.buzzer.play();                  
            }
            count++;
            if(count == LoginPage.maxCount){
                warning.setText("ERROR: Plase wait for "+ LoginPage.blockTime +" seconds!");
                control = true;
                CinemaApp.buzzer.play(); 
                Timer();
            }
        }
        else{
            warning.setText("ERROR: Plase wait until end of the "+ LoginPage.blockTime +" seconds!");
            CinemaApp.buzzer.play(); 
        }
    }
}
