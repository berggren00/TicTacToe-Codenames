package utils;

public class Ansi {
    //prevent instantiation
    private Ansi(){
        throw new AssertionError();
    }

    public static final String RESET = "\33[0m";
    public static final String FG = "\33[27m";
    public static final String BG = "\33[7m";
    public static final String BOLD = "\33[1m";
    public static final String DIM = "\33[2m";
    public static final String ITALIC = "\33[3m";
    public static final String NO_VARIANT = "\33[22m";
    public static final String UNDERLINE = "\33[4m";
    public static final String NO_UNDERLINE = "\33[24m";
    public static final String BLACK = "\33[30m";
    public static final String RED = "\33[31m";
    public static final String GREEN = "\33[32m";
    public static final String YELLOW = "\33[33m";
    public static final String BLUE = "\33[34m";
    public static final String MAGENTA = "\33[35m";
    public static final String CYAN = "\33[36m";
    public static final String WHITE = "\33[37m";
    public static final String BRIGHT_BLACK = "\33[90m";
    public static final String BRIGHT_RED = "\33[91m";
    public static final String BRIGHT_GREEN = "\33[92m";
    public static final String BRIGHT_YELLOW = "\33[93m";
    public static final String BRIGHT_BLUE = "\33[94m";
    public static final String BRIGHT_MAGENTA = "\33[95m";
    public static final String BRIGHT_CYAN = "\33[96m";
    public static final String BRIGHT_WHITE = "\33[97m";
    public static final String CURSOR_HIDE = "\33[?25l";
    public static final String CURSOR_SHOW = "\33[?25h";
    public static final String CLEAR_SCREEN = "\33[2J";
    public static final String CLEAR_LINE = "\33[2K";
}
