/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui;

import java.awt.ComponentOrientation;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import tts.core.TTSEngine;
import tts.gui.train.FrmTrain;

public class FrmStngs extends javax.swing.JDialog {
    
    Settings set;

    /**
     * Creates new form FrmStngs
     */
    public FrmStngs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        set = Settings.getSettings();
        initComponents();
        Settings.setDirection(this, ComponentOrientation.RIGHT_TO_LEFT);
        TxtMbrola.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        TxtPhoneme.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        TxtMbrola.setText(set.getMBROLA());
        TxtPhoneme.setText(set.getPhonemeDB());
        TxtStat.setText(set.getStats());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtMbrola = new javax.swing.JTextField();
        LblMbrola = new javax.swing.JLabel();
        BtnBrwsMBROLA = new javax.swing.JButton();
        LblPhoneme = new javax.swing.JLabel();
        TxtPhoneme = new javax.swing.JTextField();
        BtnBrwsPhoneme = new javax.swing.JButton();
        BtnCncl = new javax.swing.JButton();
        BtnOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TxtStat = new javax.swing.JTextField();
        BtnBrwsStat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("إعدادات");

        LblMbrola.setText("مسار برنامج MBROLA :");

        BtnBrwsMBROLA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/browse.png"))); // NOI18N
        BtnBrwsMBROLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBrwsMBROLAActionPerformed(evt);
            }
        });

        LblPhoneme.setText("مسار قاعدة المقاطع الصوتية :");

        BtnBrwsPhoneme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/browse.png"))); // NOI18N
        BtnBrwsPhoneme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBrwsPhonemeActionPerformed(evt);
            }
        });

        BtnCncl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/cancel.png"))); // NOI18N
        BtnCncl.setText("إلغاء الأمر");
        BtnCncl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCnclActionPerformed(evt);
            }
        });

        BtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/okay.png"))); // NOI18N
        BtnOK.setText("حفظ");
        BtnOK.setToolTipText("");
        BtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOKActionPerformed(evt);
            }
        });

        jLabel1.setText("ملف الإحصائيات :");

        BtnBrwsStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tts/gui/icons/browse.png"))); // NOI18N
        BtnBrwsStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBrwsStatActionPerformed(evt);
            }
        });

        jButton1.setText("جديد");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPhoneme)
                            .addComponent(TxtMbrola))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnBrwsPhoneme, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnBrwsMBROLA, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCncl))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblMbrola)
                            .addComponent(LblPhoneme)
                            .addComponent(jLabel1))
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtStat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBrwsStat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblMbrola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnBrwsMBROLA)
                    .addComponent(TxtMbrola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblPhoneme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TxtPhoneme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBrwsPhoneme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1)
                    .addComponent(BtnBrwsStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnOK)
                    .addComponent(BtnCncl))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(TxtStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOKActionPerformed
//حفظ الإعدادات

        set.setMBROLA(TxtMbrola.getText());
        set.setPhonemeDB(TxtPhoneme.getText());
        set.setStats(TxtStat.getText());
        TTSEngine.getTTSEngine().loadStats(TxtStat.getText());
        setVisible(false);
    }//GEN-LAST:event_BtnOKActionPerformed

    private void BtnBrwsMBROLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBrwsMBROLAActionPerformed
        JDialog Mbrola_Select = new JDialog(this, "الرجاء اختيار مسار MBROLA", true);
        String old_path = TxtMbrola.getText();
        if (!(old_path.equals("")) && old_path.lastIndexOf(System.getProperty("file.separator")) > 0) {
            System.out.println(old_path.lastIndexOf(System.getProperty("file.separator")));
            old_path = old_path.substring(0, old_path.lastIndexOf(System.getProperty("file.separator")));
        }
        JFileChooser choose = new JFileChooser(old_path);
        choose.setDialogTitle("الرجاء اختيار مسار MBROLA");
        int res = choose.showOpenDialog(Mbrola_Select);
        if (res == JFileChooser.APPROVE_OPTION) {
            TxtMbrola.setText(choose.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_BtnBrwsMBROLAActionPerformed

    private void BtnCnclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCnclActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BtnCnclActionPerformed

    private void BtnBrwsPhonemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBrwsPhonemeActionPerformed
        JDialog Mbrola_Select = new JDialog(this, "الرجاء اختيار مسار  قاعدة المقاطع الصوتية", true);
        String old_path = TxtPhoneme.getText();
        if (!(old_path.equals("")) && old_path.lastIndexOf(System.getProperty("file.separator")) > 0) {
            old_path = old_path.substring(0, old_path.lastIndexOf(System.getProperty("file.separator")));
        }
        JFileChooser choose = new JFileChooser(old_path);
        choose.setDialogTitle("الرجاء اختيار مسار  قاعدة المقاطع الصوتية");
        int res = choose.showOpenDialog(Mbrola_Select);
        if (res == JFileChooser.APPROVE_OPTION) {
            TxtPhoneme.setText(choose.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_BtnBrwsPhonemeActionPerformed

    private void BtnBrwsStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBrwsStatActionPerformed
        JDialog Mbrola_Select = new JDialog(this, "الرجاء اختيار مسار  ملف الإحصائيات", true);
        String old_path = TxtStat.getText();
        if (!(old_path.equals("")) && old_path.lastIndexOf(System.getProperty("file.separator")) > 0) {
            old_path = old_path.substring(0, old_path.lastIndexOf(System.getProperty("file.separator")));
        }
        JFileChooser choose = new JFileChooser(old_path);
        choose.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".attd");
            }
            
            @Override
            public String getDescription() {
                return "AraTTSJ Training Data";
            }
            
        });
        choose.setDialogTitle("الرجاء اختيار مسار  ملف الإحصائيات");
        int res = choose.showOpenDialog(Mbrola_Select);
        if (res == JFileChooser.APPROVE_OPTION) {
            TxtStat.setText(choose.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_BtnBrwsStatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FrmTrain((JFrame) this.getParent(), true).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBrwsMBROLA;
    private javax.swing.JButton BtnBrwsPhoneme;
    private javax.swing.JButton BtnBrwsStat;
    private javax.swing.JButton BtnCncl;
    private javax.swing.JButton BtnOK;
    private javax.swing.JLabel LblMbrola;
    private javax.swing.JLabel LblPhoneme;
    private javax.swing.JTextField TxtMbrola;
    private javax.swing.JTextField TxtPhoneme;
    private javax.swing.JTextField TxtStat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
