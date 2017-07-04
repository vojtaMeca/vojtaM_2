package roi.mecaRest.controller;

import roi.mecaRest.model.Activity;
import roi.mecaRest.model.User;
import roi.mecaRest.repository.UserRepository;
import roi.mecaRest.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Vojtech on 3.7.2017.
 */
@RestController
public class RestAPIController {

    private static final String template = "Name: %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/initDB")
    public void init() {
        // save a couple of books
        Activity activityA = new Activity("Activity A");
        Activity activityB = new Activity("Activity B");
        Activity activityC = new Activity("Activity C");

        userRepository.save(new HashSet<User>(){{
            add(new User("User A", new HashSet<Activity>(){{
                add(activityA);
                add(activityB);
            }}));

            add(new User("User B", new HashSet<Activity>(){{
                add(activityA);
                add(activityC);
            }}));
        }});


        // save a couple of publishers
        User userA = new User("User A");
        User userB = new User("User B");

        activityRepository.save(new HashSet<Activity>() {{
            add(new Activity("Activity A", new HashSet<User>() {{
                add(userA);
                add(userB);
            }}));

            add(new Activity("Activity B", new HashSet<User>() {{
                add(userA);
                add(userB);
            }}));
        }});


    }
    /*
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public User greeting(@RequestParam(value="name", defaultValue="Vojtěch") String name) {
        return new User(
                String.format(template, name),
                "male",
                "urlExample");
    }

    @RequestMapping(method = RequestMethod.GET, value="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String gender
            , @RequestParam String url) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User(name,gender,url);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/allusers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/initDB")
    public void init() {
        // save a couple of books
        Activity activityA = new Activity("Title1","public",3,5,"uri1");
        Activity activityB = new Activity("Title2","public",4,1,"uri2");
        Activity activityC = new Activity("Title3","private",5,3,"uri3");

        User user1 = new User("Vojta","male","UriPicture1");
        user1.setActivities(
                new HashSet<Activity>(){{
                    add(activityA);
                    add(activityB);}}
        );

        User user2 = new User("Maruska","female","UriPicture2");
        user2.setActivities(
                new HashSet<Activity>(){{
                    add(activityA);
                    add(activityC);}}
        );

        userRepository.save(new HashSet<User>(){{
            add(user1);
            add(user2);
        }});

        activityA.setUsers(
                new HashSet<User>(){{
                    add(user1);
                    add(user2);
                }}
        );

        activityB.setUsers(
                new HashSet<User>(){{
                    add(user1);
                }}
        );

        activityC.setUsers(
                new HashSet<User>(){{
                    add(user2);
                }}
        );

        activityRepository.save(
                new HashSet<Activity>(){{
                    add(activityA);
                    add(activityB);
                    add(activityC);
                }}
        );
    }
    */

}

