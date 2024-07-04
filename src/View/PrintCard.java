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

        ImageIcon photoIcon = new ImageIcon(card.getFotoMember().getAbsolutePath());
        JLabel photoLabel = new JLabel(photoIcon);
        photoLabel.setBounds(10, 10, 300, 400);
        frame.add(photoLabel);

        JLabel nameLabel = createLabel("NAME", 350, 10, 100, 20);
        frame.add(nameLabel);

        JLabel birthDateLabel = createLabel("BIRTHDATE", 350, 60, 100, 20);
        frame.add(birthDateLabel);

        JLabel validLabel = createLabel("VALID UNTIL", 350, 110, 100, 20);
        frame.add(validLabel);

        JLabel nomorMemberLabel = createLabel("NO", 350, 160, 100, 20);
        frame.add(nomorMemberLabel);

        JLabel noteTextLabel = createLabel("If you happen to find this card, please return it to this address:", 20, 200, 500, 20);
        frame.add(noteTextLabel);

        ImageIcon addressIcon = new ImageIcon("..\\asset\\Picture6\\Picture6-0000.jpg");
        JLabel addressLabel = new JLabel(addressIcon);
        addressLabel.setBounds(20, 240, 315, 175);
        frame.add(addressLabel);   
        
        ImageIcon barcodeIcon = new ImageIcon("..\\asset\\Picture1\\Picture1-0000.jpg");
        JLabel barcodeLabel = new JLabel(barcodeIcon);
        barcodeLabel.setBounds(20, 240, 300, 400);
        frame.add(barcodeLabel);  

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

    private static JLabel createLabel(String text, int x, int y, int width, int height) {

        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;

    }

    private static JButton createButton(String text, int x, int y, int width, int height) {

        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;

    }

}
