package Todo.project.Model;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="description")
    private String description;

    @Column(name = "person_id")
    private Integer person_id;

    @Column(name = "completed")
    private boolean completed = false;

    public String getDescription() {
        return description;
    }

    public Integer getPersonID() {
        return person_id;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public void setPersonID(Integer p) {
        this.person_id = p;
    }

    public void setCompleted(Boolean b){
        this.completed = b;
    }//setCompleted

    @Override
    public String toString() {
        return description;
    }
}//Todo
