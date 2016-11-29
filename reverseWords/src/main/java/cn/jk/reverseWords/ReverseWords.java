package cn.jk.reverseWords;

/**
 * Created by JinKai on 2016/11/28.
 */
public class ReverseWords {

    /**
     * 反转字符串-1
     * 1. 将字符串根据空格分解成数组
     * 2. 将数组中的元素按从大到小顺序排列
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param words
     * @return
     */
    public static String reverseWordsByArray(String words){
        String result = "";
        if(words == null){
            return result;
        }

        String[] wordArray = words.split(" ");

        if(wordArray.length <=0 ){
            return result;
        }

        for(int i = wordArray.length-1; i>= 0;i--){
            result = result + wordArray[i] + " ";
        }
        return result;
    }

    /**
     * 反转字符创-2
     * 通过将words字符串压入栈中，输出
     * @param words
     * @return
     */
    public static String reverseWordsByStack(String words){

        return null;
    }


}
