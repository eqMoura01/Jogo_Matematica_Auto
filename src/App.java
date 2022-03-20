import java.util.Random;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {

        String name = login();
        double tempoInicio = (System.currentTimeMillis() / 1000);
        int pontos = jogo();
        fimDeJogo(name, pontos, tempoInicio);

    }

    public static String login() {

        String name = "";
        String opc[] = { "Sim", "Não" };
        boolean y = false;

        while (y == false) {
            name = JOptionPane.showInputDialog(
                    "Seja bem-vindo ao CalcMaster,\no jogo de calculos matematicos!\n\nPor favor insira um nome", null);

            if (name == null || name.equals("")) {
                int x = JOptionPane.showOptionDialog(null,
                        "Você deixou o nome em branco, gostaria de continuar o jogo?", "ERRO",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, opc, opc[0]);

                if (x == 1) {
                    JOptionPane.showMessageDialog(null, "Ok, então iremos fechar o jogo.");
                    System.exit(0);
                }
            } else {
                y = true;
            }

        }

        int respJO = JOptionPane.showOptionDialog(null, "Você quer iniciar o jogo?", "Olá " + name + ".",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opc, opc[0]);

        if (respJO == 0) {
            return name;
        } else {
            JOptionPane.showMessageDialog(null, "Ok, então iremos fechar o jogo.");
            System.exit(0);
        }

        return name;

    }

    public static int jogo() {

        int pontos = 0;
        int respJO = 0;

        while (respJO == 0) {

            Random random = new Random();
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            int x = random.nextInt(2);
            String funcao[] = { "+", "-" };
            String opcoes[] = { "Sim", "Não" };
            String respPergunta = "";
            boolean controladorResposta = false;

            while (controladorResposta == false) {

                respPergunta = JOptionPane.showInputDialog(null,
                        "Quanto é " + num1 + " " + funcao[x] + " " + num2 + "?");

                if (respPergunta == null || respPergunta.equals("")) {
                    int a = JOptionPane.showOptionDialog(null,
                            "Você não inseriu nenhum valor. Gostaria de encerrar o jogo?",
                            null, 0, 0, null, opcoes, opcoes[0]);

                    if (a == 0) {
                        return pontos;
                    }

                } else {
                    try {
                        Integer.parseInt(respPergunta);
                        controladorResposta = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Insira um numero inteiro", "ERRO",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

            if (funcao[x].equals("+")) {
                if (Integer.parseInt(respPergunta) == num1 + num2) {
                    pontos++;
                    respJO = JOptionPane.showOptionDialog(null,
                            "Parabens, você acertou e ganhou um ponto!\n\nQuer continuar jogando?",
                            null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                    // return pontos;
                } else {
                    int b = JOptionPane.showOptionDialog(null, "Você errou. Gostaria de encerrar o jogo?",
                            null, 0, 0, null, opcoes, opcoes[1]);

                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "Ok, então iremos fechar o jogo.");
                        if (pontos > 0) {
                            return pontos;
                        } else {
                            System.exit(0);
                        }

                    }
                }
            } else if (funcao[x].equals("-")) {
                if (Integer.parseInt(respPergunta) == num1 - num2) {
                    pontos++;
                    respJO = JOptionPane.showOptionDialog(null,
                            "Parabens, você acertou e ganhou um ponto!\n\nQuer continuar jogando?",
                            null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                    // return pontos;
                } else {
                    int b = JOptionPane.showOptionDialog(null, "Você errou. Gostaria de encerrar o jogo?",
                            null, 0, 0, null, opcoes, opcoes[1]);

                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "Ok, então iremos fechar o jogo.");
                        if (pontos > 0) {
                            return pontos;
                        } else {
                            System.exit(0);
                        }
                    }
                }
            }

        }

        return pontos;
    }

    public static void fimDeJogo(String name, int pontos, double tempoInicio) {

        double tempoFim = (System.currentTimeMillis() / 1000) - tempoInicio;

        JOptionPane.showMessageDialog(null, "Em " + tempoFim + " segundos.\n" + "Você fez " + pontos + " pontos.", null,
                JOptionPane.INFORMATION_MESSAGE);

    }

}
