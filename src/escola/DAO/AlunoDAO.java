package escola.DAO;

import escola.Conexao.ConexaoSQL;
import escola.Objetos.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO {
    
    public void Create(Aluno a){
        
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tbl_aluno (Ra, Nome, Email) VALUES (?,?,?)");
            stmt.setString(1, a.getRa());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getEmail());
            if (stmt.execute()) {
                JOptionPane.showMessageDialog(null, "Falha ao Inserir!");
            } else {
                JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar informações: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt);
        }
    }
    
    public List<Aluno> read() {
        
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_aluno");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getInt("Id"));
                a.setRa(rs.getString("Ra"));
                a.setNome(rs.getString("Nome"));
                a.setEmail(rs.getString("Email"));
                alunos.add(a);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter registros do BD: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt, rs);
        }
        
        return alunos;    
    }
    
    public void Update(Aluno a){
    
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tbl_aluno SET Ra = ?, Nome = ?, Email = ? WHERE Id = ?");
            stmt.setString(1, a.getRa());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getEmail());
            stmt.setInt(4, a.getId());
            if (stmt.execute()) {
                JOptionPane.showMessageDialog(null, "Falha ao Atualizar!");
            } else {
                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt);
        }
        
    }
    
    public void Delete(int id){
    
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_aluno WHERE Id = ?");
            stmt.setInt(1, id);
            if (stmt.execute()) {
                JOptionPane.showMessageDialog(null, "Falha ao Excluir!");
            } else {
                JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o registro: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt);
        }
        
    }
    
    public boolean Search(String ra){
        
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean cont = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_aluno WHERE Ra = ?");
            stmt.setString(1, ra);
            rs = stmt.executeQuery();
            if(rs.next()){
                cont = true;
            }else{
                cont = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter registros do BD: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt, rs);
        }
        return cont;
        
    }
    
    public List<Aluno> Search(String tipo, String valor){
        
        Connection con = ConexaoSQL.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            if(tipo.equals("Ra")){
                stmt = con.prepareStatement("SELECT * FROM tbl_aluno WHERE Ra = ?");
            }else{
                stmt = con.prepareStatement("SELECT * FROM tbl_aluno WHERE Nome = ?");
            }
            stmt.setString(1, valor);
            rs = stmt.executeQuery();
              if(rs.next()){
                  do{                      
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("Id"));
                    a.setRa(rs.getString("Ra"));
                    a.setNome(rs.getString("Nome"));
                    a.setEmail(rs.getString("Email"));
                    alunos.add(a);
                  }while (rs.next());
              }else{
                JOptionPane.showMessageDialog(null, "Cadastro Não Encontrado");
              }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter registros do BD: " +e);
        } finally {
            ConexaoSQL.CloseConnection(con, stmt, rs);
        }
        
        return alunos;
    }
    
//    public int Somar(){
//    
//        Connection con = ConexaoSQL.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        int cont = 0;
//        
//        try {
//            stmt = con.prepareStatement("SELECT sum(Id) as soma FROM tbl_aluno");
//            rs = stmt.executeQuery();
//            if(rs.next()){
//                cont = Integer.parseInt(rs.getString("soma"));
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao obter registros do BD: " +e);
//        } finally {
//            ConexaoSQL.CloseConnection(con, stmt, rs);
//        }
//        return cont;
//        
//    }
    
}
