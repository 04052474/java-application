import java.awt.*;
import java.awt.event.*;

public class ScrollPaneDemo extends java.awt.Frame {

  // Main method
  public static void main(String[] args) {
    new ScrollPaneDemo();
  }

  // 建構函式
  public ScrollPaneDemo() {
    super("ScrollPane Demo");

    // 定義 Layout Manager 為 BorderLayout
    setLayout(new BorderLayout());

    // 捲軸面板
    ScrollPane scrollpane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
    // 支援滑鼠滾輪功能
    scrollpane.setWheelScrollingEnabled(true);

    // 自訂類別
    ImagePanel imagepanel = new ImagePanel();
    // 設定內置物件之最佳尺寸
    imagepanel.setPreferredSize(new Dimension(1280, 960));
    
    scrollpane.add(imagepanel);

    this.add(scrollpane, BorderLayout.CENTER);

    // 設定視窗的大小
    this.setSize(300, 300);

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

class ImagePanel extends java.awt.Panel {
  Image image;

  // 建構函式
  public ImagePanel() {
    ClassLoader cl = this.getClass().getClassLoader();
    Toolkit tk = Toolkit.getDefaultToolkit();

    // 取得圖像
    image = tk.createImage(cl.getResource("images/squirrel.jpg"));
  }

  public void paint(Graphics g) {
    // 繪製圖像
    g.drawImage(image, 0, 0, this);
  }

  public void update(Graphics g) {
    paint(g);
  }
}
