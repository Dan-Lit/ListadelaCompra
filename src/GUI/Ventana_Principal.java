package GUI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana_Principal extends JFrame implements ActionListener{
/**
 * Crea la ventana principal del programa. 
 * @author Daniel
 */
	private JPanel contentPane;
        private AbstractButton crear, borrar, listar;
        
	public Ventana_Principal() {
		iniciarComponentes();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setTitle("Lista de la compra");
		setLocationRelativeTo(null);
                setVisible(true);
	}

	private void iniciarComponentes() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuRecetas = new JMenu("Receta");
		JMenu menuLista = new JMenu("Lista de la compra");
                menuBar.add(menuRecetas);
		menuBar.add(menuLista);
                
                crear = new JMenuItem("Crear receta");
                borrar = new JMenuItem("Borrar receta");
                listar = new JMenuItem("Crear lista");
                crear.addActionListener(this);
                borrar.addActionListener(this);
                listar.addActionListener(this);
                menuRecetas.add(crear);
                menuRecetas.add(borrar);
                menuLista.add(listar);
                
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("LISTA DE LA COMPRA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/imagenes/fondo.jpg")));
		panel.add(lblImagen, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
            if (e.getSource() == crear) {
                Ventana_Crear v = new Ventana_Crear(this,true);
                v.setVisible(true);
                
            }
            
            if (e.getSource() == borrar) {
                Ventana_Borrar v = new Ventana_Borrar(this,true);
                v.setVisible(true);
                
            }
            
            if (e.getSource() == listar) {
                Ventana_Listar v = new Ventana_Listar(this,true);
                v.setVisible(true);
                
            }

}


}
