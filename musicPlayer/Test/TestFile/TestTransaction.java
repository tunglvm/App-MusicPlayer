package musicPlayer.Test.TestFile;

import musicPlayer.Transaction;

public class TestTransaction {
    public static void main(String[] args) {
        // Tạo một giao dịch mẫu
        Transaction t = new Transaction(
            "T001", "U001", "S001", "A001", "buy", "2024-06-07"
        );

        // In thông tin giao dịch
        System.out.println("Transaction ID: " + t.getTransactionID());
        System.out.println("User ID: " + t.getUserID());
        System.out.println("Song ID: " + t.getSongID());
        System.out.println("Artist ID: " + t.getArtistID());
        System.out.println("Type: " + t.getTransactionType());
        System.out.println("Date: " + t.getTransactionDate());

        // Thử sửa đổi thông tin
        t.setTransactionType("rent");
        t.setTransactionDate("2024-06-08");
        System.out.println("Sau khi sửa:");
        System.out.println("Type: " + t.getTransactionType());
        System.out.println("Date: " + t.getTransactionDate());
    }
}
