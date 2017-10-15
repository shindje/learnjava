package chapter8_AWT_Events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.event.Event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.beans.*;

public class EvHandler extends JFrame{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvHandler f = new EvHandler();
		JPanel p = new JPanel();
		JButton b = new JButton("BB");
		b.addActionListener(EventHandler.create(ActionListener.class, f, "someMethod"));
		p.add(b);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
	
	public void someMethod() {
		System.out.println("--someMethod");
	}
}

