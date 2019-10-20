package sample;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
    private String filename = "src\\sample\\account.xml";

    public void addFile(FileC f){

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
        File xmlFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<Account> accList = new ArrayList<>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(String.valueOf(xmlFile));
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Account"); // receiving both current entrees as null values.. Fix so it reads value. Otherwise, method is working.
            //now XML is loaded as Document in memory, lets convert it to Object List
            //Test
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i)); // Error Starts here
            }
            //

            for (int i = 0; i < nodeList.getLength(); i++) {
                accList.add(getAccount(nodeList.item(i))); // Error Starts here
            }
            //lets print Employee list information
            for (Account temp : accList) {
                System.out.println(temp.toString());
            }
        } catch (ParserConfigurationException | IOException | SAXException e1) {
            e1.printStackTrace();
        }
        Boolean isSuccess = false;

        Account result = accList.parallelStream()
                .filter(a -> Objects.equals(a.getUsername(), txtUser.getText()))
                .findAny()
                .orElse(null);
        if(result.getPassword() == txtPassword.getText())
            isSuccess = true;
        if(isSuccess) {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
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
    private static Account getAccount(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Account acc = new Account();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            acc.setFName(getTagValue("fname", element));     // will not accept method
            acc.setLName(getTagValue("lname", element));
            acc.setEmail(getTagValue("email", element));
            acc.setPassword(getTagValue("password", element));
            acc.setUsername(getTagValue("user", element));
        }

        return acc;
    }
    private static String getTagValue(String tag, Element element) {
        //String value = element.getElementsByTagName(tag).item(0).getTextContent();
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes(); // Error caused by this line. There's a null pointer exception
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue(); //value;
    }

}
