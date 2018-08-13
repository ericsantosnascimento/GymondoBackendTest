package de.gymondo.samples.restapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import de.gymondo.samples.commons.builder.FluentBuilder;

import java.util.List;

/**
 * Data Transfer Object for user information.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@JsonDeserialize(builder = UserV1Dto.Builder.class)
public class UserV1Dto implements Dto {

    private static final long serialVersionUID = -425508859743317205L;
    private final Integer id;
    private final String name;
    private final Integer age;
    private final String gender;
    private final List<SubscriptionV1Dto> subscriptions;

    private UserV1Dto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.subscriptions = builder.subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, age, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final UserV1Dto other = (UserV1Dto) obj;
        return Objects.equal(this.id, other.id)
                && Objects.equal(this.name, other.name)
                && Objects.equal(this.age, other.age)
                && Objects.equal(this.gender, other.gender)
                ;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("gender", gender)
                .toString();
    }

    public List<SubscriptionV1Dto> getSubscriptions() {
        return subscriptions;
    }

    @JsonPOJOBuilder
    public static class Builder implements FluentBuilder<UserV1Dto> {
        private Integer id;
        private String name;
        private Integer age;
        private String gender;
        private List<SubscriptionV1Dto> subscriptions;

        public Builder withName(final String name) {
            this.name = name;

            return this;
        }

        public Builder withId(final Integer id) {
            this.id = id;

            return this;
        }

        public Builder withAge(final Integer age) {
            this.age = age;

            return this;
        }

        public Builder withGender(final String gender) {
            this.gender = gender;

            return this;
        }

        public Builder withSubscriptions(final List<SubscriptionV1Dto> subscriptions) {
            this.subscriptions = subscriptions;
            return this;
        }

        @Override
        public UserV1Dto build() {
            return new UserV1Dto(this);
        }
    }

}
