/*
 * Created by JFormDesigner on Thu Oct 17 19:43:30 BOT 2024
 */

package form;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
import model.Libro;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jsanabria
 */
public class FormLibro extends JFrame {
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private LibroDAO libroDAO;

    public FormLibro() {
        setLookAndFeel("Nimbus");
        initComponents();
        autorDAO = new AutorDAO();
        editorialDAO = new EditorialDAO();
        libroDAO = new LibroDAO();
        generarCodigoLibro();
        cargarAutores();
        cargarEditoriales();

    }

    private void setLookAndFeel(String lookAndFeel) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if (lookAndFeel.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    private void cargarAutores() {
        List<Autor> autoresForm = autorDAO.leerArchivoAutores();
        System.out.println("Autores en Form");
        autoresForm.forEach(autor -> {
            cbAutores.addItem(autor.getNombres() + " " + autor.getApellidos());
        });
    }

    private void cargarEditoriales() {
        List<Editorial> editorialesForm = editorialDAO.obtenerEditoriales();
        System.out.println("Editoriales en Form");
        editorialesForm.forEach(editorial -> {
            cbEditorial.addItem(editorial.getNombreEditorial());
        });
    }

    private void generarCodigoLibro() {
        String nuevoCodigo = "";
        if (libroDAO.existenLibros()) {
            // generar código
            String lastCode = libroDAO.obtenerUltimoCodigo();
            String lastValue = lastCode.substring(lastCode.indexOf("-") + 1);
            nuevoCodigo = "L-" + String.format("%04d", (Integer.valueOf(lastValue) + 1));
        } else {
            nuevoCodigo = "L-0001";
        }
        tfCodigo.setText(nuevoCodigo);
    }


    private void guardarLibro(ActionEvent e) {
        // TODO add your code here
        Libro libro = new Libro();
        libro.setCodLibro(tfCodigo.getText());
        libro.setTitulo(tfTitulo.getText());
        libro.setNroPaginas(Integer.parseInt(tfNroPaginas.getText()));
        // obtener el autor seleccionado
        String autorSelected[] = cbAutores.getSelectedItem().toString().split(" ");
        System.out.println("Autor seleccionado --> " + cbAutores.getSelectedItem());
        Autor autor = autorDAO.findByNombreApellido(autorSelected[0], autorSelected[1]);
        if (Objects.nonNull(autor)) {
            libro.setAutor(autor);
        }
        // obtener la editorial seleccionada
        Editorial editorial = editorialDAO.findByNombre(cbEditorial.getSelectedItem().toString());
        if(Objects.nonNull(editorial)) {
            libro.setEditorial(editorial);
        }
        System.out.println("Libro para registrar --> " + libro);
        System.out.println(libroDAO.guardarLibro(libro));
        cleanForm();

    }

    private void limpiar(ActionEvent e) {
        // TODO add your code here
        cleanForm();
    }

    private void cleanForm() {
        generarCodigoLibro();
        tfTitulo.setText("");
        tfNroPaginas.setText("");
        cbAutores.setSelectedIndex(0);
        cbEditorial.setSelectedIndex(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jose
        panel1 = new JPanel();
        labelTituloRegistrar = new JLabel();
        lCodigo = new JLabel();
        tfCodigo = new JTextField();
        lTitulo = new JLabel();
        tfTitulo = new JTextField();
        lAutor = new JLabel();
        cbAutores = new JComboBox();
        lEditorial = new JLabel();
        cbEditorial = new JComboBox();
        lNroPaginas = new JLabel();
        tfNroPaginas = new JTextField();
        bGuardar = new JButton();
        bLimpiar = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- labelTituloRegistrar ----
            labelTituloRegistrar.setText("Registro de Libro");
            labelTituloRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
            labelTituloRegistrar.setFont(new Font("Roboto", Font.BOLD, 28));

            //---- lCodigo ----
            lCodigo.setText("C\u00f3digo:");
            lCodigo.setFont(new Font("Inter", Font.PLAIN, 14));

            //---- tfCodigo ----
            tfCodigo.setEditable(false);

            //---- lTitulo ----
            lTitulo.setText("T\u00edtulo:");
            lTitulo.setFont(new Font("Inter", Font.PLAIN, 14));

            //---- lAutor ----
            lAutor.setText("Autor:");
            lAutor.setFont(new Font("Inter", Font.PLAIN, 14));

            //---- lEditorial ----
            lEditorial.setText("Editorial:");
            lEditorial.setFont(new Font("Inter", Font.PLAIN, 14));

            //---- lNroPaginas ----
            lNroPaginas.setText("N\u00b0 p\u00e1ginas:");
            lNroPaginas.setFont(new Font("Inter", Font.PLAIN, 14));

            //---- bGuardar ----
            bGuardar.setText("Guardar");
            bGuardar.addActionListener(e -> guardarLibro(e));

            //---- bLimpiar ----
            bLimpiar.setText("Limpiar");
            bLimpiar.addActionListener(e -> limpiar(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lTitulo)
                                .addGap(51, 51, 51)
                                .addComponent(tfTitulo, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lAutor)
                                .addGap(52, 52, 52)
                                .addComponent(cbAutores, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lEditorial)
                                .addGap(35, 35, 35)
                                .addComponent(cbEditorial, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lNroPaginas)
                                .addGap(18, 18, 18)
                                .addComponent(tfNroPaginas, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(bGuardar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bLimpiar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelTituloRegistrar)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lCodigo)
                                .addGap(40, 40, 40)
                                .addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(138, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelTituloRegistrar)
                        .addGap(15, 15, 15)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lCodigo))
                            .addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lTitulo))
                            .addComponent(tfTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lAutor))
                            .addComponent(cbAutores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lEditorial))
                            .addComponent(cbEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lNroPaginas)
                            .addComponent(tfNroPaginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(bGuardar)
                            .addComponent(bLimpiar))
                        .addContainerGap(34, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jose
    private JPanel panel1;
    private JLabel labelTituloRegistrar;
    private JLabel lCodigo;
    private JTextField tfCodigo;
    private JLabel lTitulo;
    private JTextField tfTitulo;
    private JLabel lAutor;
    private JComboBox cbAutores;
    private JLabel lEditorial;
    private JComboBox cbEditorial;
    private JLabel lNroPaginas;
    private JTextField tfNroPaginas;
    private JButton bGuardar;
    private JButton bLimpiar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
