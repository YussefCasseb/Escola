package escola;

import escola.Interfaces.CadastroAluno;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Escola {

    public static void main(String[] args) {
        CadastroAluno cad = new CadastroAluno();
        cad.setVisible(true);
        cad.setLocationRelativeTo(null);
    }
    
}
