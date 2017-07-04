package roi.mecaRest.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Activity {
    private int id;
    private String name;
    private Set<User> users;

    public Activity(){

    }

    public Activity(String name){
        this.name = name;
    }

    public Activity(String name, Set<User> users){
        this.name = name;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "activities")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
