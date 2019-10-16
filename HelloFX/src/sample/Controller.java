package sample;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventListener;
import java.util.List;

public class Controller {

    @FXML
    private Button btnLogin, btnRegister;

    public void addFile(File f){

    }

    @FXML
    protected void initialize(){

    }
    @FXML
    protected void reg_click(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Stage stage = (Stage)btnRegister.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public void deleteFile(ActionEvent event, File f){

    }
    public void validateUser(ActionEvent event){

    }
    public void addUser(boolean admin){

    }
    public void deleteUser(String name, boolean admin){

    }
    public void encryptFile(File f){

    }
    public Account viewUser(String name, boolean admin){
        Account user = new Account();

        return user;
    }




   //MongoClientURI uri = new MongoClientURI(
   //         "mongodb+srv://admin:tamucc123@amcluster0-zsya9.mongodb.net/test?retryWrites=true&w=majority");

    //MongoClient mongoClient = new MongoClient(uri);
    //MongoDatabase database = mongoClient.getDatabase("test");

}
