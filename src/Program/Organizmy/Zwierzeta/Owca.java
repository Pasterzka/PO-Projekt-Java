package Program.Organizmy.Zwierzeta;

import Program.Organizm;
import Program.Swiat;
import Program.Zwierze;

public class Owca extends Zwierze {
    public Owca(Swiat swiat){
        super(swiat);
    }
    public Owca(Swiat swiat, int x, int y, int wiek){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = 4;
        this.sila = 4;
    }
    public Owca(Swiat swiat, int x, int y){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.inicjatywa = 4;
        this.sila = 4;
    }

    @Override public void akcja(){
        super.akcja();
    }

    @Override
    public void kolizja(Organizm organizm) {
        if (this.getClass().getSimpleName() == organizm.getClass().getSimpleName()){
            rozmnazanie(organizm);
        }else{
            super.kolizja(organizm);
        }
    }

    @Override public void wypisz(){

    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    void rozmnazanie(Organizm organizm){
        int rodzic = (int) (Math.random()*2);
        if (rodzic == 0){
            rodzic1();
        }else{
            rodzic2(organizm);
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
                swiat.dodajOrganizm(new Owca(swiat, x, y));
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
