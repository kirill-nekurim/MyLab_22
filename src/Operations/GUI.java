package Operations;

import Person.Person;
import Person.PersonFactory;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class GUI extends JFrame {
    private final Creator creator;

    public GUI(Creator creator) {
        this.creator = creator;

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Профессоры");
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты");

        Person[] customers = creator.generateCustomers(20, new PersonFactory());  // Используем метод generateCustomers из Creator
        DefaultMutableTreeNode[] customerNodes = new DefaultMutableTreeNode[customers.length];
        for (int i = 0; i < customers.length; i++) {
            customerNodes[i] = customers[i].createNode();
            if (customers[i].isProfi()) {
                professorNode.add(customerNodes[i]);
            } else studentNode.add(customerNodes[i]);
        }
        root.add(professorNode);
        root.add(studentNode);

        JTree tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();

        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library");
        this.setSize(200, 200);
        this.setVisible(true);
    }
}
