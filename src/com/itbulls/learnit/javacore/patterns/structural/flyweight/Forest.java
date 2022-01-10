package com.itbulls.learnit.javacore.patterns.structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    private DrawObject<Tree> drawImpl ;

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeTypeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);

    }

    @Override
    public void paint(Graphics graphics) {

        drawImpl = (g, objects) -> {
            for (Tree tree : objects) {
                g.setColor(Color.BLACK);
                g.fillRect(tree.getX()-1,  tree.getY()-1, 3, 5);
                TreeType treeType = tree.getType();
                g.setColor(treeType.getColor());
                g.fillOval(tree.getX() - 5, tree.getY() - 10, 10, 10);
            }
        };
        drawImpl.draw(graphics, trees);
    }

}
