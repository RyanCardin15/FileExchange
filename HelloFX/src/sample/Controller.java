package sample;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javax.xml.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Controller {


    public Controller() throws SQLException {

    }



    @FXML
    private Button btnLogin, btnRegister, btnLoginSubmit, btnBack;

    @FXML
    private TextField txtUser, txtPassword;

    @FXML
    private String filename;

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

    @FXML
    protected void login_click(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage)btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }



    public void deleteFile(ActionEvent event, File f){

    }
    public void validateUser(ActionEvent event) throws IOException{
        Boolean isSuccess = false;
        AccountList pull = new AccountList();
        List<Account> temp = pull.readConfig(filename);

        List<Account> result = temp.parallelStream()
                .filter(a -> (Objects.equals(a.getUsername(), txtUser.getText())) && (Objects.equals(a.getPassword(), txtPassword.getText())))
                .collect(Collectors.toList());


        if(isSuccess) {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
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

}
