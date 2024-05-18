package src;
public class ConvertBinaryToDigit{
    
  public int convert(String arg){
    String binary = arg;
    int total =0;
    int binaryLength = 7;

    for(int i =0;i<8;i++){
      total += (Integer.parseInt(String.valueOf(binary.charAt(i))) * (int) Math.pow(2, binaryLength));
      binaryLength = binaryLength - 1;
    }
    return total;

  }
}