package Program;

public abstract class Zwierze extends Organizm{
    public Zwierze(Swiat swiat) {
        super(swiat);
    }

    @Override
    public void akcja() {
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY;
            ruch(noweX, noweY);
        }
        else if (kierunek == 1){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY - 1;
            ruch(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY - 1;
            ruch(noweX, noweY);
        }
        else if (kierunek == 3){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY - 1;
            ruch(noweX, noweY);
        }
        else if (kierunek == 4){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY;
            ruch(noweX, noweY);
        }
        else if (kierunek == 5){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY + 1;
            ruch(noweX, noweY);
        }
        else if (kierunek == 6){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY + 1;
            ruch(noweX, noweY);
        }
        else if (kierunek == 7){
            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY + 1;
            ruch(noweX, noweY);
        }
    }

    @Override
    public void kolizja(Organizm organizm) {
        String log;

        if (organizm instanceof Roslina) {
            organizm.kolizja(this);
        } else {
            if (organizm.czyOdbil(this)) {
                log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") odbił atak " + this.getClass().getSimpleName() + "z (" + this.getPozycjaY() + " " + this.getPozycjaY() + ").\n";
                swiat.dodajLog(log);
            } else if (this.getSila() >= organizm.getSila()) {
                if (this.getSila() >= organizm.getSila()) {
                    log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") niszczy " + organizm.getClass().getSimpleName() + "z (" + organizm.getPozycjaY() + " " + organizm.getPozycjaY() + ").\n";
                    swiat.dodajLog(log);
                    int pomX = organizm.getPozycjaX();
                    int pomY = organizm.getPozycjaY();
                    swiat.usunOrganizm(swiat.getIndexOrganizmu(pomX, pomY));
                    this.setPozycjaY(pomY);
                    this.setPozycjaX(pomX);
                } else {
                    log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy atakujacego " + this.getClass().getSimpleName() + "z (" + this.getPozycjaY() + " " + this.getPozycjaY() + ").\n";
                    swiat.dodajLog(log);
                    int pomX = this.getPozycjaX();
                    int pomY = this.getPozycjaY();
                    swiat.usunOrganizm(swiat.getIndexOrganizmu(pomX, pomY));
                }
            }
        }
    }

    @Override
    public void wypisz() {

    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    void ruch(int noweX, int noweY){
        String log;
        if (noweX >= 1 && noweX <= swiat.getSzerokosc() && noweY >=1 && noweY <= swiat.getWysokosc()){
            if (!swiat.czyOrganizmXY(noweX, noweY)){
                log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") przeszedl na ("+ noweX + " " + noweY + ").\n";
                swiat.dodajLog(log);
                this.setPozycjaX(noweX);
                this.setPozycjaY(noweY);
            }else{
                Organizm oragnizm = swiat.getOrganizm(noweX, noweY);
                kolizja(oragnizm);
            }
        }else{
            log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") nie udalo sie poruszyc.\n";
            swiat.dodajLog(log);
        }
    }
}
