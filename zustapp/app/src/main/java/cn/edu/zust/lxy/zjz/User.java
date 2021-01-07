package cn.edu.zust.lxy.zjz;

public class User {
    private String username, password, type;
    public User(String name, String password, String type) {
        this.username=name;
        this.password=password;
        this.type=type;
    }

    public String getName(){return username;}
    public String getPassword() {return password;}
    public String getType() {return type;}
}
