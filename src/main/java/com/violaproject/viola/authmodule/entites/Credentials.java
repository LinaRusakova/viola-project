package com.violaproject.viola.authmodule.entites;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;


/*
 * Credentials - an entity for storing registration data in a separate repository, without receiving other data that make up the user entity.
 * */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
public class Credentials {
    @Id
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    @GeneratedValue(generator = "UUID")
    @NotNull
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Max(36)
    @NotNull
    @Column(name = "login", length = 36, unique = true, nullable = false)
    private String login;

    @Max(36)
    @NotNull
    @Column(name = "password", length = 36, nullable = false)
    private String password;

    @Max(36)
    @NotNull
    @Column(name = "secret-word", length = 36, nullable = false)
    private String secretWord;

    @OneToOne
    private UUID userId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Credentials that = (Credentials) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
