package vn.duong.itech.service.dto.user;

public class UserProfileDTO {

    private int id;
    private String username;
    private String name;
    private String email;
    private String phone;

    public UserProfileDTO() {}

    public UserProfileDTO(int id, String phone, String email, String name) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
    }

    public UserProfileDTO(int id, String phone, String email, String name, String username) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
