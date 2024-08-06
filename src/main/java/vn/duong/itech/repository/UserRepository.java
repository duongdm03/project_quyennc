package vn.duong.itech.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.duong.itech.domain.User;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOneByUsername(String userLogin);

    @Query(value = "select count(*) from tbl_user where username = ?1", nativeQuery = true)
    Integer countAllByUserName(String username);

    @Query(value = "select id from tbl_user where username = ?1", nativeQuery = true)
    Integer getIdByUserName(String username);

    @Query(value = "select * from tbl_user where username =?1", nativeQuery = true)
    User findUserByUserName(String userName);
    //    Optional<User> findOneByActivationKey(String activationKey);
    //    List<User> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);
    //    Optional<User> findOneByResetKey(String resetKey);
    //    Optional<User> findOneByEmailIgnoreCase(String email);
    //    Optional<User> findOneByLogin(String login);

    //    @EntityGraph(attributePaths = "authorities")
    //    Optional<User> findOneWithAuthoritiesByLogin(String login);

    //    @EntityGraph(attributePaths = "authorities")
    //    Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);

    //    Page<User> findAllByIdNotNullAndActivatedIsTrue(Pageable pageable);
}
