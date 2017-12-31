package org.gmake.studio;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sprite {
	String move;
	String __init__;
	String initArgs;
	final MutableTreeNode node;
	final String _class;
	final String id;

	public Sprite(String id, String className) {
		node = new DefaultMutableTreeNode(id + String.format("(%s)", className));
		_class = className;
		this.id = id;
	}

	public void save() {
		String s = "class %s(GameAPI.Python.api2d.Sprite):\n" +
				"   def __init__(self, %s):\n" +
				"       Sprite.__init__(self)\n" +
				"       %s\n" +
				"   def move(self):\n" +
				"       %s";
		s = String.format(s, _class, initArgs, __init__, move);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("game.py", true));
			bw.write(s);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
