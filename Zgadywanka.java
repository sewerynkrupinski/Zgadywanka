import java.util.Random;
import java.util.Scanner;

public class Zgadywanka {



    public static void main(String[] args) {


        String haslo;
        int dlugosc_hasla;
        char[] tablica_hasla;
        String zgadywana;
        char[] tablica_zgadywana;
        char litera;
        int licznik =0;


        String[] baza_hasel = {"dom", "kot", "samochód", "gitara", "pies", "pszczoła"};
        Random losuj = new Random();
        int wylosowane = losuj.nextInt(baza_hasel.length);
        //System.out.println(wylosowane);
        haslo = baza_hasel[wylosowane];

        Scanner odczyt = new Scanner(System.in);

        //System.out.println("Podaj hasło do odgadnięcia");
        //haslo = odczyt.nextLine();

        dlugosc_hasla = haslo.length();

        tablica_hasla = new char[dlugosc_hasla];

        for (int i = 0; i<dlugosc_hasla; i++)
        {
            tablica_hasla[i] = haslo.charAt(i);

        }



        tablica_zgadywana = new char[dlugosc_hasla];

        for (int j = 0; j<dlugosc_hasla; j++)
        {
            tablica_zgadywana[j] = '_';
            System.out.print(tablica_zgadywana[j]+ " ");

        }


        while(true)
        {
            System.out.println();
            System.out.println("podaj literę");
            zgadywana = odczyt.nextLine();
            litera = zgadywana.charAt(0);

            for (int k = 0; k<dlugosc_hasla; k++)
            {
                if (litera == tablica_hasla[k] && litera != tablica_zgadywana[k]){
                    tablica_zgadywana[k] = litera;
                    licznik +=1;

                }

            }


            for (int l = 0; l<dlugosc_hasla; l++)
            {
               System.out.print(tablica_zgadywana[l]+ " ");

            }

            if (licznik == dlugosc_hasla){

                System.out.println();

                System.out.println("Wygrana! Gratulacje!");
                break;
            }

        }

    }

}
