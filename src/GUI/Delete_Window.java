package GUI;

import XML.Writer;
import XML.Reader;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Delete_Window extends JDialog implements ActionListener, ItemListener {

    /**
     * Creates a JDialog that allows to delete recipes from the recipe book.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private final ArrayList<String> registeredRecipes = Reader.listRecipes();
    private JComboBox comboBox;
    private JButton deletebtn;
    private String recipeToDelete = null;

    public Delete_Window(Main_Window v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
        setTitle("Borrar receta"); //EN: Delete recipe

    }

    private void init() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel title = new JLabel("Borrar receta"); //EN: Delete recipe
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(10, 10, 599, 28);
        contentPanel.add(title);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(50, 50, 200, 20);
        comboBox.addItemListener(this);
        panel.add(comboBox);

        deletebtn = new JButton("Borrar receta seleccionada"); //EN: Delete selected recipe
        deletebtn.setBounds(100, 100, 200, 20);
        deletebtn.addActionListener(this);
        panel.add(deletebtn);

        for (String i : registeredRecipes) {
            comboBox.addItem(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int output = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres borrar esta receta?", //EN: Are you sure you want to delete this recipe?
                "Atención", //EN: Caution
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        switch (output) {
            case JOptionPane.YES_OPTION:
                Writer.deleteRecipe(recipeToDelete);
                dispose();
                break;
            case JOptionPane.NO_OPTION:
                dispose();
                break;
            case JOptionPane.CANCEL_OPTION:
                dispose();
                break;
            default:
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        recipeToDelete = (String) comboBox.getSelectedItem();
    }
}
