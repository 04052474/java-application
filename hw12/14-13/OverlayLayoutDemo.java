import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class OverlayLayoutDemo extends javax.swing.JFrame {

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

    new OverlayLayoutDemo();
  }

  // 建構函式
  public OverlayLayoutDemo() {
    super("Overlay Layout Demo");

    // 直接定義JFrame之Layout Manager為BorderLayout
    this.setLayout(new BorderLayout());

    JPanel jpanel = new JPanel();

    // 定義Layout Manager為OverlayLayout
    jpanel.setLayout(new OverlayLayout(jpanel));
    
    JButton jbutton1 = new JButton("Button 1");
    // 設定 jbutton1 的水平對齊點
    jbutton1.setAlignmentX(0.0f);
    // 設定 jbutton1 的垂直對齊點
    jbutton1.setAlignmentY(0.5f);
    // 設定最小尺寸
    jbutton1.setMinimumSize(new Dimension(100, 100));
    // 設定最佳尺寸
    jbutton1.setPreferredSize(new Dimension(200, 200));
    // 設定最大尺寸
//    jbutton1.setMaximumSize(new Dimension(150, 150));
    jpanel.add(jbutton1);

    JButton jbutton2 = new JButton("Button 2");
    // 設定 jbutton2 的水平對齊點
    jbutton2.setAlignmentX(0.5f);
    // 設定 jbutton2 的垂直對齊點
    jbutton2.setAlignmentY(0.0f);
    // 設定最小尺寸
    jbutton2.setMinimumSize(new Dimension(100, 100));
    // 設定最佳尺寸
    jbutton2.setPreferredSize(new Dimension(200, 200));
    // 設定最大尺寸
//    jbutton2.setMaximumSize(new Dimension(150, 150));
    jpanel.add(jbutton2);

    this.add(jpanel, BorderLayout.CENTER);
    
    // 設定視窗的大小
    this.setSize(250, 150);

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
