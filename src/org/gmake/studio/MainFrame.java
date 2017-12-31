package org.gmake.studio;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MainFrame extends JFrame {

	private static final double VERSION = 1.0;
	private static final boolean IS_ALPHA = true;

	private String[] bgs = ("background RootPane.background Panel.background Button.background Menu.background" +
			" MenuBar.background MenuItem.background Tree.background nimbusBase TextField.background").split(" ");

	private MainFrame() {
		super("GameMake Studio " + VERSION + (IS_ALPHA ? "-alpha" : ""));
		setContentPane(new Panel());
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			UIDefaults def = UIManager.getDefaults();
			Color bg = new Color(0, 0, 0, 170);
			def.put("text", new Color(214, 217, 223));
			for (String key : bgs) def.put(key, bg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(800, 600);
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(90, 90, 90));
		getContentPane().repaint();
		getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
