import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class hw11_1 extends javax.swing.JFrame {

  // Main method
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    new hw11_1();
  }

  // 建構函式
  public hw11_1() {
    super(" hw11_1 Hello World JFrame");

    //this.setUndecorated(true);
    //this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

    DisplayPanel displayPanel = new DisplayPanel();

    // JDK 1.4的用法
    // 取得其Content Pane 
    //Container contentPane = getContentPane();
    // 定義 Layout Manager 為 BorderLayout
    //contentPane.setLayout(new BorderLayout());
    // 將物件加至Content Pane中
    //contentPane.add(displayPanel, BorderLayout.CENTER);

    // JDK 5.0之後的用法
    // 直接定義JFrame之Layout BorderLayout
    this.setLayout(new BorderLayout());
    this.add(displayPanel, BorderLayout.CENTER);

    this.validate();
    this.setSize(new Dimension(200, 200));

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}

class DisplayPanel extends javax.swing.JPanel {
  public DisplayPanel() {
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString("Hello MCU", 50, 50);
  }
}
