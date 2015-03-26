import asciiPanel.AsciiPanel;
import java.util.*;

public class World
{
   public int width, height;
   public Tile[][] tiles;
   public List<Entity> entities;
   
   public World(int x, int y)
   {
      Tile[][] tiles = floorGenerator(x, y);
      this.tiles = tiles;
      this.width = tiles.length;
      this.height = tiles[0].length;
   }
   
   /* Method returns a selected tile in the map,
      if the tile is out of bounds then it returns the BOUNDS tile
      reserved for out of bounds tiles.
      */
   public Tile tile(int x, int y)
   {
      if(x < 0 || x >= width || y < 0 || y >= height)
         return Tile.BOUNDS;
      else
         return tiles[x][y];
   }
   
   /* Method returns a newly generated level layout
      of size x by y.
      */
   public Tile[][] floorGenerator(int x, int y)
   {
      Tile[][] tiles = new Tile[x][y];
      for (int i = 0; i < x; i++)
      {
         for (int ii = 0; ii < y; ii++)
         {
            if (i == 0 || ii == 0 || i == x-1 || ii == y-1)
               tiles[i][ii] = Tile.WALL;
            else
               tiles[i][ii] = Tile.AIR;
         }
      }
      return tiles;
   }
   
   public Point findEmptySpace()
   {
      Point p = new Point();
      
      do
      {
         p.x = (int)(Math.random() * width);
         p.y = (int)(Math.random() * height);
      } while (tile(p.x, p.y) != Tile.AIR);
      
      return p;
   }
   
   public Entity entity(int x, int y)
   {
      for (Entity entity : entities)
      {
         if (entity.x == x && entity.y == y)
            // if there are two entities at one spot (there shouldn't be!) this method doesnt care - returns the first.
            return entity;
      }
      // if there is no entity at such position (xy)
      return null;
   }
}