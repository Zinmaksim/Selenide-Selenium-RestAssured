package reqres.pojo.userData;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public Data() {
    }

    public Data(int id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
