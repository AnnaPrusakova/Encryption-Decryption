package encryptdecrypt;


import java.util.Arrays;

public class Shift extends Cipher{
    char[] alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    Shift (String data, int key) {
        super(data, key);
    }

    @Override
    public String encryption() {
        char[] charData = data.toCharArray();
        for (int i = 0; i < data.length(); i++) {
            for(int j = 0; j < alphabetLowerCase.length; j++) {
                if (data.charAt(i) == alphabetLowerCase[j]) {
                    int shift = j + key;
                    if (shift > alphabetLowerCase.length) {
                        charData[i] = alphabetLowerCase[shift - alphabetLowerCase.length];
                    } else if (shift < alphabetLowerCase.length) {
                        charData[i] = alphabetLowerCase[shift];
                    }
                    break;
                } else if (data.charAt(i) == alphabetUpperCase[j]) {
                    int shift = j + key;
                    if (shift > alphabetUpperCase.length) {
                        charData[i] = alphabetUpperCase[shift - alphabetUpperCase.length];
                    } else if (shift < alphabetUpperCase.length) {
                        charData[i] = alphabetUpperCase[shift];
                    }
                    break;
                }
            }
        }
        return new String(charData);
    }

    @Override
    public String decryption() {
        char[] charData = data.toCharArray();
        for (int i = 0; i < data.length(); i++) {
            for(int j = 0; j < alphabetLowerCase.length; j++) {
                if (data.charAt(i) == alphabetLowerCase[j]) {
                    int shift = j - key;
                    if (shift <= alphabetLowerCase.length && shift >= 0) {
                        charData[i] = alphabetLowerCase[shift];
                    } else if (shift < 0) {
                        charData[i] = alphabetLowerCase[alphabetLowerCase.length + shift];
                    }
                    break;
                } else if (data.charAt(i) == alphabetUpperCase[j]) {
                    int shift = j - key;
                    if (shift <= alphabetUpperCase.length && shift >= 0) {
                        charData[i] = alphabetUpperCase[shift];
                    } else if (shift < 0) {
                        charData[i] = alphabetUpperCase[alphabetUpperCase.length + shift];
                    }
                    break;
                }
            }
        }
        return new String(charData);
    }
}
