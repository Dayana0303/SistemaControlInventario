/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;
import negocio.ProductoNegocio;
import modelo.Producto;

/**
 *
 * @author damur
 */
public class EstadisticaPanel extends javax.swing.JPanel {

    /**
     * Creates new form EstadisticaPanel
     */
    private ProductoNegocio negocio;
    

    public EstadisticaPanel(ProductoNegocio negocio) {
        initComponents();
        this.negocio = negocio;
    }
    public void actualizarEstadisticas() {

        int total = negocio.getRepositorio().listar().size();
        int disponibles = 0;
        int noDisponibles = 0;
        double valorInventario = 0;

        String productoCaro = "Ninguno";
        String productoBarato = "Ninguno";

        double mayor = 0;
        double menor = Double.MAX_VALUE;

        for (modelo.Producto producto : negocio.getRepositorio().listar()) {

            if (producto.isDisponible()) {
            disponibles++;
            } else {
                noDisponibles++;
            }

            valorInventario += producto.getCantidad() * producto.getPrecio();

            if (producto.getPrecio() > mayor) {
                mayor = producto.getPrecio();
                productoCaro = producto.getNombre();
            }

            if (producto.getPrecio() < menor) {
                menor = producto.getPrecio();
                productoBarato = producto.getNombre();
            }
        }

        jLabel2.setText(String.valueOf(total));
        lblDisponibles.setText(String.valueOf(disponibles));
        lblNoDisponibles.setText(String.valueOf(noDisponibles));
        lblValorInventario.setText("₡" + valorInventario);
        lblProductoCaro.setText(productoCaro);
        lblProductoBarato.setText(productoBarato);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotalProductos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDisponibles = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNoDisponibles = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblValorInventario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblProductoCaro = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblProductoBarato = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Total de Productos:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("0");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Productos disponibles:");

        lblDisponibles.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblDisponibles.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setText("Productos no disponibles:");

        lblNoDisponibles.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNoDisponibles.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setText("Valor total del inventario:");

        lblValorInventario.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblValorInventario.setText("₡0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setText("Producto más caro:");

        lblProductoCaro.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblProductoCaro.setText("Ninguno");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel8.setText("Producto más barato:");

        lblProductoBarato.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblProductoBarato.setText("Ninguno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lblTotalProductos))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblDisponibles)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblNoDisponibles))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblValorInventario))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductoCaro))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductoBarato)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTotalProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDisponibles)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoDisponibles)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorInventario)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblProductoCaro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblProductoBarato))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblNoDisponibles;
    private javax.swing.JLabel lblProductoBarato;
    private javax.swing.JLabel lblProductoCaro;
    private javax.swing.JLabel lblTotalProductos;
    private javax.swing.JLabel lblValorInventario;
    // End of variables declaration//GEN-END:variables
}
