package View;

import javax.swing.JOptionPane;

import Controller.DBController;
import Model.Card;

public class SearchPage {
    
    public SearchPage() {

        showSearchPage();

    }

    private static void showSearchPage() {

        String inputNomor = JOptionPane.showInputDialog(null, "Masukkan nomor anggota");

        if (inputNomor != null) {
            
            Card card = DBController.getCard(Integer.parseInt(inputNomor));
    
            if (card != null) {
                
                new PrintCard(card);
    
            }
            else {
    
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
    
            }

        }
        else {

            new Homepage();

        }


    }

}   
