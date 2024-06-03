package System.Controller;

import System.Models.PasswordModel;

import java.util.List;
import java.util.Objects;

public class LoginController {
    private PasswordModel passwordModel;
    public LoginController(PasswordModel passwordModel){
        this.passwordModel = passwordModel;
    }

    public void setPasswordModel(PasswordModel passwordModel) {
        this.passwordModel = passwordModel;
    }
    public boolean ValidatePassword(String password){
        if(Objects.equals(passwordModel.getPasssword(), password)){
            return true;
        }
        return false;
    }

    public void UpdatePassword(PasswordModel passwordModel, PasswordModel passwordModelnew){
        if(passwordModel.getPasssword() == this.passwordModel.getPasssword()){
            setPasswordModel(passwordModelnew);
        }
    }
}
