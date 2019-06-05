import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class SpringLayoutDemo extends javax.swing.JFrame {

  // Main method
  public static void main(String[] args) {
    UIManager.put("swing.boldMetal", Boolean.FALSE);
    JDialog.setDefaultLookAndFeelDecorated(true);
    JFrame.setDefaultLookAndFeelDecorated(true);
    Toolkit.getDefaultToolkit().setDynamicLayout(true);

    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    new SpringLayoutDemo();
  }

  // 建構函式
  public SpringLayoutDemo() {
    super("Spring Layout Demo");

    // 直接定義JFrame之Layout Manager為BorderLayout
    this.setLayout(new BorderLayout());

    // 取得目前之Class Loader
    ClassLoader cl = this.getClass().getClassLoader();
    
    JPanel jpanel = new JPanel();
    // 定義JPanel之Layout Manager為SpringLayout
    jpanel.setLayout(new SpringLayout());

    // 取得JPanel之Layout Manager
    SpringLayout layout = (SpringLayout)jpanel.getLayout();
    
    // JButton 1
    JButton jbutton1 = new JButton("Button 1",new ImageIcon(cl.getResource("images/dance.gif")));
    jpanel.add(jbutton1);
    
    // 設定Spring物件，代表邊緣間的最佳距離
    Spring x = Spring.constant(10);
    Spring y = Spring.constant(10);
    // 取得物件的限制
    SpringLayout.Constraints spConstraints = layout.getConstraints(jbutton1);
    // 設定Spring的水平屬性值
    spConstraints.setX(x);
    // 設定Spring的垂直屬性值
    spConstraints.setY(y);

    // JButton 2
    JButton jbutton2 = new JButton("button 2",new ImageIcon(cl.getResource("images/dance.gif")));
    jpanel.add(jbutton2);
    
    // 以兩Spring物件的相加定義Spring物件
    x = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.EAST)); 
    y = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.SOUTH)); 
    // 取得物件的限制
    spConstraints = layout.getConstraints(jbutton2);
    // 設定Spring的水平屬性值
    spConstraints.setX(x);
    // 設定Spring的垂直屬性值
    spConstraints.setY(y);

    // JButton 3
    JButton jbutton3 = new JButton("Button 3", new ImageIcon(cl.getResource("images/dance.gif")));
    jpanel.add(jbutton3);
    
    // 以兩Spring物件的相加定義Spring物件
    x = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.EAST)); 
    y = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.SOUTH)); 
    // 取得物件的限制
    spConstraints = layout.getConstraints(jbutton3);
    // 設定Spring的水平屬性值
    spConstraints.setX(x);
    // 設定Spring的垂直屬性值
    spConstraints.setY(y);
	
	JButton jbutton4 = new JButton("Button 4", new ImageIcon(cl.getResource("images/dance.gif")));
    jpanel.add(jbutton4);
    
    // 以兩Spring物件的相加定義Spring物件
    x = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.EAST)); 
    y = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.SOUTH)); 
    // 取得物件的限制
    spConstraints = layout.getConstraints(jbutton4);
    // 設定Spring的水平屬性值
    spConstraints.setX(x);
    // 設定Spring的垂直屬性值
    spConstraints.setY(y);
	
	JButton jbutton5 = new JButton("Button 5", new ImageIcon(cl.getResource("images/dance.gif")));
    jpanel.add(jbutton5);
    
    // 以兩Spring物件的相加定義Spring物件
    x = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.EAST)); 
    y = Spring.sum(Spring.constant(20), spConstraints.getConstraint(SpringLayout.SOUTH)); 
    // 取得物件的限制
    spConstraints = layout.getConstraints(jbutton5);
    // 設定Spring的水平屬性值
    spConstraints.setX(x);
    // 設定Spring的垂直屬性值
    spConstraints.setY(y);
    
    this.add(jpanel, BorderLayout.CENTER);

    // 設定視窗的大小
    this.setSize(400, 250);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // 顯示視窗
    this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
