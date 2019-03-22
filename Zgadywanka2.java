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
        int licznik =0; //licznik trafionych liter, jeśli jest równy długości hasła gracz wygrywa
        int licznik_prob = 0; //licznik nieudanych prób, jeśli jest równy 5 to gra się kończy przegraną
       
        
        
        String[] baza_hasel = {"kon", "kot", "lama", "pies", "slon", "surykatka", "wielblad", "tygrys", "swinia", "mrowkojad", "kangur", "zebra", "ryjowka", "zajac", "leniwiec", "zubr", "bobr", "los", "dziobak"};
        Random losuj = new Random();
        int wylosowane = losuj.nextInt(baza_hasel.length);
        haslo = baza_hasel[wylosowane];

      
        
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Witaj w grze zgadywanka! Zgadnij ukryte hasło (zwierzę) podając literę, lub zgadując cały wyraz. W przypadku błędu masz 5 prób. Miłej zabawy!");
        
      
        dlugosc_hasla = haslo.length();  //sprawdza liczbę znakó w haśle
        tablica_hasla = new char[dlugosc_hasla]; //tablica w której będą umieszczane trafione próby gracza, długość równa długości hasła

        
        
        
        for (int i = 0; i<dlugosc_hasla; i++) //rozbija "String" na pojedyncze "char" i umieszcza w tablicy hasła
        {
            tablica_hasla[i] = haslo.charAt(i);

        }


        tablica_zgadywana = new char[dlugosc_hasla]; //tablica prób gracza równa długości hasła

        for (int j = 0; j<dlugosc_hasla; j++)           //wstawia _ w miejsca liter do odgadnięcia i wypisuje na ekran
        {
            tablica_zgadywana[j] = '_';                 
            System.out.print(tablica_zgadywana[j]+ " ");

        }

        
        while(true) //pętla gry
        {
            System.out.println();
            System.out.println("podaj literę, lub zgadnij cały wyraz (nieudanych prób: " + licznik_prob +")");
            zgadywana = odczyt.nextLine(); //odczytuje "String" podany przez gracza
                if (zgadywana.equals(haslo)){ //jeżeli podany wyraz jest taki jak hasło, gracz wygrywa...
                    System.out.println("Wygrana! Gratulacje!");
                    break;
                }
                else{           //..jeżeli nie
                    litera = zgadywana.charAt(0); //odczytuje literę z tego co podał użytkownik
                    
                    if (haslo.contains(zgadywana)){ //jeżeli hasło zawiera podaną literę to poniższa pętla przeszukuję tablicę hasła i wprowadza literę na odpowiednie miejsca

                        for (int k = 0; k<dlugosc_hasla; k++){
                            if (litera == tablica_hasla[k] && litera != tablica_zgadywana[k]){
                                tablica_zgadywana[k] = litera;
                                licznik +=1; //licznik trafionych liter zwiększa się o 1

                            }
                            else if (litera == tablica_hasla[k] && litera == tablica_zgadywana[k]){
                                System.out.println("Ta litera już jest, podaj inną");
                                continue;
                            }
                        }
                    }
                    else{ 
                        System.out.println("Nie ma takiej litery w haśle");
                        licznik_prob +=1;           //jeżeli litery nie ma w haśle, to licznik nieudanych prób zwiększa się o 1
                        
                    }

                    for (int l = 0; l<dlugosc_hasla; l++)
                    {
                       System.out.print(tablica_zgadywana[l]+ " "); //wypisuje na ekran aktualny stan odkrycia hasła

                    }
                    
                    if (licznik_prob == 5){ //warunek przegranej
                        System.out.println();
                        System.out.println("Nie zgadłeś w 5 próbach, przykro mi :(");
                        System.out.println("Poprawne hasło to: "+ haslo);
                        break;
                    }
                    

                    if (licznik == dlugosc_hasla){ //warunek wygranej

                        System.out.println();

                        System.out.println("Wygrana! Gratulacje!");
                        break;
                    }
                }
        }
    }
}