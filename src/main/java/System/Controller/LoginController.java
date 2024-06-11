package System.Controller;

import System.Models.PasswordModel;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Objects;

public class LoginController {
    public LoginController(){
    }

    public void setPassword(String password) {

    }
    public boolean ValidatePassword(String password){
        if(Objects.equals(DecryptPassword(), password)){
            return true;
        }
        return false;
    }

    public boolean UpdatePassword(String password, String passwordNEW,String passwordNEW2){
        if(ValidatePassword(password)){
            if(Objects.equals(passwordNEW,passwordNEW2)){
                CreatePassword(passwordNEW);
                return true;
            }
        }
        return false;
    }
    public String DecryptPassword() {
        try {
            String claveSecreta = "miClaveSecreta";
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            File file = new File("Files/contraseña.txt");
            byte[] encryptedPassword;
            try (FileInputStream fis = new FileInputStream(file)) {
                encryptedPassword = fis.readAllBytes();
            }


            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

            String password = new String(decryptedPassword, StandardCharsets.UTF_8);
            return password;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public void CreatePassword(String password){

        try {
            String claveSecreta = "miClaveSecreta";
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

            File file = new File("Files/contraseña.txt");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(encryptedPassword);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
