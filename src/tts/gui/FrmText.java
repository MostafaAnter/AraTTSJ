/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui;

/**
 *
 * @author ossama
 */
public class FrmText extends javax.swing.JPanel {

    /**
     * Creates new form FrmText
     */
    public FrmText() {
        initComponents();
    }

    public String getText() {
        return TxtNormal.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SPLNormal = new javax.swing.JScrollPane();
        TxtNormal = new javax.swing.JTextArea();

        TxtNormal.setColumns(20);
        TxtNormal.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        TxtNormal.setRows(5);
        SPLNormal.setViewportView(TxtNormal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SPLNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SPLNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPLNormal;
    private javax.swing.JTextArea TxtNormal;
    // End of variables declaration//GEN-END:variables
}
