package pertemuan11;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static pertemuan11.koneksi.getConnection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INSTIKI
 * TGL: 2024-05-27
 * update: 2024-06-03
 */
public class frmdataonepiece extends javax.swing.JFrame {
    DefaultTableModel tm = new DefaultTableModel();
    /**
     * Creates new form frmdataonepiece
     * @throws java.sql.SQLException
     */
    public frmdataonepiece() throws SQLException {
        initComponents();
        jtb.setModel(tm);
        tm.addColumn("ID Kru");
        tm.addColumn("Nama");
        tm.addColumn("Umur");
        tm.addColumn("Asal");
        list_all();
    }

    private void list_all() throws SQLException{
        Connection cnn = getConnection();
        
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();
        
        if(cnn.isClosed()){
            System.out.println("Koneksi tertutup");
        }else{
            String sql = "Select * from dataonepiece order by nama;";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                Object[] dta = new Object[4];
                dta[0] = rs.getInt("idkru");
                dta[1] = rs.getString("nama");
                dta[2] = rs.getString("umur");
                dta[3] = rs.getString("asal");
                tm.addRow(dta);
            }
            cnn.close();
        }
    }
    private void StoreData() throws SQLException{
        Connection cnn = getConnection();
        String NM = txNAMA.getText();
        String UM = txASAL.getText();
        String AS = txUMUR.getText();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO dataonepiece (nama,umur,asal)VALUES(?,?,?);");
            ps.setString(1, NM);
            ps.setString(2, UM);
            ps.setString(3, AS);
            ps.executeUpdate();
        }
    }
    private void UpdateData() throws SQLException{
        Connection cnn = getConnection();
        if(!cnn.isClosed()){
            String IDTEMAN = LBIDONEPIECE.getText();
            String NM = txNAMA.getText();
            String AL = txASAL.getText();
            String KN = txUMUR.getText();
            PreparedStatement ps = cnn.prepareStatement("UPDATE dataonepiece SET nama=?, umur =?, asal=? WHERE idkru=?;");
            ps.setString(1, NM);
            ps.setString(2, AL);
            ps.setString(3, KN);
            ps.setString(4, IDTEMAN);
            ps.executeUpdate();
            
            cnn.close();
        }
    }
    private void DestroyData() throws SQLException{
        Connection cnn = getConnection();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("DELETE FROM dataonepiece WHERE idkru=?;");
            ps.setString(1, LBIDONEPIECE.getText() );
            ps.executeUpdate();
            cnn.close();
        }
    }
    private void loadphoto(String idkru){
        String pas0 = "img/photo.jpg";
        String pas = "img/photo"+idkru+".jpg";
        
        BufferedImage bimg = loadIMG.loadImage(pas);
        if(bimg == null){
            bimg = loadIMG.loadImage(pas0);
        }
        ImageIcon icoimg = new ImageIcon(bimg);
        pasphoto.setIcon(icoimg);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txASAL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txUMUR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LBIDONEPIECE = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmdHapus = new javax.swing.JButton();
        cmdBaru = new javax.swing.JButton();
        cmdTutup = new javax.swing.JButton();
        cmdUbah = new javax.swing.JButton();
        pasphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Data OnePiece");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        txNAMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNAMAActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Umur");

        txASAL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Asal");

        txUMUR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txUMUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUMURActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Record:");

        LBIDONEPIECE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LBIDONEPIECE.setText("888");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("/");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("888");

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBaru.setText("Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        cmdTutup.setText("Tutup");
        cmdTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTutupActionPerformed(evt);
            }
        });

        cmdUbah.setText("Ubah");
        cmdUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUbahActionPerformed(evt);
            }
        });

        pasphoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txASAL)
                                    .addComponent(txUMUR)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LBIDONEPIECE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel1))
                                .addGap(88, 88, 88))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pasphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdBaru)
                        .addGap(18, 18, 18)
                        .addComponent(cmdUbah)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(cmdHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdTutup)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(LBIDONEPIECE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(pasphoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txASAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txUMUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cmdTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmdHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTutupActionPerformed
        if(cmdTutup.getText().equals("Tutup")){
            int jtp = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menutup Form?", 
                    "Konfirmasi Tutup Form", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jtp == JOptionPane.YES_OPTION){
                dispose();
            }
        }else{
            cmdTutup.setText("Tutup");
            cmdBaru.setText("Baru");
            cmdHapus.setEnabled(true);
        }
    }//GEN-LAST:event_cmdTutupActionPerformed

    private void jtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMouseClicked
        LBIDONEPIECE.setText(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
        txNAMA.setText(jtb.getValueAt(jtb.getSelectedRow(), 1).toString());
        txASAL.setText(jtb.getValueAt(jtb.getSelectedRow(), 2).toString());
        txUMUR.setText(jtb.getValueAt(jtb.getSelectedRow(), 3).toString());
        loadphoto(LBIDONEPIECE.getText());
    }//GEN-LAST:event_jtbMouseClicked

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
        if( cmdBaru.getText().equals("Baru") ){
            cmdBaru.setText("Simpan");
            cmdTutup.setText("Batal");
            cmdHapus.setEnabled(false);
            
            txNAMA.setText("");
            txASAL.setText("");
            txUMUR.setText("");
            
        }else{
            try {
                StoreData();
                list_all();
            } catch (SQLException ex) {
                Logger.getLogger(frmdataonepiece.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmdBaru.setText("Baru");
            cmdTutup.setText("Tutup");
            cmdHapus.setEnabled(true);
        }
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void cmdUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUbahActionPerformed
        try {
            UpdateData();
            list_all();
        } catch (SQLException ex) {
            Logger.getLogger(frmdataonepiece.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Terjadi error");
        }
        
    }//GEN-LAST:event_cmdUbahActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        
        try {
            int jtp = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menghapus data teman: "+txNAMA.getText()+"?", 
                    "Konfirmasi Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jtp == JOptionPane.YES_OPTION){
                DestroyData();
                list_all();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frmdataonepiece.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmdHapusActionPerformed

    private void txNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNAMAActionPerformed

    private void txUMURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUMURActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUMURActionPerformed

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
            java.util.logging.Logger.getLogger(frmdataonepiece.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdataonepiece.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdataonepiece.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdataonepiece.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmdataonepiece().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmdataonepiece.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBIDONEPIECE;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdTutup;
    private javax.swing.JButton cmdUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb;
    private javax.swing.JLabel pasphoto;
    private javax.swing.JTextField txASAL;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txUMUR;
    // End of variables declaration//GEN-END:variables
}