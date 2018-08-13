package de.gymondo.samples.restapi.transformation;

import com.google.common.collect.ImmutableList;
import de.gymondo.samples.commons.entity.User;
import de.gymondo.samples.restapi.dto.SubscriptionV1Dto;
import de.gymondo.samples.restapi.dto.UserV1Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Transformation utility service.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@Component
public class UserTransformationsV1 {

    private SubscriptionTransformationV1 subscriptionTransformationV1;

    @Autowired
    public UserTransformationsV1(final SubscriptionTransformationV1 subscriptionTransformationV1) {
        this.subscriptionTransformationV1 = subscriptionTransformationV1;
    }

    public List<UserV1Dto> user2Dto(List<User> users) {
        return users
                .stream()
                .map(x ->
                {
                    List<SubscriptionV1Dto> subscriptionV1Dtos = Optional.ofNullable(
                            subscriptionTransformationV1.mapSubscriptionToDto(x.getSubscriptions())).orElse(ImmutableList.of()
                    );

                    return UserV1Dto.builder()
                            .withAge(x.getAge())
                            .withId(x.getId())
                            .withName(x.getName())
                            .withGender(x.getGender())
                            .withSubscriptions(subscriptionV1Dtos)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public UserV1Dto user2Dto(User user) {
        if (user == null) {
            return null;
        }

        return user2Dto(ImmutableList.of(user)).get(0);
    }

}
