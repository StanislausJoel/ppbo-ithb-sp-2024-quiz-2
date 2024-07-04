package View;

import java.awt.*;
import javax.swing.*;

import Model.Card;

public class PrintCard {

    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 600;
    
    public PrintCard(Card card) {

        showPrintCard(card);

    }

    private static void showPrintCard(Card card) {

        JFrame frame = createFrame();
        frame.setLayout(null);

        

    }

    private static JFrame createFrame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        JFrame frame = new JFrame("Garden Ice");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;

    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {

        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;

    }

    private JTextField createTextField(int x, int y, int width, int height) {

        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        return textField;

    }

    private JButton createButton(String text, int x, int y, int width, int height) {

        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;

    }

}
