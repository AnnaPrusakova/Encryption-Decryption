package encryptdecrypt;

 abstract class Cipher implements EncryptionDecryption{
     protected String data;
     protected int key;

     Cipher (String data, int key) {
         this.data = data;
         this.key = key;
     }

}
