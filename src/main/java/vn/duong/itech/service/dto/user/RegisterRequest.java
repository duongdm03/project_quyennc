package vn.duong.itech.service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotNull
    @Size(min = 1, max = 50, message = "Ten dang nhap pahi tu 1 den 50 ki tu")
    @Pattern(
        regexp = "^(?!.*\\s{2,})(?!^\\s)(?!.*\\s$)[a-zA-Z0-9\\s]*$",
        message = "Tên đăng nhập không được chứa khoảng trắng ở đầu và cuối và không được chứa khoảng trắng liên tiếp"
    )
    private String username;

    @NotNull
    @Size(min = 1, max = 50, message = "Ten dang nhap phai tu 1 den 50 ki tu")
    private String fullName;

    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,30}$",
        message = "Mật khẩu phải có ít nhất một ký tự in thường, một ký tự in hoa, một số, một ký tự đặc biệt và không có dấu cách"
    )
    private String password;

    private String confirmPassword;

    @NotNull
    @Email(message = "Dinh dang mail khong hop le")
    private String email;

    @NotNull
    private String phoneNumber;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
