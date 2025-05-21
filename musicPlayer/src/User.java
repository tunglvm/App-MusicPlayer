public class User {
    private String name;
    private int age;
    private String userID;
    private String email;
    private String phoneNumber;
    private String address;
    private String createdDate;

    public User(String name, int age, String userID, String email, String phoneNumber, String address,
            String createdDate) {
        this.name = name;
        this.age = age;
        this.userID = userID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdDate = createdDate;
    }

    public void setUserInfo(String name, int age, String email, String phoneNumber, String address,
            String createdDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdDate = createdDate;
    }

    public String getUserInfo() {
        return this.name + " : " + this.age + " : " + this.email + " : " + this.phoneNumber + " : " + this.address
                + " : " + this.createdDate;
    }

    public void displayUserInfo() {
        System.out.println("User: " + name + " (ID: " + userID + ")");
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Created Date: " + createdDate);
    }
}