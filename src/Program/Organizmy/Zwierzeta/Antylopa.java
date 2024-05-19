package Program.Organizmy.Zwierzeta;

import Program.Organizm;
import Program.Swiat;
import Program.Zwierze;

import java.awt.*;

public class Antylopa extends Zwierze {
    public Antylopa(int inicjatywa, int sila, int x, int y, int wiek, Swiat swiat, int zdolnosc){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = inicjatywa;
        this.sila = sila;
        this.zdolnosc = 0;
    }
    public Antylopa(Swiat swiat){
        super(swiat);
    }
    public Antylopa(Swiat swiat, int x, int y, int wiek){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = 4;
        this.sila = 4;
    }
    public Antylopa(Swiat swiat, int x, int y){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.inicjatywa = 4;
        this.sila = 4;
    }

    @Override public void akcja(){
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = this.pozycjaX - 2;
            int noweY = this.pozycjaY;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 1){
            int noweX = this.pozycjaX - 2;
            int noweY = this.pozycjaY - 2;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY - 2;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 3){
            int noweX = this.pozycjaX + 2;
            int noweY = this.pozycjaY - 2;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 4){
            int noweX = this.pozycjaX + 2;
            int noweY = this.pozycjaY;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 5){
            int noweX = this.pozycjaX + 2;
            int noweY = this.pozycjaY + 2;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 6){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY + 2;
            super.ruch(noweX, noweY);
        }
        else if (kierunek == 7){
            int noweX = this.pozycjaX - 2;
            int noweY = this.pozycjaY + 2;
            super.ruch(noweX, noweY);
        }
    }

    @Override
    public void kolizja(Organizm organizm) {
        if (this.getClass().getSimpleName() == organizm.getClass().getSimpleName()){
            rozmnazanie(organizm);
        }else{
            super.kolizja(organizm);
        }
    }

    @Override public void wypisz(Graphics g){
        g.setColor(Color.decode("#E9967A"));
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    void rozmnazanie(Organizm organizm){
        if (this.getWiek()>3 && organizm.getWiek()>3){
            int rodzic = (int) (Math.random()*2);
            if (rodzic == 0){
                rodzic1();
            }else{
                rodzic2(organizm);
            }
        }else{
            swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") oraz " + organizm.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") za mlodzi aby sie rozmoznyc.\n");
        }
    }
    void rodzic1(){
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = this.getPozycjaX() -1;
            int noweY = this.getPozycjaY();
            dodanie(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = this.getPozycjaX() -1;
            int noweY = this.getPozycjaY() -1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 3){
            int noweX = this.getPozycjaX();
            int noweY = this.getPozycjaY() -1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 4){
            int noweX = this.getPozycjaX() +1;
            int noweY = this.getPozycjaY();
            dodanie(noweX, noweY);
        }
        else if (kierunek == 5){
            int noweX = this.getPozycjaX() +1;
            int noweY = this.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 6){
            int noweX = this.getPozycjaX();
            int noweY = this.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 7){
            int noweX = this.getPozycjaX() -1;
            int noweY = this.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
    }

    void rodzic2(Organizm organizm){
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = organizm.getPozycjaX() -1;
            int noweY = organizm.getPozycjaY();
            dodanie(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = organizm.getPozycjaX() -1;
            int noweY = organizm.getPozycjaY() -1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 3){
            int noweX = organizm.getPozycjaX();
            int noweY = organizm.getPozycjaY() -1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 4){
            int noweX = organizm.getPozycjaX() +1;
            int noweY = organizm.getPozycjaY();
            dodanie(noweX, noweY);
        }
        else if (kierunek == 5){
            int noweX = organizm.getPozycjaX() +1;
            int noweY = organizm.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 6){
            int noweX = organizm.getPozycjaX();
            int noweY = organizm.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
        else if (kierunek == 7){
            int noweX = organizm.getPozycjaX() -1;
            int noweY = organizm.getPozycjaY() +1;
            dodanie(noweX, noweY);
        }
    }

    void dodanie(int x, int y){
        String log;
        if (x >= 1 && x <= swiat.getSzerokosc() && y >=1 && y <= swiat.getWysokosc()){
            if (!swiat.czyOrganizmXY(x,y)){
                swiat.dodajOrganizm(new Antylopa(swiat, x, y));
                log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
                swiat.dodajLog(log);
            }else{
                log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") nie udalo sie rozmnozyc.\n";
                swiat.dodajLog(log);
            }
        }else{
            log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") nie udalo sie rozmnozyc.\n";
            swiat.dodajLog(log);
        }

    }

    protected void ucieczka(Organizm organizm){
        int szansa = (int) (Math.random()*2);
        if (szansa == 1){
            ucieczkakod(organizm);
        }else{
            bojka(organizm);
        }
    }

    void ucieczkakod(Organizm organizm){
        int x = this.getPozycjaX();
        int y = this.getPozycjaY();
        if (poleDoUcieczki(x-1,y)){
            int noweX = x-1;
            int noweY = y;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x-1,y-1)){
            int noweX = x-1;
            int noweY = y-1;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x,y-1)){
            int noweX = x;
            int noweY = y-1;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x+1,y-1)){
            int noweX = x+1;
            int noweY = y-1;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x+1,y)){
            int noweX = x+1;
            int noweY = y;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x+1,y+1)){
            int noweX = x+1;
            int noweY = y+1;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x,y+1)){
            int noweX = x;
            int noweY = y+1;
            przesun(organizm, noweX, x, noweY, y);
        }else if (poleDoUcieczki(x-1,y+1)){
            int noweX = x-1;
            int noweY = y+1;
            przesun(organizm, noweX, x, noweY, y);
        }else{
            super.bojka(organizm);
        }

    }

    void przesun(Organizm organizm, int x, int noweX, int y, int noweY){
        swiat.dodajLog(organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") przemieszcza sie na (" + x + " " + y + ").\n");
        organizm.setPozycjaX(x);
        organizm.setPozycjaY(y);
        swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") ucieka na (" + noweX + " " + noweY + ").\n");
        this.setPozycjaX(noweX);
        this.setPozycjaY(noweY);
    }

    boolean poleDoUcieczki(int x,int y){
        if (swiat.czyOrganizmXY(x,y) && x>=1 && y>=1 && x<=swiat.getSzerokosc() && y<=swiat.getWysokosc()){
            return false;
        }
        return true;
    }
}

