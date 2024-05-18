package src;
public class ConvertNumber {
    
    public int[] convert(int arg){
        int dividend = arg;
        int quotient = arg;
        int remainder;
        int[] convertedEightBitInt = {0,0,0,0,0,0,0,0};
        int binaryLength = 7;

        if(dividend>255){
            System.err.println("Value has to be less than or equal to 255");
            return convertedEightBitInt;
        }
        while(quotient!=0){
            quotient = dividend/2;
            remainder = dividend%2;
            dividend = quotient;
            convertedEightBitInt[binaryLength] = remainder;
            binaryLength = binaryLength -1;
        }

        return convertedEightBitInt;
    }

}