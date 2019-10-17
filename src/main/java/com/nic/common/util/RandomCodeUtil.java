package com.nic.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * EmployeeBiz class
 *
 * @author : cyl
 * @date : 2018/7/3 下午10:37
 * @description : 验证码生成器
 * @since :
 */
public class RandomCodeUtil {

    private final static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    private static Random random = new Random();

    /**
     * 生成一个纯由数字组成的验证码
     *
     * @param count 验证码位数
     */
    public static String getNumber(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char ctmp = (char) (random.nextInt(10) + '0');
            sb.append(ctmp);
        }

        return sb.toString();
    }


    /**
     * 生成一个纯由英文字母组成的验证码
     *
     * @param count 验证码位数
     */
    public static String getLetter(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char ctmp = (char) (random.nextInt(26) + 'a');
            sb.append(ctmp);
        }
        return sb.toString();
    }


    /**
     * 生成一个由数字和英文字母混合组成的验证码
     *
     * @param count 验证码位数
     */
    public static String getNumberOrLetter(int count) {
        StringBuilder sb = new StringBuilder();
        int len = hexDigits.length;

        for (int i = 0; i < count; i++) {
            char ctmp = hexDigits[random.nextInt(len)];
            sb.append(ctmp);
        }
        return sb.toString();
    }

    /**
     * 获取UUD 不带-
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //测试代码
    public static void main(String[] args) {
        System.out.println(RandomCodeUtil.getNumber(6));
        System.out.println(RandomCodeUtil.getLetter(6));
        System.out.println(RandomCodeUtil.getNumberOrLetter(4));
    }
}
