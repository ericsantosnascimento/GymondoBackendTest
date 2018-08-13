package de.gymondo.samples.restapi.transformation;

import com.google.common.collect.ImmutableList;
import de.gymondo.samples.commons.entity.Subscription;
import de.gymondo.samples.restapi.dto.SubscriptionV1Dto;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubscriptionTransformationV1 {

    public List<SubscriptionV1Dto> mapSubscriptionToDto(@NonNull final List<Subscription> subscriptions) {

        return subscriptions
                .stream()
                .map(subscription ->
                        SubscriptionV1Dto.builder()
                                .withId(subscription.getId())
                                .withName(subscription.getName())
                                .withExpirationDate(subscription.getExpiration())
                                .build())
                .collect(Collectors.toList());
    }

    public SubscriptionV1Dto mapSubscriptionToDto(@NonNull final Subscription subscription) {
        return mapSubscriptionToDto(ImmutableList.of(subscription)).get(0);
    }
}
