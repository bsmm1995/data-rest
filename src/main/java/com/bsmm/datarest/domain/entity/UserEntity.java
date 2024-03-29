package com.bsmm.datarest.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER_ENTITY")
@NamedQuery(name = "UserEntity.findByCustomEmail", query = "FROM USER_ENTITY WHERE email = :email")
@NamedNativeQuery(name = "UserEntity.findAllByIdsInFilter", query = "SELECT * FROM USER_ENTITY  WHERE ID IN ?", resultClass = UserEntity.class)
@SqlResultSetMapping(
        name = "UserMapping",
        entities =
        @EntityResult(
                entityClass = UserEntity.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "email", column = "email")
                })
)
@NamedNativeQuery(name = "UserEntity.findAllUsersByNameAndEmail",
        query = "SELECT * FROM USER_ENTITY ue WHERE ue.name = :name AND ue.email = :email",
        resultClass = UserEntity.class,
        resultSetMapping = "UserMapping")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }
}