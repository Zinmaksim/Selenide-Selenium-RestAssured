package pojo.game.userControllerNew;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
public class ResponseBodyGetUser {
    private int id;
    private String login;
    private String pass;
    private ArrayList<Object> games;

    public ResponseBodyGetUser(){};


    public ResponseBodyGetUser(int id, ArrayList<Object> games, String pass, String login) {
        this.id = id;
        this.games = games;
        this.pass = pass;
        this.login = login;
    }


    @Override
    public String toString() {
        return "ResponseBodyGetUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", games=" + games +
                '}';
    }
}
