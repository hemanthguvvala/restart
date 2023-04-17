package client.models;

public class UserModel {
    private String userName;
    private int age;

    private int userCount;

    public UserModel() {
    }

    public UserModel(String userName, int age) {
        this.userName = userName;
        this.age = age;
        this.userCount++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getUserInfo() {
        System.out.println(userCount + ". " + userName + " and age is " + age);
    }


}
