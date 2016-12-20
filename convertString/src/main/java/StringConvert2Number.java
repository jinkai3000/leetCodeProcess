import java.util.IllegalFormatException;

/**
 * Created by JinKai on 2016/12/20.
 */
public class StringConvert2Number {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(parseInt(s));

    }


    public static Integer parseInt(String s){
        if(s == null){
            throw new NumberFormatException("null");
        }
        Integer result = 0;
        boolean negative = false;
        int i = 0;
        int length = s.length();

        if(length <= 0){
            throw new NumberFormatException("null");
        }

        char firstChar = s.charAt(0);
        if(firstChar < '0'){
            if(firstChar == '-'){
                negative = true;
            }else if (firstChar != '+'){
                throw new NumberFormatException(s + " is not Number");
            }
            i++;
        }
        while (i < s.length()){
            Integer temp = parseInt(s.charAt(i++));
            result *= 10;
            result +=temp;
        }

        return  negative ? -result : result;
    }

    public static Integer parseInt(char c){
        Integer result = c-'0';
        if(result < 0 || result >9){
            throw new NumberFormatException("Char "+ c + " is not a number");
        }
        return result;
    }


}
