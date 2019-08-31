package escola.Interfaces;

import PDF.GerarPDF;
import escola.DAO.AlunoDAO;
import escola.Model.AlunoTableModel;
import escola.Objetos.Aluno;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CadastroAluno extends javax.swing.JFrame {

    AlunoTableModel modelo = new AlunoTableModel();
    
    public CadastroAluno() {
        //Designer da Interface e seus Componentes
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	}catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            throw new RuntimeException("Erro: " +e);
	}
        initComponents();
        modelo.RecarregaTabela();
        jTAlunos.setModel(modelo);
        //Add valores ao combobox
        List<Aluno> al = modelo.RetornaArray();
        for (Aluno aluno : al) {
           jCNomes.addItem(aluno.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTEmail = new javax.swing.JTextField();
        jTRa = new javax.swing.JTextField();
        jBCad = new javax.swing.JButton();
        jBAlt = new javax.swing.JButton();
        jBExc = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jCNomes = new javax.swing.JComboBox<>();
        jBPdf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nome:");

        jLabel2.setText("Email:");

        jLabel3.setText("RA:");

        jBCad.setText("Cadastrar");
        jBCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadActionPerformed(evt);
            }
        });

        jBAlt.setText("Alterar");
        jBAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltActionPerformed(evt);
            }
        });

        jBExc.setText("Excluir");
        jBExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcActionPerformed(evt);
            }
        });

        jBPesquisar.setText("Pesquisar Aluno");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jCNomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCNomesActionPerformed(evt);
            }
        });

        jBPdf.setText("Gerar PDF");
        jBPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTRa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAlt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBPdf)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBExc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCNomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCad)
                    .addComponent(jCNomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAlt)
                    .addComponent(jBPdf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExc)
                    .addComponent(jBPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTAlunos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadActionPerformed
        Aluno a = new Aluno();
        AlunoDAO adao = new AlunoDAO();
        if(jTNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nome está vazio!");
            jTNome.requestFocus();
        }else if(jTEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email está vazio!");
            jTEmail.requestFocus();
        }else if(jTRa.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "RA está vazio!");
            jTRa.requestFocus();
        }else{
        if(adao.Search(jTRa.getText())){
            JOptionPane.showMessageDialog(this, "Aluno já Existe!");
        }else{
            a.setNome(jTNome.getText());
            a.setEmail(jTEmail.getText());
            a.setRa(jTRa.getText());
            adao.Create(a);
            modelo.RecarregaTabela();
            LimpaCampos();
        }
        }
    }//GEN-LAST:event_jBCadActionPerformed

    private void jTAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAlunosMouseClicked
        jTNome.setText(String.valueOf(modelo.getValueAt(jTAlunos.getSelectedRow(), 0)));
        jTEmail.setText(String.valueOf(modelo.getValueAt(jTAlunos.getSelectedRow(), 1)));
        jTRa.setText(String.valueOf(modelo.getValueAt(jTAlunos.getSelectedRow(), 2)));
    }//GEN-LAST:event_jTAlunosMouseClicked

    private void jBAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltActionPerformed
        AlunoDAO adao = new AlunoDAO();
        if(jTAlunos.getSelectedRow() != -1){
            modelo.setValueAt(jTNome.getText(), jTAlunos.getSelectedRow(), 0);
            modelo.setValueAt(jTEmail.getText(), jTAlunos.getSelectedRow(), 1);
            modelo.setValueAt(jTRa.getText(), jTAlunos.getSelectedRow(), 2);
            Aluno a = modelo.PegaDadosLinha(jTAlunos.getSelectedRow());
            adao.Update(a);
            LimpaCampos();
        }
    }//GEN-LAST:event_jBAltActionPerformed

    private void jBExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcActionPerformed
        AlunoDAO adao = new AlunoDAO();
        if(jTAlunos.getSelectedRow() != -1){
            adao.Delete(modelo.PegaDadosLinha(jTAlunos.getSelectedRow()).getId());
            modelo.RecarregaTabela();
            LimpaCampos();
        }
    }//GEN-LAST:event_jBExcActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        PesquisaAluno pa = new PesquisaAluno();
        pa.setVisible(true);
        pa.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jCNomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCNomesActionPerformed
        
    }//GEN-LAST:event_jCNomesActionPerformed

    private void jBPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPdfActionPerformed
        GerarPDF pdf = new GerarPDF();
        pdf.GerarPDF(modelo.RetornaArray());
    }//GEN-LAST:event_jBPdfActionPerformed

    public void LimpaCampos(){
        jTNome.setText("");
        jTEmail.setText("");
        jTRa.setText("");
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlt;
    private javax.swing.JButton jBCad;
    private javax.swing.JButton jBExc;
    private javax.swing.JButton jBPdf;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JComboBox<String> jCNomes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAlunos;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTRa;
    // End of variables declaration//GEN-END:variables
}
