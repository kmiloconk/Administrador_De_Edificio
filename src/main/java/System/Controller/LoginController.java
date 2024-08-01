package System.Controller;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.spec.KeySpec;
import java.util.Objects;

public class LoginController {
    private String masterPassword="0000";

    public LoginController(){
    }

    public boolean ValidatePassword(String password){

        if(Objects.equals(DecryptPassword(), password)){
            return true;
        }

        if(Objects.equals(masterPassword, password)){
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

            String programFilesDir = System.getenv("ProgramFiles");
            if (programFilesDir == null) {
                programFilesDir = System.getenv("ProgramFiles(x86)");
            }
            String appDirPath = programFilesDir + "/EdificioPietraApp";

            File file = new File(appDirPath, "contraseña.txt");

            byte[] encryptedPassword = Files.readAllBytes(file.toPath());

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

            return new String(decryptedPassword, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void CreatePassword(String password) {
        try {
            String claveSecreta = "miClaveSecreta";
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

            String programFilesDir = System.getenv("ProgramFiles");
            if (programFilesDir == null) {
                programFilesDir = System.getenv("ProgramFiles(x86)");
            }
            String appDirPath = programFilesDir + "/EdificioPietraApp";


            File file = new File(appDirPath, "contraseña.txt");

            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(encryptedPassword);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
