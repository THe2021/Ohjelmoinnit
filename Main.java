package com.company;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna kayttajanimi: ");
        String nimi = lukija.nextLine();

        System.out.print("Luo tekstitiedosto osoitteeseen (Anna tiedostopolku ja tiedostonimi.txt): ");
        String osoite = lukija.nextLine();

        luo(osoite, lukija);
        kirjoita(nimi, osoite, lukija);
        tulosta(osoite);

    }

    public static void luo(String osoite, Scanner lukija) {
        try {
            File file = new File(osoite);

            if (file.createNewFile()) {
                System.out.println("File is created");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void kirjoita(String nimi, String osoite, Scanner lukija) {
        try {
            FileWriter myWriter = new FileWriter(osoite);
            System.out.println("Kirjoita tekstitiedostoon: ");
            String teksti = lukija.nextLine();
            myWriter.write("<" + nimi + ">");
            myWriter.write(teksti);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            System.out.println("");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void tulosta(String osoite) {
        try {

            File myObj = new File(osoite);

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            System.out.print("<" + sdf.format(myObj.lastModified()) + ">");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}






