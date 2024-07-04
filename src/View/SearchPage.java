package View;

import javax.swing.JOptionPane;

import Controller.DBController;
import Model.Card;

public class SearchPage {
    
    public SearchPage() {

        showSearchPage();

    }

    private static void showSearchPage() {

        int inputNomor = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan nomor anggota"));

        Card card = DBController.getCard(inputNomor);

        if (card != null) {
            
            new PrintCard(card);

        }
        else {

            JOptionPane.showMessageDialog(null, "Data tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}   
