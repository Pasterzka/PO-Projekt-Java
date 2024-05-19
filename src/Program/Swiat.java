package Program;


import java.util.List;

public class Swiat {
    private List<Organizm> organizmy;
    private SwiatGui swiatGUI;

    private int szerokosc;
    private int wysokosc;

    private String log;

    private int tura;
    private int globalIndex;

    //konstruktory
    Swiat(int wysokosc, int szerokosc, List<Organizm> organizmy, int tura){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.organizmy = organizmy;
        this.tura = tura;
        this.log = ""; // Inicjalizacja logów
    }
    Swiat(int wysokosc, int szerokosc, List<Organizm> organizmy){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.organizmy = organizmy;
        this.log = ""; // Inicjalizacja logów
    }

    //getery
    public int getWysokosc() {
        return wysokosc;
    }
    public int getSzerokosc() {
        return szerokosc;
    }
    public String getLogi() {
        return this.log;
    }
    public int getIndexOrganizmu(int x, int y) {
        for (int i = 0; i < organizmy.size(); i++) {
            if (organizmy.get(i).getPozycjaX() == x && organizmy.get(i).getPozycjaY() == y) {
                return i;
            }
        }
        return -1;  // Jeśli nie znaleziono
    }
    public int getDlougoscOrganizmow() {
        return organizmy.size();
    }

    //setery
    public void czyscLog() {
        this.log = "";
    }
    public void dodajLog(String log) {
        this.log += log;
        if (swiatGUI != null) {
            swiatGUI.updateLog(); // Aktualizacja logów w GUI
        }
    }
    public void setSzerokosc(int szerokosc) {
        this.szerokosc = szerokosc;
    }
    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    //dodanie organizmu
    public void dodajOrganizm(Organizm organizm) {

        if (!this.czyOrganizmXY(organizm.getPozycjaX(), organizm.getPozycjaY()) && organizm.getPozycjaX()>=1 && organizm.getPozycjaX()<=this.getSzerokosc() && organizm.getPozycjaY()>=1 && organizm.getPozycjaY()<=this.getWysokosc()) {
            this.organizmy.add(organizm);
            this.organizmy.sort((a, b) -> Integer.compare(b.getInicjatywa(), a.getInicjatywa()));
            if (organizm.getInicjatywa() > this.organizmy.get(globalIndex).getInicjatywa()) {
                globalIndex++;
            }
        }else{
            this.dodajLog("Nie można dodać organizmu!!!!\n");
        }


    }

    //następna tura
    public void nastepnaTura() {
        tura++;
        this.organizmy.sort((a, b) -> Integer.compare(b.getInicjatywa(), a.getInicjatywa()));
        for (globalIndex = 0; globalIndex < organizmy.size(); globalIndex++) {
            if (organizmy.get(globalIndex).getWiek() > 0) {
                organizmy.get(globalIndex).akcja();
            }
            organizmy.get(globalIndex).dorastanie();
        }

        if (swiatGUI != null) {
            swiatGUI.repaint();
        }
    }

    //dorastanie początek gry
    public void dorastanieStart() {
        for (Organizm organizm : organizmy) {
            organizm.dorastanie();
        }
    }

    //sprawdzanie czy jest organizm na pozycji X Y
    public boolean czyOrganizmXY(int x, int y) {
        for (Organizm organizm : organizmy) {
            if (organizm.getPozycjaX() == x && organizm.getPozycjaY() == y) {
                return true;
            }
        }
        return false;
    }

    //usunięcie organizmu
    public void usunOrganizm(int index) {
        if (globalIndex > index) {
            globalIndex--;
        }
        organizmy.get(index).setInicjatywa(-1);
        this.organizmy.sort((a, b) -> Double.compare(b.getInicjatywa(), a.getInicjatywa()));
        organizmy.remove(organizmy.size() - 1);
    }

    //zwracanie organizmu o inedxie
    public Organizm getOrganizm(int x, int y) {
        for (Organizm organizm : organizmy) {
            if (organizm.getPozycjaX() == x && organizm.getPozycjaY() == y) {
                return organizm;
            }
        }
        return null;  // Jeśli nie znaleziono
    }

    public List<Organizm> getOrganizmy() {
        return organizmy;
    }

    public void setSwiatGUI(SwiatGui swiatGui) {
        this.swiatGUI = swiatGui;
    }

    public String getLog() {
        return log;
    }

}
