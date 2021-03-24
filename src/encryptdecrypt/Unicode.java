package encryptdecrypt;

public class Unicode extends Cipher{
    Unicode (String data, int key) {
        super(data, key);
    }

    @Override
    public String encryption() {
        String encMessage = "";
        for (int i = 0; i < data.length(); i++) {
            char c = (char) (data.charAt(i) + key);
            encMessage += c;
        }
        return encMessage;
    }

    @Override
    public String decryption() {
        String decMessage = "";
        for (int i = 0; i < data.length(); i++) {
            char c = (char) (data.charAt(i) - key);
            decMessage += c;
        }
        return decMessage;
    }
}
