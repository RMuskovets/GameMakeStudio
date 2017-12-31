package org.gmake.studio;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MainFrame extends JFrame {

	private static final double VERSION = 1.2;
	private static final boolean IS_ALPHA = true;

	private static final String[] bgs = ("background RootPane.background Panel.background Button.background Menu.background" +
			" MenuBar.background MenuItem.background JTree.background Tree.background nimbusBase TextField.background JPanel.background").split(" ");

	private MainFrame() {
		super("GameMake Studio " + VERSION + (IS_ALPHA ? "-alpha" : ""));
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			UIDefaults def = UIManager.getDefaults();
			Color bg = new Color(0, 0, 0, 170);
			def.put("text", new Color(214, 217, 223));
			for (String key : bgs) def.put(key, bg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainScreen screen = new MainScreen();
		setContentPane(screen.$$$getRootComponent$$$());
		setSize(800, 600);
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(90, 90, 90));
		getContentPane().repaint();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setJMenuBar(screen.mb);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
