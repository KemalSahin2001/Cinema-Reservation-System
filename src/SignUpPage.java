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

public class SignUpPage {
    //Root
    public static GridPane root;
    //Scene
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
        Text passwordLabel1 = new Text("Password:");
        Text passwordLabel2 = new Text("Password:");

        //Creating text field for username
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");

        //Creating text field for password
        PasswordField passwordInput1 = new PasswordField();
        PasswordField passwordInput2 = new PasswordField();
        passwordInput1.setPromptText("password");
        passwordInput2.setPromptText("password");

        //Creating buttons       
        Button btn1 = new Button("LOG IN");
        Button btn2 = new Button("SIGN UP");

        //setting the padding
        root.setVgap(5);
        root.setHgap(10);
        root.setPadding(new Insets(10, 10,270, -30));

        usernameInput.setMaxWidth(150);
        usernameInput.setTranslateX(250);
        passwordInput1.setMaxWidth(150);
        passwordInput1.setTranslateX(250);
        passwordInput2.setMaxWidth(150);
        passwordInput2.setTranslateX(250);

        warning.setTranslateX(50);

        usernameLabel.setTranslateX(250);
        passwordLabel1.setTranslateX(250);
        passwordLabel2.setTranslateX(250);

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
        passwordInput1.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");
        passwordInput2.setStyle("#glass-grey {-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%)," + 
        "radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius:"+ 
        "30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );}");


        lbl1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lbl2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        lbl3.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        usernameInput.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordInput1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordInput2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));


        usernameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordLabel1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        passwordLabel2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        warning.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 20));            

        //adding childs
        root.add(lbl1,1,0);
        root.add(lbl2,1,1);
        root.add(lbl3,1,2);
        root.add(usernameLabel,0,4);
        root.add(passwordLabel1,0,5);
        root.add(passwordLabel2,0,6);
        root.add(usernameInput,1,4);
        root.add(passwordInput1,1,5);
        root.add(passwordInput2,1,6);
        root.add(btn1,0,7);
        root.add(btn2,1,7);
        root.add(warning,1,8);

        //Adding root into scene
        scene.setRoot(root);
        
        //button func
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                //Creating variables
                String username = usernameInput.getText();                
                String password1 = passwordInput1.getText();
                String password2 = passwordInput2.getText();

                //Is username empty
                if(username.equals("")){
                    warning.setText("ERROR: Username cannot be empty!");                   
                    CinemaApp.buzzer.play();
                    return;
                }
                //Is password empty
                else if(password1.equals("") || password2.equals("")){
                    warning.setText("ERROR: Password cannot be empty!");
                    CinemaApp.buzzer.play();
                    return;                    
                }
                //Does passwords match
                else if(!password1.equals(password2)){
                    warning.setText("ERROR: Password do not match!");
                    CinemaApp.buzzer.play();
                    return;
                }
                else{
                    //Searching for same username
                    for(User user: CinemaApp.users){
                        if(user.getUsername().equals(username)){
                            warning.setText("ERROR: This username already exists!");                            
                            CinemaApp.buzzer.play();
                            return;
                        }
                    }
                    //Encoding password
                    String password = Base64.getEncoder().encodeToString(password1.getBytes(StandardCharsets.UTF_8));
                    try {
						byte[] md5Digest = MessageDigest.getInstance( "MD5" ).digest(password1.getBytes(StandardCharsets.UTF_8));
                        password = Base64.getEncoder().encodeToString(md5Digest);
					} catch (NoSuchAlgorithmException e) {}

                    //Creating temp user variable
                    User temp = new User(username, password, false, false);

                    //Adding user to App
                    CinemaApp.users.add(temp);
                    
                    warning.setText("SUCCESS: You have successfully registered!");
                    usernameInput.clear();
                    passwordInput1.clear();
                    passwordInput2.clear();
                    CinemaApp.success.play();
                    return;
                }
            }
            
        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LoginPage.SetUpPage();
                CinemaApp.Stage.setScene(LoginPage.scene);
                usernameInput.clear();
                passwordInput1.clear();
                passwordInput2.clear();
            }            
        });

    }
}
