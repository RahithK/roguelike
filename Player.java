import java.awt.*;
import asciiPanel.AsciiPanel;

public class Player extends Entity
{
   Player()
   {
      super();
      this.color = new Color(200, 255, 200);
   }
   
   Player(int x, int y)
   {
      this.symbol = '@';
      this.x = x;
      this.y = y;
      this.color = new Color(200, 255, 200);
   }
   
   Player(Point p)
   {
      this.symbol = '@';
      this.x = p.x;
      this.y = p.y;
      this.color = new Color(200, 255, 200);
   }
}