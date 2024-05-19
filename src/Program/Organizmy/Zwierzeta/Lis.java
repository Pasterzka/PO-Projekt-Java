package Program.Organizmy.Zwierzeta;

import Program.Organizm;
import Program.Swiat;
import Program.Zwierze;

import java.awt.*;

public class Lis extends Zwierze {
    public Lis(int inicjatywa, int sila, int x, int y, int wiek, Swiat swiat, int zdolnosc){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = inicjatywa;
        this.sila = sila;
        this.zdolnosc = 0;
    }
    public Lis(Swiat swiat){
        super(swiat);
    }
    public Lis(Swiat swiat, int x, int y, int wiek){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = 7;
        this.sila = 3;
    }
    public Lis(Swiat swiat, int x, int y){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.inicjatywa = 7;
        this.sila = 3;
    }

    @Override
    public void akcja() {
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 1){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY - 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 2){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY - 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 3){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY - 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 4){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 5){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY + 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 6){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY + 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
        }
        else if (kierunek == 7){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY + 1;
            if (!swiat.czyOrganizmXY(noweX,noweY) || (swiat.czyOrganizmXY(noweX,noweY) && swiat.getOrganizm(noweX,noweY).getSila()<this.getSila())){
                super.ruch(noweX, noweY);
            }else{
                swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie wykonal ruchu, bo na wylosowanym polu (" + noweX + " " + noweY + ") znajduje sie silniejszy przeciwnik.\n");
            }
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
    @Override
    protected void ucieczka(Organizm organizm) {

    }

    @Override public void wypisz(Graphics g){
        g.setColor(Color.ORANGE);
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
                swiat.dodajOrganizm(new Lis(swiat, x, y));
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
}
