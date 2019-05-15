import java.awt.*;
import java.awt.event.*;

public class FileDialog extends java.awt.FileDialog {

  Frame parent;
  Button btnOK, btnCancel;
  String title, text;
  boolean state, modal;
  
  // �غc�禡
  public FileDialog(Frame parent, String title, int mode) {
    super(parent, title, mode);

    
    // �]�w��ܲ��O�_���L��ؤμ��D�C�˦�
    this.setUndecorated(false);

    // �]�w��ܲ����j�p
    this.setSize(220, 120);
    
    Dimension frameSize = parent.getSize();
    Dimension dialogSize = this.getSize();
    
    this.setLocation(
      (frameSize.width - dialogSize.width) / 2 + parent.getLocation().x,
      (frameSize.height - dialogSize.height) / 2 + parent.getLocation().y);

    // ��ܹ�ܲ�
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void WindowDeactivated(WindowEvent e) {
        setVisible(false);
      }
    });
  }

  
}
