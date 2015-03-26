import java.io.*;
public class Test
{
   public static void main(String[] args) throws IOException
   {
      //String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9a", "10a", "11a"};
      for (int i = 0; i < 10; i++)
         SimpleFiles.add("test.txt", "ABC" + (int)(Math.random()*100));
   }
}