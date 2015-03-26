import java.awt.*;
import asciiPanel.AsciiPanel;

public class Player extends Entity
{
   Player()
   {
      super();
      this.color = AsciiPanel.green;
   }
   
   Player(int x, int y)
   {
      this.symbol = '@';
      this.x = x;
      this.y = y;
      this.color = AsciiPanel.green;
   }
   
   Player(Point p)
   {
      this.symbol = '@';
      this.x = p.x;
      this.y = p.y;
      this.color = AsciiPanel.green;
   }
}