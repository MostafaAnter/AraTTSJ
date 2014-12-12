/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.gui;

import tts.core.phonemes.types.Phoneme;
import java.awt.Frame;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import tts.audioplayer.AudioPlayer;
import tts.core.*;
import tts.core.preprocess.vocalrules.TextVocalRule;
import tts.core.preprocess.vocalrules.VocalRule;
import tts.core.preprocess.vocalrules.WordVocalRule;

/**
 *
 * @author ossama
 */
public class FrmMain extends javax.swing.JFrame {

    TTSEngine tts;
    Settings set = Settings.getSettings();
    String AudioTarget = "";
    AudioPlayer player = new AudioPlayer();

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        tts = new TTSEngine();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TblControls = new javax.swing.JToolBar();
        BtnSettings = new javax.swing.JButton();
        BtnConvert = new javax.swing.JButton();
        BtnTalk = new javax.swing.JButton();
        PnlMain = new javax.swing.JPanel();
        PnlNormalText = new javax.swing.JPanel();
        LblNormalText = new javax.swing.JLabel();
        SPNormalText = new javax.swing.JScrollPane();
        TxtNormalText = new javax.swing.JTextArea();
        PnlSecondery = new javax.swing.JPanel();
        PnlVocalText = new javax.swing.JPanel();
        LblVocalText = new javax.swing.JLabel();
        SPVocalText = new javax.swing.JScrollPane();
        TxtVocalText = new javax.swing.JTextArea();
        PnlPhoneme = new javax.swing.JPanel();
        LblPhoneme = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AraTTS");
        setMinimumSize(new java.awt.Dimension(500, 350));

        TblControls.setFloatable(false);
        TblControls.setRollover(true);

        BtnSettings.setText("الإعدادات");
        BtnSettings.setFocusable(false);
        BtnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSettingsActionPerformed(evt);
            }
        });
        TblControls.add(BtnSettings);

        BtnConvert.setText("تحويل");
        BtnConvert.setFocusable(false);
        BtnConvert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnConvert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConvertActionPerformed(evt);
            }
        });
        TblControls.add(BtnConvert);

        BtnTalk.setText("لفظ");
        BtnTalk.setFocusable(false);
        BtnTalk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnTalk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnTalk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTalkActionPerformed(evt);
            }
        });
        TblControls.add(BtnTalk);

        PnlMain.setLayout(new java.awt.GridLayout(0, 1));

        LblNormalText.setText("النص الطبيعي :");

        TxtNormalText.setColumns(20);
        TxtNormalText.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        TxtNormalText.setRows(5);
        SPNormalText.setViewportView(TxtNormalText);

        javax.swing.GroupLayout PnlNormalTextLayout = new javax.swing.GroupLayout(PnlNormalText);
        PnlNormalText.setLayout(PnlNormalTextLayout);
        PnlNormalTextLayout.setHorizontalGroup(
            PnlNormalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNormalTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlNormalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPNormalText, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(PnlNormalTextLayout.createSequentialGroup()
                        .addComponent(LblNormalText)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlNormalTextLayout.setVerticalGroup(
            PnlNormalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNormalTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblNormalText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPNormalText, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        PnlMain.add(PnlNormalText);

        PnlSecondery.setLayout(new java.awt.GridLayout(1, 0));

        LblVocalText.setText("الكتابة الصوتية :");

        TxtVocalText.setEditable(false);
        TxtVocalText.setColumns(20);
        TxtVocalText.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        TxtVocalText.setRows(5);
        SPVocalText.setViewportView(TxtVocalText);

        javax.swing.GroupLayout PnlVocalTextLayout = new javax.swing.GroupLayout(PnlVocalText);
        PnlVocalText.setLayout(PnlVocalTextLayout);
        PnlVocalTextLayout.setHorizontalGroup(
            PnlVocalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlVocalTextLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlVocalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlVocalTextLayout.createSequentialGroup()
                        .addComponent(LblVocalText)
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addComponent(SPVocalText, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlVocalTextLayout.setVerticalGroup(
            PnlVocalTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlVocalTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblVocalText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPVocalText, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        PnlSecondery.add(PnlVocalText);

        LblPhoneme.setText("المقاطع اللفظية :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المقطع الصوتي", "المدة الزمنية", "الطبقة"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout PnlPhonemeLayout = new javax.swing.GroupLayout(PnlPhoneme);
        PnlPhoneme.setLayout(PnlPhonemeLayout);
        PnlPhonemeLayout.setHorizontalGroup(
            PnlPhonemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPhonemeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlPhonemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlPhonemeLayout.createSequentialGroup()
                        .addComponent(LblPhoneme)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlPhonemeLayout.setVerticalGroup(
            PnlPhonemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPhonemeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblPhoneme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        PnlSecondery.add(PnlPhoneme);

        PnlMain.add(PnlSecondery);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TblControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TblControls, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSettingsActionPerformed
        new FrmStngs(this, true).setVisible(true);
    }//GEN-LAST:event_BtnSettingsActionPerformed

    private void BtnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConvertActionPerformed
        JDialog Mbrola_Select = new JDialog(this, "الرجاء اختيار المسار الذي تريد أن تحفظ فيه الملف الصوتي", true);
        if (!(AudioTarget.equals(""))) {
            AudioTarget = AudioTarget.substring(0, AudioTarget.lastIndexOf(System.getProperty("file.separator")));
        }
        JFileChooser choose = new JFileChooser(AudioTarget);
        choose.setDialogTitle("الرجاء اختيار المسار الذي تريد أن تحفظ فيه الملف الصوتي");
        choose.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getAbsolutePath().toLowerCase().endsWith(".wav");
            }

            @Override
            public String getDescription() {
                return "Wave Files (*.wav)";
            }
        });
        int res = choose.showSaveDialog(Mbrola_Select);

        if (res == JFileChooser.APPROVE_OPTION) {
            AudioTarget = choose.getSelectedFile().getAbsolutePath();
        }
        if (!AudioTarget.toLowerCase().endsWith(".wav")) {
            AudioTarget += ".wav";
        }
        if (tts.convert(TxtNormalText.getText(), set.getMBROLA(), set.getPhonemeDB(), AudioTarget)) {
            String vocals[] = tts.getVocals();
            Phoneme[] phonemes = tts.getPhonemes();
            String text = "";
            for (int i = 0; i < vocals.length; i++) {
                text += vocals[i] + "\n";
            }
            TxtVocalText.setText(text);
            DefaultTableModel mod = (DefaultTableModel) jTable1.getModel();
            mod.setRowCount(0);
            for (int i = 0; i < phonemes.length; i++) {
                mod.addRow(new Object[]{
                    phonemes[i].getPhoneme(), phonemes[i].getTime(), phonemes[i].pitchString()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, tts.getError(), "خطأ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnConvertActionPerformed

    private void BtnTalkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTalkActionPerformed
        try {

            player.open(AudioTarget);
            player.play();
        } catch (Exception ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnTalkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        VocalRule[] x = WordVocalRule.getSet();

        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i].getPriority() + " " + x[i].toString());
        }
        VocalRule[] y = TextVocalRule.getSet();

        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i].getPriority() + " " + y[i].toString());
        }
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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConvert;
    private javax.swing.JButton BtnSettings;
    private javax.swing.JButton BtnTalk;
    private javax.swing.JLabel LblNormalText;
    private javax.swing.JLabel LblPhoneme;
    private javax.swing.JLabel LblVocalText;
    private javax.swing.JPanel PnlMain;
    private javax.swing.JPanel PnlNormalText;
    private javax.swing.JPanel PnlPhoneme;
    private javax.swing.JPanel PnlSecondery;
    private javax.swing.JPanel PnlVocalText;
    private javax.swing.JScrollPane SPNormalText;
    private javax.swing.JScrollPane SPVocalText;
    private javax.swing.JToolBar TblControls;
    private javax.swing.JTextArea TxtNormalText;
    private javax.swing.JTextArea TxtVocalText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
