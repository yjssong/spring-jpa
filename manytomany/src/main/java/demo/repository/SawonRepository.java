package demo.repository;

import demo.model.Sawon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-29.
 */
public interface SawonRepository extends JpaRepository<Sawon, Long> {
}
