package sample;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.io.File;
public class Controller {
    Scene register, login;

    {

    }

    public Controller(){

    }

    public void addFile(File f){
        try {
            register = new Scene(FXMLLoader.load(getClass().getResource("register.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            login = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(File f){
        File f1 = new File(String.valueOf(f));
        boolean success = f1.delete();
        if (!success){
            System.out.println("Deletion failed.");
            System.exit(0);
        }
        else{
            System.out.println("File deleted.");
        }
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




   //MongoClientURI uri = new MongoClientURI(
   //         "mongodb+srv://admin:tamucc123@amcluster0-zsya9.mongodb.net/test?retryWrites=true&w=majority");

    //MongoClient mongoClient = new MongoClient(uri);
    //MongoDatabase database = mongoClient.getDatabase("test");

}
