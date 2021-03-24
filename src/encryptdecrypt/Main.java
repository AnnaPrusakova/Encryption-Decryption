package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static String mode = "enc";
    private static int key = 0;
    private static String data = "";
    private static String fileToSaveURL = "";
    private static String fileURL = "";
    private static String fileMessage = "";
    private static String result = "";
    private static String alg = "shift";

    public static void main(String[] args) {
        findArgs(args);
        if (data.equals("") && fileURL.equals("")) {
            System.out.println();
        } else if (!data.equals("")) {
            typeMode(data);
            outputData();
        } else {
            readFromFile();
            typeMode(fileMessage);
            outputData();
        }

    }

    private static void outputData() {
        if (fileToSaveURL.equals("")) {
            System.out.println(result);
        } else {
            writeToFile(result);
        }
    }

    private static void typeMode(String message) {
        Cipher cipher;
        switch (alg) {
            case "shift":
                cipher = new Shift(message, key);
                if (mode.equals("enc")) {
                    result = cipher.encryption();
                } else {
                    result = cipher.decryption();
                }
                break;
            case "unicode":
                cipher = new Unicode(message, key);
                if (mode.equals("enc")) {
                    result = cipher.encryption();
                } else {
                    result = cipher.decryption();
                }
                break;
            default:
                result = "Error! Invalid method";
        }
    }

    private static void writeToFile(String information) {
        File file = new File(fileToSaveURL);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(information);
        } catch (IOException e) {
            System.out.println("Error! Cannot write to file! " + e.getMessage());
        }
    }

    private static void readFromFile() {
        File file = new File(fileURL);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                fileMessage += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found!");
        }
    }

    private static void findArgs(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-out":
                    fileToSaveURL = args[i + 1];
                    break;
                case "-in":
                    fileURL = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }
    }

}
