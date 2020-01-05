package Zad4;

import Zad4.skladniki.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class EkspresClass implements Ekspres{

    private Panel panel = new Panel();
    private Woda woda = new Woda();
    private Mleko mleko = new Mleko();
    private Kubki kubki = new Kubki();
    private KawaZiarna kawaZiarna = new KawaZiarna();
    private Cukier cukier = new Cukier();

    private Zbiornik[] zbiorniki = {
            kubki,
            woda,
            mleko,
            kawaZiarna,
            cukier
    };

    private Grzalka[] grzalki = {
            mleko,
            woda
    };

    private  Pompa[] pompy = {
            mleko,
            woda
    };

    EkspresClass(){ uzupelnijSkladniki(); }

    @Override
    public void uzupelnijSkladniki() { for (Zbiornik zbiornik : zbiorniki) { zbiornik.napelnij(); } }

    @Override
    public void wlaczEkspres() {
        panel.setAll(true);

        for (Pompa pompa : pompy) {
            pompa.setPompa(true);
            pompa.setPressure(55);
        }
    }

    @Override
    public void getCisnienie() {
        for (int i = 0; i < pompy.length; i++) {
            System.out.println("cisnienie pompy "+ (i+1) + " wynosi " + pompy[i].getPressure());
        }
    }

    @Override
    public void setCisnienie(float pressure) {
        for (Pompa pompa : pompy)
            pompa.setPressure(pressure);
    }

    @Override
    public void latte() {
        if(makeCoffee(30, 45, 60, 40, 10, 90))
            System.out.println("latte");
    }

    @Override
    public void espresso() {
        if(makeCoffee(50, 5, 0, 0, 40, 90))
            System.out.println("espresso");

    }

    @Override
    public void americana() {
        if(makeCoffee(30, 10, 0, 0,70, 90))
            System.out.println("americana");
    }

    @Override
    public void iceCoffee() {
        if(makeCoffee(20, 30, 60, 0, 20, 20))
            System.out.println("iceCoffee");
    }

    @Override
    public void flatWhite() {
               if(makeCoffee(45, 10, 50, 90, 50, 90))
            System.out.println("flatWhite");
    }

    @Override
    public void wlasna(
            float kawa ,
            float cukier,
            float ilocsMleka,
            float temperaturaMleka,
            float iloscWody,
            float temperaturaWody )
    {
        makeCoffee(kawa, cukier, ilocsMleka, temperaturaMleka, iloscWody, temperaturaWody);
        System.out.println();
    }

    @Override
    public void wybierzNumerem() {
        System.out.println("wybierz ktora kawe chcesz \n 1 late\n 2 espresso\n 3 americana\n 4 iceCoffee\n 5 flatWhite\n 6 wlasna");
        Scanner skan = new Scanner(System.in);
        int ktoraKawa = skan.nextInt();

        switch (ktoraKawa){
            case 1:
                latte();
                break;
            case 2:
                espresso();
                break;
            case 3:
                americana();
                break;
            case 4:
                iceCoffee();
                break;
            case 5:
                flatWhite();
                break;
            case 6:
                System.out.print("Podaj ilosc kawy: ");
                float iloscKawy = skan.nextFloat();
                System.out.print("Podaj ilosc cukru: ");
                float iloscCukru = skan.nextFloat();
                System.out.print("Podaj ilosc mleka: ");
                float iloscMleka = skan.nextFloat();
                System.out.print("Podaj temperature mleka: ");
                float temperaturaMleka = skan.nextFloat();
                System.out.print("Podaj ilosc wody: ");
                float iloscWody = skan.nextFloat();
                System.out.print("Podaj temperature wody: ");
                float temperaturaWody = skan.nextFloat();
                wlasna(iloscKawy, iloscCukru, iloscMleka, temperaturaMleka, iloscWody, temperaturaWody);
                break;
        }

    }

    @Override
    public void informacjeEkspres() {
        System.out.println("temperatura grzalki wody: " + grzalki[1].getTemperature());
        System.out.println("temperatura grzalki mleka: " + grzalki[0].getTemperature());
        System.out.println("cisnienie pompy z woda: " + pompy[1].getPressure());
        System.out.println("cisnienie pompy z mlekiem: " + pompy[0].getPressure());
        System.out.println("ilosc kubkow w zbiorniku: " + zbiorniki[0].getZbiornik());
        System.out.println("ilosc wody w zbiorniku: " + zbiorniki[1].getZbiornik());
        System.out.println("ilosc malek w zbiorniku: " + zbiorniki[2].getZbiornik());
        System.out.println("ilosc kawy w zbiorniku: " + zbiorniki[3].getZbiornik());
        System.out.println("ilosc cukru w zbiorniku: " + zbiorniki[4].getZbiornik());
    }


    private boolean makeCoffee(float kawaZiarna, float cukier, float ilocsMleka, float temperaturaMleka, float iloscWody, float temperaturaWody) {
        this.mleko.setTemperature(temperaturaMleka);
        this.mleko.pobierz(ilocsMleka);
        this.woda.setTemperature(temperaturaWody);
        this.woda.pobierz(iloscWody);
        this.kawaZiarna.pobierz(kawaZiarna);
        this.cukier.pobierz(cukier);

        if(canMakeCoffee()){
            Runnable[] runnables = new Runnable[4];

            runnables[0] = () -> {
                System.out.println("mielenie kawy");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            runnables[1] = () -> {
                System.out.println("dodawanie cukru");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            runnables[2] = () -> {
                System.out.println("nalewanie mleka");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            runnables[3] = () -> {
                System.out.println("nalewanie wody");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            ArrayList<Thread> threadList = new<Thread> ArrayList();
            for (Runnable runnable : runnables) { threadList.add(new Thread(runnable)); }

            for (Thread thread : threadList) { thread.start(); }



            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("zaserwowano kawe ");
            return true;
        }
        else
            System.out.println("Kturegos ze skladnikow brakuje");
        return false;
    }

    private boolean canMakeCoffee() {
        if(mleko.isEmpty()) return false;
        if(woda.isEmpty()) return false;
        if(kawaZiarna.isEmpty()) return false;
        if(cukier.isEmpty()) return false;
        if(kubki.isEmpty()) return false;
        if(!woda.isOn() || !mleko.isOn()) return false;

        return true;
    }

}
