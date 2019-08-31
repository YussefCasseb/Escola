package escola.Model;

import escola.DAO.AlunoDAO;
import escola.Objetos.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel{

    private String[] colunas = {"Nome","Email","RA"};
    private List<Aluno> dados = new ArrayList<>();

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getEmail();
            case 2:
                return dados.get(linha).getRa();
        }

        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setNome((String) valor);
                break;
            case 1:
                dados.get(linha).setEmail((String) valor);
                break;
            case 2:
                dados.get(linha).setRa((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Aluno a) {        
        this.dados.add(a);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Aluno PegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void LerDados(){
        
        AlunoDAO adao = new AlunoDAO();
        
        for (Aluno a: adao.read()) {
            this.addLinha(a);
        }
        
        this.fireTableDataChanged();
        
    }
    
    public void Search(String tipo, String valor){
        
        this.dados.clear();
        AlunoDAO adao = new AlunoDAO();
        for (Aluno a: adao.Search(tipo, valor)) {
            this.addLinha(a);
        }
        
        this.fireTableDataChanged();
        
    }
    
    public void RecarregaTabela(){
        this.dados.clear();
        LerDados();
        this.fireTableDataChanged();
    }
    
    public List<Aluno> RetornaArray(){
        return dados;
    }
    
}
