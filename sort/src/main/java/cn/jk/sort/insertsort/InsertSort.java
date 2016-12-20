package cn.jk.sort.insertsort;

import cn.jk.sort.ISort;

import java.util.Arrays;

/**
 * 插入排序--直接插入排序
 *
 * 算法说明：
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 *
 *  要点：设立哨兵，作为临时存储和判断数组边界之用。
 *
 * 例如：
 *  0 : r1,r5,r2,r4,r3
 *  1 : (r1),r5,r2,r4,r3
 *  2 : (r1,r5),r2,r4,r3
 *  3 : (r1,r2,r5),r4,r3
 *  4 : (r1,r2,r4,r5),r3
 *  5 : (r1,r2,r3,r4,rt)
 *
 * 时间复杂度: O(n) ~ O(n^2)  平均: O(n^2)
 * 空间复杂度：O(1)
 *
 * Created by JinKai on 2016/12/5.
 */
public class InsertSort implements ISort {

    @Override
    public void sort(Integer[] numbers) {
        //第0位作为有序数列，从第1位开始向后遍历
        int count = 0;
        for(int i = 1;i<numbers.length;i++){
            count++;
            //0~i位有序，若第i位小于i-1位，继续寻位并插入，否则任务0~i位也是有序的，忽略此次
            if(numbers[i] < numbers[i-1] ){
                //保存第i位的值
                Integer temp = numbers[i];
                int  k = i-1;
                //从i-1位向前遍历并移位，直至找到小于第i位值停止
                for(int j = k ; j >= 0 && temp < numbers[j];j--){
                    count++;
                    numbers[j+1] = numbers[j];
                    k--;
                }
                //插入第i位的值
                numbers[k+1] = temp;
            }
            System.out.println("第"+count+"次: "+Arrays.toString(numbers));
        }
        System.out.println("第"+count+"次: "+Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        Integer[] numbers = {7,6,5,4,3,2,1,0};
        insertSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
