package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

import java.awt.*;

public class BarszczSosnowskiego extends Roslina {
    public BarszczSosnowskiego(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 10;
    }

    public BarszczSosnowskiego(Swiat swiat, int x, int y) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 10;
        this.pozycjaX = x;
        this.pozycjaY = y;
    }

    public BarszczSosnowskiego(Swiat swiat, int x, int y, int wiek) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 10;
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
    }
    @Override
    public void akcja(){
        palenie();
        super.akcja();
    }

    @Override
    public void kolizja(Organizm organizm) {
        String log;
        if (organizm.getSila() > this.sila){
            log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy " + this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") niszczy " + organizm.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            swiat.usunOrganizm(swiat.getIndexOrganizmu(organizm.getPozycjaX(), organizm.getPozycjaY()));
            swiat.usunOrganizm(swiat.getIndexOrganizmu(this.getPozycjaX(), this.getPozycjaY()));
        }else {
            log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") niszczy " + organizm.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            swiat.usunOrganizm(swiat.getIndexOrganizmu(organizm.getPozycjaX(), organizm.getPozycjaY()));
        }
    }

    @Override
    public void wypisz(Graphics g) {
        g.setColor(Color.decode("#48D1CC"));
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    @Override
    protected void ucieczka(Organizm organizm) {

    }

    @Override
    protected void dodanie(int x, int y) {
        swiat.dodajOrganizm(new BarszczSosnowskiego(swiat, x, y));
        String log;
        log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
        swiat.dodajLog(log);
    }

    void palenie(){
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
}
