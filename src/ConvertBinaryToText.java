package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConvertBinaryToText {

    public String convert(String arg){
        String binary = arg;
        String character ="";
        ConvertBinaryToDigit binaryConverter = new ConvertBinaryToDigit();
        ArrayList<String> ASCIITABLE = new ArrayList<String>();


        try {
            File asciiFile = new File("ASCIITABLE.txt");
            Scanner myReader = new Scanner(asciiFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ASCIITABLE.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int number = binaryConverter.convert(binary);

        for(int i =0;i<ASCIITABLE.size();i++){
            String[] tempArr = ASCIITABLE.get(i).split(" ");
            String asciiNumber = tempArr[0];
            String asciiCharacter = tempArr[1];
            if(asciiNumber.contentEquals(String.valueOf(number))){
                character = asciiCharacter;
            }
        }
        return character;
    }
    
}
