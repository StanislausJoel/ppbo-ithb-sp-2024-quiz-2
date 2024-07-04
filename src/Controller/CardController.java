package Controller;

public class CardController {
    
    public static String getMasaBerlaku(String tanggal) {

        String newTanggal = "";

        String[] arrTanggal = tanggal.split(" ");

        arrTanggal[2] = String.valueOf(Integer.parseInt(arrTanggal[2]) + 2);

        for (int i = 0; i < arrTanggal.length - 1; i++) {
            newTanggal += arrTanggal[i] + " ";
        }
        newTanggal += arrTanggal[2];
        
        return newTanggal;

    }

}
