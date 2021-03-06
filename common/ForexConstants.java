package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Class of constants.
 * Those constants are used in other classes.
 * Cannot be changed by user.
 */
public class ForexConstants {
    public static final String propFileName = "res\\properties.ini";
    public static final String defPropFileName = "res\\default properties.ini";

    public static ArrayList<String> PERIODS = new ArrayList<>();

    public static Map<String, Integer> MULTIPLIERS = new HashMap<>();



    //constants not to change
    public static final int UP_DIRECTION = 1;
    public static final int DOWN_DIRECTION = -1;
    public static final int ADVICE_UP = 2;
    public static final int ADVICE_CLOSE_DOWN = 1;
    public static final int ADVICE_STAY = 0;
    public static final int ADVICE_CLOSE_UP = -1;
    public static final int ADVICE_DOWN = -2;


    public static int UP_COUNTER; //to not make positions too frequently. bigger value - less pos
    public static int DOWN_COUNTER;
    public static double COMMISSION;
    public static double TAKE_PROFIT;
    //stopLoss = -money/STOP_LOSS_DIVIDER;
    public static double STOP_LOSS_DIVIDER;
    public static double DYNAMIC_STOP_LOSS_DIVIDER;
    public static double START_BALANCE;
    public static double PERCENT_OF_BALANCE; //money to open
    public static int UP_ADVICE_MIN_VALUE; //if the value is bigger advices to open up positions
    public static int DOWN_ADVICE_MAX_VALUE;
    public static double CLOSE_DOWN_MIN_VALUE;
    public static double CLOSE_UP_MAX_VALUE;
    public static int HIST_COUNT;


    public static double EX_SENS_4;// 35?+ 20?+ 13?~  IN %  DIFFERENT FOR PERIODS
    public static double EX_SENS_2;//defines sensitivity to extremes (for finding)
    public static double EX_SENS_5;
    public static int WIDTH_OF_REL_EX;
    public static int DEFAULT_MA;


    //coefficient of indicator for adviser
    public static double ADV_EX_LINES;
    public static double ADV_TREND_LINES;
    public static double ADV_TD_LINES;
    public static double ADV_INNER_TREND_LINE;
    public static double ADV_RSI;

    public static int WIDTH_OF_BAR;
    public static int gridPeriod; //period of marks of the grid


    public static double OVER_RES_LINE; //1.001;
    public static double OVER_TREND_LINE;
    public static double OVER_TD_LINE;
    public static double RES_LINE_SENS; //for covering 20?+ 15?~+ 13
    public static double TREND_LINE_SENS; //for covering 17
    public static double TD_LINE_SENS;

    public static void applySettings(){
        PERIODS.add("5");
        PERIODS.add("15");
        PERIODS.add("30");
        PERIODS.add("60");
        PERIODS.add("1440");

        MULTIPLIERS.put("EURUSD", 500);
        MULTIPLIERS.put("AUDUSD", 500);

        String sec = "common";
        RES_LINE_SENS = Double.parseDouble(Settings.properties.getProperty(sec+".RES_LINE_SENS"));
        TREND_LINE_SENS = Double.parseDouble(Settings.properties.getProperty(sec+".TREND_LINE_SENS"));
        HIST_COUNT = (int)Double.parseDouble(Settings.properties.getProperty(sec+".HIST_COUNT"));

        sec = "adviser";
        UP_COUNTER = (int)Double.parseDouble(Settings.properties.getProperty(sec + ".UP_COUNTER"));
        DOWN_COUNTER = (int)Double.parseDouble(Settings.properties.getProperty(sec+".DOWN_COUNTER"));
        UP_ADVICE_MIN_VALUE = (int)Double.parseDouble(Settings.properties.getProperty(sec+".UP_ADVICE_MIN_VALUE"));
        DOWN_ADVICE_MAX_VALUE = (int)Double.parseDouble(Settings.properties.getProperty(sec+".DOWN_ADVICE_MAX_VALUE"));
        CLOSE_DOWN_MIN_VALUE = (int)Double.parseDouble(Settings.properties.getProperty(sec+".CLOSE_DOWN_MIN_VALUE"));
        CLOSE_UP_MAX_VALUE = (int)Double.parseDouble(Settings.properties.getProperty(sec+".CLOSE_UP_MAX_VALUE"));
        //coefficient of indicator for adviser
        ADV_EX_LINES = Double.parseDouble(Settings.properties.getProperty(sec+".ADV_EX_LINES"));
        ADV_TREND_LINES = Double.parseDouble(Settings.properties.getProperty(sec+".ADV_TREND_LINES"));
        ADV_TD_LINES = Double.parseDouble(Settings.properties.getProperty(sec+".ADV_TD_LINES"));
        ADV_INNER_TREND_LINE = Double.parseDouble(Settings.properties.getProperty(sec+".ADV_INNER_TREND_LINE"));
        ADV_RSI = Double.parseDouble(Settings.properties.getProperty(sec+".ADV_RSI"));
        OVER_RES_LINE = Double.parseDouble(Settings.properties.getProperty(sec+".OVER_RES_LINE"));
        OVER_TREND_LINE = Double.parseDouble(Settings.properties.getProperty(sec+".OVER_TREND_LINE"));
        OVER_TD_LINE = Double.parseDouble(Settings.properties.getProperty(sec+".OVER_TD_LINE"));
        TD_LINE_SENS = Double.parseDouble(Settings.properties.getProperty(sec+".TD_LINE_SENS"));


        sec = "analyser";
        EX_SENS_4 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_4"));
        EX_SENS_2 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_2"));
        EX_SENS_5 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_5"));
        WIDTH_OF_REL_EX = (int)Double.parseDouble(Settings.properties.getProperty(sec+".WIDTH_OF_REL_EX"));
        DEFAULT_MA = (int)Double.parseDouble(Settings.properties.getProperty(sec+".DEFAULT_MA"));

        sec = "ui";
        WIDTH_OF_BAR = (int)Double.parseDouble(Settings.properties.getProperty(sec+".WIDTH_OF_BAR"));
        gridPeriod = (int)Double.parseDouble(Settings.properties.getProperty(sec+".GRID_PERIOD"));

        sec = "simulation";
        COMMISSION = Double.parseDouble(Settings.properties.getProperty(sec+".COMMISSION"));
        TAKE_PROFIT = Double.parseDouble(Settings.properties.getProperty(sec+".TAKE_PROFIT"));
        STOP_LOSS_DIVIDER = Double.parseDouble(Settings.properties.getProperty(sec+".STOP_LOSS_DIVIDER"));
        START_BALANCE = Double.parseDouble(Settings.properties.getProperty(sec+".START_BALANCE"));
        PERCENT_OF_BALANCE = Double.parseDouble(Settings.properties.getProperty(sec+".PERCENT_OF_BALANCE"));
    }

    public static void applyAdjustmentValues (){
        String sec = "adjustable";
        OVER_RES_LINE = Double.parseDouble(Settings.properties.getProperty(sec+".OVER_RES_LINE"));
        RES_LINE_SENS = Double.parseDouble(Settings.properties.getProperty(sec+".RES_LINE_SENS"));
        PERCENT_OF_BALANCE = Double.parseDouble(Settings.properties.getProperty(sec+".PERCENT_OF_BALANCE"));
        STOP_LOSS_DIVIDER = Double.parseDouble(Settings.properties.getProperty(sec+".STOP_LOSS_DIVIDER"));
        EX_SENS_4 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_4"));
        EX_SENS_2 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_2"));
        EX_SENS_5 = Double.parseDouble(Settings.properties.getProperty(sec+".EX_SENS_5"));
        TAKE_PROFIT = Double.parseDouble(Settings.properties.getProperty(sec+".TAKE_PROFIT"));
    }
}
