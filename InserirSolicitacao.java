package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;


public class InserirSolicitacao {

    static Scanner scn = new Scanner(System.in);

    static TelaInicial menu = new TelaInicial();

    public static void insereSolicitacao() throws SQLException {

        Date dt_dev_prevista = new Date();

        double valor_diaria = 0;


        //(INICIO) - Desse jeito que foi criado ele bloqueará tentativa
        System.out.println("Informe a identificacao do cliente");
        int id_cliente = scn.nextInt();

        System.out.println("Informe a identificacao do carro");
        int id_carro = scn.nextInt();

        System.out.println("Informe por quantos dias deseja alugar");
        int total_dias = scn.nextInt();

        //Abre uma conexao com o banco
        Connection conexao = FarmConexao.getConnection();

        // comando sql a ser executado para pegar o valor da diaria do carro indicado pelo usuario
        String sql2 = "Select valor_diaria from carro_tb where id_carro = ? ";

        // cria a preparação da declaracao para receber um resultado do sql
        PreparedStatement stmt1 = conexao.prepareStatement(sql2);
        stmt1.setInt(1, id_carro);
        //Recebendo os resultados do sql2 executado mais acima no codigo
        ResultSet resultado = stmt1.executeQuery(); // Nao passar nessa parte o comando sql

        //Se tiver algum resultado o mesmo eh gravado na variavel valor_diaria
        //Se NAO tiver algum resultado o mesmo retorna uma mensagem para o usuario
        if (resultado.next()) {

            valor_diaria = resultado.getDouble(1);
        } else {

            System.out.println("Não existe carro cadastrado ou id digitado está invalido");
        }


        //Comando de insercao da solicitacao
        String sql = "Insert Into solicitacao_tb (id_cliente, id_carro, dt_dev_prevista, valor_diaria, total_diaria, qtd_dias_aluguel) Values (?,?,?,?,?,?)";

        // Preparo da declaracao
        PreparedStatement stmt = conexao.prepareStatement(sql);

        //Calculo do valor total da diária da reserva
        double total_diaria = (valor_diaria * total_dias);

        //Ajusta a variavel total_diaria para que sempre fique com 2 casas decimais
        new DecimalFormat("#,##0.00").format(total_diaria);

        //Utilizacao do Calendar para pegar a data atual e adicionar a quantidade de dias que o carro ficará alugado
        //Fazendo assim a geracao da data prevista de devolucao do veiculo
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt_dev_prevista );
        cal.add(Calendar.DATE, total_dias); //somando a data mais o total de dias indicado pelo usuario
        dt_dev_prevista = cal.getTime();

        //Passagem dos parâmetros para o Statement
        stmt.setInt(1, id_cliente);
        stmt.setInt(2, id_carro);
        stmt.setDate(3, new java.sql.Date(dt_dev_prevista.getTime()));
        stmt.setDouble(4, valor_diaria);
        stmt.setDouble(5, total_diaria);
        stmt.setDouble(6, total_dias);

        //Execucao
        stmt.execute();

        System.out.println("Solicitacao inserida com sucesso!");

        //Mensagem que pergunta ao usuario se deseja inserir uma nova solicitacao na base de dados
        System.out.println("Deseja fazer uma nova reserva? (S/N)");

        String clienteNovo = scn.next();

        // Se digitado S ele chama novamente o metodo de insercao, caso contrario ele retorna para o Menu principal
        if (clienteNovo.equalsIgnoreCase("S")) {
            Auxiliar.clearConsole();
            insereSolicitacao();
        } else {
            Auxiliar.clearConsole();
            menu.main(null);
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
