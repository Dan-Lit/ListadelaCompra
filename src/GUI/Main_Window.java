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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main_Window extends JFrame implements ActionListener {
    /**
     * Creates the app main window 
     * @author Daniel
     */
    private JPanel contentPane;
    private AbstractButton create, delete, list, edit;

    public Main_Window() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setTitle("Lista de la compra"); //EN: Shopping list
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu recipesMenu = new JMenu("Receta");
        JMenu listMenu = new JMenu("Lista de la compra");
        menuBar.add(recipesMenu);
        menuBar.add(listMenu);

        create = new JMenuItem("Crear receta");
        delete = new JMenuItem("Borrar receta");
        edit = new JMenuItem("Editar receta");
        list = new JMenuItem("Crear lista");
        create.addActionListener(this);
        delete.addActionListener(this);
        edit.addActionListener(this);
        list.addActionListener(this);
        recipesMenu.add(create);
        recipesMenu.add(delete);
        recipesMenu.add(edit);
        listMenu.add(list);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel title = new JLabel("LISTA DE LA COMPRA"); //EN: SHOPPING LIST
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        contentPane.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            Create_Window v = new Create_Window(this,true);
            v.setVisible(true);

        }

        if (e.getSource() == delete) {
            Delete_Window v = new Delete_Window(this,true);
            v.setVisible(true);

        }
        if (e.getSource() == edit) {
            Edit_Window v = new Edit_Window(this, true);
            v.setVisible(true);
        }
        if (e.getSource() == list) {
            List_Window v = new List_Window(this,true);
            v.setVisible(true);

        }

    }

}
