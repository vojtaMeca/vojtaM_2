package roi.mecaRest.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    private int id;
    private String name;
    private String access_token;
    private String gender;
    private String profile_picture_URL;

    private Set<Activity> activities;

    public User() {

    }

    public User(String name, String gender, String profile_picture_URL) {
        this.name = name;
        this.gender = gender;
        this.profile_picture_URL = profile_picture_URL;
    }

    public User(String name, String access_token){
        this.name = name;
        this.access_token = access_token;
    }

    public User(String name, Set<Activity> activities){
        this.name = name;
        this.activities = activities;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_activity", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"))
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }



    @Override
    public String toString() {
        String result = String.format(
                "User [id=%d, name='%s']%n",
                id, name);
        if (activities != null) {
            for(Activity activity : activities) {
                result += String.format(
                        "Activity[id=%d, name='%s']%n",
                        activity.getId(), activity.getTitle());
            }
        }

        return result;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile_picture_URL() {
        return profile_picture_URL;
    }

    public void setProfile_picture_URL(String profile_picture_URL) {
        this.profile_picture_URL = profile_picture_URL;
    }
}
