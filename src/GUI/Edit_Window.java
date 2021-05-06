package GUI;

import XML.Writer;
import XML.Reader;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class Edit_Window extends JDialog implements ActionListener, ItemListener {

    /**
     * Creaes a JDialog that allows to edit existing recipes. 
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JTextField ingredient1_text, ingredient2_text, ingredient3_text, 
            ingredient4_text, ingredient5_text, ingredient6_text, ingredient7_text,
            ingredient8_text, ingredient9_text, ingredient10_text, ingredient11_text, 
            ingredient12_text, ingredient13_text, ingredient14_text;
    
    private JButton cancelbtn;
    private JButton addbtn;
    private final ArrayList<String> registeredRecipes = Reader.listRecipes();
    private JComboBox comboBox;
    private String recipeToEdit;

    public Edit_Window(Main_Window v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        init();
        setTitle("Editar receta"); //EN: "Edit recipe"

    }

    private void init() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel title = new JLabel("Editar receta"); //EN: "Edit recipe"
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(10, 10, 599, 28);
        contentPanel.add(title);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel ingredient1 = new JLabel("Ingrediente 1:");
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

        ingredient1.setBounds(24, 22 + 30, 81, 21);
        ingredient2.setBounds(24, 22 + 60, 81, 21);
        ingredient3.setBounds(24, 22 + 90, 81, 21);
        ingredient4.setBounds(24, 22 + 120, 81, 21);
        ingredient5.setBounds(24, 22 + 150, 81, 21);
        ingredient6.setBounds(24, 22 + 180, 81, 21);
        ingredient7.setBounds(24, 22 + 210, 81, 21);
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

        comboBox = new JComboBox();
        comboBox.setBounds(170, 20, 200, 20);
        comboBox.addItemListener(this);
        panel.add(comboBox);

        for (String i : registeredRecipes) {
            comboBox.addItem(i);
        }

        JLabel nombre = new JLabel("Nombre de la receta"); //EN: Recipe's name
        nombre.setBounds(25, 20, 120, 21);
        panel.add(nombre);

        cancelbtn = new JButton("Cancelar"); //EN: Cancel
        cancelbtn.setBounds(463, 276, 89, 23);
        cancelbtn.addActionListener(this);
        panel.add(cancelbtn);

        addbtn = new JButton("Registrar"); //EN: Add
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
            try {

                if ((ingredient1_text.getText().equals("") == false) && (ingredient1_text.getText() != null)) {
                    ingredients.add(ingredient1_text.getText());
                }
                if ((ingredient2_text.getText().equals("") == false) && (ingredient2_text.getText() != null)) {
                    ingredients.add(ingredient2_text.getText());
                }
                if ((ingredient3_text.getText().equals("") == false) && (ingredient3_text.getText() != null)) {
                    ingredients.add(ingredient3_text.getText());
                }
                if ((ingredient4_text.getText().equals("") == false) && (ingredient4_text.getText() != null)) {
                    ingredients.add(ingredient4_text.getText());
                }
                if ((ingredient5_text.getText().equals("") == false) && (ingredient5_text.getText() != null)) {
                    ingredients.add(ingredient5_text.getText());
                }
                if ((ingredient6_text.getText().equals("") == false) && (ingredient6_text.getText() != null)) {
                    ingredients.add(ingredient6_text.getText());
                }
                if ((ingredient7_text.getText().equals("") == false) && (ingredient7_text.getText() != null)) {
                    ingredients.add(ingredient7_text.getText());
                }
                if ((ingredient8_text.getText().equals("") == false) && (ingredient8_text.getText() != null)) {
                    ingredients.add(ingredient8_text.getText());
                }
                if ((ingredient9_text.getText().equals("") == false) && (ingredient9_text.getText() != null)) {
                    ingredients.add(ingredient9_text.getText());
                }
                if ((ingredient10_text.getText().equals("") == false) && (ingredient10_text.getText() != null)) {
                    ingredients.add(ingredient10_text.getText());
                }
                if ((ingredient11_text.getText().equals("") == false) && (ingredient11_text.getText() != null)) {
                    ingredients.add(ingredient11_text.getText());
                }
                if ((ingredient12_text.getText().equals("") == false) && (ingredient12_text.getText() != null)) {
                    ingredients.add(ingredient12_text.getText());
                }
                if ((ingredient13_text.getText().equals("") == false) && (ingredient13_text.getText() != null)) {
                    ingredients.add(ingredient13_text.getText());
                }
                if ((ingredient14_text.getText().equals("") == false) && (ingredient14_text.getText() != null)) {
                    ingredients.add(ingredient14_text.getText());
                }
            } catch (NullPointerException e2) {
            }

            Writer.deleteRecipe(recipeToEdit);
            Writer.createRecipe(recipeToEdit, ingredients);
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        recipeToEdit = (String) comboBox.getSelectedItem();
        ArrayList<String> oldIngredients = Reader.listIngredients(recipeToEdit);

        try {
            ingredient1_text.setText(null);
            ingredient2_text.setText(null);
            ingredient3_text.setText(null);
            ingredient4_text.setText(null);
            ingredient5_text.setText(null);
            ingredient6_text.setText(null);
            ingredient7_text.setText(null);
            ingredient8_text.setText(null);
            ingredient9_text.setText(null);
            ingredient10_text.setText(null);
            ingredient11_text.setText(null);
            ingredient12_text.setText(null);
            ingredient13_text.setText(null);
            ingredient14_text.setText(null);
            if (oldIngredients.get(0) != null) {
                ingredient1_text.setText(oldIngredients.get(0));
            }
            if (oldIngredients.get(1) != null) {
                ingredient2_text.setText(oldIngredients.get(1));
            }
            if (oldIngredients.get(2) != null) {
                ingredient3_text.setText(oldIngredients.get(2));
            }
            if (oldIngredients.get(3) != null) {
                ingredient4_text.setText(oldIngredients.get(3));
            }
            if (oldIngredients.get(4) != null) {
                ingredient5_text.setText(oldIngredients.get(4));
            }
            if (oldIngredients.get(5) != null) {
                ingredient6_text.setText(oldIngredients.get(5));
            }
            if (oldIngredients.get(6) != null) {
                ingredient7_text.setText(oldIngredients.get(6));
            }
            if (oldIngredients.get(7) != null) {
                ingredient8_text.setText(oldIngredients.get(7));
            }
            if (oldIngredients.get(8) != null) {
                ingredient9_text.setText(oldIngredients.get(8));
            }
            if (oldIngredients.get(9) != null) {
                ingredient10_text.setText(oldIngredients.get(9));
            }
            if (oldIngredients.get(10) != null) {
                ingredient11_text.setText(oldIngredients.get(10));
            }
            if (oldIngredients.get(11) != null) {
                ingredient12_text.setText(oldIngredients.get(11));
            }
            if (oldIngredients.get(12) != null) {
                ingredient13_text.setText(oldIngredients.get(12));
            }
            if (oldIngredients.get(13) != null) {
                ingredient14_text.setText(oldIngredients.get(13));
            }
            
        } catch (IndexOutOfBoundsException e2) {}
    }
}
