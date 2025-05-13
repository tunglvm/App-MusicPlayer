public class User {
    private String name;
    private int age;
    public String userId;

    public User(String name, int age, String userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}