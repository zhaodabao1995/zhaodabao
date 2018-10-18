package light;



import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

 

public class UpdateJFrame extends JFrame
{
 private JLabel lb = new JLabel();
 private JTextField tf = new JTextField();
 private JButton bt = new JButton();

 public UpdateJFrame()
 {
  super("用户修改数据中");
  setSize(300, 250);
  setLocation(450, 200);
  setLayout(new GridLayout(6, 2, 10, 10));
  setVisible(true);
  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  WindowOperate ml = new WindowOperate();
  ml.getAddComponentListener(this, 300, 250);
 }

 public void add(JLabel lb)
 {
  this.lb = lb;
  add(lb);
 }

 public void add(JTextField tf)
 {
  this.tf = tf;
  add(tf);
 }

 public void add(JButton bt)
 {
  this.bt = bt;
  add(bt);
 }
}