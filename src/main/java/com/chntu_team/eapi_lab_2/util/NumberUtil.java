package com.chntu_team.eapi_lab_2.util;

public final class NumberUtil {
    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
