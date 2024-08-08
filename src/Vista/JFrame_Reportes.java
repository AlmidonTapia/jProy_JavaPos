/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author AlmidonTapia
 */
public class JFrame_Reportes extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_Reportes
     */
    public JFrame_Reportes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_bg = new javax.swing.JPanel();
        jPanel_Nav = new javax.swing.JPanel();
        jLabel_ModuloClientes = new javax.swing.JLabel();
        jLabel_ModuloProducto = new javax.swing.JLabel();
        jLabel_ModuloVentas = new javax.swing.JLabel();
        jLabel_ModuloReportes = new javax.swing.JLabel();
        jLabel_Modulo_Comprobantes = new javax.swing.JLabel();
        jButton_Salir = new javax.swing.JButton();
        jLabel_UserIcon = new javax.swing.JLabel();
        jLabel_UserName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_NombreEmpresa = new javax.swing.JLabel();
        jLabel_Modulo_Comprobantes1 = new javax.swing.JLabel();
        jLabel_Modulo_Comprobantes2 = new javax.swing.JLabel();
        jPanel_Productos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdesde = new com.toedter.calendar.JDateChooser();
        txthasta = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_bg.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Nav.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_Nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_ModuloClientes.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_ModuloClientes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModuloClientes.setText("Clientes");
        jPanel_Nav.add(jLabel_ModuloClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 165, -1, -1));

        jLabel_ModuloProducto.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_ModuloProducto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModuloProducto.setText("Productos");
        jPanel_Nav.add(jLabel_ModuloProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 198, -1, -1));

        jLabel_ModuloVentas.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_ModuloVentas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModuloVentas.setText("Ventas");
        jPanel_Nav.add(jLabel_ModuloVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 231, -1, -1));

        jLabel_ModuloReportes.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_ModuloReportes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModuloReportes.setText("Reportes");
        jPanel_Nav.add(jLabel_ModuloReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 264, -1, -1));

        jLabel_Modulo_Comprobantes.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_Modulo_Comprobantes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modulo_Comprobantes.setText("Comprobantes");
        jPanel_Nav.add(jLabel_Modulo_Comprobantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 297, -1, -1));

        jButton_Salir.setBackground(new java.awt.Color(255, 0, 51));
        jButton_Salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salir.setText("Salir");
        jPanel_Nav.add(jButton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 480, 160, 35));

        jLabel_UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user_149071.png"))); // NOI18N
        jPanel_Nav.add(jLabel_UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 20, 30));

        jLabel_UserName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel_UserName.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_UserName.setText("Saul Tapia Almidon");
        jPanel_Nav.add(jLabel_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/store.png"))); // NOI18N
        jPanel_Nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 90));

        jLabel_NombreEmpresa.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel_NombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreEmpresa.setText("Minimarket");
        jPanel_Nav.add(jLabel_NombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 143, 27));

        jLabel_Modulo_Comprobantes1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_Modulo_Comprobantes1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modulo_Comprobantes1.setText("Usuarios");
        jPanel_Nav.add(jLabel_Modulo_Comprobantes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel_Modulo_Comprobantes2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel_Modulo_Comprobantes2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modulo_Comprobantes2.setText("Usuarios");
        jPanel_Nav.add(jLabel_Modulo_Comprobantes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 30));

        jPanel_bg.add(jPanel_Nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 560));

        jPanel_Productos.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_Productos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel_Productos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 670, 310));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/correcto.png"))); // NOI18N
        jLabel1.setText("Reportes");
        jPanel_Productos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Desde");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Hasta");

        txtdesde.setBackground(new java.awt.Color(204, 204, 204));
        txtdesde.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdesde, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txthasta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdesde, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        jPanel_Productos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 670, 90));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("********");
        jPanel_Productos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Ingresos Totales:");
        jPanel_Productos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jPanel_bg.add(jPanel_Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 770, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_ModuloClientes;
    private javax.swing.JLabel jLabel_ModuloProducto;
    private javax.swing.JLabel jLabel_ModuloReportes;
    private javax.swing.JLabel jLabel_ModuloVentas;
    private javax.swing.JLabel jLabel_Modulo_Comprobantes;
    private javax.swing.JLabel jLabel_Modulo_Comprobantes1;
    private javax.swing.JLabel jLabel_Modulo_Comprobantes2;
    private javax.swing.JLabel jLabel_NombreEmpresa;
    private javax.swing.JLabel jLabel_UserIcon;
    private javax.swing.JLabel jLabel_UserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Nav;
    private javax.swing.JPanel jPanel_Productos;
    private javax.swing.JPanel jPanel_bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser txtdesde;
    private com.toedter.calendar.JDateChooser txthasta;
    // End of variables declaration//GEN-END:variables
}
