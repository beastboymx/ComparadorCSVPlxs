import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
public class admin extends javax.swing.JFrame {

    public admin() {
         initComponents();
         setSize(750,554);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocationRelativeTo(null);
        setVisible(true);
        this.setResizable(false);
        cargarDatosDesdeArchivo();
        jtUsuarios.setDefaultEditor(Object.class, null);
        // Centrar el contenido de las celdas
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < jtUsuarios.getColumnCount(); i++) {
            jtUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // Centrar las cabeceras de las columnas
        ((DefaultTableCellRenderer) jtUsuarios.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        // Hacer que las líneas de cuadrícula sean visibles
        jtUsuarios.setShowGrid(true);
        // Estilo de las líneas de cuadrícula
        jtUsuarios.setGridColor(java.awt.Color.BLACK); // Color de las líneas de cuadrícula
        jtUsuarios.setShowHorizontalLines(true);
        jtUsuarios.setShowVerticalLines(true);
    }
    
    private void cargarDatosDesdeArchivo() {
        DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
        model.setRowCount(0); // Limpia cualquier dato existente en la tabla
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\App\\usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Suponiendo que los datos en el archivo de texto están separados por comas
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
private void guardarRegistroEnArchivo(String nombre, String numero, String pass) {
    String rutaArchivo = "C:\\App\\usuarios.txt";   
    try (FileWriter fw = new FileWriter(rutaArchivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
        out.println(nombre + "," + numero + "," + pass);
        System.out.println("Registro guardado en el archivo.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error al guardar el registro en el archivo: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegreso = new javax.swing.JButton();
        jtNombre = new javax.swing.JTextField();
        jtNumero = new javax.swing.JTextField();
        jtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jtAgregar = new javax.swing.JButton();
        jtEliminar = new javax.swing.JButton();
        jtEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Admin");

        btnRegreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/re.png"))); // NOI18N
        btnRegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Numero");

        jLabel3.setText("Contraseña");

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre","Numero de empleado","Contraseña"}));
    jtUsuarios.setColumnSelectionAllowed(true);
    jScrollPane1.setViewportView(jtUsuarios);
    jtUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    jtAgregar.setText("Agregar");
    jtAgregar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jtAgregarActionPerformed(evt);
        }
    });

    jtEliminar.setText("Eliminar");
    jtEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jtEliminarActionPerformed(evt);
        }
    });

    jtEditar.setText("Editar");
    jtEditar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jtEditarActionPerformed(evt);
        }
    });

    jLabel4.setText("Esta es información personal, no compartas los datos con nadie.");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel1))
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(66, 66, 66)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel2)
                                    .addGap(29, 29, 29))
                                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(84, 84, 84)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(jtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(jtAgregar)
                            .addGap(50, 50, 50)
                            .addComponent(jtEditar)
                            .addGap(55, 55, 55)
                            .addComponent(jtEliminar)))
                    .addGap(109, 109, 109)))
            .addComponent(btnRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel4)
            .addGap(200, 200, 200))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtAgregar)
                        .addComponent(jtEliminar)
                        .addComponent(jtEditar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(42, 42, 42))))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresoActionPerformed
        login l = new login();
        dispose();
    }//GEN-LAST:event_btnRegresoActionPerformed

    private void jtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEliminarActionPerformed
   DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
    int selectedRow = jtUsuarios.getSelectedRow();
    if (selectedRow != -1) { // Verificar si se seleccionó una fila
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este registro?", "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);        
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Obtener los valores de la fila seleccionada
            String nombre = (String) model.getValueAt(selectedRow, 0);
            String numero = (String) model.getValueAt(selectedRow, 1);
            String pass = (String) model.getValueAt(selectedRow, 2);
            // Eliminar la fila del JTable
            model.removeRow(selectedRow);
            // Eliminar el registro del archivo de texto
            boolean eliminacionExitosa = eliminarRegistroDeArchivo(nombre, numero, pass);
            if (eliminacionExitosa) {
                JOptionPane.showMessageDialog(this, "Registro eliminado del archivo.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el registro del archivo.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            }
            // Limpiar los campos de entrada
            jtNombre.setText("");
            jtNumero.setText("");
            jtPass.setText("");
        }
    }
    }//GEN-LAST:event_jtEliminarActionPerformed

private boolean eliminarRegistroDeArchivo(String nombre, String numero, String pass) {
 
    String rutaArchivo = "C:\\App\\usuarios.txt";
    File archivo = new File(rutaArchivo);
    // Crear una lista para almacenar las líneas del archivo
    ArrayList lineas = new ArrayList();
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String line;
        boolean registroEncontrado = false;
        while ((line = br.readLine()) != null) {
            // Leer cada línea y verificar si coincide con el registro a eliminar
            String[] data = line.split(",");
            if (!data[0].equals(nombre) || !data[1].equals(numero) || !data[2].equals(pass)) {
                // Si no coincide, agregar la línea a la lista
                lineas.add(line);
            } else {
                registroEncontrado = true;
            }
        }     
        if (!registroEncontrado) {
            // El registro no fue encontrado, no se realiza ningún cambio en el archivo
            return false;
        } 
        // Sobreescribir el archivo con las líneas actualizadas
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Object linea : lineas) {
                bw.write((String) linea);
                bw.newLine();
            }
        }
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    private void jtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEditarActionPerformed
    DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
    int selectedRow = jtUsuarios.getSelectedRow();
    if (selectedRow != -1) { // Verificar si se seleccionó una fila
        // Obtener los valores actuales de la fila seleccionada
        String nombreActual = (String) model.getValueAt(selectedRow, 0);
        String numeroActual = (String) model.getValueAt(selectedRow, 1);
        String passActual = (String) model.getValueAt(selectedRow, 2);

        // Crear un panel para ingresar los nuevos valores
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField nombreField = new JTextField(nombreActual);
        JTextField numeroField = new JTextField(numeroActual);
        JTextField passField = new JTextField(passActual);
        panel.add(new JLabel("Nuevo Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Nuevo Numero:"));
        panel.add(numeroField);
        panel.add(new JLabel("Nueva Contraseña:"));
        panel.add(passField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Editar Datos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Obtener los nuevos valores ingresados
            String nuevoNombre = nombreField.getText();
            String nuevoNumero = numeroField.getText();
            String nuevaPass = passField.getText();

            // Actualizar el modelo de la tabla con los nuevos valores
            model.setValueAt(nuevoNombre, selectedRow, 0);
            model.setValueAt(nuevoNumero, selectedRow, 1);
            model.setValueAt(nuevaPass, selectedRow, 2);

            // Guardar los cambios en el archivo
            guardarCambiosEnArchivo(model);
        }
    }
    }//GEN-LAST:event_jtEditarActionPerformed

private void guardarCambiosEnArchivo(DefaultTableModel model) {
    String rutaArchivo = "C:\\App\\usuarios.txt";

    try (FileWriter fw = new FileWriter(rutaArchivo, false); // Abrir el archivo para escritura (false para reemplazar)
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String nombre = (String) model.getValueAt(i, 0);
            String numero = (String) model.getValueAt(i, 1);
            String pass = (String) model.getValueAt(i, 2);
            out.println(nombre + "," + numero + "," + pass);
        }
        System.out.println("Cambios guardados en el archivo.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error al guardar los cambios en el archivo: " + e.getMessage());
    }
}
    
    private void jtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAgregarActionPerformed
     DefaultTableModel model = (DefaultTableModel) jtUsuarios.getModel();
    String nombre = jtNombre.getText();
    String numero = jtNumero.getText();
    String pass = jtPass.getText();

    // Verificar si los campos están vacíos
    if (nombre.isEmpty() || numero.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si hay campos vacíos
    }

    // Agregar la fila al JTable
    model.addRow(new Object[]{nombre, numero, pass});

    // Guardar el registro en el archivo de texto
    guardarRegistroEnArchivo(nombre, numero, pass);

    // Limpiar los campos de entrada
    jtNombre.setText("");
    jtNumero.setText("");
    jtPass.setText("");   // TODO add your handling code here:
    }//GEN-LAST:event_jtAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jtAgregar;
    private javax.swing.JButton jtEditar;
    private javax.swing.JButton jtEliminar;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPass;
    private javax.swing.JTable jtUsuarios;
    // End of variables declaration//GEN-END:variables
}
