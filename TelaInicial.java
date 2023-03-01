package crud;

import java.sql.SQLException;
import java.util.Scanner;

public class TelaInicial {
    public static void main(String[] args) throws SQLException {

        // Instanciando Scanner para capturar o que for digitado na tela
        Scanner scn = new Scanner(System.in);

        // Menu de Opcoes
        System.out.println("=================================");
        System.out.println("ESCOLHA UMA OPÇÃO ABAIXO:");
        System.out.println("=================================");
        System.out.println("1 -  Cadastrar novo Cliente");
        System.out.println("2 -  Cadastrar novo Carro");
        System.out.println("3 -  Listar clientes cadastrados");
        System.out.println("4 -  Listar carros cadastrados");
        System.out.println("5 -  Excluir Cliente");
        System.out.println("6 -  Excluir Carro");
        System.out.println("7 -  Solicitar reserva");
        System.out.println("8 -  Buscar solicitacao Ativas");
        System.out.println("9 -  Buscar histórico de reservas");
        System.out.println("10 - Finalizar reserva");
        System.out.println("---------------------------------");

        int num1 = scn.nextInt();

        //Garantir que recebera um numero valido
        //Enquanto nao receber ficara solicitando uma opcao valida
        while (num1 > 10 || num1<=0) {

            System.out.println("Dado inválido, escolha a opção 1 a 10");
            num1 = scn.nextInt();
        }

        //inicio das opcoes
        switch (num1) {
            case 1:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que insere cliente
                InserirCliente.insereCliente();
                break;
            case 2:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que insere carro
                InserirCarro.insereCarro();
                break;
            case 3:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que lista cliente
                ListaCliente.listaCliente();
                break;
            case 4:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que lista carro
                ListaCarros.listaCarro();
                break;
            case 5:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que exclui clientes
                ExcluiCliente.excluirClientes();
                break;
            case 6:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que exclui carros
                ExcluiCarro.excluirCarros();
                break;
            case 7:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que insere solicitacao
                InserirSolicitacao.insereSolicitacao();
                break;
            case 8:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que lista as solicitacoes de reservas ativas
                ListaSolicitacao.listaSolicitacoesAtivas();
                break;
            case 9:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que lista o historico de reservas de carro
                ListaSolicitacao.historicoDeReservas();
                break;
            case 10:
                //limpar a tela
                Auxiliar.clearConsole();
                //chamada do metodo que lista finaliza as solicitacoes de reserva
                FinalizarSolicitacao.finalizaSolicitacoes();
                break;
            default:
                System.out.println("Dado inválido, escolha a opção 1 a 10");

        }

        //fecha o scanner
        scn.close();
    }

}