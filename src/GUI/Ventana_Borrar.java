package GUI;

import XML.Escritura;
import XML.Lector;
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

public class Ventana_Borrar extends JDialog implements ActionListener, ItemListener {

    /**
     * Crea un JDialog que permite borrar recetas del recetario.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private final ArrayList<String> recetasRegistradas = Lector.listaRecetas();
    private JComboBox comboBox;
    private JButton btnBorrar;
    private String recetaABorrar = null;

    public Ventana_Borrar(Ventana_Principal v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciarComponentes();
        setTitle("Borrar receta");

    }

    private void iniciarComponentes() {
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Borrar receta");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        //lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblTitulo.setBounds(10, 10, 599, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        comboBox = new JComboBox();
        comboBox.setBounds(50, 50, 200, 20);
        comboBox.addItemListener(this);
        panel.add(comboBox);

        btnBorrar = new JButton("Borrar seleccionada");
        btnBorrar.setBounds(100, 100, 200, 20);
        btnBorrar.addActionListener(this);
        panel.add(btnBorrar);

        for (String i : recetasRegistradas) {
            comboBox.addItem(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int output = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres borrar esta receta?",
                "Atención",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        switch (output) {
            case JOptionPane.YES_OPTION:
                Escritura.borrarReceta(recetaABorrar);
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
        recetaABorrar = (String) comboBox.getSelectedItem();
    }
}
