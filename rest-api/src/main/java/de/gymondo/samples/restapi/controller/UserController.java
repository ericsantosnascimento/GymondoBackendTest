package de.gymondo.samples.restapi.controller;

import de.gymondo.samples.commons.entity.Subscription;
import de.gymondo.samples.commons.entity.User;
import de.gymondo.samples.commons.repository.SubscriptionRepository;
import de.gymondo.samples.commons.repository.UserRepository;
import de.gymondo.samples.restapi.dto.SubscriptionV1Dto;
import de.gymondo.samples.restapi.dto.UserV1Dto;
import de.gymondo.samples.restapi.transformation.SubscriptionTransformationV1;
import de.gymondo.samples.restapi.transformation.UserTransformationsV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@RestController
@RequestMapping("/api/v1/users")
@ResponseBody
public class UserController {

    // NOTE: In a real approach this would be calling the service layer and not the
    // persistence one directly.
    private UserRepository userRepository;
    private SubscriptionRepository subscriptionRepository;
    private UserTransformationsV1 transformations;
    private SubscriptionTransformationV1 subscriptionTransformationV1;

    @Autowired
    public UserController(final UserTransformationsV1 transformations,
                          final UserRepository userRepository,
                          final SubscriptionRepository subscriptionRepository,
                          final SubscriptionTransformationV1 subscriptionTransformationV1) {
        this.transformations = transformations;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionTransformationV1 = subscriptionTransformationV1;
    }

    /**
     * Lists all the users.
     *
     * @return The list of users.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserV1Dto> list() {
        return transformations.user2Dto(userRepository.findAll());
    }

    /**
     * Get user by id.
     *
     * @return The list of users.
     */
    @RequestMapping(value = "{user_id}", method = RequestMethod.GET)
    public UserV1Dto get(@PathVariable(value = "user_id") final Integer userId) {
        final User user = userRepository.findOne(userId);
        return transformations.user2Dto(user);
    }

    /**
     * Get user subscriptions.
     *
     * @return The list of subscriptions for given user.
     */
    @RequestMapping(value = "{user_id}/subscriptions", method = RequestMethod.GET)
    public List<SubscriptionV1Dto> getSubscriptions(@PathVariable(value = "user_id") final Integer userId) {
        final List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
        return subscriptionTransformationV1.mapSubscriptionToDto(subscriptions);
    }
}
