package controller;

import dao.AccountDAO;
import dto.Account;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRegex {

    private String emailExistedError;
    private String emailRegexError;
    private String phoneRegexError;
    private String passwordError;
    private String confirmError;
    private String fullnameError;

    RegisterRegex() {
        
    }

    public String checkEmailExisted(String email) {
        AccountDAO dao = new AccountDAO();
        Account account = null;
        account = dao.getAccount(email);

        if (account != null) {
            emailExistedError = "This account with email: " + email + " has been existed.";
        } else {
            emailExistedError = null;
        }
        return emailExistedError;
    }

    public String checkPhoneRegex(String phoneNum) {
        // Regular expression pattern for phone number validation
        String phoneRegex = "^[0-9]{9}(?:[0-9]{2})?$";

        // Compile the pattern and check if phone number string matches it
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.matches()) {
            phoneRegexError = null;
        } else {
            phoneRegexError = "Invalid Phone Number: The phone number must be either 9 or 11 digits long.";
        }
        return phoneRegexError;
    }

    public String checkEmailRegex(String email) {
        // Regular expression pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the pattern and check if email string matches it
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            emailRegexError = null;
        } else {
            emailRegexError = "Invalid Email: The email must be in a valid format (e.g. example@example.com).";
        }
        return emailRegexError;
    }

    // kiểm tra xem tài khoản tồn tại hay chưa
    // thay đổi giá trị của emailRegexError của object - setter
    public String checkPasswordLength(String password) {
        if (password.length() < 3) {
            passwordError = "Password is too short.";
        } else if (password.length() > 20) {
            passwordError = "Password is too long.";
        } else {
            passwordError = null;
        }
        return passwordError;
    }

    public String checkConfirm(String password, String confirm) {
        if (!password.equals(confirm)) {
            confirmError = "Password and confirm are not match.";
        } else {
            confirmError = null;
        }
        return confirmError;
    }

    public String checkFullname(String fullname) {
        if (fullname.length() < 4) {
            fullnameError = "Fullname is too short.";
        } else if (fullname.length() > 30) {
            fullnameError = "Fullname is too long.";
        } else {
            fullnameError = null;
        }
        return fullnameError;
    }

    public RegisterRegex(String emailExistedError, String emailRegexError, String phoneRegexError, String passwordError, String confirmError, String fullnameError) {
        this.emailExistedError = emailExistedError;
        this.emailRegexError = emailRegexError;
        this.phoneRegexError = phoneRegexError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.fullnameError = fullnameError;
    }

    public String getEmailExistedError() {
        return emailExistedError;
    }

    public void setEmailExistedError(String emailExistedError) {
        this.emailExistedError = emailExistedError;
    }

    public String getEmailRegexError() {
        return emailRegexError;
    }

    public void setEmailRegexError(String emailRegexError) {
        this.emailRegexError = emailRegexError;
    }

    public String getPhoneRegexError() {
        return phoneRegexError;
    }

    public void setPhoneRegexError(String phoneRegexError) {
        this.phoneRegexError = phoneRegexError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    

}
