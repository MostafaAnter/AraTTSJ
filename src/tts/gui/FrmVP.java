/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui;

import java.awt.ComponentOrientation;
import javax.swing.table.DefaultTableModel;
import tts.core.phonemes.types.Word;


public class FrmVP extends javax.swing.JPanel {

    /**
     * Creates new form FrmVP
     */
    public FrmVP() {
        initComponents();
           Settings.setDirection(this, ComponentOrientation.RIGHT_TO_LEFT);
    }

    public void setWords(Word[] words) {
        DefaultTableModel tbl = (DefaultTableModel) TblVP.getModel();
        tbl.setRowCount(0);
        for (Word word : words) {
            for (int j = 0; j < word.getPhonemes().length; j++) {
                if (j == 0) {
                    tbl.addRow(new Object[]{word.getNormal(), word.getEnd().toString(),
                        word.getVocal(), word.getPhonemes()[j].getPhoneme(),
                        word.getPhonemes()[j].getTime(), word.getPhonemes()[j].pitchString()});
                } else {
                    tbl.addRow(new Object[]{"", "", "", word.getPhonemes()[j].getPhoneme(),
                        word.getPhonemes()[j].getTime(), word.getPhonemes()[j].pitchString()});
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SPLVP = new javax.swing.JScrollPane();
        TblVP = new javax.swing.JTable();

        TblVP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "الكتابة العادية", "نهاية الكلمة", "الكتابة الصوتية", "المقطع الصوتي", "الزمن", "الطبقة"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SPLVP.setViewportView(TblVP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SPLVP, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SPLVP, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPLVP;
    private javax.swing.JTable TblVP;
    // End of variables declaration//GEN-END:variables
}
