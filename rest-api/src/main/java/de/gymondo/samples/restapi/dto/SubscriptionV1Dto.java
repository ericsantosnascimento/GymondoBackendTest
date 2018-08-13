package de.gymondo.samples.restapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import de.gymondo.samples.commons.builder.FluentBuilder;

import java.time.LocalDate;

/**
 * Data Transfer Object for subscription information.
 *
 * @author Rui Vilao (rui@gymondo.de)
 */
@JsonDeserialize(builder = SubscriptionV1Dto.Builder.class)
public class SubscriptionV1Dto implements Dto {

    private static final long serialVersionUID = -4793835579929604582L;

    private final Integer id;
    private final String name;
    private final LocalDate expirationDate;

    private SubscriptionV1Dto(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.expirationDate = builder.expirationDate;
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
        final SubscriptionV1Dto other = (SubscriptionV1Dto) obj;
        return Objects.equal(this.id, other.id) &&
                Objects.equal(this.name, other.name)
                ;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @JsonPOJOBuilder
    public static class Builder implements FluentBuilder<SubscriptionV1Dto> {
        private Integer id;
        private String name;
        private LocalDate expirationDate;

        public Builder withExpirationDate(final LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withId(final Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public SubscriptionV1Dto build() {
            return new SubscriptionV1Dto(this);
        }
    }

}
