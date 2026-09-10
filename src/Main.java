import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char odpowiedz = 't';
        while (odpowiedz == 't') {
            Scanner scanner = new Scanner(System.in);
            int iloscKostek = 0;

            while (iloscKostek < 3 || iloscKostek > 10) {
                System.out.println("Ile kostek chcesz rzucic? (3 - 10)");
                iloscKostek = scanner.nextInt();
            }

            Random random = new Random();
            int liczbaLosowana;
            int[] tablicaLiczb = new int[iloscKostek];



            //wklada losowana liczbe do tablicy x razy i je wyswietla
            for (int i = 0; i < iloscKostek; i++) {
                liczbaLosowana = random.nextInt(6) + 1;
                tablicaLiczb[i] = liczbaLosowana;
                System.out.println("Kostka " + (i + 1) + ":" + " " + liczbaLosowana);
            }


            //liczenie punktow
            //jesli sie powtarza conajniej 2 razy
            // daj punkty za kaze powtorzenie o wartosci liczby powtorzonej

            int punkty = 0;

            for(int i = 0; i < iloscKostek; i++){
                for(int j = i+1; j < iloscKostek; j++){
                    if(tablicaLiczb[i] == tablicaLiczb[j]){
                        punkty += (tablicaLiczb[i])*2;
                    }
                }
            }
            System.out.println("Liczba uzyskanych punktów: " + punkty);


            System.out.println("Jeszcze raz? (t/n)");
            odpowiedz = scanner.next().charAt(0);
        }
    }
}