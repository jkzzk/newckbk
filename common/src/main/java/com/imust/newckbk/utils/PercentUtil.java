package com.imust.newckbk.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import java.text.DecimalFormat;

public class PercentUtil {
    public final static int         BIGDECIMAL_LENGTH = 4;
    public final static MathContext mathContext       = new MathContext(BIGDECIMAL_LENGTH);

    public static String FormatPercent(Double percent) throws Exception {
        String formatStr = "";

        if (percent.equals(0)) {
            return "0.00%";
        }

        formatStr = new DecimalFormat("#.00%").format(percent);

        return formatStr;
    }

    public static String FormatPercent(BigDecimal percentage, BigDecimal proportion) throws Exception {
        String formatStr = "";

        if (percentage.equals(0)) {
            return "0.00%";
        }

        BigDecimal percentageDecimal = percentage;
        BigDecimal proportionDecimal = proportion;
        BigDecimal percentNumber     = percentageDecimal.divide(proportionDecimal, mathContext);

        formatStr = new DecimalFormat("#.00%").format(percentNumber);

        return formatStr;
    }

    public static String FormatPercent(BigInteger percentage, BigInteger proportion) throws Exception {
        String formatStr = "";

        if (percentage.equals(0)) {
            return "0.00%";
        }

        BigDecimal percentageDecimal = new BigDecimal(percentage, mathContext);
        BigDecimal proportionDecimal = new BigDecimal(proportion, mathContext);
        BigDecimal percentNumber     = percentageDecimal.divide(proportionDecimal, mathContext);

        formatStr = new DecimalFormat("#.00%").format(percentNumber);

        return formatStr;
    }

    public static String FormatPercent(Double percentage, Double proportion) throws Exception {
        String formatStr = "";

        if (percentage == 0) {
            return "0.00%";
        }

        BigDecimal percentageDecimal = new BigDecimal(percentage, mathContext);
        BigDecimal proportionDecimal = new BigDecimal(proportion, mathContext);
        BigDecimal percentNumber     = percentageDecimal.divide(proportionDecimal, mathContext);

        formatStr = new DecimalFormat("#.00%").format(percentNumber);

        return formatStr;
    }

    public static String FormatPercent(Integer percentage, Integer proportion) throws Exception {
        String formatStr = "";

        if (percentage == 0) {
            return "0.00%";
        }

        BigDecimal percentageDecimal = new BigDecimal(percentage, mathContext);
        BigDecimal proportionDecimal = new BigDecimal(proportion, mathContext);
        BigDecimal percentNumber     = percentageDecimal.divide(proportionDecimal, mathContext);

        formatStr = new DecimalFormat("##.00%").format(percentNumber);

        return formatStr;
    }

    public static String FormatPercent(String percentage, String proportion) throws Exception {
        String formatStr = "";

        if ("0".equals(percentage)) {
            return "0.00%";
        }

        BigDecimal percentageDecimal = new BigDecimal(percentage, mathContext);
        BigDecimal proportionDecimal = new BigDecimal(proportion, mathContext);
        BigDecimal percentNumber     = percentageDecimal.divide(proportionDecimal, mathContext);

        formatStr = new DecimalFormat("#.00%").format(percentNumber);

        return formatStr;
    }

    public static void main(String[] args) {
        try {
            System.out.println(PercentUtil.FormatPercent(3, 5));
            System.out.println(PercentUtil.FormatPercent(321.23, 632.92));
            System.out.println(PercentUtil.FormatPercent("321.23", "632.92"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



