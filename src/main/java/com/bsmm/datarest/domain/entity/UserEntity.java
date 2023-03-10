package com.bsmm.datarest.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "UserEntity.findByCustomEmail", query = "from UserEntity where email = :email")
@NamedNativeQuery(name = "UserEntity.findAllByIdsInFilter", query = "SELECT * FROM USER_ENTITY  WHERE ID IN ?", resultClass = UserEntity.class)
@SqlResultSetMapping(
        name = "UserDTOAMapper",
        classes = {
                @ConstructorResult(
                        targetClass = com.bsmm.datarest.domain.dto.UserDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email")})})
@NamedNativeQuery(name = "UserEntity.findAllUsersByNameAndEmail",
        query = "SELECT * FROM USER_ENTITY WHERE u.email = :email AND u.name = :name",
        resultSetMapping = "UserDTOAMapper")
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