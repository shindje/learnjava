package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class SampleFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("sd");
		//EventQueue.invokeLater
		JFrame ff = new JFrame();
		MyFrame f = new MyFrame();
		f.setSize();
		f.setImage();
		//f.setContent();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JButton b = new JButton("emo");
		b.setAction(new AbstractAction("emo2") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print(" action source: " + e.getSource());
				JButton b = (JButton)e.getSource();
				JPanel p = (JPanel)b.getParent();
				JTextField text = (JTextField)p.getComponent(1);
				text.setColumns(10);
				//p.revalidate();
				//JFrame f = (JFrame)p.getParent();
				System.out.println("");
				System.out.println(" panel: " + p);
				System.out.println(" panel parent: " + p.getParent());
				System.out.println(" panel parent parent: " + p.getParent().getParent());
				System.out.println(" panel parent parent: " + p.getParent().getParent().getParent());
				System.out.println(" panel parent parent: " + p.getParent().getParent().getParent().getParent());
				//JFrame f = (JFrame)p.getParent().getParent().getParent().getParent();
				JFrame f = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, p);
				f.validate();	// = p.revalidate();
			}
		});
		b.getModel();
		JPanel panel = new JPanel();
		panel.add(b);
		final JTextField t = new JTextField("input", 30); 
		panel.add(t);
		final JTextArea ta = new JTextArea(3, 10);
		JScrollPane scroll = new JScrollPane(ta);
		panel.add(scroll);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.print(" 1111 " + e.getSource());
				ta.setColumns(5);
				ta.revalidate();
			}
		});

		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.BLUE, Color.RED));
		
		JComboBox cb = new JComboBox<String>();
		cb.addItem("one");
		cb.addItem("two");
		cb.setEditable(true);
		panel.add(cb);
		
		JSlider slide = new JSlider(SwingConstants.VERTICAL, 0, 100, 15);
		slide.setMinorTickSpacing(10);
		slide.setMajorTickSpacing(20);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setSnapToTicks(true);
		panel.add(slide);
		
		f.add(panel, BorderLayout.SOUTH);
		
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("top");
		menu.add(new JMenuItem("one", 'O'));
		menu.add(new JMenuItem("two"));
		JMenu inside = new JMenu("inside");
		inside.add(new JCheckBoxMenuItem("in one"));
		inside.add(new JMenuItem("in two"));
		menu.addSeparator();
		menu.add(inside);
		mb.add(menu);
		//f.setJMenuBar(mb);	//add to TOP
		f.add(mb, BorderLayout.EAST);
		
		JPopupMenu popup = new JPopupMenu();
		popup.add("One p");
		panel.setComponentPopupMenu(popup);
		
		JToolBar tb = new JToolBar("ToolBar", SwingConstants.VERTICAL);
		tb.add("one t", new JButton("in one t"));
		f.add(tb, BorderLayout.WEST);
		
		f.setLayout(new GridLayout(2,2));
		f.pack();
		
		//System.out.print("\n:" +  JOptionPane.showInputDialog("mess"));
		final JDialog dialog = new JDialog();
		final JTextField dtext = new JTextField();
		dialog.add(dtext, BorderLayout.CENTER);
		JButton dbutton = new JButton();
		dbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(false);
				ta.setText(dtext.getText());
			}
		});
		dialog.add(dbutton, BorderLayout.EAST);

		dialog.pack();
		dialog.setVisible(true);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(f);
		if (fileChooser.getSelectedFile() != null)
			ta.setText(fileChooser.getSelectedFile().getPath());
		
		Color c = JColorChooser.showDialog(f, "color", Color.RED);
		if (c != null)
			t.setText(c.toString());
	}
	
	static class MyFrame extends JFrame {
		public void setSize() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screen = kit.getScreenSize();
			super.setSize(screen.height/5, screen.width/5);
		}
		
		public void setImage() {
			Image i = new ImageIcon("D:\\_Temp\\_er\\11.jpg").getImage();
			File f = new File("D:\\_Temp\\_er\\11.jpg");
			System.out.print(" 11.jpg exists: " + f.exists());
			setIconImage(i);
		}
		
		public void setContent() {
			Container cPanel = getContentPane();
			cPanel.add(new JComponent() {
				@Override
				public void paintComponent (Graphics g) {
					// TODO Auto-generated method stub
					super.paint(g);
					g.drawString("Some Sring", 100, 50);
				}
			});
			
			add(new JComponent() {
				@Override
				public void paint(Graphics g) {
					// TODO Auto-generated method stub
					super.paint(g);
					g.drawString("Other sring", 100, 150);
					g.drawString("Other 4 sring", 100, 250);
					
					Graphics2D g2d = (Graphics2D)g;
					g2d.setPaint(Color.GREEN);
					g2d.setPaint(new Color(24,126,215).brighter().brighter());
					Rectangle2D r = new Rectangle2D.Double(50.3, 50.22, 100.442, 150.21); 
					g2d.draw(r);
					g2d.fill(r);
				}
			});
		}
	}
}
