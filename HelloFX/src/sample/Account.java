package sample;

public class Account {
    private String username;
    private boolean isAdmin;
    private Controller controller;
    private String fName;
    private String lName;
    private String email;
    private String password;

    public Account(){
        this.username = "";
        this.isAdmin = true;
        this.fName = "";
        this.lName = "";
        this.email = "";
        this.password="";
    }
    public Account(String u, boolean a, String f, String l, String e, String p){
        this.username = u;
        this.isAdmin = a;
        this.fName = f;
        this.lName = l;
        this.email = e;
        this.password = p;
    }

    @Override
    public String toString() {
        return "Account [fName=" + fName + ", lName=" + lName + ", username=" + username + ", email=" + email + ", password=" + password + "]";
    }

    public void setFName(String value) {
    }

    public void setLName(String data) {
    }

    public void setEmail(String data) {
    }

    public void setPassword(String data) {
    }

    public void setUsername(String data) {
    }
}
