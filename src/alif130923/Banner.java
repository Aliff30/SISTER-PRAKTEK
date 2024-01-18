package alif130923;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Banner {

    private JFrame frame;
    private JPanel bannerPanel;
    private JLabel bannerLabel;
    private JLabel movingTextLabel;
    private String bannerText;
    private String movingText;
    private int bannerPosition;
    private int movingTextPosition;
    private Timer timer;

    public Banner() {
        frame = new JFrame("Banner Example");
        bannerPanel = new JPanel();
        bannerText = "Alif Jindan!";
        movingText = "Muhammad Ali Akbar";

        bannerPosition = 0;
        movingTextPosition = 0;

        bannerLabel = new JLabel(bannerText);
        bannerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        movingTextLabel = new JLabel(movingText);
        movingTextLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        bannerPanel.setLayout(new BorderLayout());

        bannerPanel.add(bannerLabel, BorderLayout.CENTER); 
        bannerPanel.add(movingTextLabel, BorderLayout.SOUTH); 

        frame.add(bannerPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBanner();
                moveMovingText();
            }
        });

        timer.start();
    }

    private void moveBanner() {
        bannerPosition++;
        if (bannerPosition >= bannerText.length()) {
            bannerPosition = 0;
        }

        String displayText = bannerText.substring(bannerPosition) + bannerText.substring(0, bannerPosition);
        bannerLabel.setText(displayText);
    }

    private void moveMovingText() {
        movingTextPosition++;
        if (movingTextPosition >= movingText.length()) {
            movingTextPosition = 0;
        }

        String displayText = movingText.substring(movingTextPosition) + movingText.substring(0, movingTextPosition);
        movingTextLabel.setText(displayText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Banner().frame.setVisible(true);
            }
        });
    }
}
