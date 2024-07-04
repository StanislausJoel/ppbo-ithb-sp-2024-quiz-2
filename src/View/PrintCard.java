package View;

import java.awt.*;
import java.io.File;

import javax.swing.*;

import Model.Card;

public class PrintCard {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    
    public PrintCard(Card card) {

        showPrintCard(card);

    }

    private static void showPrintCard(Card card) {

        JFrame frame = createFrame();
        frame.setLayout(null);

        ImageIcon photoIcon = new ImageIcon(card.getFotoMember().getAbsolutePath());
        JLabel photoLabel = new JLabel(photoIcon);
        photoLabel.setBounds(50, 10, 150, 250);
        frame.add(photoLabel);

        JLabel nameLabel = createLabel("NAME", 250, 10, 100, 20);
        frame.add(nameLabel);

        JLabel nameData = createLabel(" : " + card.getNama(), 380, 10, 100, 20);
        frame.add(nameData);

        JLabel birthDateLabel = createLabel("BIRTHDATE", 250, 60, 100, 20);
        frame.add(birthDateLabel);

        JLabel birthDateData = createLabel(" : " + card.getTanggalLahir(), 380, 60, 100, 20);
        frame.add(birthDateData);

        JLabel validLabel = createLabel("VALID UNTIL", 250, 110, 100, 20);
        frame.add(validLabel);

        JLabel validData = createLabel(" : " + card.getMasaBerlaku(), 380, 110, 100, 20);
        frame.add(validData);

        JLabel nomorMemberLabel = createLabel("NO", 250, 160, 100, 20);
        frame.add(nomorMemberLabel);

        int memberNumber = Integer.parseInt(card.getNomorMember());
        String nomorMemberFormatter = String.format("G%09d", memberNumber);

        JLabel nomorMemberData = createLabel(" : " + nomorMemberFormatter, 380, 160, 100, 20);
        frame.add(nomorMemberData);

        JLabel noteTextLabel = createLabel("If you happen to find this card, please return it to this address:", 50, 280, 500, 20);
        frame.add(noteTextLabel);

        String currentWorkingDir = System.getProperty("user.dir");

        String addressPath = currentWorkingDir + File.separator + "asset" + File.separator + "Picture6" + File.separator + "Picture6-0000.jpg";
        ImageIcon addressIcon = new ImageIcon(addressPath);
        JLabel addressLabel = new JLabel(addressIcon);
        addressLabel.setBounds(50, 320, 315, 175);
        frame.add(addressLabel);

        String barcodePath = currentWorkingDir + File.separator + "asset" + File.separator + "Picture1" + File.separator + "Picture1-0000.jpg";
        ImageIcon barcodeIcon = new ImageIcon(barcodePath);
        JLabel barcodeLabel = new JLabel(barcodeIcon);
        barcodeLabel.setBounds(400, 240, 300, 400);
        frame.add(barcodeLabel);

        JButton backButton = createButton("Back to Homepage", 550, 10, 200, 30);
        backButton.addActionListener(e -> {
            frame.dispose();
            new Homepage();
        });
        frame.add(backButton);
 

        frame.setVisible(true);

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
