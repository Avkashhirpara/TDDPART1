import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RomanNumeralConverter {


    private LinkedHashMap<Integer,String> numberMap = new LinkedHashMap<Integer, String>();

    public RomanNumeralConverter(){
        numberMap.put(100,"C");
        numberMap.put(90,"XC ");
        numberMap.put(50,"L");
        numberMap.put(40,"XL");
        numberMap.put(10,"X");
        numberMap.put(9,"IX");
        numberMap.put(5,"V");
        numberMap.put(4,"IV");
    }
    private int getRomanDigitforNumber(int input){
        if (input >= 100){
            return 100;
        }else if (input >= 90 ){
            return 90;
        }else if (input >= 50){
            return 50;
        }else if (input >=40){
            return 40;
        }else if (input >= 10){
            return 10;
        }else if (input >= 9){
            return 9;
        }else if (input >= 5){
            return 5;
        }else if (input >= 4){
            return 4;
        }
        return 0;
    }

    public String convert(int number){
        String returnType = "";
        for(int i = number; i > 0 ; ){
            int t =getRomanDigitforNumber(i);
            if(numberMap.containsKey(t)) {
                returnType+= numberMap.get(t);
                i-=t;
                continue;
            }
            returnType+= "I";
            i--;
        }
        return returnType;
    }


}
