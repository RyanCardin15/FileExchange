package sample;

import com.mongodb.client.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.List;

public class Controller {
    Scene scene;

    {
        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("sample.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFile(File f){

    }
    public void deleteFile(File f){

    }
    public void validateUser(){

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



    MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:tamucc123@amcluster0-zsya9.mongodb.net/test?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("test");


}
