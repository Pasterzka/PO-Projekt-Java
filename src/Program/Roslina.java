package Program;

public abstract class Roslina extends Organizm{

    public Roslina(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
    }

    @Override
    public void akcja(){
        int szansa = (int) (Math.random()*100) + 1;
        if (szansa>50){
            kierunekRozmazania();
        }else{
            String log;
            log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") za mala szansa na rozmnozenie.\n";
            swiat.dodajLog(log);
        }
    }

    @Override
    public void kolizja(Organizm organizm) {
    }

    @Override
    public void wypisz() {
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    void kierunekRozmazania(){
        int kierunek = (int) (Math.random()*8);
        if (kierunek == 0){
            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY - 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 1){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY - 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 2){
            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 3){

            int noweX = this.pozycjaX + 1;
            int noweY = this.pozycjaY + 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 4){

            int noweX = this.pozycjaX;
            int noweY = this.pozycjaY + 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 5){

            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY + 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 6){

            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY;
            SprawdzenieMiejsca(noweX, noweY);
        }
        else if (kierunek == 7){

            int noweX = this.pozycjaX - 1;
            int noweY = this.pozycjaY - 1;
            SprawdzenieMiejsca(noweX, noweY);
        }
    }

    void SprawdzenieMiejsca(int noweX, int noweY){
        if ((this.pozycjaY != noweY || this.pozycjaX != noweX) && noweX >= 1 && noweX <= swiat.getSzerokosc() && noweY >=1 && noweY <= swiat.getWysokosc()){
            if (!swiat.czyOrganizmXY(noweX, noweY)){
                dodanie(noweX, noweY);
            }else{
                String log;
                log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") nie udalo sie rozmnozyc.\n";
                swiat.dodajLog(log);
            }
        }else{
            String log;
            log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") nie udalo sie rozmnozyc.\n";
            swiat.dodajLog(log);
        }
    }

    protected abstract void dodanie(int x, int y);
}


