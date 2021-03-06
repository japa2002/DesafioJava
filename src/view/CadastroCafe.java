/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

/**
 *
 * @author Leonardo
 */
public class CadastroCafe extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
     * Creates new form CadastroCafe
     */
    public CadastroCafe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        jLabelEspacoCafeTitulo = new javax.swing.JLabel();
        jLabelNomeEspacoCafe = new javax.swing.JLabel();
        jTextFieldNomeEspacoCafe = new javax.swing.JTextField();
        jLabelLotacaoCafe = new javax.swing.JLabel();
        jTextFieldLotacaoCafe = new javax.swing.JTextField();
        jButtonSalvarCafe = new javax.swing.JButton();
        jButtonSalvarCafe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(!(jTextFieldNomeEspacoCafe.getText().equals("")) && !(jTextFieldLotacaoCafe.getText().equals(""))) {
        			
        			
        		}else {
        			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        		}
        	}
        });
        jLabelFundoCafe = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 322));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelEspacoCafeTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEspacoCafeTitulo.setText("Espa\u00E7o caf\u00E9");
        getContentPane().add(jLabelEspacoCafeTitulo);
        jLabelEspacoCafeTitulo.setBounds(150, 30, 100, 17);

        jLabelNomeEspacoCafe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeEspacoCafe.setText("Nome do espa\u00E7o de caf\u00E9:");
        getContentPane().add(jLabelNomeEspacoCafe);
        jLabelNomeEspacoCafe.setBounds(20, 100, 160, 30);
        getContentPane().add(jTextFieldNomeEspacoCafe);
        jTextFieldNomeEspacoCafe.setBounds(190, 100, 180, 30);

        jLabelLotacaoCafe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLotacaoCafe.setText("Lota\u00E7\u00E3o:");
        getContentPane().add(jLabelLotacaoCafe);
        jLabelLotacaoCafe.setBounds(20, 160, 60, 30);
        getContentPane().add(jTextFieldLotacaoCafe);
        jTextFieldLotacaoCafe.setBounds(90, 160, 70, 30);

        jButtonSalvarCafe.setText("Salvar");
        getContentPane().add(jButtonSalvarCafe);
        jButtonSalvarCafe.setBounds(150, 250, 90, 30);

        jLabelFundoCafe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/plano de fundo.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoCafe);
        jLabelFundoCafe.setBounds(-1, -2, 420, 350);

        setSize(new java.awt.Dimension(416, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CadastroCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCafe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvarCafe;
    private javax.swing.JLabel jLabelEspacoCafeTitulo;
    private javax.swing.JLabel jLabelFundoCafe;
    private javax.swing.JLabel jLabelLotacaoCafe;
    private javax.swing.JLabel jLabelNomeEspacoCafe;
    private javax.swing.JTextField jTextFieldLotacaoCafe;
    private javax.swing.JTextField jTextFieldNomeEspacoCafe;
    // End of variables declaration//GEN-END:variables
    
  
}
