package org.gmake.studio;

import javax.swing.*;

public class MainFrame extends JFrame {

	private static final double VERSION = 1.0;

	MainFrame() {
		super("GameMake Studio " + VERSION);

	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
