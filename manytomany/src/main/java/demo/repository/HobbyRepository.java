package demo.repository;

import demo.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-29.
 */
public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
