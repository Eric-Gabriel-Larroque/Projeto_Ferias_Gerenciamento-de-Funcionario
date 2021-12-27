package gerenciamento_de_usuarios;

import javax.swing.*;
import java.util.Arrays;

public class GUI {

    Validacao validacao = new Validacao();


    public void iniciar() {
        int resposta = 0;
        Integer[] respostasPossiveis = {1,2,3,4,5};

        if(Funcionario.listaFuncionarios.size()==0) {
            criarFrame("img/welcome.png","audio/iniciar.wav",3500);
        }
       while(!Arrays.asList(respostasPossiveis).contains(resposta)) {
           resposta = validacao.somenteNumeros(
                   validacao.entradaVazia(
                           JOptionPane.showInputDialog(null,"Você é um:\n" +
                                           "1 - Colaborador\n2 - Líder Técnico\n3 - Gerente de Departamento\n" +
                                           "4 - Gerente Geral\n5 - Sair"
                                   ,"Gerenciamento de Funcionários",JOptionPane.QUESTION_MESSAGE)
                   )
           );
       }
        switch (resposta) {
            case 1:
                new Colaborador();
                break;
            case 2:
                new LiderTecnico();
            case 3:
                    Gerente gerenteDepto = new GerenteDepartamento();
                break;
            case 4:
                if(Funcionario.listaFuncionarios.stream().anyMatch(f->f instanceof GerenteGeral&&f.getSituacao().equals("Empregado"))) {
                    JOptionPane.showMessageDialog(null,
                            "Só pode haver um único Gerente Geral.",
                            "Mais de um Gerente Geral",JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    Gerente gerenteGeral = new GerenteGeral();
                }
            case 5: encerrar();
                break;
        }
    }


            public void encerrar() {
               criarFrame("img/encerrar.jpg","audio/encerrar.wav",1500);
                System.exit(0);
            }

            public void criarFrame(String caminhoImg, String caminhoAudio,int tempoDeTela) {
                JFrame frame = new JFrame();
                JLabel label = new JLabel();
                ImageIcon image = new ImageIcon(caminhoImg);

                label.setIcon(image);
                frame.setTitle("Gerenciamento de Funcionários");
                frame.setSize(600,600);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.add(label);
                new Audio().tocarAudio(caminhoAudio);

                try {
                    Thread.sleep(tempoDeTela);
                    frame.setVisible(false);
                }catch (Exception e){

                }
            }
}