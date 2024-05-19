package Program.Organizmy.Zwierzeta;

import Program.Organizm;
import Program.Swiat;
import Program.Zwierze;

import java.awt.*;

public class Zolw extends Zwierze {
    public Zolw(Swiat swiat){
        super(swiat);
    }
    public Zolw(Swiat swiat, int x, int y, int wiek){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = 1;
        this.sila = 2;
    }
    public Zolw(Swiat swiat, int x, int y){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.inicjatywa = 1;
        this.sila = 2;
    }

    @Override public void akcja(){
        int szansa = (int) (Math.random()*4);
        if (szansa==0){
            super.akcja();
        }else{
            swiat.dodajLog(this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") nie poruszyl się, za mala sznsa na ruch.\n");
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
        g.setColor(Color.decode("#2E8B57"));
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        if (organizm.getSila() > 5) {
            return false;
        }else{
            return true;
        }
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

    @Override
    protected void ucieczka(Organizm organizm) {

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
                swiat.dodajOrganizm(new Zolw(swiat, x, y));
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
