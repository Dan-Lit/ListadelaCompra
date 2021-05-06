package GUI;

import XML.Reader;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class List_Window extends JDialog implements ActionListener {

    /**
     * Creates a JDialog that lists the selected recipe's ingredients.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JButton cancelbtn, generatebtn;
    private JList<String> jlist;
    private String[] array;
    private JTextArea text;

    public List_Window(Main_Window v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        init();
        setTitle("Generar lista"); //EN: Create shopping list 

    }

    private void init() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel title = new JLabel("Generar lista"); //EN: Generate list 
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(10, 10, 599, 28);
        contentPanel.add(title);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        //Must convert list into a String[] 
        ArrayList<String> arrayList = Reader.listRecipes();
        array = arrayList.toArray(new String[arrayList.size()]);
        jlist = new JList<String>(array);
        jlist.setBounds(50, 50, 200, 200);
        panel.add(jlist);

        JScrollPane scroll = new JScrollPane();
        jlist.add(scroll);

        text = new JTextArea();
        text.setBounds(335, 50, 200, 200);
        panel.add(text);

        cancelbtn = new JButton("Cancelar"); //EN: Cancel
        cancelbtn.setBounds(463, 276, 89, 23);
        cancelbtn.addActionListener(this);
        panel.add(cancelbtn);

        generatebtn = new JButton("Generar lista"); //EN: Generate list
        generatebtn.setBounds(364, 276, 89, 23);
        generatebtn.addActionListener(this);
        panel.add(generatebtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generatebtn) {
            text.setText(null);
            for (int i = 0; i < array.length; i++) {
                if (jlist.isSelectedIndex(i)) {
                    String seleccion = array[i];
                    ArrayList<String> ingredientesReceta = Reader.listIngredients(seleccion);
                    for (int j = 0; j < ingredientesReceta.size(); j++) {
                        text.append(ingredientesReceta.get(j) + "\n");
                    }

                }

            }
        }
        if (e.getSource() == cancelbtn) {
            dispose();
        }

    }

}
