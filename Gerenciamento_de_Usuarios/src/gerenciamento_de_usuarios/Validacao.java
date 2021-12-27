package gerenciamento_de_usuarios;

import javax.swing.*;


public class Validacao {


    public long validaRG(String RG) {
        String RG_TEMPLATE = "\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";

        while(!RG.matches(RG_TEMPLATE)) {
                RG = entradaVazia(JOptionPane.showInputDialog(null,"O registro geral contém " +
                        "10 números, serve para distinguir um funcionário do outro. Insira novamente: "));
        }
        return Long.parseLong(RG);
    }

    public int somenteNumeros(String entrada) {
        String SOMENTE_NUMEROS_TEMPLATE = "[0-9]+";
        while(!entrada.matches(SOMENTE_NUMEROS_TEMPLATE)){
            entrada = entradaVazia(JOptionPane.showInputDialog(null,
                    "Somente números são aceitos. Insira novamente: "));
        }
        return Integer.parseInt(entrada);
    }

    public String entradaVazia(String entrada) {
        entrada = String.valueOf(entrada);
        while(entrada.isEmpty()||entrada.isBlank()){
            entrada = JOptionPane.showInputDialog(null,"Entrada de dados vazia. Digite novamente: ");
            entrada = String.valueOf(entrada);
        }
        return entrada;
    }
}
