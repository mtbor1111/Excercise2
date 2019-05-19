package pl.sda.brudnopis1;

import java.util.Scanner;

public class Metody {



    public void Start () {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);


        System.out.println();
        int[][] Tablica1;                                                                                                      //Tworzenie tablic
        Tablica1 = new int[12][12];
        int[][] Tablica2;
        Tablica2 = new int[12][12];
        int[][][] Statki1;                                                                                                      //Tworzenie tablic
        Statki1 = new int[10][2][10];
        int[][][] Statki2;
        Statki2 = new int[10][2][10];

        Metody metody = new Metody();
        int opcje=1;

        System.out.println("                                                          <<< OKRĘTY >>>");

        while (opcje != 3) {

        System.out.println();
        System.out.println(" ");
        System.out.println("MENU:");
        System.out.println(" ");
        System.out.println("(1.) NOWA GRA");
        System.out.println("(2.) ZASADY GRY");
        System.out.println("(3.) WYJŚCIE");
        System.out.println();

            opcje = in.nextInt();
            //ZASADY GRY
            if(opcje==2) {
                metody.Zasady();
            }
            //NOWA GRA
            if(opcje==1) {

                //Zerowanie tablic z pozycjami statkow gracza 1
                Statki1 = metody.ZerowanieTablicStatkow(Statki1);
                //Zerowanie tablic z pozycjami statkow gracza 2
                Statki1 = metody.ZerowanieTablicStatkow(Statki1);

                //Zerowanie planszy gracza 1
                Tablica1 = metody.ZerowaniePlansz(Tablica1);
                //Zerowanie planszy gracza 2
                Tablica2 = metody.ZerowaniePlansz(Tablica2);

                System.out.println("            Ustawianie statków gracza 1");
                System.out.println();
                metody.WyswietlaniePlanszy(Tablica1, Tablica2);                                                            //Wyświetlanie Plansz dla garcza 1
                metody.TworzenieStatku(Tablica1, Tablica2, Statki1, Statki2);                                                                //Ustawianie statków gracza 1

                               System.out.println("            Ustawianie statków gracza 2");
                               System.out.println();
                               metody.WyswietlaniePlanszy(Tablica2, Tablica1);                                                            //Wyświetlanie Plansz dla garcza 2
                               metody.TworzenieStatku(Tablica2, Tablica1, Statki2, Statki1);                                                                //Ustawianie statków gracza 2

                metody.WyswietlanieTablicyStatkow(Statki1);

                metody.WyswietlanieTablicyStatkow(Statki2);
            }
        }
    }
                                                                                                                              // Menu główne
    private void Zasady () {
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int opcje=2;


                                                                                                                              //Zasady Gry

            System.out.println();
            System.out.println("                                                        ZASADY ROZGRYWKI:");
            System.out.println();
            System.out.println("- Każdy z graczy ma przed sobą dwie plansze do gry o rozmiarach 10 na 10 pól.");
            System.out.println();
            System.out.println("- Na pierwszej z plansz ustawiamy nasze własne okręty, natomiast druga służy do wskazywania okrętów przeciwnika.");
            System.out.println();
            System.out.println("- Każdy z graczy na początku gry ustawia na swojej planszy: jeden czteromasztowiec, dwa trójmasztowce, trzy dwumasztowce oraz cztery jednomasztowce.");
            System.out.println();
            System.out.println("- Okręty muszą być ustawiane w linii prostej, np. jeśli trójmasztowiec ma swój początek na polu E3, jego koniec musi znajdować się ");
            System.out.println("  na polu E1 lub C3 lub G3 lub E5. ");
            System.out.println();
            System.out.println("- Każdy okręty należy ustawić w taki sposób by nie przylegały w żadnym miejscu do pozostałych okrętów");
            System.out.println();
            System.out.println("- Celem gry jest poprawne wskazanie wszystkich pól zajmowanych przez okręty przeciwnika.");
            System.out.println();
            System.out.println("- Gracze wskazują pola swoich przeciwników, jeśli wskażą je poprawnie przeciwnik informuje o tym (trafiony), jeśli gracz wskazał już wszystkie pola");
            System.out.println("  zajmowane przez ten okręt, przeciwnik dodaje również (zatopiony).");
            System.out.println();
            System.out.println("- Gracze atakują swoich przeciwników na zmianę, jednak wskazanie przez gracza pola na którym znajdował się okręt daje mu możliwość ponownego ataku.");
            System.out.println();
            System.out.println("(2.) DALEJ");
            System.out.println("(9.) POWRÓT");
            System.out.println();
            opcje = in.nextInt();

            if (opcje==2) {

                System.out.println("                    LEGENDA:");
                System.out.println();
                System.out.println("- '-': Brak informacji na temat tego pola");
                System.out.println("- 'S': Okręt");
                System.out.println("- 'x': Okręt trafiony (płynie)");
                System.out.println("- 'X': Okręt trafiony (zatopiony)");
                System.out.println("- 'o': Przestrzeń wokół okrętu/wraku gdzie nie może znajdować się inny okręt ");
                System.out.println("- 'O': Pudło");
                System.out.println();
                System.out.println("  <<Twoja Plansza>>          <<Plansza Przeciwnika>>");
                System.out.println();
                System.out.println("  1 2 3 4 5 6 7 8 9 10         1 2 3 4 5 6 7 8 9 10");
                System.out.println("A o o o S o o O X O -        A X O O - - - - - - -");
                System.out.println("B o S O o O o o X o -        B X o - - - O - - - -");
                System.out.println("C o S o o S o o X o -        C X o - - x x O - - -");
                System.out.println("D o S o o S o o o o o        D X o - - - - - - - -");
                System.out.println("E o S o o o o o S S o        E o o O - - - - - - -");
                System.out.println("F o O o o o o o o O o        F - - o o o o - - - -");
                System.out.println("G o o o o X o o x O -        G - - o X X o - O - -");
                System.out.println("H o S o o o o o S o -        H - - O o o o - - - -");
                System.out.println("I o o o o o - o O o -        I - - - - - - - - - -");
                System.out.println("J o S S S o O - - - -        J - - - - - - - - - -");
                System.out.println();
                System.out.println("(9.) POWRÓT");
                opcje = in.nextInt();

            }



        }
                                                                                                                              // Zerowanie plansz
    private int[][] ZerowaniePlansz(int[][] Tab) {

        int tabwys=0; int tabszer=0;
        int wysokosc=12; int szerokosc=12;
        while (tabwys < wysokosc) {
            while (tabszer < szerokosc) {
                Tab[tabwys][tabszer] = 0;
                tabszer++;
            }
            tabszer=0;
            tabwys++;
        }

        return Tab;
    }

    private int[][][] ZerowanieTablicStatkow(int[][][] Tab) {

        int tabwys=0; int tabszer=0; int tabgl=0;
        int wysokosc=2; int szerokosc=2; int glebokosc=10;
        while (tabgl <glebokosc) {
            while (tabwys < wysokosc) {
                while (tabszer < szerokosc) {
                    Tab[tabwys][tabszer][tabgl] = 0;
                    tabszer++;
                }
                tabszer = 0;
                tabwys++;
            }
            tabwys=0;
            tabgl++;
        }
        return Tab;
    }
                                                                                                                              // Wyświetlanie plansz
    private void WyswietlaniePlanszy(int[][] Tab1, int[][] Tab2) {


        int tabwys = 1;
        int tabszer = 1;
        int a = 0;
        char znak;
        int k;


        Main metody = new Main();
        k=65;
        System.out.println("   <<Twoja Plansza>>         <<Plansza Przeciwnika>>");
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8 9 10         1 2 3 4 5 6 7 8 9 10");
        while (tabwys < 11) {
            znak = (char) k;
            System.out.print(znak+" ");
            while (tabszer < 11) {
                if (Tab1[tabwys][tabszer] == 0) {
                    System.out.print("- ");
                }
                if (Tab1[tabwys][tabszer] == 1) {
                    System.out.print("S ");
                }
                if (Tab1[tabwys][tabszer] == 2) {
                    System.out.print("o ");
                }
                if (Tab1[tabwys][tabszer] == 3) {
                    System.out.print("O ");
                }
                if (Tab1[tabwys][tabszer] == 4) {
                    System.out.print("X ");
                }
                if (Tab1[tabwys][tabszer] == 5) {
                    System.out.print("x ");
                }
                tabszer++;
            }
            tabszer=1;

            System.out.print("       "+ (znak)+" ");

            while (tabszer < 11) {
                if (Tab2[tabwys][tabszer] == 0) {
                    System.out.print("- ");
                }
                if (Tab2[tabwys][tabszer] == 1) {
                    System.out.print("- ");
                }
                if (Tab2[tabwys][tabszer] == 2) {
                    System.out.print("- ");
                }
                if (Tab2[tabwys][tabszer] == 3) {
                    System.out.print("X ");
                }
                if (Tab2[tabwys][tabszer] == 4) {
                    System.out.print("o ");
                }
                if (Tab2[tabwys][tabszer] == 5) {
                    System.out.print("O ");
                }
                tabszer++;
            }
            k++;
            tabszer=1;
            tabwys++;
            System.out.println();
        }
        System.out.println();


    }
                                                                                                                              //
    private void WyswietlanieTablicyStatkow(int[][][] Tab1) {

        System.out.println();
        System.out.println();

        int tabwys = 0;
        int tabszer = 0;
        int tabgl=0;
        int a = 0;


        while(tabwys<10){
            while(tabszer<2){
                while(tabgl<4){
                    System.out.print(Tab1[tabwys][tabszer][tabgl]+" ");
                    tabgl++;
                }
                System.out.print(" ");
                tabgl=0;
                tabszer++;
                while(tabgl<4){
                    if(tabszer==1) {
                        System.out.print(Tab1[tabwys][tabszer][tabgl] + " ");
                        tabgl++;
                    }
                    if(tabszer==0) {
                        char znak = (char) (Tab1[tabwys][tabszer][tabgl]+64);
                        System.out.print(znak + " ");
                        tabgl++;
                    }
                }
                System.out.print(" ");
                tabgl=0;
                tabszer++;
            }
            tabszer=0;
            tabwys++;
            System.out.println();
        }




    }
                                                                                                                              // Podawanie współrzędnych
    private void PodawanieWspolrzednych(int[] Tab1) {

                                                                                                                              //Tworzenie tablic
        int error=1;
        int pion,poziom;
        String wspolrzedne;
        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int k;

        while (error==1) {
            System.out.println();
            wspolrzedne = scan.nextLine();
            if(wspolrzedne.length()>1) {
                k = wspolrzedne.charAt(0);
                if (k > 96) {
                    k = k - 32;
                }
                pion = k - 64;
                poziom = (wspolrzedne.charAt(1) - 48);
                if (wspolrzedne.length()==3) {
                    if (wspolrzedne.charAt(2)==0) {
                        poziom = poziom + 9;
                    }
                }
                Tab1[0] = pion;
                Tab1[1] = poziom;


                if (wspolrzedne.length()==2) {
                    if (Tab1[0] > 0 && Tab1[0] < 11 && Tab1[1] > 0 && Tab1[1] < 11) {
                        error = 0;
                    }
                }

                else if (wspolrzedne.length()==3){
                    System.out.println(wspolrzedne.length());
                    System.out.println(wspolrzedne.charAt(2));
                if (wspolrzedne.charAt(2)==48) {
                        error = 0;
                    System.out.println(wspolrzedne.charAt(2));
                    }
                } else System.out.println("Podałeś nieprawidłowe współzędne");

            }
            else System.out.println("Podałeś nieprawidłowe współzędne");
        }

    }
                                                                                                                              // Ustalanie kierunku statku
    private int PodawanieKierunku() {

        Scanner in = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int error = 1;
        int kierunek=0,pion=1,poziom=1;

while(error==1) {
    System.out.println("W którą stronę okręt ma być skierowany?");
    System.out.println();
    System.out.println("1. W górę");
    System.out.println("2. W dół");
    System.out.println("3. W lewo");
    System.out.println("4. W prawo");
    System.out.println();
    kierunek = in.nextInt();

    if (kierunek != 1 && kierunek != 2 && kierunek != 3 && kierunek != 4) {
        System.out.println();
        System.out.println("<<Podałeś zły kierunek, użyj cyfry 1-4 w celu wybrania kierunku>>");
        System.out.println();
    } else {
        error = 0;
    }
}
        return kierunek;
    }
                                                                                                                              // Sprawdzanie czy statek może zostać ustawiony w danym miejscu
    private int SprawdzaniePolPodStatek(int[][] Tab1, int[] wspolrzedne, int kierunek,int typstatku){
        int wynik=0;
        int pion = wspolrzedne[0]; int poziom = wspolrzedne[1];

        if (typstatku>0){
            if(kierunek==1){wynik=wynik+Tab1[pion-0][poziom];}
            if(kierunek==2){wynik=wynik+Tab1[pion+0][poziom];}
            if(kierunek==3){wynik=wynik+Tab1[pion][poziom-0];}
            if(kierunek==4){wynik=wynik+Tab1[pion][poziom+0];}
            if (typstatku>1){
                if(kierunek==1){wynik=wynik+Tab1[pion-1][poziom];}
                if(kierunek==2){wynik=wynik+Tab1[pion+1][poziom];}
                if(kierunek==3){wynik=wynik+Tab1[pion][poziom-1];}
                if(kierunek==4){wynik=wynik+Tab1[pion][poziom+1];}
                if (typstatku>2){
                    if(kierunek==1){wynik=wynik+Tab1[pion-2][poziom];}
                    if(kierunek==2){wynik=wynik+Tab1[pion+2][poziom];}
                    if(kierunek==3){wynik=wynik+Tab1[pion][poziom-2];}
                    if(kierunek==4){wynik=wynik+Tab1[pion][poziom+2];}
                    if (typstatku>3){
                        if(kierunek==1){wynik=wynik+Tab1[pion-3][poziom];}
                        if(kierunek==2){wynik=wynik+Tab1[pion+3][poziom];}
                        if(kierunek==3){wynik=wynik+Tab1[pion][poziom-3];}
                        if(kierunek==4){wynik=wynik+Tab1[pion][poziom+3];}

                    }}}}



        return wynik;
    }
                                                                                                                              // Przypisywanie statku do danego miejsca
    private void UstawianieStatku(int[][] Tab1, int licznik, int[] wspolrzedne, int kierunek,int typstatku,int[][][] Statki) {




    int pion = wspolrzedne[0]; int poziom = wspolrzedne[1];
    int licznik1 = -1;
    int licznik2 = -1;

        if (typstatku>0){
            if(kierunek==1){while(licznik1<2){while(licznik2<2){Tab1[pion-0+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
            if(kierunek==2){while(licznik1<2){while(licznik2<2){Tab1[pion+0+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
            if(kierunek==3){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom-0+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
            if(kierunek==4){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom+0+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
            if (typstatku>1){
                if(kierunek==1){while(licznik1<2){while(licznik2<2){Tab1[pion-1+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                if(kierunek==2){while(licznik1<2){while(licznik2<2){Tab1[pion+1+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                if(kierunek==3){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom-1+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                if(kierunek==4){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom+1+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                if (typstatku>2){
                    if(kierunek==1){while(licznik1<2){while(licznik2<2){Tab1[pion-2+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                    if(kierunek==2){while(licznik1<2){while(licznik2<2){Tab1[pion+2+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                    if(kierunek==3){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom-2+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                    if(kierunek==4){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom+2+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                    if (typstatku>3){
                        if(kierunek==1){while(licznik1<2){while(licznik2<2){Tab1[pion-3+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                        if(kierunek==2){while(licznik1<2){while(licznik2<2){Tab1[pion+3+licznik1][poziom+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                        if(kierunek==3){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom-3+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}
                        if(kierunek==4){while(licznik1<2){while(licznik2<2){Tab1[pion+licznik1][poziom+3+licznik2]=2; licznik2++;}licznik1++;licznik2=-1;}licznik1=-1;}

                    }}}}

        if (typstatku>0){
            if(kierunek==1){Tab1[pion-0][poziom]=1;Statki[licznik][0][0]=pion-0;Statki[licznik][1][0]=poziom;}
            if(kierunek==2){Tab1[pion+0][poziom]=1;Statki[licznik][0][0]=pion+0;Statki[licznik][1][0]=poziom;}
            if(kierunek==3){Tab1[pion][poziom-0]=1;Statki[licznik][0][0]=pion;Statki[licznik][1][0]=poziom-0;}
            if(kierunek==4){Tab1[pion][poziom+0]=1;Statki[licznik][0][0]=pion;Statki[licznik][1][0]=poziom+0;}
        if (typstatku>1){
            if(kierunek==1){Tab1[pion-1][poziom]=1;Statki[licznik][0][1]=pion-1;Statki[licznik][1][1]=poziom;}
            if(kierunek==2){Tab1[pion+1][poziom]=1;Statki[licznik][0][1]=pion+1;Statki[licznik][1][1]=poziom;}
            if(kierunek==3){Tab1[pion][poziom-1]=1;Statki[licznik][0][1]=pion;Statki[licznik][1][1]=poziom-1;}
            if(kierunek==4){Tab1[pion][poziom+1]=1;Statki[licznik][0][1]=pion;Statki[licznik][1][1]=poziom+1;}
        if (typstatku>2){
            if(kierunek==1){Tab1[pion-2][poziom]=1;Statki[licznik][0][2]=pion-2;Statki[licznik][1][2]=poziom;}
            if(kierunek==2){Tab1[pion+2][poziom]=1;Statki[licznik][0][2]=pion+2;Statki[licznik][1][2]=poziom;}
            if(kierunek==3){Tab1[pion][poziom-2]=1;Statki[licznik][0][2]=pion;Statki[licznik][1][2]=poziom-2;}
            if(kierunek==4){Tab1[pion][poziom+2]=1;Statki[licznik][0][2]=pion;Statki[licznik][1][2]=poziom+2;}
        if (typstatku>3){
            if(kierunek==1){Tab1[pion-3][poziom]=1;Statki[licznik][0][3]=pion-3;Statki[licznik][1][3]=poziom;}
            if(kierunek==2){Tab1[pion+3][poziom]=1;Statki[licznik][0][3]=pion+3;Statki[licznik][1][3]=poziom;}
            if(kierunek==3){Tab1[pion][poziom-3]=1;Statki[licznik][0][3]=pion;Statki[licznik][1][3]=poziom-3;}
            if(kierunek==4){Tab1[pion][poziom+3]=1;Statki[licznik][0][3]=pion;Statki[licznik][1][3]=poziom+3;}
        }}}}

    }
                                                                                                                              // Tworzenie statku
    private void TworzenieStatku(int[][] Tab1, int[][] Tab2, int[][][] Tab3, int[][][] Tab4) {

        int typstatku=0;
        int kierunek=0;
        int[] Tab5;                                                                                                           //Tworzenie tablic
        Tab5 = new int[2];
        int wynik;
        Metody metody=new Metody();
        int licznik=0;

                                                                                                                               //Tworzenie czteromasztowca
        while (licznik<1) {
            typstatku=4;
            System.out.println("Podaj współrzędne początku czteromasztowca np 'A4' lub 'g1'");
            metody.PodawanieWspolrzednych(Tab5);
            kierunek=metody.PodawanieKierunku();
            wynik=metody.SprawdzaniePolPodStatek(Tab1,Tab5,kierunek,typstatku);
            if(wynik==0){
            metody.UstawianieStatku(Tab1,licznik,Tab5,kierunek,typstatku,Tab3);
            licznik++;}
            else {
                System.out.println("     <<<<Statki nachodzą na siebie>>>>");
                System.out.println();
            }
            metody.WyswietlaniePlanszy(Tab1, Tab2);
        }
                                                                                                                               //Tworzenie trójmasztowca
        while (licznik<3) {
            typstatku=3;
            System.out.println("Podaj współrzędne początku trójmasztowca np 'A4' lub 'g1'");
            metody.PodawanieWspolrzednych(Tab5);
            kierunek=metody.PodawanieKierunku();
            wynik=metody.SprawdzaniePolPodStatek(Tab1,Tab5,kierunek,typstatku);
            if(wynik==0){
                metody.UstawianieStatku(Tab1,licznik,Tab5,kierunek,typstatku,Tab3);
                licznik++;}
            else {
                System.out.println("Statki nachodzą na siebie");
            }
            metody.WyswietlaniePlanszy(Tab1, Tab2);
        }
                                                                                                                               //Tworzenie dwumasztowca
        while (licznik<6) {
            typstatku=2;
            System.out.println("Podaj współrzędne początku dwumasztowca np 'A4' lub 'g1'");
            metody.PodawanieWspolrzednych(Tab5);
            kierunek=metody.PodawanieKierunku();
            wynik=metody.SprawdzaniePolPodStatek(Tab1,Tab5,kierunek,typstatku);
            if(wynik==0){
                metody.UstawianieStatku(Tab1,licznik,Tab5,kierunek,typstatku,Tab3);
                licznik++;}
            else {
                System.out.println("Statki nachodzą na siebie");
            }
            metody.WyswietlaniePlanszy(Tab1, Tab2);
        }
                                                                                                                               //Tworzenie jednomasztowca
        while (licznik<10) {
            typstatku=1;
            System.out.println("Podaj współrzędne początku jednomasztowca np 'A4' lub 'g1'");
            metody.PodawanieWspolrzednych(Tab5);
            kierunek=metody.PodawanieKierunku();
            wynik=metody.SprawdzaniePolPodStatek(Tab1,Tab5,kierunek,typstatku);
            if(wynik==0){
                metody.UstawianieStatku(Tab1,licznik,Tab5,kierunek,typstatku,Tab3);
                licznik++;}
            else {
                System.out.println("Statki nachodzą na siebie");
            }
            metody.WyswietlaniePlanszy(Tab1, Tab2);
        }

    }
}
