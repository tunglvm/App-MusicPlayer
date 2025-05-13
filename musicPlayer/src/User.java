public class User {
    private String name;
    private int age;
    private String UserID;

    public User(String name, int age, String UserID) {
        this.name = name;
        this.age = age;
        this.UserID = UserID;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getUserID() {
        return UserID;
    }


    public void setName(String nameInput){
        name = nameInput;

    }


}