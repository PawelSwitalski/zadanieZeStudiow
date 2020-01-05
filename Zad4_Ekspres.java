package Zad4;

import java.util.Scanner;

public interface Ekspres {

    default void main(){
        //Ekspres ekspres = new EkspresClass();
        this.wlaczEkspres();
        this.uzupelnijSkladniki();

        Scanner input = new Scanner(System.in);
        for (int i=0 ; i == 0;) {
            System.out.println("\nwybierz kawe \"Kawa\" \nuzupelnij skladniki \"Uzupelnij\" \ninformacje o ekspresie \"info\"");
            String decyzja = input.nextLine();

            switch (decyzja){
                case "Kawa":
                    this.wybierzNumerem();
                    break;
                case "Uzupelnij":
                    this.uzupelnijSkladniki();
                    break;
                case "info":
                    this.informacjeEkspres();
                    break;
                default:
                    i = 1;
            }
        }
    }


    void uzupelnijSkladniki();
    void wlaczEkspres();
    void getCisnienie();
    void setCisnienie(float pressure);
    void latte();
    void espresso();
    void americana();
    void iceCoffee();
    void flatWhite();
    void wlasna(float kawa, float cukier, float ilocsMleka, float temperaturaMleka, float iloscWody, float temperaturaWody);
    void wybierzNumerem();  // interaktywne
    void informacjeEkspres();
}
