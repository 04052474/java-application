import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawImageDemo extends java.awt.Frame implements MouseListener, MouseMotionListener {
  int x, y;

  Image image;
  
  boolean blnDrag = false;
  
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
    if (blnDrag) {
      // 設定Graphics物件之目前顏色
      g.setColor(Color.white);
      // 繪製矩形並以目前指定之顏色填滿面積
      // 則清除畫面
      g.fillRect(0, 0, this.getSize().width, this.getSize().height);
      
      // 繪製圖像
      g.drawImage(image, x, y, null);
    }
  }

  // 實作MouseListener介面之方法
  public void mousePressed(MouseEvent e){
    blnDrag = true;
  }
  
  public void mouseReleased(MouseEvent e){
    blnDrag = false;
  }
  
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  
  // 實作MouseMotionListener介面之方法
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();

    repaint();
  }

  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y = e.getY();

    repaint();
  }
}
