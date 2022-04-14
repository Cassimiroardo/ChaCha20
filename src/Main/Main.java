package Main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {

    private static final String ENCRYPT_ALGO = "ChaCha20";
    private static final int COUNTER = 5;

    public static void main(String[] args) throws Exception {
    	byte[] message;
    	byte[] nonce;
    	byte[] key;
    	byte[] encrypted;
    	byte[] decrypted;
    			
    	message = "O que é melhor ? nascer bom, ou superar sua natureza maligna através de grande esforço?".getBytes();
        nonce = getNonce();
        key = getKey();

        encrypted = encrypt(message, key, nonce);
    	
        System.out.println("ALGORITMO: " + ENCRYPT_ALGO);
        System.out.println("ORIGINAL: " + new String(message));
        System.out.println("ENCRIPTADA: " + toBase64(encrypted));
        System.out.println("NONCE: " + toBase64(nonce));
        System.out.println("CHAVE: " + toBase64(key));
        System.out.println("CONTADOR: " + COUNTER);
    	
    	message = fromBase64("YUd+lbniY4S76zvlsTmdSW5ixw==");
    	nonce = fromBase64("riZ5cUNRs0rOEpqN");
    	key = fromBase64("ecHJcaqib9O8Lkhi3SjhTV8QH2VeddEcRfDerJ9Dhh8=");

    	decrypted = decrypt(message, key, nonce);
    	System.out.println("DECIFRADA: " + new String(decrypted));
    }

    public static byte[] encrypt(byte[] pText, byte[] key, byte[] nonce) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, COUNTER);
        SecretKeySpec keySpec = new SecretKeySpec(key, ENCRYPT_ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
        byte[] encryptedText = cipher.doFinal(pText);
        return encryptedText;
    }

    public static byte[] decrypt(byte[] cText, byte[] key, byte[] nonce) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
        ChaCha20ParameterSpec paramSpec = new ChaCha20ParameterSpec(nonce, COUNTER);
        SecretKeySpec keySpec = new SecretKeySpec(key, ENCRYPT_ALGO);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
        byte[] decryptedText = cipher.doFinal(cText);
        return decryptedText;
    }

    private static byte[] getKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(ENCRYPT_ALGO);
        keyGen.init(256);
        return keyGen.generateKey().getEncoded();
    }

    private static byte[] getNonce() {
        byte[] nonce = new byte[12];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    private static String toBase64(byte[] str) {
        return new String(Base64.getEncoder().encode(str));
    }

    private static byte[] fromBase64(String str) {
        return Base64.getDecoder().decode(str);
    }
}