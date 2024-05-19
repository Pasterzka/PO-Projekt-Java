package Program;


import Program.Organizmy.Rosliny.*;
import Program.Organizmy.Zwierzeta.*;

import java.io.*;
import java.util.ArrayList;
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

    public Swiat(){
        wysokosc = 0;
        szerokosc = 0;
        organizmy = new ArrayList<Organizm>();
        tura=0;
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
    public int getTura(){
        return tura;
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

    public void zapisz() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("zapis.txt"))) {
            writer.write(wysokosc + "\n");
            writer.write(szerokosc + "\n");
            writer.write(tura + "\n");
            writer.write(organizmy.size() + "\n");

            for (Organizm organizm : organizmy) {
                writer.write(organizm.getClass().getSimpleName() + " " + organizm.getInicjatywa() + " " + organizm.getSila() + " " +
                        organizm.getPozycjaX() + " " + organizm.getPozycjaY() + " " + organizm.getWiek()+ " " + organizm.getZdolnosc());
                writer.write("\n");
            }
            System.out.println("Gra została zapisana do pliku.");
        } catch (IOException e) {
            System.out.println("Nie można otworzyć pliku do zapisu!");
            e.printStackTrace();
        }
    }

    public void wczytaj() {
        try (BufferedReader reader = new BufferedReader(new FileReader("zapis.txt"))) {
            wysokosc = Integer.parseInt(reader.readLine());
            szerokosc = Integer.parseInt(reader.readLine());
            tura = Integer.parseInt(reader.readLine());
            log = "";
            int liczba = Integer.parseInt(reader.readLine());

            for (int i = 0; i < liczba; i++) {
                String[] parts = reader.readLine().split(" ");
                String nazwa = parts[0];
                int inicjatywa = Integer.parseInt(parts[1]);
                int sila = Integer.parseInt(parts[2]);
                int x = Integer.parseInt(parts[3]);
                int y = Integer.parseInt(parts[4]);
                int wiek = Integer.parseInt(parts[5]);
                int zdolnosc = Integer.parseInt(parts[6]);


                wczytajOrganizm(nazwa, inicjatywa, sila, x, y, wiek, zdolnosc);
            }
            System.out.println("Gra została odczytana z pliku.");
        } catch (IOException e) {
            System.out.println("Nie można otworzyć pliku do odczytu!");
            e.printStackTrace();
        }
    }
    private void wczytajOrganizm(String nazwa, int inicjatywa, int sila, int x, int y, int wiek, int zdolnosc) {
        switch (nazwa) {
            case "Czlowiek":
                this.dodajOrganizm(new Czlowiek(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Antylopa":
                this.dodajOrganizm(new Antylopa(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Lis":
                this.dodajOrganizm(new Lis(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Owca":
                this.dodajOrganizm(new Owca(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Wilk":
                this.dodajOrganizm(new Wilk(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Zolw":
                this.dodajOrganizm(new Zolw(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "BarszczSosnowskiego":
                this.dodajOrganizm(new BarszczSosnowskiego(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Trawa":
                this.dodajOrganizm(new Trawa(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Mlecz":
                this.dodajOrganizm(new Mlecz(inicjatywa, sila, x, y, wiek, this, zdolnosc));
                break;
            case "Guarana":
                this.dodajOrganizm(new Guarana(inicjatywa, sila, x, y, wiek, this,zdolnosc));
                break;
            case "WilzceJagody":
                this.dodajOrganizm(new WilczeJagody(inicjatywa, sila, x, y, wiek, this,zdolnosc));
                break;
        }
    }
}
