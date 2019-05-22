import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AudioClipDemo extends java.applet.Applet implements Runnable, MouseListener {
  int width, height;

  int x = 0, y = 0;  
  int dx = 1, dy = 1;  

  boolean horizontal = true;
  
  Image image;
  AudioClip clip;

  // 執行緒
  Thread thread;

  // 建構函式
  public AudioClipDemo() {
  }
  
  public void init(){
    setBackground(Color.white);

    // Applet Size
    width = this.getSize().height;
    height = this.getSize().width;

    // 讀取Java Archive檔案內的圖像檔案
    ClassLoader cl = this.getClass().getClassLoader();
    Toolkit tk = Toolkit.getDefaultToolkit();

    // 取得圖像
    image = tk.createImage(cl.getResource("images/duke.gif"));

    // 取得音效檔案
    clip = getAudioClip(cl.getResource("audio/sound.au"));       
    
    // 註冊 MouseListener
    this.addMouseListener(this);    
  }

  public void start() {
    thread = new Thread(this);
    // 開始執行緒
    thread.start();
  }

  public void stop() {
    // 停止執行緒
    thread.yield();
  }

  public void destroy()  {
    // 停止執行緒
    thread.yield();
  }

  public void run() {
    while (true) {
      if (horizontal) {
        if (x > width - 50)  {
          dx = -1;
  
          // 播放音效
          clip.play();
        }
        else if (x < 0) {
          dx = +1;
  
          // 播放音效
          clip.play();
        }
  
        x = x + dx;
      }
      else {
        if (y > height - 55)  {
          dy = -1;
  
          // 播放音效
          clip.play();
        }
        else if (y < 0) {
          dy = +1;
  
          // 播放音效
          clip.play();
        }
  
        y = y + dy;
      }

      repaint();

      try {
        // 暫停執行緒
        Thread.sleep(20);
      }
      catch (InterruptedException ex) { }
    }
  }

  public void update(Graphics g) {
    paint(g);
  }

  public void paint(Graphics g) {
    // Applet Size
    width = this.getSize().height;
    height = this.getSize().width;

    // 設定Graphics物件之目前顏色
    g.setColor(Color.white);
    // 繪製矩形並以目前指定之顏色填滿面積
    // 則清除畫面
    g.fillRect(0, 0, width, height);
    
    // 繪製圖像
    g.drawImage(image, x, y, null);
  }

  // 實作MouseListener介面之方法
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseClicked(MouseEvent e){
    if (horizontal)
      horizontal = false;
    else
      horizontal = true;

    repaint(); 
  }
  
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
}
