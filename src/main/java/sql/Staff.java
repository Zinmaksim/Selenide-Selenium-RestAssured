package sql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "has_children")
    private Boolean has_children;


    public Staff() {
    }


    public Staff(Integer id, Boolean has_children, Date birthday, String position, String name) {
        this.id = id;
        this.has_children = has_children;
        this.birthday = birthday;
        this.position = position;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", birthday=" + birthday +
                ", has_children=" + has_children +
                '}';
    }
}
