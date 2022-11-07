package Todo.project.Model;

import javax.persistence.*;
import java.util.List;

// to be used for bonus 2
//points to table named person
@Entity
@Table(name="person")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personID", referencedColumnName = "id")
    private List<Todo> todos;

    public String getName(){
        return name;
    }

    public List<Todo> getTodoList(){
        return todos;
    }

    public void setName(String n){
        this.name = n;
    }

    @Override
    public String toString(){
        return name + " with User ID: " + id;
    }//toString

}//User
