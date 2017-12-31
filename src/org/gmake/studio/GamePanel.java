package org.gmake.studio;

import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
	private Sprite sprite;

	GamePanel(Sprite spr) {
		this.sprite = spr;
		setLayout(new BorderLayout());
		JPanel top = new JPanel();
		top.setBackground(new Color(90, 90, 90));
		top.add(new JLabel("Sprite (" + sprite.id + ", class name: " + sprite._class + ")"));
		add(top, BorderLayout.NORTH);
		JPanel center = new JPanel(null);
		center.setBackground(new Color(90, 90, 90));
		add(center, BorderLayout.CENTER);
		JButton code = new JButton("Code for sprite");
		JPanel pfc = new JPanel(new BorderLayout());
		JTextPane pane = new JTextPane();
		pane.setForeground(new Color(0, 0, 0));
		center.add(code);
		center.add(pfc);
		pfc.add(new JScrollPane(pane));
		pfc.setBounds(240, 100, 300, 200);
		pfc.setVisible(false);
		code.addActionListener(e -> pfc.setVisible(true));
		code.setBounds(100, 100, 125, 30);
		JButton exit = new JButton("    X    ");
		exit.addActionListener(e -> pfc.setVisible(false));
		pfc.add(exit, "South");
		JToolBar jtb = new JToolBar();
		JComboBox<String> jcb = new JComboBox<>();
		jcb.addItem("__init__");
		jcb.addItem("move");
		jcb.addItem("initArgs");
		jcb.setSelectedItem("__init__");
		JButton save = new JButton("Save");
		save.addActionListener(e -> {
			String method = (String) jcb.getSelectedItem();
			try {
				sprite.getClass().getField(method).set(sprite, pane.getText());
			} catch (IllegalAccessException | NoSuchFieldException e1) {
				e1.printStackTrace();
			}
			sprite.save();
		});
		jtb.add(save);
		JButton saveTo = new JButton("Save to sprite");
		saveTo.addActionListener(e -> {
			String method = (String) jcb.getSelectedItem();
			try {
				sprite.getClass().getField(method).set(sprite, pane.getText());
			} catch (IllegalAccessException | NoSuchFieldException e1) {
				e1.printStackTrace();
			}
		});
		jtb.add(jcb);
		jtb.add(saveTo);
		pfc.add(jtb, "North");
	}
}
