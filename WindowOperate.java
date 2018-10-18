package light;



import java.awt.event.ComponentAdapter;

 

import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

public class WindowOperate
{
 private JFrame jf;
 private JFrame jf2;
 private int limitewidth = 0;
 private int limiteheight = 0;

 public void getAddComponentListener(final JFrame jf, final int limitewidth,
   final int limiteheight)
 {
  this.jf = jf;
  this.limitewidth = limitewidth;
  this.limiteheight = limiteheight;
  jf.addComponentListener(new ComponentAdapter()
  {
   public void componentResized(ComponentEvent e)
   {
    int width = e.getComponent().getWidth();
    int height = e.getComponent().getHeight();
    if (width < limitewidth)
    {
     width = limitewidth;
    }
    if (height < limiteheight)
    {
     height = limiteheight;
    }
    jf.setSize(width, height);
   }
  });
 }

 public void getaddWindowListener(final JFrame jf)
 {
  this.jf = jf;
  jf.addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    System.exit(0);
   }
  });
 }

 public void getaddWindowListener(final JFrame jf, final JFrame jf2)
 {
  this.jf = jf;
  this.jf2 = jf2;
  jf.addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    jf.setVisible(false);
    jf2.setVisible(true);
   }
  });
 }

 public void refreshWindow(final JFrame jf)
 {
  jf.setVisible(false);
  jf.setVisible(true);
 }
}