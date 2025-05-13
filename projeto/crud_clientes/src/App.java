import javax.swing.*;

import dao.ClienteMapDAO;
import dao.IClienteDAO;

public class App {
    public static void main(String[] args) throws Exception {
        IClienteDAO clienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para exclusao, 4 para alteracao ou 5 para sair",
        "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        
        if("1".equals(opcao)){
            JOptionPane.showMessageDialog(null, "Opcao: "+opcao, "Exibe Opcao", JOptionPane.INFORMATION_MESSAGE);
        } else if("2".equals(opcao)) {
            JOptionPane.showMessageDialog(null, "Opcao: "+opcao, "Exibe Opcao", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOpcaoValida'");
    }

    
}
