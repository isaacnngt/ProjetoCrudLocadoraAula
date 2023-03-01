package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaCliente {

    public static void listaCliente() throws SQLException {

        Connection conexao = FarmConexao.getConnection();

        // comando sql a ser executado
        String sql = "Select * from cliente_tb";

        // cria a declaracao para receber um resultado do sql
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        // Cria uma lista de clientes para armazenar os dados vindo do banco
        List<Cliente> clientes = new ArrayList<>();

        // percorre todas as linhas do Resultset
        while (resultado.next()) {
            // Pega o resultado
            int id_cliente = resultado.getInt("id_cliente");
            String nome = resultado.getString("nome");
            String cpf = resultado.getString("cpf");
            String telefone = resultado.getString("telefone");
            String endereco = resultado.getString("endereco");

            // cria um cliente
            clientes.add(new Cliente(id_cliente, nome, cpf, telefone, endereco));

        }

        // Para exibir na tela os cliente que vieram no select executado pela variavel
        for (Cliente c : clientes) {

            System.out.println("ID: " + c.getId_cliente() + " Nome: " + c.getNome() + " CPF: " + c.getCpf()
                    + " Telefone: " + c.getTelefone() + " Endereco: " + c.getEndereco());
        }

        // chama o metodo perguntando se o cliente deseja voltar ao menu principal
        Auxiliar.voltaMenu();

        // fecha o statment
        stmt.close();
        // fecha a conexao
        conexao.close();
    }

}
