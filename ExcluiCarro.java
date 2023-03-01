package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluiCarro {

    public static void excluirCarros() throws SQLException {

        //Instancia o Scanner
        Scanner scn = new Scanner(System.in);

        System.out.println("Informe o codigo do carro a ser excluído: ");
        int id_cliente = scn.nextInt();

        //Abertura da conexao com o banco
        Connection conexao = FarmConexao.getConnection();

        //Comando Sql para exclusao do dado
        String sql = "DELETE FROM carro_tb WHERE id_carro = ?";

        //Preparacao da declaracao
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id_cliente);

        // utilizado o IF para confirma se realmente alguma linha sofreu algum impacto
        // durante o processo de exclusao
        // o "stmt.executeUpdate()" verifica a quantidade de linhas que foram excluidas
        if (stmt.executeUpdate() > 0) {

            // Mensagem de sucesso na operacao de exclusao do carro
            System.out.println("Carro excluido(a) com sucesso");

        } else {

            // Caso nao tenha carro a ser excluida ou o codigo não existe na base irá
            // retornar a seguinte mensagem abaixo
            System.out.println("Carro não excluído: Codigo do carro inserido não existente na base");
        }

        // chama o metodo perguntando se o cliente deseja voltar ao menu principal
        Auxiliar.voltaMenu();

        // Fecha a conexao com o banco
        conexao.close();
        // fecha o Scanner
        scn.close();
        // fecha o PreparedStatement
        stmt.close();
    }

}
