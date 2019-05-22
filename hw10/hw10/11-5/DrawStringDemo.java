import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawStringDemo extends java.awt.Frame implements MouseListener, MouseMotionListener {
  String str = "";
  
  int x, y;
  
  public static void main(String args[]){
    new DrawStringDemo();
  }
  
  // 建構函式
  public DrawStringDemo() {
    super("Draw String Demo");

    // 設定背景顏色
    setBackground(Color.white);

    // 預設滑鼠指標
    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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
    // 設定Graphics物件之目前顏色
    g.setColor(Color.white);
    // 繪製矩形並以目前指定之顏色填滿面積
    // 則清除畫面
    g.fillRect(0, 0, this.getSize().width, this.getSize().height);

    // 設定Graphics物件之目前顏色
    g.setColor(Color.RED);

    // 設定Graphics物件之文字字型
    g.setFont(new Font("dialog", Font.PLAIN, 12));
    
    // 繪製文字
    g.drawString(str, 10, 40);


    // 設定Graphics物件之目前顏色
    g.setColor(Color.BLACK);

    g.drawLine(x, 0, x, this.getSize().height);  
    g.drawLine(0, y, this.getSize().width, y);  
  }

  // 實作MouseListener介面之方法
  public void mousePressed(MouseEvent e){
    x = e.getX();
    y = e.getY();
    
    str = "Mouse Pressed at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseReleased(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Released at: " + x + ", " + y;
    repaint();
  }

  public void mouseClicked(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Clicked at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseEntered(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Entered at: " + x + ", " + y;
    repaint();
  }
  
  public void mouseExited(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Exited at: " + x + ", " + y;
    repaint();
  }
  
  // 實作MouseMotionListener介面之方法
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Dragged at: " + x + ", " + y;
    repaint();
  }

  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y = e.getY();

    str = "Mouse Moved at: " + x + ", " + y;
    repaint();
  }
}
