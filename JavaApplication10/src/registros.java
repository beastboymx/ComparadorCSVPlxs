
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class registros extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> tableRowSorter;
    
    public registros() {
        initComponents();
        setSize(1119,608);
        setIconImage(getIconImage());
        //Centrar pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Asignar valores a la ventana
        setLocationRelativeTo(null);
        setVisible(true);
        //Bloqueo de maximizar ventana
        this.setResizable(false);
        

        tableModel = (DefaultTableModel) jtRegistros.getModel();
        tableRowSorter = new TableRowSorter<>(tableModel);
        jtRegistros.setRowSorter(tableRowSorter);

        cargarDatosDesdeArchivo();

        // Aplicar el renderizador personalizado a todas las columnas de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jtRegistros.setDefaultRenderer(Object.class, centerRenderer);

        // Aplicar el renderizador personalizado al encabezado de la tabla
        JTableHeader header = jtRegistros.getTableHeader();
        header.setDefaultRenderer(centerRenderer);

        ajustarAnchoColumnas();
        jtRegistros.setShowGrid(true);
        jtRegistros.setGridColor(java.awt.Color.BLACK);

        // Agregar un DocumentListener al campo de filtro para que se actualice automáticamente
        jtFiltro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarFiltro();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarFiltro();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarFiltro();
            }
        });
        for (int row = 0; row < jtRegistros.getRowCount(); row++) {
            for (int column = 0; column < jtRegistros.getColumnCount(); column++) {
                jtRegistros.getCellEditor(row, column).getTableCellEditorComponent(jtRegistros, null, false, row, column).setEnabled(false);
            }}
    }

      private void cargarDatosDesdeArchivo() {
        DefaultTableModel model = (DefaultTableModel) jtRegistros.getModel();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\App\\datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 8) {
                    String nombre = partes[0].trim();
                    String numEmpleado = partes[1].trim();
                    String modelo = partes[2].trim();
                    String wo = partes[3].trim();
                    String selectiva = partes[4].trim();
                    String comentario = partes[5].trim();
                    String fecha = partes[6].trim();
                    String hora = partes[7].trim();

                    // Agregar una fila a la tabla con los datos
                    model.addRow(new Object[]{nombre, numEmpleado, modelo, wo, selectiva, comentario, fecha, hora});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
      private void ajustarAnchoColumnas() {
        int[] anchos = {30, 30, 30, 30, 30, 300, 20, 10}; // Ancho deseado para cada columna

        for (int i = 0; i < jtRegistros.getColumnCount(); i++) {
            TableColumn columna = jtRegistros.getColumnModel().getColumn(i);
            columna.setPreferredWidth(anchos[i]);
        }
        
        // Ajustar el ancho de la columna del título individualmente
        jtRegistros.getColumnModel().getColumn(0).setPreferredWidth(20); // Título de la columna 0
        jtRegistros.getColumnModel().getColumn(1).setPreferredWidth(20); // Título de la columna 1
        // Y así sucesivamente para cada columna que quieras ajustar
    }
      
       private void actualizarFiltro() {
        String text = jtFiltro.getText();
        if (text.trim().length() == 0) {
            tableRowSorter.setRowFilter(null);
        } else {
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtRegistros = new javax.swing.JTable();
        jtFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegreso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre","Num. Empleado","Modelo","WO","Selectiva","Comentario","Fecha","Hora"}));
    jtRegistros.setColumnSelectionAllowed(true);
    jScrollPane1.setViewportView(jtRegistros);

    jtFiltro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jtFiltroActionPerformed(evt);
        }
    });

    jLabel1.setText("Filtro de datos");

    btnRegreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/re.png"))); // NOI18N
    btnRegreso.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegresoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(31, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(473, 473, 473))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(466, 466, 466)
                    .addComponent(btnRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btnRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
            .addGap(26, 26, 26))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFiltroActionPerformed

        String text = jtFiltro.getText();
        if (text.trim().length() == 0) {
            tableRowSorter.setRowFilter(null);
        } else {
            tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_jtFiltroActionPerformed

    private void btnRegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresoActionPerformed
        login l = new login();
        dispose();
    }//GEN-LAST:event_btnRegresoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtFiltro;
    private javax.swing.JTable jtRegistros;
    // End of variables declaration//GEN-END:variables
}
