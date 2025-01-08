package vn.edu.hcmuaf.fit.project.DAO.model;

public class User {
    private int id;
    private String username;
    private String password;
    private int isAdmin;
    private int isClient;

    public User() {}

    public User(int id, String username, String password, int isAdmin, int isClient) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isClient = isClient;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsClient() {
        return isClient;
    }

    public void setIsClient(int isClient) {
        this.isClient = isClient;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isClient=" + isClient +
                '}';
    }
}
