package de.gymondo.samples.commons.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import de.gymondo.samples.commons.builder.FluentBuilder;

import java.time.LocalDate;

/**
 * Subscription database entity.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
public class Subscription {
    private Integer id;
    private String name;
    private LocalDate expiration;

    public Subscription(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.expiration = builder.expiration;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Subscription other = (Subscription) obj;
        return Objects.equal(this.id, other.id)
                ;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }

    public static class Builder implements FluentBuilder<Subscription> {
        private Integer id;
        private String name;
        private LocalDate expiration;

        public Builder withExpiration(LocalDate expiration) {
            this.expiration = expiration;

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

        @Override
        public Subscription build() {
            return new Subscription(this);
        }
    }

}
