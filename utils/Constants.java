package utils;

import java.util.ArrayList;
import java.util.Arrays;

public final class Constants {

    public Constants() {}

    private static final String[] aux = {"clubs", "spades", "diamonds", "hearts"};
    public static final ArrayList<String> SUITS = new ArrayList<String>(Arrays.asList(aux));
    public static final int LOWEST_VALUE = 2;
    public static final int HIGHEST_VALUE = 15;
    public static final int CARD_WIDTH = 100;
    public static final int CARD_HEIGHT = 100;
    public static final int DECK_SIZE = 14;
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int CENTER_HOR = FRAME_WIDTH / 2;
    public static final int CENTER_VERT = FRAME_HEIGHT / 2;
    public static final int PLAYER_WINS = 1;
    public static final int DEALER_WINS = 2;
    public static final int ERROR_EVALUATION = 3;
}
