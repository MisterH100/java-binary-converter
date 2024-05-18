package src;
import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.ArrayList;

public class ConvertText {
    public ArrayList<int[]> convert(String arg){
        String text = arg;
        ArrayList<String> ASCIITABLE = new ArrayList<String>();
        ArrayList<int[]> binaryList = new ArrayList<int[]>();
        ConvertNumber numConverter = new ConvertNumber();

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
        
        for(int i =0;i<text.length();i++){
            for(int j=0;j<ASCIITABLE.size();j++){
                String[] tempArr = ASCIITABLE.get(j).split(" ");
                String asciiCharacter = tempArr[1];
                String textCharacter = String.valueOf(text.charAt(i));

                if(asciiCharacter.equals(textCharacter)){
                    int [] binaryDigits = numConverter.convert(Integer.parseInt(tempArr[0]));
                    binaryList.add(binaryDigits);
                }
            }
        }
        return binaryList;
    } 
}
