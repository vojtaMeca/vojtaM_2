package roi.mecaRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloJpaApplication /*implements CommandLineRunner*/ {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    //@Autowired
    //private UserRepository bookRepository;

    //@Autowired
    //private ActivityRepository publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }

    /*
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of books
        Activity publisherA = new Activity("Activity A");
        Activity publisherB = new Activity("Activity B");
        Activity publisherC = new Activity("Activity C");

        bookRepository.save(new HashSet<User>(){{
            add(new User("User A", new HashSet<Activity>(){{
                add(publisherA);
                add(publisherB);
            }}));

            add(new User("User B", new HashSet<Activity>(){{
                add(publisherA);
                add(publisherC);
            }}));
        }});

        // fetch all books
        for(User book : bookRepository.findAll()) {
            logger.info(book.toString());
        }

        // save a couple of publishers
        User bookA = new User("User A");
        User bookB = new User("User B");

        publisherRepository.save(new HashSet<Activity>() {{
            add(new Activity("Activity A", new HashSet<User>() {{
                add(bookA);
                add(bookB);
            }}));

            add(new Activity("Activity B", new HashSet<User>() {{
                add(bookA);
                add(bookB);
            }}));
        }});

        // fetch all publishers
        for(Activity publisher : publisherRepository.findAll()) {
            logger.info(publisher.toString());
        }
    }
    */
}
