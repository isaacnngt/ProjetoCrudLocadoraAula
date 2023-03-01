package crud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaSolicitacao {

    //Metodo que pega as solicitacoes ativas de acordo com o cliente
    public static void listaSolicitacoesAtivas() throws SQLException {

        // Declaracao do scanner
        Scanner scn = new Scanner(System.in);

        // Para atualizar algo incialmente é preciso ter uma conexão
        // Abertura da conexão com o banco de dados
        Connection conexao = FarmConexao.getConnection();

        // Mensagem que apresentara para que o usuario possa digitar o valor da pesquisa
        System.out.println("Informe o codigo do cliente");
        int id_cliente = scn.nextInt();

        //Comando Sql que pega as informações das solicitacoes ativas
        String sql1 = "SELECT c.id_solicitacao id_solicitacao, " +
                "c.id_cliente id_cliente, " +
                "e.nome nome, " +
                "e.cpf cpf ," +
                "ca.id_carro id_carro," +
                "ca.modelo modelo," +
                "c.dt_solicitacao dt_solicitacao," +
                "c.dt_retirada dt_retirada, " +
                "c.dt_dev_prevista dt_prevista," +
                "c.dt_devolucao dt_devolucao," +
                "c.qtd_dias_aluguel qtd_dias_aluguel," +
                "c.valor_diaria valor_diaria," +
                "c.total_diaria total_diaria," +
                "c.ativo ativo " +
                "FROM solicitacao_tb c, " +
                "cliente_tb e, " +
                "carro_tb ca " +
                "WHERE e.id_cliente = c.id_cliente " +
                "AND c.id_carro = ca.id_carro " +
                "AND c.id_cliente = ? "+
                "AND c.ativo = 'S'" + //Aqui e onde ele pega tudo que esta ativo
                "ORDER BY 1 DESC;"; //Ordena de forma decrescente


        // cria a preparação da declaracao para receber um resultado do sql
        PreparedStatement stmt = conexao.prepareStatement(sql1);
        stmt.setInt(1, id_cliente);
        ResultSet resultado = stmt.executeQuery(); // Nao passar nessa parte o comando sql

        // Cria uma lista de solicitacoes para armazenar os dados vindo do banco
        List<Solicitacao> solicitacoes = new ArrayList<>();

        //Se tiver algum resultado do sql anterior
        if (resultado.next()) {

            // percorre todas as linhas do Resultset
            while (resultado.next()) {

                // Pega o resultado
                int id_solicitacao = resultado.getInt("id_solicitacao");
                id_cliente = resultado.getInt("id_cliente");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                int id_carro = resultado.getInt("id_carro");
                String modelo = resultado.getString("modelo");
                String dt_solicitacao = resultado.getString("dt_solicitacao");
                String dt_retirada = resultado.getString("dt_retirada");
                String dt_prevista = resultado.getString("dt_prevista");
                String dt_devolucao = resultado.getString("dt_devolucao");
                int qtd_dias_aluguel = resultado.getInt("qtd_dias_aluguel");
                double valor_diaria = resultado.getDouble("valor_diaria");
                double total_diaria = resultado.getDouble("total_diaria");
                String ativo = resultado.getString("ativo");

                // cria uma solicitacao
                solicitacoes.add(new Solicitacao(id_solicitacao
                        ,id_cliente
                        ,id_carro
                        ,dt_solicitacao
                        ,dt_retirada
                        ,dt_prevista
                        ,dt_devolucao
                        ,qtd_dias_aluguel
                        ,valor_diaria
                        ,total_diaria
                        ,ativo
                        ,nome
                        ,cpf
                        ,modelo));

            }

            // Para exibir na tela as solicitacoes que vieram no select executado
            for (Solicitacao s : solicitacoes) {

                System.out.println(
                        "ID: " + s.getId_solicitacao() +
                                " id_cliente: " + s.getId_cliente() +
                                " nome " + s.getNome()+
                                " CPF "+ s.getCpf()+
                                " id_carro: " + s.getId_carro() +
                                " modelo: " + s.getModelo() +
                                " dt_solicitacao: " + s.getDt_solicitacao() +
                                " dt_retirada " + s.getDt_retirada()+
                                " dt_prevista "+ s.getDt_prevista()+
                                " dt_devolucao: " + s.getDt_devolucao() +
                                " qtd_dias_aluguel " + s.getQtd_dias_aluguel()+
                                " valor_diaria R$: "+ s.getValor_diaria()+
                                " total_diaria R$: " + s.getTotal_diaria() +
                                " ativo " + s.getAtivo());

                System.out.println("");
            }

        }else {
            //Se num tiver nada retorna para o usuario esta mensagem
            System.out.println("Não existem solicitacoes ATIVAS para este cliente");
        }

        // chama o metodo perguntando se o cliente deseja voltar ao menu principal
        Auxiliar.voltaMenu();

        //Fecha o Statement
        stmt.close();
        //fecha o scanner
        scn.close();
        //fecha conexao
        conexao.close();
        //(FIM)
    }


    //Puxa o historico geral das solicitacoes estando ativas e inativas
    public static void historicoDeReservas() throws SQLException {

        // Declaracao do scanner
        Scanner scn = new Scanner(System.in);

        // Para atualizar algo incialmente é preciso ter uma conexão
        // Abertura da conexão com o banco de dados
        Connection conexao = FarmConexao.getConnection();

        // Mensagem que apresentara para que o usuario possa digitar o valor da pesquisa
        System.out.println("Informe o codigo do cliente");
        int id_cliente = scn.nextInt();

        //Comando Sql que pega as informações das solicitacoes ativas
        String sql1 = "SELECT c.id_solicitacao id_solicitacao, " +
                "c.id_cliente id_cliente, " +
                "e.nome nome, " +
                "e.cpf cpf ," +
                "ca.id_carro id_carro," +
                "ca.modelo modelo," +
                "c.dt_solicitacao dt_solicitacao," +
                "c.dt_retirada dt_retirada, " +
                "c.dt_dev_prevista dt_prevista," +
                "c.dt_devolucao dt_devolucao," +
                "c.qtd_dias_aluguel qtd_dias_aluguel," +
                "c.valor_diaria valor_diaria," +
                "c.total_diaria total_diaria," +
                "c.ativo ativo " +
                "FROM solicitacao_tb c, " +
                "cliente_tb e, " +
                "carro_tb ca " +
                "WHERE e.id_cliente = c.id_cliente " +
                "AND c.id_carro = ca.id_carro " +
                "AND c.id_cliente = ? "+
                "ORDER BY 1 DESC;";


        // cria a preparação da declaracao para receber um resultado do sql
        PreparedStatement stmt = conexao.prepareStatement(sql1);
        stmt.setInt(1, id_cliente);
        ResultSet resultado = stmt.executeQuery(); // Nao passar nessa parte o comando sql

        // Cria uma lista de solicitacoes para armazenar os dados vindo do banco
        List<Solicitacao> solicitacoes = new ArrayList<>();

        // percorre todas as linhas do Resultset
        while (resultado.next()) {
            // Pega o resultado do codigo e nome
            int id_solicitacao = resultado.getInt("id_solicitacao");
            id_cliente = resultado.getInt("id_cliente");
            String nome = resultado.getString("nome");
            String cpf = resultado.getString("cpf");
            int id_carro = resultado.getInt("id_carro");
            String modelo = resultado.getString("modelo");
            String dt_solicitacao = resultado.getString("dt_solicitacao");
            String dt_retirada = resultado.getString("dt_retirada");
            String dt_prevista = resultado.getString("dt_prevista");
            String dt_devolucao = resultado.getString("dt_devolucao");
            int qtd_dias_aluguel = resultado.getInt("qtd_dias_aluguel");
            double valor_diaria = resultado.getDouble("valor_diaria");
            double total_diaria = resultado.getDouble("total_diaria");
            String ativo = resultado.getString("ativo");

            // cria uma solicitacao
            solicitacoes.add(new Solicitacao(id_solicitacao
                    ,id_cliente
                    ,id_carro
                    ,dt_solicitacao
                    ,dt_retirada
                    ,dt_prevista
                    ,dt_devolucao
                    ,qtd_dias_aluguel
                    ,valor_diaria
                    ,total_diaria
                    ,ativo
                    ,nome
                    ,cpf
                    ,modelo));

        }

        // Para exibir na tela as solicitacoes que vieram no select executado
        for (Solicitacao s : solicitacoes) {

            System.out.println(
                    "ID: " + s.getId_solicitacao() +
                            " id_cliente: " + s.getId_cliente() +
                            " nome " + s.getNome()+
                            " CPF "+ s.getCpf()+
                            " id_carro: " + s.getId_carro() +
                            " modelo: " + s.getModelo() +
                            " dt_solicitacao: " + s.getDt_solicitacao() +
                            " dt_retirada " + s.getDt_retirada()+
                            " dt_prevista "+ s.getDt_prevista()+
                            " dt_devolucao: " + s.getDt_devolucao() +
                            " qtd_dias_aluguel " + s.getQtd_dias_aluguel()+
                            " valor_diaria R$: "+ s.getValor_diaria()+
                            " total_diaria R$: " + s.getTotal_diaria() +
                            " ativo " + s.getAtivo());

            System.out.println("");
        }
        // chama o metodo perguntando se o cliente deseja voltar ao menu principal
        Auxiliar.voltaMenu();

        stmt.close();
        scn.close();
        conexao.close();
    }

}
