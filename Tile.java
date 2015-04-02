import java.awt.*;
import asciiPanel.AsciiPanel;

public enum Tile {
    AIR(' ', AsciiPanel.white),
    WALL((char)219, AsciiPanel.brightBlack),
    BOUNDS('x', AsciiPanel.black);

    public char symbol;
    public Color color;

    Tile(char symbol, Color color){
        this.symbol = symbol;
        this.color = color;
    }
}