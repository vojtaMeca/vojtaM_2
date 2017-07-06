package roi.mecaRest.controller;

import roi.mecaRest.model.Activity;
import roi.mecaRest.model.User;
import roi.mecaRest.repository.UserRepository;
import roi.mecaRest.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Vojtech on 3.7.2017.
 */
@RestController
public class RestAPIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/initDB")
    public String init() {
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
        return "200 ok: initialize of database was run OK!";
    }

    @RequestMapping(method = RequestMethod.GET, value="/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{user_google_id}")
    public String deleteUserAndHisActivities(@PathVariable int user_google_id){
        //todo zmen pak, ze se ma vyhledavat String google_id
        Optional<User> deletedUser = userRepository.findByIdEquals(user_google_id);
        if (deletedUser.isPresent()) {
            Set<User> currentUser = new HashSet<User>(){{
                add(deletedUser.get());
            }};
            Collection<Activity> activitiesOnDeleted = activityRepository.findActivitiesByUsers(currentUser);
            for (Activity activity:
                 activitiesOnDeleted) {
                //pridej aktivitu, do mnoziny vsech aktivit, podle kterzch se pak bude vyhledavat, kolik ji sdili uzivatelu
                Set<Activity> currentActivity = new HashSet<Activity>(){{
                    add(activity);
                }};

                Collection<User> usersOfActivity = userRepository.findByActivities(currentActivity);
                if(usersOfActivity.size() == 1){
                    //smaz aktivitu, jelikoz je jedina prirazena k danemu uzivateli
                    activityRepository.delete(activity);
                }
            }
            userRepository.delete(deletedUser.get());

        }

        return "200 OK: User with user ID: " + user_google_id + " is successfully deleted!";
    }


}

