package org.gmake.studio;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private Sprite sprite;

	public GamePanel(Sprite spr) {
		this.sprite = spr;
		setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.setBackground(new Color(90, 90, 90));
		top.add(new JLabel("Sprite (" + sprite.id + ", class name: " + sprite._class + ")"));
		add(top, BorderLayout.NORTH);
		JPanel center = new JPanel(null);
		center.setBackground(new Color(90, 90, 90));
		add(center, BorderLayout.CENTER);

	}
}
