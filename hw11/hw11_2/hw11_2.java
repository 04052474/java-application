import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.UIManager;

public class hw11_2 extends javax.swing.JFrame implements ActionListener{
	
	
  
  String item[] = {
    "Metal","CDE/Motif","Windows XP","Windows Classic","GTK+","Mac"};
	String classname[] = {
    "javax.swing.plaf.metal.MetalLookAndFeel", 
    "com.sun.java.swing.plaf.motif.MotifLookAndFeel", 
    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel", 
    "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel", 
    "com.sun.java.swing.plaf.gtk.GTKLookAndFeel",
    "com.sun.java.swing.plaf.mac.MacLookAndFeel"};
  // Main method
  public static void main(String[] args) {

	try {
      // �]�w�P�@�~�t�Φ�����Look and Feel
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
	
    new hw11_2();
  }

  // �غc�禡
  // ���ե�
  public hw11_2() {
    super("hw11_2 Look and Feel Demo");

    // �����w�qJFrame��Layout Manager��FlowLayout
    this.setLayout(new FlowLayout());

    JMenuBar jmenubar = createJMenuBar();

    // �w�q�����ϥΪ̤��������C
    this.setJMenuBar(jmenubar);

    // �]�w�������j�p
    this.setSize(250, 150);

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
   private JMenuBar createJMenuBar() {
	   JMenuBar jmenubar = new JMenuBar();
	   JMenu jmenuLF = new JMenu("L&F");

    // �غc�s��
    ButtonGroup group = new ButtonGroup();
	JRadioButtonMenuItem[] jrbmenuitem = new JRadioButtonMenuItem[6];
	
    for (int i=0; i<item.length; i++) {
      jrbmenuitem[i] = new JRadioButtonMenuItem(item[i]);
      jmenuLF.add(jrbmenuitem[i]);
      group.add(jrbmenuitem[i]);
	  
      jrbmenuitem[i].setEnabled(isLookAndFeelSupported(classname[i]));
      // ���U ActionListener
      jrbmenuitem[i].addActionListener(this);
     
      if (i==0)
        jrbmenuitem[i].setSelected(true);
    }
	jmenubar.add(jmenuLF);
	return jmenubar;
   }
   public void actionPerformed(ActionEvent e) {
	   try {
		  // �]�w�P�@�~�t�Φ�����Look and Feel
		  if(e.getActionCommand().equals(item[0])) {
			  if(isLookAndFeelSupported("javax.swing.plaf.metal.MetalLookAndFeel"))
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		if(e.getActionCommand().equals(item[1])) {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		if(e.getActionCommand().equals(item[2])) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		if(e.getActionCommand().equals(item[3])) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		}
		if(e.getActionCommand().equals(item[4])) {
			if(isLookAndFeelSupported("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"))
			{UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");}
		}
		if(e.getActionCommand().equals(item[5])) {
			if(isLookAndFeelSupported("com.sun.java.swing.plaf.mac.MacLookAndFeel"))
			{UIManager.setLookAndFeel(" com.sun.java.swing.plaf.mac.MacLookAndFeel");}
		}
	}
    catch(Exception ex) {
		
    }
	SwingUtilities.updateComponentTreeUI(this);
   }
   private boolean isLookAndFeelSupported(String lnfname) {
    try { 
      Class lnfclass = Class.forName(lnfname);
      javax.swing.LookAndFeel lnf = (LookAndFeel)(lnfclass.newInstance());
            // �P�_�@�~�t�άO�_�䴩Look and Feel
      return lnf.isSupportedLookAndFeel();
    } 
    catch(Exception e) { 
      return false;    
	  }  
	  
	}
}
