import javax.swing.*;

public class Project2Runner {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Project2());
        frame.pack();
        frame.setVisible(true);
    }
}
