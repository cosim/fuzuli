/*
 * fuzuli : A general purpose interpreter
 * Copyright (C) 2013 Mehmet Hakan Satman <mhsatman@yahoo.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Editor;

import Interpreter.Environment;
import Interpreter.Expression;
import Interpreter.Parser;
import Compiler.Fuzulic;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


/*
 * Icon Library:
 * http://www.iconfinder.com/search/?q=iconset%3Aonebit
 */
public class MainFrame extends javax.swing.JFrame {

    public static boolean loaded = false;
    String currentFilename;
    Parser parser;
    Environment globalEnvironment;
    FuzuliOutputStream fos;
    FuzuliColorizer colorizer;
    AboutForm aboutForm;
    Fuzulic compiler;
    
    public JTextPane getTextPane(){
        return (this.jTextPane1);
    }
    public MainFrame() {
        initComponents();
        globalEnvironment = new Environment(null);
        fos = new FuzuliOutputStream(this.jTextArea1);
        colorizer = new FuzuliColorizer(this);
        this.setSize(new Dimension(800, 600));
        aboutForm = new AboutForm(this, true);
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/Editor/images/icon.png"));
        this.setIconImage(ii.getImage());
        
        System.setOut(fos.getPrintStream());
        System.setErr(fos.getPrintStream());
        
        MainFrame.loaded = true;
    }
    
    public void setCaption(String s) {
        this.setTitle("Fuzuli Editor: " + s);
    }

    public void output(String s) {
        this.jTextArea1.setText(this.jTextArea1.getText() + s + "\n");
        this.jTextArea1.setSelectionStart(this.jTextArea1.getText().length() - 2);
        this.jTextArea1.setSelectionEnd(this.jTextArea1.getText().length() - 1);
    }
    
    public void updateOutput(){
        String text = fos.readText();
        if (text.length()>0){
            output(fos.readText());
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

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fuzuli Editor");

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/new.png"))); // NOI18N
        jButton1.setToolTipText("New");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/load.png"))); // NOI18N
        jButton2.setToolTipText("Open");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/save.png"))); // NOI18N
        jButton3.setToolTipText("Save");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/run.png"))); // NOI18N
        jButton4.setToolTipText("Run");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/compile.png"))); // NOI18N
        jButton6.setToolTipText("Compile");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/images/about.png"))); // NOI18N
        jButton5.setToolTipText("About");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextPane1.setDoubleBuffered(true);
        jTextPane1.setMargin(new java.awt.Insets(8, 8, 8, 8));
        jScrollPane3.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser filer = new JFileChooser();
        int result = filer.showOpenDialog(this);
        File file = null;
        if (result == 0) {
            file = filer.getSelectedFile();
            this.currentFilename = file.toString();
            this.setCaption(this.currentFilename);
            parser = new Parser(file);
            this.jTextPane1.setText(parser.getSourceCode());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File file = null;
        if(this.currentFilename != null){
            file = new File(this.currentFilename);
        }else{
            JFileChooser filechooser = new JFileChooser();
            int result = filechooser.showSaveDialog(this);            
            if (result == 0){
                file = filechooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, file);
            }else {
                return;
            }
        }
        
        if(file != null){
            try{
                this.currentFilename = file.toString();
                FileWriter writer = new FileWriter(file);
                writer.write(this.jTextPane1.getText());
                writer.flush();
                writer.close();
                output("File saved: "+this.currentFilename);
            }catch (Exception e){
                output(e.toString());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String code = this.jTextPane1.getText();
        Expression expr;
        Object result;

        try {
            if (this.parser == null) {
                parser = new Parser(code);
                parser.resetParser();
            } else {
                parser.setSourceCode(code);
                parser.resetParser();
            }
        } catch (Exception e) {
            output(e.toString());
        }

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Expression expr = parser.getNextExpression();
                        if (expr == null) {
                            break;
                        }
                        expr.eval(globalEnvironment);
                        output(MainFrame.this.fos.readText());
                    } catch (Exception e) {
                        output(e.toString());
                        break;
                    }
                }
            }
        }
                );
        th.start();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        aboutForm.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(this.currentFilename==null){
            output("Please save your file first");
            return;
        }
        String[] args= new String[]{this.currentFilename};
        compiler = new Fuzulic(args);
        output("Started to compiling "+currentFilename);
        File JARFile = compiler.compile(currentFilename);
        output("Compiled to "+JARFile.toURI());
        this.updateOutput();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    
    public static void showSplashScreen(){
        ImageIcon ii = new ImageIcon(MainFrame.class.getResource("/Editor/images/jfuzuliblack.jpg"));
        final JFrame splashform = new JFrame();
        JButton but = new JButton(ii);
        but.setContentAreaFilled(false);
        splashform.add(but);
        splashform.setUndecorated(true);
        splashform.setSize(ii.getIconWidth(),ii.getIconHeight());
        splashform.setLocationRelativeTo(null);
        splashform.setVisible(true);
        
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            
        }
        
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    try{
                        Thread.sleep(100);
                        if(MainFrame.loaded){
                            break;
                        }
                    }catch (Exception e){
                        
                    }
                }
                splashform.dispose();
            }
        });
        th.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        showSplashScreen();
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
