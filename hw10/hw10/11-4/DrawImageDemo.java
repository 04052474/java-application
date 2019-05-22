import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawImageDemo extends java.awt.Frame implements MouseListener, MouseMotionListener {
  int x, y, x1, x2, y1, y2;

  Image image;
  
  boolean mouseUp = false, mouseDrag = false;
  
  public static void main(String args[]){
    new DrawImageDemo();
  }
  
  // 建構函式
  public DrawImageDemo() {
    super("Draw Image Demo");

    // 設定背景顏色
    setBackground(Color.white);

    // 讀取Java Archive檔案內的圖像檔案
    ClassLoader cl = this.getClass().getClassLoader();
    Toolkit tk = Toolkit.getDefaultToolkit();

    // 取得圖像
    image = tk.createImage(cl.getResource("images/SuperDuke.gif"));

    // 註冊 MouseListener
    this.addMouseListener(this);    
    // 註冊 MouseMotionListener
    this.addMouseMotionListener(this);    

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

  public void update(Graphics g) {
    paint(g);
  }

  public void paint (Graphics g) {
    if (mouseUp || mouseDrag) {
      int imgWidth = x2 - x1;
      int imgHeight = y2 - y1; 
      
      // 設定Graphics物件之目前顏色
      g.setColor(Color.white);
      // 繪製矩形並以目前指定之顏色填滿面積
      // 則清除畫面
      g.fillRect(0, 0, this.getSize().width, this.getSize().height);
      
      // 繪製圖像並縮放圖像至指定之寬度與高度  
      g.drawImage(image, x1, y1, imgWidth, imgHeight, null);
    }
  }

  // 實作MouseListener介面之方法
  public void mousePressed(MouseEvent e) {
    x1 = e.getX();
    y1 = e.getY();
    mouseUp = false;
    mouseDrag = false;
  }

  public void mouseReleased(MouseEvent e) {
    mouseUp = true;
    repaint(); 
  }
  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}

  // 實作MouseMotionListener介面之方法
  public void mouseDragged(MouseEvent e) {
    x2 = Math.max(e.getX(), x1);
    y2 = Math.max(e.getY(), y1);
    x1 = Math.min(e.getX(), x1);
    y1 = Math.min(e.getY(), y1);

    mouseDrag = true;
    repaint(); 
  }

  public void mouseMoved(MouseEvent e){}
}
