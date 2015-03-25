import asciiPanel.AsciiPanel;
import java.awt.*;

public class MenuItemList
{
   public MenuItem[] items;
   public int selected;
      
   public MenuItemList(String ... itemStrings)
   {
      items = new MenuItem[itemStrings.length];
      for (int n = 0; n < items.length; n++)
      {
         items[n] = new MenuItem(itemStrings[n]);
         this.selected = 0; //the ^top one
      }
   }
   
   //draws the MenuItems' menu items,
   //                     bottom is where the final MenuItems menu item should be written
   public void drawList(AsciiPanel terminal, int bottom)
   {
      for(int n = items.length-1; n >= 0; n--) //from the back of the items array to the fronmt
      {
         Color c;
         if (n != selected)
           c = items[n].color;
         else
           c = AsciiPanel.blue;
         
         terminal.writeCenter(selected + " " + items[n].text, bottom+n, c);
      }
   }
   
   public void select(int direction) //the direction you'd like to select -1 = back 1, 1 = forward 1
   {
      this.selected += direction;
      if(this.selected == this.items.length)
         this.selected = 0;
      else if(this.selected == -1)
         this.selected = this.items.length -1;
   }
}