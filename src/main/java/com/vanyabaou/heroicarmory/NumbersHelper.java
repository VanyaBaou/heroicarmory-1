package com.vanyabaou.heroicarmory;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

public class NumbersHelper {
    public static String getRomanNumber(int number) {
        return join("", nCopies(number, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    public static float clamp(float val, float min, float max){
        return Math.max(min,Math.min(max,val));
    }
}
