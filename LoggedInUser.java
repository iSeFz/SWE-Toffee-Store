public class LoggedInUser extends GeneralUser {
    private Account account;
    private Address address;
    private boolean isSuspended = false;

    public LoggedInUser(Account account){
        this.account = account;
    }
    public LoggedInUser(Account account, Address address, boolean isSuspended){
        this.account = account;
        this.address = address;
        this.isSuspended = isSuspended;
    }
    public boolean checkOut(){
        return true;
    }
    public boolean isSuspended(){
        return isSuspended;
    }
    public Account getAccount(){
        return account;
    }
}
