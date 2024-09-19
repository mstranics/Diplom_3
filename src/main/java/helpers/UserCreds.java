package helpers;

import lombok.Data;

@Data

public class UserCreds {
    public String email;
    public String password;

    public UserCreds(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public static UserCreds from(User user) {
        return new UserCreds(user.getEmail(), user.getPassword());
    }
}
