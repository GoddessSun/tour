package com.sun.tour.utils;

import java.util.regex.Pattern;

/**
 * Date: 2017/12/21
 * Time: 17:07
 * author: sunmingmao
 */

public class MobileCheckUtil {
    /**
     * 中国移动：China Mobile
     * 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     */
    private static String REG_CM = "^1(3[4-9]|4[7]|5[0-27-9]|7[08]|8[2-47-8])\\d{8}$";
    /**
     * 中国联通：China Unicom
     * 130,131,132,145,155,156,170,171,175,176,185,186
     */
    private static String REG_CU = "^1(3[0-2]|4[5]|5[56]|7[0-15-6]|8[56])\\d{8}$";
    /**
     * 中国电信：China Telecom
     * 133,149,153,170,173,177,180,181,189,199
     */
    private static String REG_CT = "^1(3[3]|4[9]|5[3]|7[037]|8[019]|9[9])\\d{8}$";

    public static boolean isRealMobile(String mobile) {
        boolean isCM = Pattern.matches(REG_CM, mobile);
        boolean isCU = Pattern.matches(REG_CU, mobile);
        boolean isCT = Pattern.matches(REG_CT, mobile);
        if (isCM || isCT || isCU)
            return true;
        return false;
    }

}
