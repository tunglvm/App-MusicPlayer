public class User {
    private String name;
    private int age;
    private String UserID;

    public User(String name, int age, String UserID) {
        this.name = name;
        this.age = age;
        this.UserID = UserID;
    }

    public User(String UserID, String name){
        this.UserID= UserID;
        this.name= name;
    }
    public void setUserInfo(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getUserInfo(){
        return this.name + " : " + this.age;
    }

public void displayUserInfo() {
        System.out.println("User: " + name + " (ID: " + UserID + ")");
        System.out.println("Age: " + age);
    
}


}