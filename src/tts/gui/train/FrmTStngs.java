/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui.train;

import java.awt.ComponentOrientation;
import tts.gui.Settings;

/**
 *
 * @author Ossama Nasser <ossnass@gmail.com>
 */
public class FrmTStngs extends javax.swing.JPanel {

    /**
     * Creates new form FrmTStngs
     */
    public FrmTStngs() {
        initComponents();
        Settings.setDirection(this, ComponentOrientation.RIGHT_TO_LEFT);
    }

    public boolean isValidValues() {
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 4; j++) {
                try {
                    double d = Double.parseDouble(TblIV.getModel().getValueAt(i, j).toString());
                    System.out.println(i + ":" + j + ":" + TblIV.getModel().getValueAt(i, j).toString());
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return TxtNormal.getText().trim().length() != 0;
    }

    public int getTrainingRounds() {
        return (Integer) SpnrTr.getModel().getValue();
    }

    public String getTrainingData() {
        return TxtNormal.getText();
    }

    public double[][] getInitialValues() {
        double res[][] = new double[3][2];

        for (int j = 1; j < 4; j++) {
            for (int i = 0; i < 2; i++) {
                res[j - 1][i] = Double.parseDouble(TblIV.getModel().getValueAt(i, j).toString());
            }
        }
        return res;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblTR = new javax.swing.JLabel();
        SpnrTr = new javax.swing.JSpinner();
        LblIV = new javax.swing.JLabel();
        SPLIV = new javax.swing.JScrollPane();
        TblIV = new javax.swing.JTable();
        LblTV = new javax.swing.JLabel();
        SPLNormal = new javax.swing.JScrollPane();
        TxtNormal = new javax.swing.JTextArea();

        LblTR.setLabelFor(SpnrTr);
        LblTR.setText("عدد دورات التدريب :");

        SpnrTr.setModel(new javax.swing.SpinnerNumberModel(10, 10, 10000, 1));

        LblIV.setText("القيم الابتدائية :");
        LblIV.setToolTipText("");

        TblIV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"المتوسط الحسابي", null, null, null},
                {"الانحراف المعياري", null, null, null}
            },
            new String [] {
                "", "الزمن القصير", "الزمن المتوسط", "الزمن الطويل"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblIV.setColumnSelectionAllowed(true);
        TblIV.getTableHeader().setReorderingAllowed(false);
        TblIV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TblIVFocusLost(evt);
            }
        });
        SPLIV.setViewportView(TblIV);
        TblIV.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        LblTV.setText("القيم التدريبية :");

        SPLNormal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TxtNormal.setColumns(20);
        TxtNormal.setFont(new java.awt.Font("Droid Arabic Naskh", 0, 36)); // NOI18N
        TxtNormal.setRows(5);
        TxtNormal.setToolTipText("");
        TxtNormal.setWrapStyleWord(true);
        TxtNormal.setMargin(new java.awt.Insets(10, 10, 10, 10));
        SPLNormal.setViewportView(TxtNormal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPLIV, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblTR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpnrTr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblIV)
                            .addComponent(LblTV))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SPLNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTR)
                    .addComponent(SpnrTr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblIV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPLIV, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTV)
                .addContainerGap(260, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(SPLNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TblIVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TblIVFocusLost
        if (TblIV.getCellEditor() != null) {
            TblIV.getCellEditor().stopCellEditing();
        }
    }//GEN-LAST:event_TblIVFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblIV;
    private javax.swing.JLabel LblTR;
    private javax.swing.JLabel LblTV;
    private javax.swing.JScrollPane SPLIV;
    private javax.swing.JScrollPane SPLNormal;
    private javax.swing.JSpinner SpnrTr;
    private javax.swing.JTable TblIV;
    private javax.swing.JTextArea TxtNormal;
    // End of variables declaration//GEN-END:variables
}