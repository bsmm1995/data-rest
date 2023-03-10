package com.bsmm.datarest.repository;

import com.bsmm.datarest.domain.dto.UserDTO;
import com.bsmm.datarest.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByNameLike(@Param("name") String name);

    List<UserEntity> findByCustomEmail(@Param("email") String email);

    List<UserEntity> findAllByIdsInFilter(Set<Long> ids);

    List<UserDTO> findAllUsersByNameAndEmail(@Param("name") String name, @Param("email") String email);

    @Query(value = "SELECT u.name AS name, u.email AS email FROM UserEntity u WHERE u.email = :email AND u.name = :name")
    List<Object> findAllUsersByNameAndEmailInterface(@Param("name") String name, @Param("email") String email);
}