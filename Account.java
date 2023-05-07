public class Account {
    private String userName;
    private String email;
    private String password;

    public Account(String email, String password){
        this.email = email;
        this.password = password;
    }

    public boolean setInfo(String name, String mail, String pass){
        this.userName = name;
        this.email = mail;
        this.password = pass;
        return true;
    }

    public String getUserName(){
        return this.userName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
