package musicPlayer;

public class User {
    private String userID;
    private String name;

    // Constructor
    public User(String userID, String name) {
        try {
            if (userID == null || userID.isEmpty()) {
                throw new IllegalArgumentException("UserID không thể là null hoặc rỗng.");
            }
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name không thể là null hoặc rỗng.");
            }

            this.userID = userID;
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong constructor User: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong constructor User: " + e.getMessage());
        }
    }

    // Getter for userID
    public String getUserID() {
        return userID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String newName) {
        try {
            if (newName == null || newName.isEmpty()) {
                throw new IllegalArgumentException("Tên không thể là null hoặc rỗng.");
            }
            this.name = newName;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong setName: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong setName: " + e.getMessage());
        }
    }

    // Optional: Display user information (optional, just for convenience)
    public void displayUserInfo() {
        System.out.println("UserID: " + userID + ", Name: " + name);
    }
}
