package demo.repository;

import demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-30.
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
