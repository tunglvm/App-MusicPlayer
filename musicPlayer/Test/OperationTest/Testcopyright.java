package musicPlayer.Test.OperationTest;

import Operation.Copyright;

public class Testcopyright {
    public static void main(String[] args) {
        Copyright copyright1 = new Copyright("IU Entertainment", "2024", "All rights reserved.");
        Copyright copyright2 = new Copyright("Universal Music", "2023", "For album use only.");

        System.out.println("Thông tin bản quyền 1:");
        System.out.println(copyright1);

        System.out.println("\nThông tin bản quyền 2:");
        System.out.println(copyright2);

        // Thay đổi thông tin bản quyền
        copyright1.setOwner("Loen Entertainment");
        copyright1.setYear("2025");
        copyright1.setDescription("Bản quyền thuộc về Loen Entertainment.");

        System.out.println("\nSau khi cập nhật:");
        System.out.println(copyright1);
    }
}
