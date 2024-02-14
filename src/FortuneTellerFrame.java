import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea textArea;
    private ArrayList<String> fortunes;
    private int previousFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create fonts
        Font titleFont = new Font("Arial", Font.BOLD, 36);
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font fortuneFont = new Font("Arial", Font.PLAIN, 14);

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);

        // Add JLabel with text and ImageIcon
        ImageIcon fortuneTellerImage = new ImageIcon("fortune_teller_image.png");
        JLabel titleLabel = new JLabel("Fortune Teller", fortuneTellerImage, JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        topPanel.add(titleLabel);


        add(topPanel, BorderLayout.NORTH); // Add top panel to the frame

        // Middle panel
        JPanel middlePanel = new JPanel(new BorderLayout());

        // Add JTextArea within a JScrollPane
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font and size for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        add(middlePanel, BorderLayout.CENTER); // Add middle panel to the frame

        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Add buttons to the bottom panel
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH); // Add bottom panel to the frame

        // Create fortunes array
        fortunes = new ArrayList<>();
        fortunes.add("Expect a surpise soon");
        fortunes.add("Look forward to tomorrow!");
        fortunes.add("Think carefully on upcoming decisions");
        fortunes.add("You will have a new love come into your life!");
        fortunes.add("Don't doubt yourself");
        fortunes.add("Remember to look around you!");
        fortunes.add("You will get an A on your next exam");
        fortunes.add("Do a good deed today");
        fortunes.add("Be careful on tuesday");
        fortunes.add("Someone will call you today");
        fortunes.add("You are lovely");
        fortunes.add("Surround yourself with good people");

        // Add more fortunes...

        // Read My Fortune button
        readFortuneButton.addActionListener(e -> {
            String newFortune = selectRandomFortune();
            textArea.append(newFortune + "\n");
        });

        // Quit button
        quitButton.addActionListener(e -> System.exit(0));
    }

    private String selectRandomFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == previousFortuneIndex); // Ensure not the same as last one

        previousFortuneIndex = index; // Update previous index

        return fortunes.get(index);
    }
}
