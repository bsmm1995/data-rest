package com.bsmm.datarest.repository;

import com.bsmm.datarest.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByNameLikeIgnoreCase(@Param("name") String name);

    Optional<UserEntity> findByCustomEmail(@Param("email") String email);

    List<UserEntity> findAllByIdsInFilter(Set<Long> ids);

    @Query(value = "SELECT new com.bsmm.datarest.domain.entity.UserEntity(ue.id, ue.name, ue.email) FROM USER_ENTITY ue")
    List<UserEntity> findAllUserEntity();

    @Query(name = "UserEntity.findAllUsersByNameAndEmail")
    List<UserEntity> findAllUsersByNameAndEmail();
}