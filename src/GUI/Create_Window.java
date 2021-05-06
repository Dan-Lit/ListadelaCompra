package GUI;

import XML.Writer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class Create_Window extends JDialog implements ActionListener {

    /**Cr
     * Creates a JDialog that allows merging new recipes to the recipe book. 
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JTextField name_text, ingredient1_text, ingredient2_text, ingredient3_text, 
            ingredient4_text, ingredient5_text, ingredient6_text, ingredient7_text,
            ingredient8_text, ingredient9_text, ingredient10_text, ingredient11_text, 
            ingredient12_text, ingredient13_text, ingredient14_text;
    private JButton cancelbtn;
    private JButton addbtn;

    public Create_Window(Main_Window v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        init();
        setTitle("Crear nueva receta"); //EN: Create new recipe

    }

    private void init() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel title = new JLabel("Nueva receta"); //EN: New recipe
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(10, 10, 599, 28);
        contentPanel.add(title);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel name = new JLabel("Nombre:");
        name.setBounds(24, 22, 81, 21);
        panel.add(name);

        name_text = new JTextField();
        name_text.setBounds(80, 22, 100, 21);
        panel.add(name_text);

        JLabel ingredient1 = new JLabel("Ingrediente 1:"); //EN: Ingredient n:
        JLabel ingredient2 = new JLabel("Ingrediente 2:");  
        JLabel ingredient3 = new JLabel("Ingrediente 3:");
        JLabel ingredient4 = new JLabel("Ingrediente 4:");
        JLabel ingredient5 = new JLabel("Ingrediente 5:");
        JLabel ingredient6 = new JLabel("Ingrediente 6:");
        JLabel ingredient7 = new JLabel("Ingrediente 7:");
        JLabel ingredient8 = new JLabel("Ingrediente 8:");
        JLabel ingredient9 = new JLabel("Ingrediente 9:");
        JLabel ingredient10 = new JLabel("Ingrediente 10:");
        JLabel ingredient11 = new JLabel("Ingrediente 11:");
        JLabel ingredient12 = new JLabel("Ingrediente 12:");
        JLabel ingredient13 = new JLabel("Ingrediente 13:");
        JLabel ingredient14 = new JLabel("Ingrediente 14:");

        ingredient1.setBounds(24, 22 + 30, 90, 21);
        ingredient2.setBounds(24, 22 + 60, 90, 21);
        ingredient3.setBounds(24, 22 + 90, 90, 21);
        ingredient4.setBounds(24, 22 + 120, 90, 21);
        ingredient5.setBounds(24, 22 + 150, 90, 21);
        ingredient6.setBounds(24, 22 + 180, 90, 21);
        ingredient7.setBounds(24, 22 + 210, 90, 21);
        ingredient8.setBounds(250, 22 + 30, 90, 21);
        ingredient9.setBounds(250, 22 + 60, 90, 21);
        ingredient10.setBounds(250, 22 + 90, 90, 21);
        ingredient11.setBounds(250, 22 + 120, 90, 21);
        ingredient12.setBounds(250, 22 + 150, 90, 21);
        ingredient13.setBounds(250, 22 + 180, 90, 21);
        ingredient14.setBounds(250, 22 + 210, 90, 21);

        panel.add(ingredient1);
        panel.add(ingredient2);
        panel.add(ingredient3);
        panel.add(ingredient4);
        panel.add(ingredient5);
        panel.add(ingredient6);
        panel.add(ingredient7);
        panel.add(ingredient8);
        panel.add(ingredient9);
        panel.add(ingredient10);
        panel.add(ingredient11);
        panel.add(ingredient12);
        panel.add(ingredient13);
        panel.add(ingredient14);

        ingredient1_text = new JTextField();
        ingredient1_text.setBounds(114, 22 + 31, 100, 21);
        panel.add(ingredient1_text);

        ingredient2_text = new JTextField();
        ingredient2_text.setBounds(114, 22 + 61, 100, 21);
        panel.add(ingredient2_text);

        ingredient3_text = new JTextField();
        ingredient3_text.setBounds(114, 22 + 91, 100, 21);
        panel.add(ingredient3_text);

        ingredient4_text = new JTextField();
        ingredient4_text.setBounds(114, 22 + 121, 100, 21);
        panel.add(ingredient4_text);

        ingredient5_text = new JTextField();
        ingredient5_text.setBounds(114, 22 + 151, 100, 21);
        panel.add(ingredient5_text);

        ingredient6_text = new JTextField();
        ingredient6_text.setBounds(114, 22 + 181, 100, 21);
        panel.add(ingredient6_text);

        ingredient7_text = new JTextField();
        ingredient7_text.setBounds(114, 22 + 211, 100, 21);
        panel.add(ingredient7_text);
        
        ingredient8_text = new JTextField();
        ingredient8_text.setBounds(114+226, 22 + 31, 100, 21);
        panel.add(ingredient8_text);
        
        ingredient9_text = new JTextField();
        ingredient9_text.setBounds(114+226, 22 + 61, 100, 21);
        panel.add(ingredient9_text);
        
        ingredient10_text = new JTextField();
        ingredient10_text.setBounds(114+226, 22 + 91, 100, 21);
        panel.add(ingredient10_text);
        
        ingredient11_text = new JTextField();
        ingredient11_text.setBounds(114+226, 22 + 121, 100, 21);
        panel.add(ingredient11_text);
        
        ingredient12_text = new JTextField();
        ingredient12_text.setBounds(114+226, 22 + 151, 100, 21);
        panel.add(ingredient12_text);
        
        ingredient13_text = new JTextField();
        ingredient13_text.setBounds(114+226, 22 + 181, 100, 21);
        panel.add(ingredient13_text);
        
        ingredient14_text = new JTextField();
        ingredient14_text.setBounds(114+226, 22 + 211, 100, 21);
        panel.add(ingredient14_text);

        /*JLabel aviso = new JLabel("(Dejar vacío si no procede)");
        aviso.setBounds(250, 22 + 60, 200, 21);
        panel.add(aviso);*/

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(463, 276, 89, 23);
        cancelbtn.addActionListener(this);
        panel.add(cancelbtn);

        addbtn = new JButton("Add");
        addbtn.setBounds(364, 276, 89, 23);
        addbtn.addActionListener(this);
        panel.add(addbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelbtn) {
            dispose();
        }

        if (e.getSource() == addbtn) {
            ArrayList<String> ingredients = new ArrayList();
            ingredients.add(ingredient1_text.getText());

            if (ingredient2_text.getText().equals("") == false) {
                ingredients.add(ingredient2_text.getText());
            }
            if (ingredient3_text.getText().equals("") == false) {
                ingredients.add(ingredient3_text.getText());
            }
            if (ingredient4_text.getText().equals("") == false) {
                ingredients.add(ingredient4_text.getText());
            }
            if (ingredient5_text.getText().equals("") == false) {
                ingredients.add(ingredient5_text.getText());
            }
            if (ingredient6_text.getText().equals("") == false) {
                ingredients.add(ingredient6_text.getText());
            }
            if (ingredient7_text.getText().equals("") == false) {
                ingredients.add(ingredient7_text.getText());
            }
            if (ingredient8_text.getText().equals("") == false) {
                ingredients.add(ingredient8_text.getText());
            }
            if (ingredient9_text.getText().equals("") == false) {
                ingredients.add(ingredient9_text.getText());
            }
            if (ingredient10_text.getText().equals("") == false) {
                ingredients.add(ingredient10_text.getText());
            }
            if (ingredient11_text.getText().equals("") == false) {
                ingredients.add(ingredient11_text.getText());
            }
            if (ingredient12_text.getText().equals("") == false) {
                ingredients.add(ingredient12_text.getText());
            }
            if (ingredient13_text.getText().equals("") == false) {
                ingredients.add(ingredient13_text.getText());
            }
            if (ingredient14_text.getText().equals("") == false) {
                ingredients.add(ingredient14_text.getText());
            }

            Writer.createRecipe(name_text.getText(), ingredients);
            dispose();
        }
    }
}
