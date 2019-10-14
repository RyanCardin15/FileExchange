package sample;

public class Account {
        private String username;
        private boolean isAdmin;
        private Controller controller;
        private String fName;
        private String lName;
        private String email;

        public Account(){
            this.username = "";
            this.isAdmin = true;
            this.fName = "";
            this.lName = "";
            this.email = "";
        }
        public Account(String u, boolean a, String f, String l, String e){
            this.username = u;
            this.isAdmin = a;
            this.fName = f;
            this.lName = l;
            this.email = e;
        }
        public void get(String s, String p){

        }
}
