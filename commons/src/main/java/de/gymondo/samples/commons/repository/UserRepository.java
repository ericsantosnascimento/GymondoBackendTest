package de.gymondo.samples.commons.repository;

import com.google.common.collect.ImmutableMap;
import de.gymondo.samples.commons.entity.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simplified user repository.
 * <p>
 * Think of this as a database repository, so all
 * the calls go to the DB.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
public class UserRepository {

    /**
     * Gets the user given the client.
     *
     * @param id The user id.
     * @return The user.
     */
    public User findOne(Integer id) {
        return USERS.get(id);
    }

    /**
     * Finds all the users.
     *
     * @return A list of users.
     */
    public List<User> findAll() {
        return USERS.values().stream().collect(Collectors.toList());
    }

    // DATA.
    private static final Map<Integer, User> USERS = ImmutableMap.<Integer, User>builder()
            .put(1, User.builder().withAge(16).withName("John").withId(1).withGender("male").build())
            .put(2, User.builder().withAge(24).withName("Maria").withId(2).withGender("female").build())
            .put(3, User.builder().withAge(32).withName("Eva").withId(3).withGender("female").build())
            .put(4, User.builder().withAge(40).withName("Carl").withId(4).withGender("male").build())
            .put(5, User.builder().withAge(48).withName("Lewis").withId(5).withGender("male").build())
            .build();
}
