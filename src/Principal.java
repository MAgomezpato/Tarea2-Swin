
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class Principal extends JDialog {
    private JPanel contentPane;
    private JTextField txtCodigo;
    private JTextField txtPanaderia;
    private JTextField txtPedido;
    private JComboBox boxEquipo;
    private JButton btNuevo;
    private JButton BtAgregar;
    private JButton btEliminar;
    private JButton btEliminarTodo;
    private JButton btSalir;
    private JTable table1;
    private JButton buttonOK;
    private JButton buttonCancel;

    DefaultTableModel model=new DefaultTableModel();



    public Principal() {

        model.addColumn("Codigo");
        model.addColumn("Panaderia");
        model.addColumn("Pedido");
        model.addColumn("Equipo");
        this.table1.setModel(model);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        BtAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] agregar=new String [4];
                agregar[0]=txtCodigo.getText();
                agregar[1]=txtPanaderia.getText();
                agregar[2]=txtPedido.getText();
                agregar[3]=(String)boxEquipo.getSelectedItem();
                model.addRow(agregar);
            }
        });
        btNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigo.setText("");
                txtPanaderia.setText("");
                txtPedido.setText("");

            }
        });
        btEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int elimin=table1.getSelectedRowCount();
                if(elimin>=0){
                    model.removeRow(elimin);
                }else{
                    JOptionPane.showMessageDialog(null, "No hay datos que Eliminar" );
                }
            }
        });
        btEliminarTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int eliminTotal=table1.getRowCount();
                for (int i=eliminTotal-1;i>=0; i--){
                    model.removeRow(i);

                }
            }
        });
        btSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void onOK() {
        // add your code here
        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
//        dispose();
    }

    public static void main(String[] args) {
        Principal dialog = new Principal();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {

    }
}
