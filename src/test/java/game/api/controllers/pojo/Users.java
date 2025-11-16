package game.api.controllers.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
    private String user;

    public Users(String user) {
        this.user = user;
    }


    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                '}';
    }
}
