package Program;

import Program.Organizmy.Rosliny.*;
import Program.Organizmy.Zwierzeta.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SwiatGui extends JPanel {
    private Swiat swiat;
    private JButton nextTurnButton;
    private JButton saveButton;
    private JTextArea logArea;

    private int tileSize =25;
    private int padding =2;

    public SwiatGui(Swiat swiat) {
        this.swiat = swiat;

        JFrame frame = new JFrame("Symulacja Świata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension( 800, 600));
        this.setLayout(new BorderLayout());

        // Panel z przyciskiem
        JPanel buttonPanel = new JPanel();
        nextTurnButton = new JButton("Następna Tura");
        nextTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.czyscLog();
                swiat.nastepnaTura();
                updateLog();
                repaint();
            }
        });
        buttonPanel.add(nextTurnButton);

        // Przycisk do zapisu gry
        saveButton = new JButton("Zapisz grę");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.zapisz();
            }
        });
        buttonPanel.add(saveButton);

        // Panel z logami
        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logArea);

        // Panel z polem wyboru organizmu
        JPanel selectPanel = new JPanel();
        selectPanel.add(new JLabel("Wybierz organizm:"));
        String[] organisms = {"Trawa", "Wilk", "Owca", "Barszcz Sosnowskiego", "Guarana", "Mlecz", "Wilcze Jagody", "Zolw", "Lis", "Antylopa"};
        JComboBox organismSelection = new JComboBox<>(organisms);
        selectPanel.add(organismSelection);

        // Dodanie paneli do ramki
        frame.add(this, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(logScrollPane, BorderLayout.EAST);
        frame.add(selectPanel, BorderLayout.NORTH);

        frame.setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / (tileSize + padding);
                int y = e.getY() / (tileSize + padding);
                String selectedOrganism = (String) organismSelection.getSelectedItem();
                if (selectedOrganism.equals("Trawa")) {
                    swiat.dodajOrganizm(new Trawa(swiat,x, y));
                } else if (selectedOrganism.equals("Wilk")) {
                    swiat.dodajOrganizm(new Wilk(swiat,x, y));
                } else if (selectedOrganism.equals("Owca")) {
                    swiat.dodajOrganizm(new Owca(swiat,x, y));
                } else if (selectedOrganism.equals("Guarana")) {
                    swiat.dodajOrganizm(new Guarana(swiat,x, y));
                } else if (selectedOrganism.equals("Barszcz Sosnowskiego")) {
                    swiat.dodajOrganizm(new BarszczSosnowskiego(swiat,x, y));
                } else if (selectedOrganism.equals("Mlecz")) {
                    swiat.dodajOrganizm(new Mlecz(swiat,x, y));
                } else if (selectedOrganism.equals("Wilcze Jagody")) {
                    swiat.dodajOrganizm(new WilczeJagody(swiat,x, y));
                } else if (selectedOrganism.equals("Zolw")) {
                    swiat.dodajOrganizm(new Zolw(swiat,x, y));
                } else if (selectedOrganism.equals("Lis")) {
                    swiat.dodajOrganizm(new Lis(swiat,x, y));
                } else if (selectedOrganism.equals("Antylopa")) {
                    swiat.dodajOrganizm(new Antylopa(swiat,x, y));
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tileSize = 25;
        padding = 2;

        int boardWidth = swiat.getSzerokosc() * (tileSize + padding);
        int boardHeight = swiat.getWysokosc() * (tileSize + padding);

        // Rysujemy ramkę planszy
        g.drawRect(padding + tileSize, padding + tileSize, boardWidth, boardHeight);

        for (Organizm organizm : swiat.getOrganizmy()) {
            int x = organizm.getPozycjaX() * (tileSize + padding) + padding; // Dodawanie padding dla pozycji x i y
            int y = organizm.getPozycjaY() * (tileSize + padding) + padding;
            organizm.wypisz(g);
            g.fillRect(x, y, tileSize, tileSize);
        }
    }
    public void updateLog() {
        logArea.setText(swiat.getLog());
    }

}
