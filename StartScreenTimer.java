import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreenTimer implements ActionListener
{
   Timer timer;
   
   public StartScreenTimer()
   {
       timer = new Timer(1000, this);
       timer.start();
   }
   
   public void actionPerformed(ActionEvent e)
   {
      System.out.println("garbage" + System.currentTimeMillis());
   }
}