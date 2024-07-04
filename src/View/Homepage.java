package View;

import java.awt.*;
import javax.swing.*;

public class Homepage {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    
    public Homepage() {

        showMainMenu();

    }

    private void showMainMenu() {

        JFrame frame = createFrame();
        frame.setLayout(null);

        JLabel welcomeLabel = createLabel("Welcome, employee", FRAME_WIDTH / 2 - 65, FRAME_HEIGHT / 2 - 70, 200, 50);
        frame.add(welcomeLabel);

        JButton registerButton = createButton("Register", 70, FRAME_HEIGHT - 80, 100, 30);
        registerButton.addActionListener(e -> {
            frame.dispose();
            new RegisterPage();
        });
        frame.add(registerButton);

        JButton viewMemberButton = createButton("View Member List", 180, FRAME_HEIGHT - 80, 150, 30);
        viewMemberButton.addActionListener(e -> {
            frame.dispose();
            new SearchPage();
        });
        frame.add(viewMemberButton);

        frame.setVisible(true);

    }

    private JFrame createFrame() {

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

    private JButton createButton(String text, int x, int y, int width, int height) {

        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;

    }

}
