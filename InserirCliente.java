package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirCliente {

    static TelaInicial menu = new TelaInicial();

    static Scanner scn = new Scanner(System.in);

    public static void insereCliente() throws SQLException {

        //(INICIO) - Desse jeito que foi criado ele bloqueará tentativa sql Injector
        System.out.println("Informe o nome");
        String nome = scn.nextLine();

        System.out.println("Informe o cpf");
        String cpf = scn.nextLine();

        System.out.println("Informe o endereco");
        String endereco = scn.nextLine();

        System.out.println("Informe o telefone");
        String telefone = scn.nextLine();

        Connection conexao = FarmConexao.getConnection();

        // Comando Sql de inserção String sql =
        String sql = "Insert Into cliente_tb (nome, cpf, endereco, telefone) Values (?,?,?,?)";

        // Preparo da declaracao
        PreparedStatement stmt = conexao.prepareStatement(sql);

        //Passando para o Statement "stmt" os parâmetros de insercao
        stmt.setString(1, nome);
        stmt.setString(2, cpf);
        stmt.setString(3, endereco);
        stmt.setString(4, telefone);

        //executa o statement
        stmt.execute();

        System.out.println("Cliente inserido com sucesso!");

        //Mensagem que pergunta ao usuario se deseja inserir um novo cliente na base de dados
        System.out.println("Deseja Inserir um novo cliente? (S/N)");

        String clienteNovo = scn.nextLine();

        // Se digitado S ele chama novamente o metodo de insercao, caso contrario ele retorna para o Menu principal
        if (clienteNovo.equalsIgnoreCase("S")) {
            Auxiliar.clearConsole();
            insereCliente();
        } else {
            Auxiliar.clearConsole();
            TelaInicial.main(null);
        }

        //Fecha o Statement
        stmt.close();
        //fecha o scanner
        scn.close();
        //fecha conexao
        conexao.close();
        //(FIM)

    }

}
