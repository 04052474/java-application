import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GraphicsDemo extends java.awt.Frame implements MouseListener { // 實作MouseListener介面
  
  public static void main(String args[]){
    new GraphicsDemo();
  }
  
  // 建構函式
  public GraphicsDemo() {
    super("Graphics Demo");

    // 設定背景顏色
    this.setBackground(Color.white);

    // 註冊 MouseListener
    this.addMouseListener(this);

    // 設定視窗的大小
    this.setSize(250, 250);

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

  public void paint(Graphics g) {
    int r, x1, x2, y1, y2;
    int red, green, blue;

    Random random = new Random();

    int width = this.getSize().width;
    int height = this.getSize().height;

    for (int i=0; i<100; i++) {
      r = random.nextInt(9);
      x1 = random.nextInt(width);  
      y1 = random.nextInt(height); 
      x2 = random.nextInt(width); 
      y2 = random.nextInt(height);  
      red = random.nextInt(255); 
      green = random.nextInt(255); 
      blue = random.nextInt(255); 
      
      // 設定Graphics物件之目前顏色
      g.setColor(new Color(red, green, blue)); 

      switch (r) {
        case 0:
          g.drawLine(x1, y1, x2, y2);  
          break;
        case 1:
          g.draw3DRect(x1, y1, x2-x1, y2-y1, true); 
          break;
        case 2:
          g.drawOval(x1, y1, x2-x1, y2-y1); 
          break;
        case 3:
          g.drawRect(x1, y1, x2-x1, y2-y1); 
          break;
        case 4:
          g.drawRoundRect(x1, y1, x2-x1, y2-y1, 10, 10); 
          break;
        case 5:
          g.fill3DRect(x1, y1, x2-x1, y2-y1, true); 
          break;
        case 6:
          g.fillOval(x1, y1, x2-x1, y2-y1); 
          break;
        case 7:
          g.fillRect(x1, y1, x2-x1, y2-y1); 
          break;
        case 8:
          g.fillRoundRect(x1, y1, x2-x1, y2-y1, 10, 10); 
          break;
        default:
          break;
      }
    }
  }

  // 實作MouseListener介面之方法
  public void mouseClicked(MouseEvent e) {
    this.repaint();
  }

  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
}