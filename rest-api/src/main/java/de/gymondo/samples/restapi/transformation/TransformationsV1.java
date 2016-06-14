package de.gymondo.samples.restapi.transformation;

import com.google.common.collect.ImmutableList;
import de.gymondo.samples.commons.entity.User;
import de.gymondo.samples.commons.repository.SubscriptionRepository;
import de.gymondo.samples.restapi.dto.UserV1Dto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Transformation utility service.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
public class TransformationsV1 {

    private final SubscriptionRepository subscriptionRepository = new SubscriptionRepository();

    public List<UserV1Dto> user2Dto(List<User> users) {
        /*
         * TODO: Enrich the user information with all the subscriptions that belong to him/her.
         */

        return users.stream().map(x ->
                UserV1Dto.builder()
                        .withAge(x.getAge())
                        .withId(x.getId())
                        .withName(x.getName())
                        .withGender(x.getGender())
                        .build())
                .collect(Collectors.toList());
    }

    public UserV1Dto user2Dto(User user) {
        if (user == null) {
            return null;
        }

        return user2Dto(ImmutableList.of(user)).get(0);
    }

    /*
     * TODO: Create the transformation methods for the subscriptions. Add the expiration date as well.
     */
}
