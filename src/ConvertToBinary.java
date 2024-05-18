package src;
import java.util.ArrayList;

public class ConvertToBinary {
    public static void main(String[] args){
        String valueTypeFlag;
        String returnTypeFlag;
        String value;
        if(args.length ==0){
            System.out.println("type -help for help");
            return;
        }
        valueTypeFlag = args[0];
        if(args.length ==1){
            value = "0";
        }
        else{
            value = args[1];
        }
        ConvertNumber numConverter = new ConvertNumber();
        ConvertText textConverter = new ConvertText();
        ConvertBinaryToDigit digitBinaryConverter = new ConvertBinaryToDigit();
        ConvertBinaryToText textBinaryConverter = new ConvertBinaryToText();

        switch (valueTypeFlag) {
            case "-number":  
                int[] numberBinaryDigits = numConverter.convert(Integer.parseInt(value));
                String digitBinaryValue ="";

                for(int i=0;i<numberBinaryDigits.length;i++){
                    digitBinaryValue += String.valueOf(numberBinaryDigits[i]);
                }
                System.out.println("Binary value: "+digitBinaryValue);
                break;

            case "-text":
                ArrayList<int[]> textBinaryDigits = textConverter.convert(value);
                String textBinaryValue ="";

                for(int i=0;i<textBinaryDigits.size();i++){
                    int[] tempArr = textBinaryDigits.get(i);
                    for(int j =0;j<tempArr.length;j++){
                        textBinaryValue += String.valueOf(tempArr[j]);
                    }   
                    textBinaryValue += " ";
                }
                System.out.println("Binary value: "+ textBinaryValue);
                break;

            case "-binary":
                if(args.length <3){
                    System.err.println("Provide return type for the binary input, -help for help");
                    break;
                }
                returnTypeFlag = args[2];

                if(returnTypeFlag.contentEquals("-number")){
                    int number = digitBinaryConverter.convert(value);
                    System.out.println(number);
                    break;
                }

                if(returnTypeFlag.contentEquals("-text")){
                    String output = "";
                    String[] tempArr = value.split("-");
                    for(int i=0;i<tempArr.length;i++){
                        String character = textBinaryConverter.convert(tempArr[i]);
                        output += character;
                    }
                    System.out.println(output);
                }
                break;

            case "-help":
                System.out.println("To use this program: [-flag] [value]");
                System.out.println("[-flag]: specify whether your value is text or number for correct conversion");
                System.out.println("[value]: text or number value");
                System.out.println("flags: "+"\n"+"-number: to convert a number to binary,"+"\n"+"-text: to covert a word to binary");
                break;

            default:
                System.out.println("type -help for help");
                break;
        }
    }
    
}
