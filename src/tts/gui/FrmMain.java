/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui;

import java.awt.ComponentOrientation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import tts.core.*;
import tts.core.phonemes.types.Word;

public class FrmMain extends javax.swing.JFrame {
    
    private final TTSEngine tts;
    private final Settings set = Settings.getSettings();
    private final FrmText txt = new FrmText();
    private final FrmVP vp = new FrmVP();
    private final FrmCreate crt = new FrmCreate();
    private int index = 0;

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        
        initComponents();
        vp.setVisible(false);
        crt.setVisible(false);
        Settings.setDirection(this, ComponentOrientation.RIGHT_TO_LEFT);
        tts = TTSEngine.getTTSEngine();
        tts.loadStats(set.getStats());
        View.setViewportView(txt);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tbl = new javax.swing.JToolBar();
        BtnPrv = new javax.swing.JButton();
        BtnNxt = new javax.swing.JButton();
        BtnSet = new javax.swing.JButton();
        View = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AraTTS");
        setMinimumSize(new java.awt.Dimension(500, 350));

        Tbl.setFloatable(false);
        Tbl.setRollover(true);

        BtnPrv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/previous.png"))); // NOI18N
        BtnPrv.setText("السابق");
        BtnPrv.setFocusable(false);
        BtnPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrvActionPerformed(evt);
            }
        });
        Tbl.add(BtnPrv);

        BtnNxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/next.png"))); // NOI18N
        BtnNxt.setText("التالي");
        BtnNxt.setFocusable(false);
        BtnNxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNxtActionPerformed(evt);
            }
        });
        Tbl.add(BtnNxt);

        BtnSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/settings.png"))); // NOI18N
        BtnSet.setText("إعدادات");
        BtnSet.setFocusable(false);
        BtnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSetActionPerformed(evt);
            }
        });
        Tbl.add(BtnSet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(View)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(View, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNxtActionPerformed
        switch (index) {
            case 0:
                if (processText()) {
                    index++;
                    txt.setVisible(false);
                    vp.setWords(tts.getWords());
                    vp.setVisible(true);
                    View.setViewportView(vp);
                }
                break;
            case 1: {
                index++;
                vp.setVisible(false);
                crt.setVisible(true);
                View.setViewportView(crt);
                break;
            }
            
        }
    }//GEN-LAST:event_BtnNxtActionPerformed
    
    private boolean processText() {
        String text = txt.getText();
        if (text == null || text.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "لا يمكن أن يكون النص فارغاً", "خطأ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Word[] words = tts.convert(text);
        if (words == null) {
            JOptionPane.showMessageDialog(this, "حدث الخطأ التالي: \n" + tts.getError(), "خطأ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void BtnPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrvActionPerformed
        switch (index) {
            case 0:
                break;
            case 1:
                txt.setVisible(true);
                vp.setVisible(false);
                View.setViewportView(txt);
                index--;
                break;
            case 2:
                vp.setVisible(true);
                crt.setVisible(false);
                View.setViewportView(vp);
                index--;
                break;
            
        }
    }//GEN-LAST:event_BtnPrvActionPerformed

    private void BtnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSetActionPerformed
        
        new FrmStngs(this, true).setVisible(true);
    }//GEN-LAST:event_BtnSetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Settings.loadFonts();
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());        //</editor-fold>
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNxt;
    private javax.swing.JButton BtnPrv;
    private javax.swing.JButton BtnSet;
    private javax.swing.JToolBar Tbl;
    private javax.swing.JScrollPane View;
    // End of variables declaration//GEN-END:variables
}
