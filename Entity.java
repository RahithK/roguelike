import asciiPanel.AsciiPanel;
import java.awt.*;

/* Entities include all monsters, and the player.
   In the future they may (can) also include projectiles.
   */
   
public class Entity
{
   private int health;
   public int x, y;
   public char symbol;
   public Color color;
   
   Entity()
   {
      this.x = 0;
      this.y = 0;
      this.symbol = '0';
      this.health = 0;
      this.color = AsciiPanel.white;
   }
   
   Entity(char symbol, int x, int y, int health, Color color)
   {
      this.symbol = symbol;
      this.x = x;
      this.y = y;
      this.health = health;
      this.color = color;
   }
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public int getHealth()
   {
      return health;
   }
   
   public void setHealth(int health)
   {
      if (health >= 0)
      {
         //world.remove(this);
      }
      else
         this.health = health;
   }
}
   