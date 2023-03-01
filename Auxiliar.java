package crud;

import java.sql.SQLException;
import java.util.Scanner;

public class Auxiliar {

    static TelaInicial menu = new TelaInicial();
    static Scanner scn = new Scanner(System.in);


    public final static void clearConsole()
    {
        for (int i = 0; i < 100; ++i)
            System.out.println();
    }

    public final static void voltaMenu() throws SQLException {

        TelaInicial menu = new TelaInicial();

        System.out.println("Deseja voltar ao menu inicial ? S-sim)");
        String voltar = scn.nextLine();

        if (voltar.equalsIgnoreCase("S")) {
            Auxiliar.clearConsole();
            TelaInicial.main(null);
        }else {
            System.out.println("Para Voltarao Menu inicial digite S");
            voltar = scn.nextLine();
            Auxiliar.clearConsole();
            TelaInicial.main(null);

        }

    }

}
