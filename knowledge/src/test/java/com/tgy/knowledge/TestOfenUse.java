package com.tgy.knowledge;

import sun.applet.Main;

import java.util.Arrays;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-11-25 14:16
 **/

public class TestOfenUse {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 解法：异或
     *
     * 异或运算的特点：两个相同的数字异或，结果为0。
     *
     * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，如果把所有的数都异或，相同的数字异或为0，
     * 最后只剩下出现一次的数字，它和0异或，结果就是它本身。
     **/
   /* public static void main(String[] args) {
        int[] nums={2,2,4};
        System.out.println(singleNumber(nums));
        System.out.println("两个相同的数字异或结果："+(3^3));
        System.out.println("两个不同的数字异或结果："+(0^3));
    }
    public static int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }*/

   //给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在众数。

    public static void main(String[] args) {
        int[] a = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(a));
    }
    // 方法一：取数组第一个元素，去循环重复一个就计数为1，没遇到一样的就减一，直到为零换下一个元素去数组碰，剩下的一定是最多的那个
    public static int majorityElement(int[] nums) {
        int a = nums[0];
        int count = 1;
        for(int num : nums) {
            if(num == a) {
                count ++;
            }else {
                count --;
                if(count == 0) {
                    a = num;
                    count = 1;
                }
            }
        };
        return a;
    }
    //方法二：先sort排下序，然后取最中间的那个数,因为定义的是个数大于数组长度的二分之一
    /*public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/

}