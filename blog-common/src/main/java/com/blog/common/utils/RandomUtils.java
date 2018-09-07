package com.blog.common.utils;

import java.util.Random;

/**
 * @author wangfujie
 * @date 2018-09-07 15:03
 * @description 随机数工具类
 */
public class RandomUtils {

    /**
     * 随机生成数字，提供 长度参数，随机生成多少位的验证码数字
     *
     * @param length
     * @return
     */
    public static int getRandomCode(int length) {
        if (length < 1) {
            return 0;
        }
        int m = new Double(Math.pow(10, length) - Math.pow(10, length - 1)).intValue();
        Random r = new Random();
        return r.nextInt(m) + (new Double(Math.pow(10, length - 1)).intValue());
    }

    /**
     * 获取指定范围里得随机码
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNum(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    /**
     * 测试主函数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(RandomUtils.getRandomNum(1,2));
    }
}
