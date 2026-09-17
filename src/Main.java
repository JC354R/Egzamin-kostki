import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int iloscKostek = 0;

        while (iloscKostek < 3 || iloscKostek > 10) {
            System.out.println("Ile kostek chcesz rzucic? (3 - 10)");
            iloscKostek = scanner.nextInt();
        }

        int[] tablicaLiczb = new int[iloscKostek];

        char odpowiedz = 't';
        while (odpowiedz != 'n' || odpowiedz == 't') {

            rzucanieKoscmi(iloscKostek, tablicaLiczb);
            liczeniePunktow(tablicaLiczb, iloscKostek);

            System.out.println("Jeszcze raz? (t/n)");
            odpowiedz = scanner.next().charAt(0);
        }
    }

    public static int[] rzucanieKoscmi(int iloscKostek, int[] tablicaLiczb){
        Random random = new Random();
        int liczbaLosowana;




        //wklada losowana liczbe do tablicy x razy i je wyswietla
        for (int i = 0; i < iloscKostek; i++) {
            liczbaLosowana = random.nextInt(6) + 1;
            tablicaLiczb[i] = liczbaLosowana;
            System.out.println("Kostka " + (i + 1) + ":" + " " + liczbaLosowana);
        }
        return tablicaLiczb;
    }

    public static int liczeniePunktow(int[] tablicaLiczb, int iloscKostek){
        int punkty = 0;
        int[] powtorzenia = new int[7];
        int iloscPowtorzen = 0;

        for(int i = 0; i < iloscKostek; i++){

            for(int j = i+1; j < iloscKostek; j++){
                if(tablicaLiczb[i] == tablicaLiczb[j]){
                    powtorzenia[iloscPowtorzen] += tablicaLiczb[i];
                    powtorzenia[iloscPowtorzen] += tablicaLiczb[j];
                    iloscPowtorzen++;
                }
            }
        }
        //liczenie punktow z tablicy z powtorzeniami
       for(int i=0; i<iloscPowtorzen; i++){
            punkty += powtorzenia[i];
        }


        System.out.println("Liczba uzyskanych punktów: " + punkty);
        return punkty;
    }
}
