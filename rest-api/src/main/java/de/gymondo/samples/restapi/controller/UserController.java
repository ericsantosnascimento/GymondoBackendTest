package de.gymondo.samples.restapi.controller;

import de.gymondo.samples.commons.repository.SubscriptionRepository;
import de.gymondo.samples.commons.repository.UserRepository;
import de.gymondo.samples.restapi.dto.UserV1Dto;
import de.gymondo.samples.restapi.transformation.TransformationsV1;
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

    private TransformationsV1 transformations = new TransformationsV1();

    // NOTE: In a real approach this would be calling the service layer and not the
    // persistence one directly.
    private UserRepository userRepository = new UserRepository();
    private SubscriptionRepository subscriptionRepository = new SubscriptionRepository();

    /**
     * Lists all the users.
     *
     * @return The list of users.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserV1Dto> list() {
        return transformations.user2Dto(userRepository.findAll());
    }

    /*
     * TODO: Create an endpoint to get a single user by id.
     *
     * You can ignore the fact the user doesn't exist.
     */





    /*
     * TODO: Create an endpoint to get all the subscriptions of a user given its id.
     *
     * You can ignore the fact the user doesn't exist.
     */
}
