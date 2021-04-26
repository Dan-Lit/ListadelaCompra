package GUI;

import XML.Escritura;
import XML.Lector;
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

public class Ventana_Editar extends JDialog implements ActionListener, ItemListener {

    /**
     * Crea un JDialog que permite editar recetas ya creadas.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JTextField txtIngrediente1, txtIngrediente2, txtIngrediente3, txtIngrediente4, txtIngrediente5, txtIngrediente6;
    private JButton btnCancelar;
    private JButton btnRegistrar;
    private final ArrayList<String> recetasRegistradas = Lector.listaRecetas();
    private JComboBox comboBox;
    private String recetaAEditar;

    public Ventana_Editar(Ventana_Principal v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        iniciarComponentes();
        setTitle("Editar receta");

    }

    private void iniciarComponentes() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Editar receta");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 10, 599, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel ingrediente1 = new JLabel("Ingrediente 1:");
        JLabel ingrediente2 = new JLabel("Ingrediente 2:");
        JLabel ingrediente3 = new JLabel("Ingrediente 3:");
        JLabel ingrediente4 = new JLabel("Ingrediente 4:");
        JLabel ingrediente5 = new JLabel("Ingrediente 5:");
        JLabel ingrediente6 = new JLabel("Ingrediente 6:");
        JLabel ingrediente7 = new JLabel("Ingrediente 7:");

        ingrediente1.setBounds(24, 22 + 30, 81, 21);
        ingrediente2.setBounds(24, 22 + 60, 81, 21);
        ingrediente3.setBounds(24, 22 + 90, 81, 21);
        ingrediente4.setBounds(24, 22 + 120, 81, 21);
        ingrediente5.setBounds(24, 22 + 150, 81, 21);
        ingrediente6.setBounds(24, 22 + 180, 81, 21);
        ingrediente7.setBounds(24, 22 + 210, 81, 21);

        panel.add(ingrediente1);
        panel.add(ingrediente2);
        panel.add(ingrediente3);
        panel.add(ingrediente4);
        panel.add(ingrediente5);
        panel.add(ingrediente6);
        panel.add(ingrediente7);

        txtIngrediente1 = new JTextField();
        txtIngrediente1.setBounds(114, 22 + 31, 100, 21);
        panel.add(txtIngrediente1);

        txtIngrediente2 = new JTextField();
        txtIngrediente2.setBounds(114, 22 + 61, 100, 21);
        panel.add(txtIngrediente2);

        txtIngrediente3 = new JTextField();
        txtIngrediente3.setBounds(114, 22 + 91, 100, 21);
        panel.add(txtIngrediente3);

        txtIngrediente4 = new JTextField();
        txtIngrediente4.setBounds(114, 22 + 121, 100, 21);
        panel.add(txtIngrediente4);

        txtIngrediente5 = new JTextField();
        txtIngrediente5.setBounds(114, 22 + 151, 100, 21);
        panel.add(txtIngrediente5);

        txtIngrediente6 = new JTextField();
        txtIngrediente6.setBounds(114, 22 + 181, 100, 21);
        panel.add(txtIngrediente6);

        txtIngrediente6 = new JTextField();
        txtIngrediente6.setBounds(114, 22 + 211, 100, 21);
        panel.add(txtIngrediente6);

        JLabel aviso = new JLabel("(Dejar vacío si no procede)");
        aviso.setBounds(250, 82, 200, 21);
        panel.add(aviso);

        comboBox = new JComboBox();
        comboBox.setBounds(170, 20, 200, 20);
        comboBox.addItemListener(this);
        panel.add(comboBox);

        for (String i : recetasRegistradas) {
            comboBox.addItem(i);
        }

        JLabel nombre = new JLabel("Nombre de la receta");
        nombre.setBounds(25, 20, 120, 21);
        panel.add(nombre);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(463, 276, 89, 23);
        btnCancelar.addActionListener(this);
        panel.add(btnCancelar);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(364, 276, 89, 23);
        btnRegistrar.addActionListener(this);
        panel.add(btnRegistrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            ArrayList<String> ingredientes = new ArrayList();
            try {

                if ((txtIngrediente1.getText().equals("") == false) && (txtIngrediente1.getText() != null)) {
                    ingredientes.add(txtIngrediente1.getText());
                }
                if ((txtIngrediente2.getText().equals("") == false) && (txtIngrediente2.getText() != null)) {
                    ingredientes.add(txtIngrediente2.getText());
                }
                if ((txtIngrediente3.getText().equals("") == false) && (txtIngrediente3.getText() != null)) {
                    ingredientes.add(txtIngrediente3.getText());
                }
                if ((txtIngrediente4.getText().equals("") == false) && (txtIngrediente4.getText() != null)) {
                    ingredientes.add(txtIngrediente4.getText());
                }
                if ((txtIngrediente5.getText().equals("") == false) && (txtIngrediente5.getText() != null)) {
                    ingredientes.add(txtIngrediente5.getText());
                }
                if ((txtIngrediente6.getText().equals("") == false) && (txtIngrediente6.getText() != null)) {
                    ingredientes.add(txtIngrediente6.getText());
                }
            } catch (NullPointerException e2) {
            }

            //Borramos la antigua y creamos la nueva, con el mismo nombre y nuevos ingredientes
            Escritura.borrarReceta(recetaAEditar);
            Escritura.crearReceta(recetaAEditar, ingredientes);
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        recetaAEditar = (String) comboBox.getSelectedItem();
        ArrayList<String> ingredientesAntiguos = Lector.listaIngredientes(recetaAEditar);

        try {
            txtIngrediente1.setText(null);
            txtIngrediente2.setText(null);
            txtIngrediente3.setText(null);
            txtIngrediente4.setText(null);
            txtIngrediente5.setText(null);
            txtIngrediente6.setText(null);

            if (ingredientesAntiguos.get(0) != null) {
                txtIngrediente1.setText(ingredientesAntiguos.get(0));
            }
            if (ingredientesAntiguos.get(1) != null) {
                txtIngrediente2.setText(ingredientesAntiguos.get(1));
            }
            if (ingredientesAntiguos.get(2) != null) {
                txtIngrediente3.setText(ingredientesAntiguos.get(2));
            }
            if (ingredientesAntiguos.get(3) != null) {
                txtIngrediente4.setText(ingredientesAntiguos.get(3));
            }
            if (ingredientesAntiguos.get(4) != null) {
                txtIngrediente5.setText(ingredientesAntiguos.get(4));
            }
            if (ingredientesAntiguos.get(5) != null) {
                txtIngrediente6.setText(ingredientesAntiguos.get(5));
            }
        } catch (IndexOutOfBoundsException e2) {

        }
    }
}
