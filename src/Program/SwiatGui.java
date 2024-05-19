package Program;

import Program.Organizmy.Rosliny.Trawa;
import Program.Organizmy.Zwierzeta.Wilk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwiatGui extends JPanel {
    private Swiat swiat;
    private JButton nextTurnButton;
    private JTextArea logArea;

    private int tileSize;
    private int padding;

    public SwiatGui(Swiat swiat) {
        this.swiat = swiat;
        JFrame frame = new JFrame("Symulacja Świata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

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

        // Panel z logami
        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logArea);

        // Panel z polem wyboru organizmu
        JPanel selectPanel = new JPanel();
        selectPanel.add(new JLabel("Wybierz organizm:"));
        String[] organisms = {"Trawa", "Wilk"}; // Dodaj więcej opcji według potrzeb
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
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tileSize = Math.min(getWidth() / swiat.getSzerokosc(), getHeight() / swiat.getWysokosc());
        tileSize = Math.max(tileSize / 2, 5); // Zmniejszamy rozmiar organizmów
        padding = 2; // Dodajemy odstęp pomiędzy polami

        int boardWidth = swiat.getSzerokosc() * (tileSize + padding); // Usuwamy padding na krawędziach planszy
        int boardHeight = swiat.getWysokosc() * (tileSize + padding);

        // Rysujemy ramkę planszy
        g.drawRect(padding + tileSize, padding + tileSize, boardWidth, boardHeight);

        for (Organizm organizm : swiat.getOrganizmy()) {
            int x = organizm.getPozycjaX() * (tileSize + padding) + padding; // Dodajemy padding dla pozycji x i y
            int y = organizm.getPozycjaY() * (tileSize + padding) + padding;
            if (organizm instanceof Trawa) {
                g.setColor(Color.GREEN);
            } else if (organizm instanceof Wilk) {
                g.setColor(Color.RED);
            }
            g.fillRect(x, y, tileSize, tileSize);
        }
    }
    public void updateLog() {
        logArea.setText(swiat.getLog());
    }
}
