package GUI;

import XML.Lector;
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

public class Ventana_Listar extends JDialog implements ActionListener {

    /**
     * Crea un JDialog que permite imprimir los ingredientes de las recetas que
     * el usuario seleccione.
     *
     * @author Daniel
     */
    private final JPanel contentPanel = new JPanel();
    private JButton botonCancelar, botonGenerar;
    private JList<String> jlist;
    private String[] array;
    private JTextArea text;

    public Ventana_Listar(Ventana_Principal v, boolean modal) {
        super(v, modal);
        setSize(624, 423);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        iniciarComponentes();
        setTitle("Generar lista");

    }

    private void iniciarComponentes() {
        //contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Generar lista");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        //lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        lblTitulo.setBounds(10, 10, 599, 28);
        contentPanel.add(lblTitulo);

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        panel.setBounds(10, 49, 588, 324);
        contentPanel.add(panel);
        panel.setLayout(null);

        //Convertimos la lista en un String[]
        ArrayList<String> arrayList = Lector.listaRecetas();
        array = arrayList.toArray(new String[arrayList.size()]);
        jlist = new JList<String>(array);
        jlist.setBounds(50, 50, 200, 200);
        panel.add(jlist);

        JScrollPane scroll = new JScrollPane();
        jlist.add(scroll);

        text = new JTextArea();
        text.setBounds(335, 50, 200, 200);
        panel.add(text);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(463, 276, 89, 23);
        botonCancelar.addActionListener(this);
        panel.add(botonCancelar);

        botonGenerar = new JButton("Generar lista");
        botonGenerar.setBounds(364, 276, 89, 23);
        botonGenerar.addActionListener(this);
        panel.add(botonGenerar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGenerar) {
            text.setText(null);
            for (int i = 0; i < array.length; i++) {
                if (jlist.isSelectedIndex(i)) {
                    String seleccion = array[i];
                    ArrayList<String> ingredientesReceta = Lector.listaIngredientes(seleccion);
                    for (int j = 0; j < ingredientesReceta.size(); j++) {
                        text.append(ingredientesReceta.get(j) + "\n");
                    }

                }

            }
        }
        if (e.getSource() == botonCancelar) {
            dispose();
        }

    }

}
