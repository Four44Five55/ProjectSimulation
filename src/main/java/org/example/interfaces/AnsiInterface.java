package org.example.interfaces;

public interface AnsiInterface {
    //System.out.println(ANSI_EMPTY+ANSI_PREDATOR+ANSI_HERBIVORE+ANSI_TREE+ANSI_GRASS+ANSI_ROCK+ANSI_RESET);
    public static final String ANSI_RESET="\u001b[0m";
    public static final String ANSI_GRAY_BACKGROUND="\u001b[48;5;247m";
    public static final String ANSI_RED_BACKGROUND="\u001b[48;5;9m";
    public static final String ANSI_PINK_BACKGROUND="\u001b[48;5;213m";
    public static final String ANSI_GREEN_BACKGROUND="\u001b[48;5;22m";
    public static final String ANSI_LIGHT_GREEN_BACKGROUND="\u001b[48;5;40m";
    public static final String ANSI_BROWN_BACKGROUND="\u001b[48;5;130m";

/*    public static final String ANSI_EMPTY=ANSI_GRAY_BACKGROUND+"\uD83C\uDFFF";
    public static final String ANSI_PREDATOR=ANSI_RED_BACKGROUND+"\uD83D\uDC3A";
    public static final String ANSI_HERBIVORE=ANSI_PINK_BACKGROUND+"\uD83D\uDC07";
    public static final String ANSI_TREE=ANSI_GREEN_BACKGROUND+"\uD83C\uDF33";
    public static final String ANSI_GRASS=ANSI_LIGHT_GREEN_BACKGROUND+"\uD83C\uDF3C";
    public static final String ANSI_ROCK=ANSI_BROWN_BACKGROUND+"\uD83E\uDDF1";*/

    public static final String ANSI_EMPTY="\uD83C\uDFFF";
    public static final String ANSI_PREDATOR="\uD83D\uDC3A";
    public static final String ANSI_HERBIVORE="\uD83D\uDC07";
    public static final String ANSI_TREE="\uD83C\uDF33";
    public static final String ANSI_GRASS="\uD83C\uDF3C";
    public static final String ANSI_ROCK="\uD83E\uDDF1";
}
