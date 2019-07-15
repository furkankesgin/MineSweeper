import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        int satir = 15; int sutun=15;    //Satir ve sutun sayisi belirtilir.
        int satirIsaretlenen, sutunIsaretlenen;
        Scanner scn = new Scanner(System.in);
        System.out.println();

        int [][]bomb = new int [satir][sutun];  //bombalar icin 2li array olusturulur

        Random rnd = new Random();  // random uretilmesi icin random class i cagirilir.

        ///////////////satir ve sutunlarin hepsini 1 e esitleme\\\\\\\\\\\\\\\\\\\\\\\

        for(int i=0; i<satir; i++)
        {
            for (int j=0; j<sutun; j++)
            {
                bomb[i][j]=1;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        /////////////////Cerceve ici kontrol\\\\\\\\\\\\\\\\\\\\\\\

        int r1, r2; //satir ve sutun icni 2 ayri random deger
        int count=0; //kac bomba oldugunu ogrenmek icin

        for(int i=0; i<30; i++)
        {
            r1 = rnd.nextInt(satir-1)+1;
            r2 = rnd.nextInt(sutun-1)+1;


            System.out.println(i);
            System.out.println("r1 r2  == " + r1 + " " + r2 + " ");

            /*if(bomb[r1][r2-1]==0)     //sol
            {
                i=i-1;
                continue;
            }*/
            if(r2>0){
                if(bomb[r1][r2-1]==0)     //sol
                {
                    i=i-1;
                    continue;
                }
            }
            if(r2<sutun-1){
                if(bomb[r1][r2+1]==0)     //sag
                {
                    i=i-1;

                    continue;
                }
            }

            if(r1>0){
                if(bomb[r1-1][r2]==0)     //ust
                {
                    i=i-1;

                    continue;
                }
            }

            if(r1<satir-1){
                if(bomb[r1+1][r2]==0)     //alt
                {
                    i=i-1;
                    continue;
                }
            }
           /* if(bomb[r1+1][r2]==0)     //alt
            {
                i=i-1;

                continue;
            }
            */

            if(bomb[r1-1][r2-1]==0)     //solust
            {
                i=i-1;

                continue;
            }
            if((r1>0)&r2<sutun-1) {
                if (bomb[r1 - 1][r2 + 1] == 0)     //sagust
                {
                    i = i - 1;

                    continue;
                }
            }
            if((r1<satir-1)&r2>0) {
                if (bomb[r1 + 1][r2 - 1] == 0)     //solalt
                {
                    i = i - 1;

                    continue;
                }
            }
            if(r2>0) {
                if (bomb[r1][r2 - 1] == 0)     //sag
                {
                    i = i - 1;

                    continue;
                }
            }
            if((r1<satir-1)&r2<sutun-1) {
                if (bomb[r1 + 1][r2 + 1] == 0)     //sagalt
                {
                    i = i - 1;

                    continue;
                }
                else{
                   // bomb[r1+1][r2+1] = 1;

                }
            }


                if (bomb[r1][r2] == 1)
                {
                    count++;
                }
                else if(bomb[r1][r2] == 0){
                    i=i-1;
                }
                bomb[r1][r2] = 0;


        }
                System.out.println("Count == " + count);

            for(int i = 0; i<satir; i++)
            {
                for(int j = 0; j<sutun; j++)
                {
                    System.out.print(bomb[i][j] + " ");
                }
                System.out.println();
            }

            for(;;)
            {
                System.out.print("Hangi satir giriniz; ");
                satirIsaretlenen = scn.nextInt();
                System.out.print("Hangi sutun giriniz; ");
                sutunIsaretlenen = scn.nextInt();

                satirIsaretlenen--;
                sutunIsaretlenen--;

                if (bomb[satirIsaretlenen][sutunIsaretlenen] == 2)
                {
                    System.out.println("Isaretlediginiz yeri secemezsiniz!");
                    continue;
                }
                else if(bomb[satirIsaretlenen][sutunIsaretlenen] == 0)
                {
                    System.out.println("Bombaya bastiniz!");
                    break;
                }
                else
                {
                    bomb[satirIsaretlenen][sutunIsaretlenen]=2;
                }

                for(int i=0; i<satir; i++)
                {
                    for(int j=0; j<sutun; j++)
                    {
                        if(bomb[i][j] == 2)
                        {
                            System.out.print("x ");
                        }
                        else
                        {
                            System.out.print("- ");
                        }
                    }
                    System.out.println();
                }
                if((satir == -1) || (sutun == -1))
                {
                    break;
                }
                else if ((satir&sutun) == -1)
                {
                    break;
                }

            }
    }
}
