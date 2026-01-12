import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Project2 extends JPanel {

    private int new_xcoord, new_ycoord;
    private int score = 0;
    private int targetSize = 50;  // Default target size
    private JLabel scoreLabel;
    private JButton exitButton, restartButton;
    private ExitListener e1;
    private JButton easyButton, mediumButton, hardButton;
    private Random rand = new Random();
    private JProgressBar progressBar;

    public Project2() {
        JFrame frame = new JFrame("Aim Simulator");
        frame.setSize(1000, 800);
        this.setPreferredSize(new Dimension(1000, 800));
        this.setLayout(null);

        // Score label
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setBounds(460, 25, 300, 30);

        // Exit button
        exitButton = new JButton("Exit Game");
        exitButton.setBounds(900, 770, 100, 30);
        e1 = new ExitListener();
        exitButton.addActionListener(e1);

        // Restart button
        restartButton = new JButton("Restart Game");
        restartButton.setBounds(700, 770, 150, 30);
        restartButton.addActionListener(new ButtonListener1());
        

        // Difficulty buttons
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");
        easyButton.setBounds(700, 0, 100, 50);
        mediumButton.setBounds(800, 0, 100, 50);
        hardButton.setBounds(900, 0, 100, 50);
        easyButton.addActionListener(new ButtonListener2(75));
        mediumButton.addActionListener(new ButtonListener2(50));
        hardButton.addActionListener(new ButtonListener2(25));
        

        // Add the JProgressBar to represent the progress
        progressBar = new JProgressBar(0, 30); // Maximum value of 30
        progressBar.setValue(0);
        progressBar.setStringPainted(true);  // To show percentage
        progressBar.setBounds(350, 0, 300, 30);
        progressBar.setString("Score Progress");

        MouseClicker m1 = new MouseClicker();

        // Add components to the panel
        this.add(scoreLabel);
        this.add(exitButton);
        this.add(restartButton);
        this.add(progressBar);
        this.addMouseListener(m1);
        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        newTarget();  // Initial target setup
    }

    // This method restarts the game if button is pressed
    private class ButtonListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            restartGame();
        }
    }

    // This method changes the size of the targets based on difficulty
    private class ButtonListener2 implements ActionListener {
        private int size;

        public ButtonListener2(int size) {
            this.size = size;
        }

        public void actionPerformed(ActionEvent e) {
            targetSize = size;
            newTarget();
        }
    }

    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            System.exit(0);
        }
    }

    public class MouseClicker implements MouseListener {
        // If mouse pressed and is on the coordinates of the target, the program creates a new target and adds 1 to the score
        public void mousePressed(MouseEvent m) {
            int getMouseX = m.getX();
            int getMouseY = m.getY();

            if ((getMouseX >= new_xcoord && getMouseX <= new_xcoord + targetSize) &&
                (getMouseY >= new_ycoord && getMouseY <= new_ycoord + targetSize)) {
                score++;
                scoreLabel.setText("Score: " + score);
                progressBar.setValue(score);  // Update progress bar based on score
                newTarget();
            } else {
                System.out.println("miss");
            }
        }

        public void mouseClicked(MouseEvent m) {}
        public void mouseEntered(MouseEvent m) {}
        public void mouseExited(MouseEvent m) {}
        public void mouseReleased(MouseEvent m) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int layers = 5;

        // Draw rectangles to form the target
        for (int i = 0; i < layers; i++) {
            int padding = (int) (i * (targetSize * 0.1)); // Each layer shrinks by 10%
            int size = targetSize - 2 * padding;
            int x = new_xcoord + padding;
            int y = new_ycoord + padding;

            if (i % 2 == 0){
                g2d.setColor(Color.RED);
            }
            else{
                g2d.setColor(Color.WHITE);
            }
            g2d.fillRect(x, y, size, size);
        }
    }

    private void newTarget() {
        // Ensure the target stays within the panel
        if (getWidth() > targetSize && getHeight() > targetSize) {
            new_xcoord = rand.nextInt(getWidth() - targetSize);
            new_ycoord = rand.nextInt(getHeight() - targetSize);
            repaint();  // Repaint to update the target position
        } else {
            System.out.println("Not ready");
        }
    }

    // Method to restart the game
    private void restartGame(){
        score = 0;
        targetSize = 50;  // Reset the target size to default
        progressBar.setValue(0);  // Reset the progress bar
        scoreLabel.setText("Score: " + score);  // Reset the score label
        newTarget();  // Create a new target
    }
}


