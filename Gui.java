package light;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener{
	private JPanel penter = new JPanel();
	private JPanel pcontrol = new JPanel();
	private JLabel username = new JLabel("用户名");
	private JLabel pwd = new JLabel("密码");
	private JLabel ip = new JLabel("I P");
	private JLabel port = new JLabel("端口");
	private JLabel dbname = new JLabel("数据库");
	private JTextField tusername=new JTextField();
	private JTextField tpwd=new JTextField();
	private JTextField tip=new JTextField();
	private JTextField tport=new JTextField();
	private JTextField tdbname=new JTextField();
	private JButton conn=new JButton("连接");
	WindowOperate ml = null;
	UserModel um = null;
	public Gui() {
		super("登录页面");
		lunachframe();
		ml = new WindowOperate();
		ml.getAddComponentListener(this, 300, 250);
		ml.getaddWindowListener(this);
		um = new UserModel();
	}
	
	private void lunachframe() {
		setLayout(new BorderLayout());
		penter.setLayout(new GridLayout(5, 2, 10, 10));
		penter.add(username);
		penter.add(tusername);
		penter.add(pwd);
		penter.add(tpwd);
		penter.add(ip);
		penter.add(tip);
		penter.add(port);
		penter.add(tport);
		penter.add(dbname);
		penter.add(tdbname);
		pcontrol.add(conn);
		conn.addActionListener(this);
		add(penter, BorderLayout.NORTH);
		add(pcontrol, BorderLayout.SOUTH);
		setSize(300, 450);
		setLocation(450, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		Gui Test = new Gui();
		Test.setVisible(true);
	}
	public void conn() {
		String username1=tusername.getText();
		String pwd1=tpwd.getText();
		String ip1=tip.getText();
		String port1=tport.getText();
		String dbname1=tdbname.getText();
		
		
		if (um.connect(username1, pwd1, ip1, port1, dbname1) == true) {
			setVisible(false);
			getdialog("数据库连接成功。提示：查询仅需输入数字编号，请勿输入其他内容！");
			UserManager user = new UserManager();
		} else {
			getdialog("数据库连接失败，请修改配置。");
		}
	}
	public void getdialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == conn) {
			conn();
			}
	}
}
