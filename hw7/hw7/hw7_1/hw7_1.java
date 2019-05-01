import java.awt.*;
import java.awt.event.*;

public class hw7_1 extends java.awt.Frame {

  public static void main(String args[]){
    new hw7_1();
  }
  
  // �غc�禡
  public hw7_1() {
    super("hw7_1 Scrollbar Demo");

    // �w�q Layout Manager �� BorderLayout
    setLayout(new BorderLayout());

    java.awt.Scrollbar scrollbar;

    // �غc�禡 1
    scrollbar = new Scrollbar();
    // �]�w���b�̤j��
    scrollbar.setMaximum(500);
    // �]�w���b�̤p��
    scrollbar.setMinimum(0);
    // �]�w���b���t�m��V���������b
    scrollbar.setOrientation(Scrollbar.VERTICAL);
    // �]�w���b������j�p��
    scrollbar.setVisibleAmount(10);
    // �]�w���b���ثe��
	scrollbar.setBlockIncrement(15);
	scrollbar.setUnitIncrement(3);
    scrollbar.setValue(300);
    add(scrollbar, BorderLayout.EAST);

    // �غc�禡 3
    // �]�w�t�m��V���������b
    //     �ثe�Ȭ�100
    //     ���b����j�p�Ȭ�60
    //     �̤p�Ȭ�0
    //     �̤j�Ȭ�300
//    scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 100, 60, 0, 300);
//    add(scrollbar, BorderLayout.SOUTH);

    // �]�w�������j�p
    this.setSize(200, 200);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // ��ܵ���
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
