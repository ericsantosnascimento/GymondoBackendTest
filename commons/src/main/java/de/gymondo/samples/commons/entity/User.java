package de.gymondo.samples.commons.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import de.gymondo.samples.commons.builder.FluentBuilder;

import java.util.List;

/**
 * User database entity.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private List<Subscription> subscriptions;

    public User(Builder builder) {
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

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equal(this.id, other.id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("gender", gender)
                .add("subscriptions", subscriptions)
                .toString();
    }


    public static class Builder implements FluentBuilder<User> {
        private Integer id;
        private String name;
        private Integer age;
        private String gender;
        private List<Subscription> subscriptions;

        public Builder withSubscriptions(List<Subscription> subscriptions) {
            this.subscriptions = subscriptions;

            return this;
        }

        public Builder withName(String name) {
            this.name = name;

            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;

            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;

            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;

            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }
}
