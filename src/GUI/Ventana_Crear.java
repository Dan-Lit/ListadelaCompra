package GUI;

import XML.Escritura;
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

public class Ventana_Crear extends JDialog implements ActionListener {

    /**
     * Crea un JDialog que permite incoporar nuevas recetas al recetario.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre, txtIngrediente1, txtIngrediente2, txtIngrediente3, txtIngrediente4, txtIngrediente5, txtIngrediente6, txtIngrediente7,
            txtIngrediente8, txtIngrediente9, txtIngrediente10, txtIngrediente11, txtIngrediente12, txtIngrediente13, txtIngrediente14;
    private JButton btnCancelar;
    private JButton btnRegistrar;

    public Ventana_Crear(Ventana_Principal v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        iniciarComponentes();
        setTitle("Creación de receta");

    }

    private void iniciarComponentes() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Creación de receta");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 10, 599, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(24, 22, 81, 21);
        panel.add(nombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(80, 22, 100, 21);
        panel.add(txtNombre);

        JLabel ingrediente1 = new JLabel("Ingrediente 1:");
        JLabel ingrediente2 = new JLabel("Ingrediente 2:");
        JLabel ingrediente3 = new JLabel("Ingrediente 3:");
        JLabel ingrediente4 = new JLabel("Ingrediente 4:");
        JLabel ingrediente5 = new JLabel("Ingrediente 5:");
        JLabel ingrediente6 = new JLabel("Ingrediente 6:");
        JLabel ingrediente7 = new JLabel("Ingrediente 7:");
        JLabel ingrediente8 = new JLabel("Ingrediente 8:");
        JLabel ingrediente9 = new JLabel("Ingrediente 9:");
        JLabel ingrediente10 = new JLabel("Ingrediente 10:");
        JLabel ingrediente11 = new JLabel("Ingrediente 11:");
        JLabel ingrediente12 = new JLabel("Ingrediente 12:");
        JLabel ingrediente13 = new JLabel("Ingrediente 13:");
        JLabel ingrediente14 = new JLabel("Ingrediente 14:");

        ingrediente1.setBounds(24, 22 + 30, 90, 21);
        ingrediente2.setBounds(24, 22 + 60, 90, 21);
        ingrediente3.setBounds(24, 22 + 90, 90, 21);
        ingrediente4.setBounds(24, 22 + 120, 90, 21);
        ingrediente5.setBounds(24, 22 + 150, 90, 21);
        ingrediente6.setBounds(24, 22 + 180, 90, 21);
        ingrediente7.setBounds(24, 22 + 210, 90, 21);
        ingrediente8.setBounds(250, 22 + 30, 90, 21);
        ingrediente9.setBounds(250, 22 + 60, 90, 21);
        ingrediente10.setBounds(250, 22 + 90, 90, 21);
        ingrediente11.setBounds(250, 22 + 120, 90, 21);
        ingrediente12.setBounds(250, 22 + 150, 90, 21);
        ingrediente13.setBounds(250, 22 + 180, 90, 21);
        ingrediente14.setBounds(250, 22 + 210, 90, 21);

        panel.add(ingrediente1);
        panel.add(ingrediente2);
        panel.add(ingrediente3);
        panel.add(ingrediente4);
        panel.add(ingrediente5);
        panel.add(ingrediente6);
        panel.add(ingrediente7);
        panel.add(ingrediente8);
        panel.add(ingrediente9);
        panel.add(ingrediente10);
        panel.add(ingrediente11);
        panel.add(ingrediente12);
        panel.add(ingrediente13);
        panel.add(ingrediente14);

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

        txtIngrediente7 = new JTextField();
        txtIngrediente7.setBounds(114, 22 + 211, 100, 21);
        panel.add(txtIngrediente7);
        
        txtIngrediente8 = new JTextField();
        txtIngrediente8.setBounds(114+226, 22 + 31, 100, 21);
        panel.add(txtIngrediente8);
        
        txtIngrediente9 = new JTextField();
        txtIngrediente9.setBounds(114+226, 22 + 61, 100, 21);
        panel.add(txtIngrediente9);
        
        txtIngrediente10 = new JTextField();
        txtIngrediente10.setBounds(114+226, 22 + 91, 100, 21);
        panel.add(txtIngrediente10);
        
        txtIngrediente11 = new JTextField();
        txtIngrediente11.setBounds(114+226, 22 + 121, 100, 21);
        panel.add(txtIngrediente11);
        
        txtIngrediente12 = new JTextField();
        txtIngrediente12.setBounds(114+226, 22 + 151, 100, 21);
        panel.add(txtIngrediente12);
        
        txtIngrediente13 = new JTextField();
        txtIngrediente13.setBounds(114+226, 22 + 181, 100, 21);
        panel.add(txtIngrediente13);
        
        txtIngrediente14 = new JTextField();
        txtIngrediente14.setBounds(114+226, 22 + 211, 100, 21);
        panel.add(txtIngrediente14);

        /*JLabel aviso = new JLabel("(Dejar vacío si no procede)");
        aviso.setBounds(250, 22 + 60, 200, 21);
        panel.add(aviso);*/

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
            ingredientes.add(txtIngrediente1.getText());

            if (txtIngrediente2.getText().equals("") == false) {
                ingredientes.add(txtIngrediente2.getText());
            }
            if (txtIngrediente3.getText().equals("") == false) {
                ingredientes.add(txtIngrediente3.getText());
            }
            if (txtIngrediente4.getText().equals("") == false) {
                ingredientes.add(txtIngrediente4.getText());
            }
            if (txtIngrediente5.getText().equals("") == false) {
                ingredientes.add(txtIngrediente5.getText());
            }
            if (txtIngrediente6.getText().equals("") == false) {
                ingredientes.add(txtIngrediente6.getText());
            }
            if (txtIngrediente7.getText().equals("") == false) {
                ingredientes.add(txtIngrediente7.getText());
            }
            if (txtIngrediente8.getText().equals("") == false) {
                ingredientes.add(txtIngrediente8.getText());
            }
            if (txtIngrediente9.getText().equals("") == false) {
                ingredientes.add(txtIngrediente9.getText());
            }
            if (txtIngrediente10.getText().equals("") == false) {
                ingredientes.add(txtIngrediente10.getText());
            }
            if (txtIngrediente11.getText().equals("") == false) {
                ingredientes.add(txtIngrediente11.getText());
            }
            if (txtIngrediente12.getText().equals("") == false) {
                ingredientes.add(txtIngrediente12.getText());
            }
            if (txtIngrediente13.getText().equals("") == false) {
                ingredientes.add(txtIngrediente13.getText());
            }
            if (txtIngrediente14.getText().equals("") == false) {
                ingredientes.add(txtIngrediente14.getText());
            }

            Escritura.crearReceta(txtNombre.getText(), ingredientes);
            dispose();
        }
    }
}
