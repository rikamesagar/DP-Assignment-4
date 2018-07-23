/**
 *Class to create log messages and write to the log file
 */

package maxKVisitors.util;

public class MyLogger {
    public static enum DebugLevel {CONSTRUCTOR, FILEREAD, VISITOR, OUTPUT, NONE};

    private static DebugLevel debugLevel;


    public MyLogger(int levelIn) {

        this.setDebugValue(levelIn);
    }

    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 4: debugLevel = DebugLevel.FILEREAD; break;
            case 3: debugLevel = DebugLevel.OUTPUT; break;
            case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
            case 1: debugLevel = DebugLevel.VISITOR; break;
            case 0: debugLevel = DebugLevel.NONE; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage (String message, DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    public static DebugLevel convertToDebugVal(int levelIn){
        DebugLevel temp = null;
        try{
            if(levelIn >4 || levelIn < 0){
                throw new RuntimeException("Invalid myLogger level");
            }
            switch (levelIn){
                case 4: temp = DebugLevel.FILEREAD; break;
                case 3: temp = DebugLevel.OUTPUT; break;
                case 2: temp = DebugLevel.CONSTRUCTOR; break;
                case 1: temp = DebugLevel.VISITOR; break;
                case 0: temp = DebugLevel.NONE; break;
            }
        }catch(RuntimeException e){
            e.printStackTrace();
            System.exit(3);
        }
        return temp;
    }
}