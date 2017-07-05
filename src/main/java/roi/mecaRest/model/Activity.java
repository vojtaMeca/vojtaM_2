package roi.mecaRest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Activity {
    private int id;
    private String title;
    private String kind;
    private Integer number_of_replies;
    private Integer number_of_pluseners;
    private String url_on_googleplus;

    @JsonIgnore
    private Set<User> users;

    public Activity(){

    }

    public Activity(String title, String kind, Integer number_of_replies, Integer number_of_pluseners, String url_on_googleplus){
        this.title = title;
        this.kind = kind;
        this.number_of_replies = number_of_replies;
        this.number_of_pluseners = number_of_pluseners;
        this.url_on_googleplus = url_on_googleplus;
    }

    public Activity(String title, Set<User> users){
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name = "user_activity", joinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getNumber_of_replies() {
        return number_of_replies;
    }

    public void setNumber_of_replies(Integer number_of_replies) {
        this.number_of_replies = number_of_replies;
    }

    public Integer getNumber_of_pluseners() {
        return number_of_pluseners;
    }

    public void setNumber_of_pluseners(Integer number_of_pluseners) {
        this.number_of_pluseners = number_of_pluseners;
    }

    public String getUrl_on_googleplus() {
        return url_on_googleplus;
    }

    public void setUrl_on_googleplus(String url_on_googleplus) {
        this.url_on_googleplus = url_on_googleplus;
    }
}
