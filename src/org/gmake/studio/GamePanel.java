package org.gmake.studio;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private Sprite sprite;

	public GamePanel(Sprite spr) {
		setBackground(new Color(100, 00, 90));
		this.sprite = spr;
		setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.setBackground(new Color(90, 90, 90));
		top.add(new JLabel("Sprite (" + sprite.id + ", class name: " + sprite._class + ")"));
		add(top, BorderLayout.NORTH);
	}
}
