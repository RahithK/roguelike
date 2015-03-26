/* ConsoleHelper by Alistair Carscadden 2015
   this class includes (or should include) all helpeful methods for drawing onto the terminal */
import asciiPanel.AsciiPanel;   

public class ConsoleHelper
{
   private static char corner = '+';
   private static char hor = '-';
   private static char ver = '|';
   private static char fill = ' ';
   
   public static void rect(AsciiPanel terminal, int x, int y, int w, int h)
   {
      for (int i = x; i < x+w; i++)
      {
         for (int ii = y; ii < y+h; ii++)
         {
            terminal.setCursorX(i);
            terminal.setCursorY(ii);
            // if corner
            if (i == x && ii == y)
               terminal.write(corner);
            else if (i == x && ii == y + h - 1)
               terminal.write(corner);
            else if (i == x + w - 1 && ii == y)
               terminal.write(corner);
            else if (i == x + w - 1 && ii == y + h - 1)
               terminal.write(corner);
            //if vertical wall
            else if (i == x || i == x + w - 1)
               terminal.write(ver);
            //if horizontal wall
            else if (ii == y || ii == y + h - 1)
               terminal.write(hor);
            //if fill
            else
               terminal.write(fill);
         }
      }
   }
   
   public static void rectNoFill(AsciiPanel terminal, int x, int y, int w, int h)
   {
      for (int i = x; i < x+w; i++)
      {
         for (int ii = y; ii < y+h; ii++)
         {
            terminal.setCursorX(i);
            terminal.setCursorY(ii);
            // if corner
            if (i == x && ii == y)
               terminal.write(corner);
            else if (i == x && ii == y + h - 1)
               terminal.write(corner);
            else if (i == x + w - 1 && ii == y)
               terminal.write(corner);
            else if (i == x + w - 1 && ii == y + h - 1)
               terminal.write(corner);
            //if vertical wall
            else if (i == x || i == x + w - 1)
               terminal.write(ver);
            //if horizontal wall
            else if (ii == y || ii == y + h - 1)
               terminal.write(hor);
         }
      }
   }
   
   public static void writeCenterArray(AsciiPanel terminal, String[] s, int y)
   {
      for (int i = 0; i < s.length; i++)
      {
         terminal.writeCenter(s[i], y + i);
      }
   }
}