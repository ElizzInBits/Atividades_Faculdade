package br.com.sistema.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class TestarConexao {

    public static void main(String[] args) {

        int tentativas = 3; // número máximo de tentativas
        int contador = 0;
        boolean conectado = false;

        while (contador < tentativas && !conectado) {
            try {
                new ConexaoBanco().pegarConexao();
                JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados");
                conectado = true; // conexão bem-sucedida, sair do loop
            } catch (HeadlessException erro) {
                contador++;
                JOptionPane.showMessageDialog(null, "Tentativa de conexão número: " + contador +
                        "\nErro ao tentar se conectar com o banco de dados: " + erro.getLocalizedMessage());
            }
        }

        if (!conectado) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar após " + tentativas + " tentativas.");
        }

    }

}
