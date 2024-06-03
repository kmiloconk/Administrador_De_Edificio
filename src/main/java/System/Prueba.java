package System;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Prueba {

    public static void main(String[] args) {
        String password = "miContraseña123";

        try {
            // Generar una clave secreta
            String claveSecreta = "miClaveSecreta";
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(claveSecreta.toCharArray(), claveSecreta.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            // Encriptar la contraseña
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedPassword = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));

            // Guardar la contraseña en un archivo
            File file = new File("contraseña.txt");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(encryptedPassword);
            }

            System.out.println("Contraseña encriptada y guardada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}