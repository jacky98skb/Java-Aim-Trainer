import javax.swing.*;

public class Project2Runner {
    
    /*
     * Name: <Jacky Ling>
     * Student ID: <501326887>
     * 
     ******** Project Description ********
     * 
     * The program is an aiming simulator where you attempt to click targets on the screen to add to your score.
     * The program gives the option to choose your difficulty, and the difficulty changes through the sizes of the targets.
     * You also have the ability to exit or restart the game when you're finished and to keep progress, there's a progress bar that shows
     * the percentage of the amount of targets you need to hit to finish the game (30 hits).
     ******** Swing Requirement ********
     * 
     * The swing requirements are satisfied through the use of the score label, difficulty buttons,
     * and the progress bar. The components are located in the Project2.java file.
     * Lines 25 to 27 is the score label. Lines 42 to 50 are the difficulty buttons.
     * Lines 54 to 58 are the progress bar.
     * 
     ******** 2D Graphics Requirement ********
     *
     * The JPanel is used by extending the Project2 class in the file Project2.java which is on line 5.
     * The drawing on the JPanel is located on lines 128 to 146 where it uses paintComponent to draw the actual targets.
     * The JPanel is added to the JFrame inside the constructor of Project2 on line 72.
     * 
     ******** Event Listener Requirement ********
     *
     * The ActionListener is implemented through ButtonListener1 and ButtonListener2
     * starting on lines 79 to 83 and 85 to 97. ButtonListener1 handles the restarting of the game while
     * ButtonListener2 handles the difficulty buttons. The MouseListener is implemented
     * in the MouseClicker class on lines 105 to 126. The listener detects mouse clicks to check
     * if the mouse has clicked on the coordinates of the target and updates the score/position when the target
     * is pressed.
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Project2());
        frame.pack();
        frame.setVisible(true);
    }
}
