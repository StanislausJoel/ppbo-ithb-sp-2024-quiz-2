package View;

import java.awt.*;
import java.io.File;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controller.CardController;
import Model.Card;

public class RegisterPage {
    
    private static final int FRAME_WIDTH = 480;
    private static final int FRAME_HEIGHT = 600;
    private static File filePhoto;

    public RegisterPage() {

        showRegisterPage();

    }

    private void showRegisterPage() {


        JFrame frame = createFrame();
        frame.setLayout(null);

        JLabel formTitleLabel = createLabel("Form Registrasi Member GardenIce", 80, 5, 400, 25);
        formTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        frame.add(formTitleLabel);

        JLabel namaLabel = createLabel("Nama Lengkap", 10, 100, 150, 20);
        namaLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.add(namaLabel);

        JTextField namaField = createTextField(180, 100, 240, 25);
        frame.add(namaField);

        JLabel jenisKelaminLabel = createLabel("Jenis Kelamin", 10, 160, 150, 20);
        jenisKelaminLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.add(jenisKelaminLabel);

        JRadioButton priaRadio = new JRadioButton("Pria");
        JRadioButton wanitaRadio = new JRadioButton("Wanita");

        priaRadio.setBounds(180, 145, 50, 50);
        wanitaRadio.setBounds(270, 145, 100, 50);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(priaRadio);
        genderGroup.add(wanitaRadio);

        frame.add(priaRadio);
        frame.add(wanitaRadio);

        JLabel tanggalLahirLabel = createLabel("Tanggal Lahir", 10, 220, 150, 20);
        tanggalLahirLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.add(tanggalLahirLabel);

        UtilDateModel tanggalLahirModel = new UtilDateModel();
        Properties tanggalLahirProperties = new Properties();
        JDatePanelImpl tanggalLahirDatePanel = new JDatePanelImpl(tanggalLahirModel, tanggalLahirProperties);
        JDatePickerImpl tanggalLahirPicker = new JDatePickerImpl(tanggalLahirDatePanel, new DateLabelFormatter());

        tanggalLahirPicker.setBounds(180, 220, 240, 30);
        frame.add(tanggalLahirPicker);

        JLabel fotoMemberLabel = createLabel("Foto Member", 10, 280, 150, 20);
        fotoMemberLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.add(fotoMemberLabel);

        JButton photoButton = new JButton("Upload Photo");
        photoButton.setBounds(180, 280, 240, 30);
        frame.add(photoButton);

        photoButton.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                filePhoto = fileChooser.getSelectedFile();
                
            }

        });

        JLabel tanggalPembuatanLabel = createLabel("Tanggal Pembuatan", 10, 340, 150, 20);
        tanggalPembuatanLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frame.add(tanggalPembuatanLabel);

        UtilDateModel tanggalPembuatanModel = new UtilDateModel();
        Properties tanggalPembuatanProperties = new Properties();
        JDatePanelImpl tanggalPembuatanDatePanel = new JDatePanelImpl(tanggalPembuatanModel, tanggalPembuatanProperties);
        JDatePickerImpl tanggalPembuatanPicker = new JDatePickerImpl(tanggalPembuatanDatePanel, new DateLabelFormatter());

        tanggalPembuatanPicker.setBounds(180, 340, 240, 30);
        frame.add(tanggalPembuatanPicker);

        JButton submitButton = createButton("Submit", 120, FRAME_HEIGHT - 80, 100, 30);
        submitButton.addActionListener(e -> {

            if (namaField.getText().trim().isEmpty() || genderGroup.getSelection() == null || tanggalLahirPicker.getModel().getValue() == null || filePhoto == null || tanggalPembuatanPicker.getModel().getValue() == null) {
                
                JOptionPane.showMessageDialog(null, "Semua field belum terisi!", "Error", JOptionPane.ERROR_MESSAGE);

            }
            else {

                String masaBerlaku = CardController.getMasaBerlaku(tanggalPembuatanPicker.getModel().getValue().toString());

                Card myCard = new Card(namaField.getText(), tanggalLahirPicker.getModel().getValue().toString(), tanggalPembuatanPicker.getModel().getValue().toString(), filePhoto, genderGroup.getSelection().toString(), masaBerlaku);

                frame.dispose();

                new PrintCard(myCard);

            }

        }); 
        frame.add(submitButton);

        JButton exitButton = createButton("Exit", 260, FRAME_HEIGHT - 80, 100, 30);
        exitButton.addActionListener(e -> {
            frame.dispose();
            new Homepage();
        });
        frame.add(exitButton);

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
