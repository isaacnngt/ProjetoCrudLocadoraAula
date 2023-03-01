package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirCarro {

    static TelaInicial menu = new TelaInicial();

    static Scanner scn = new Scanner(System.in);

    public static void insereCarro() throws SQLException {

        //(INICIO) - Desse jeito que foi criado ele bloqueará tentativa sql Injector
        System.out.println("Informe o modelo");
        String modelo = scn.nextLine();

        System.out.println("Informe a cor");
        String cor = scn.nextLine();

        System.out.println("Informe o fabricante");
        String fabricante = scn.nextLine();

        System.out.println("Informe a placa");
        String placa = scn.nextLine();

        System.out.println("Informe o Valor da Diária");
        Double vl_diaria = scn.nextDouble();

        Connection conexao = FarmConexao.getConnection();

        // Comando Sql de inserção String sql =
        String sql = "Insert Into carro_tb (modelo, cor, fabricante, placa, valor_diaria) Values (?,?,?,?,?)";

        // Preparo da declaracao
        PreparedStatement stmt = conexao.prepareStatement(sql);

        //Passando para o Statement "stmt" os parâmetros de insercao
        stmt.setString(1, modelo);
        stmt.setString(2, cor);
        stmt.setString(3, fabricante);
        stmt.setString(4, placa);
        stmt.setDouble(5, vl_diaria);

        //executa o statement
        stmt.execute();

        System.out.println("Carro inserido com sucesso!");

        //Mensagem que pergunta ao usuario se deseja inserir um novo carro na base de dados
        System.out.println("Deseja Inserir um novo carro? (S/N)");

        String carro = scn.next();

        // Se digitado S ele chama novamente o metodo de insercao, caso contrario ele retorna para o Menu principal
        if (carro.equalsIgnoreCase("S")) {
            Auxiliar.clearConsole();
            insereCarro();
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
