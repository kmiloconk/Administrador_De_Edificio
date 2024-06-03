package System.Models;

public class PasswordModel {
    private String passsword;
    public PasswordModel(String passsword){
        this.passsword = passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getPasssword() {
        return passsword;
    }
}
