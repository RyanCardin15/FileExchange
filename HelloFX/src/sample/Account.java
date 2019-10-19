package sample;

public class Account {
    private String username;
    private boolean isAdmin;
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

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
