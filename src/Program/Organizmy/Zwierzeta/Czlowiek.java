package Program.Organizmy.Zwierzeta;

import Program.Organizm;
import Program.Swiat;
import Program.Zwierze;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Czlowiek extends Zwierze {
    public Czlowiek(Swiat swiat, int x, int y){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = 1;
        this.inicjatywa = 4;
        this.sila = 5;
        this.zdolnosc =10;
    }
    public Czlowiek(int inicjatywa, int sila, int x, int y, int wiek, Swiat swiat, int zdolnosc){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = inicjatywa;
        this.sila = sila;
        this.zdolnosc = zdolnosc;
    }

    public void akcja(){
        Scanner scanner = new Scanner(System.in);

        int kierunek = Integer.parseInt(JOptionPane.showInputDialog("Podaj co chcesz zrobic:"));;
        if (kierunek == 4){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 7){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY - 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 8){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY - 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 9){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY - 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 6){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 3){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY + 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY + 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 1){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY + 1;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 5){
            if (zdolnosc == 10){
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") uzywa zdolnosc.\n");
                uzycieZdolnosc();
                zdolnosc = -1;
            }else{

                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") zdolnosc aktywna lub sie laduje.\n");
            }
        }

        if (zdolnosc<10){
            zdolnosc++;
            uzycieZdolnosc();
        }
    }

    private void uzycieZdolnosc() {
        palenieXY(pozycjaX - 1, pozycjaY);
        palenieXY(pozycjaX - 1, pozycjaY - 1);
        palenieXY(pozycjaX, pozycjaY - 1);
        palenieXY(pozycjaX + 1, pozycjaY - 1);
        palenieXY(pozycjaX + 1, pozycjaY);
        palenieXY(pozycjaX + 1, pozycjaY + 1);
        palenieXY(pozycjaX, pozycjaY + 1);
        palenieXY(pozycjaX - 1, pozycjaY + 1);
    }

    void palenieXY(int x, int y){
        if ( x>=1 && x<=swiat.getSzerokosc() && y>1 && y<=swiat.getWysokosc()){
            if (swiat.czyOrganizmXY(x,y)){
                if (swiat.getOrganizm(x,y).getClass().getSimpleName() == swiat.getOrganizm(pozycjaX,pozycjaY).getClass().getSimpleName()){

                }else{
                    String log;
                    log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") pali organizm z (" + x + " " + y + ").\n";
                    swiat.dodajLog(log);
                    swiat.usunOrganizm(swiat.getIndexOrganizmu(x,y));
                }
            }
        }
    }

    @Override public void wypisz(Graphics g){
        g.setColor(Color.red);
    }

    @Override
    protected void ucieczka(Organizm organizm) {

    }
}
