package demo.repository;

import demo.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-29.
 */
public interface EmpRepository extends JpaRepository<Emp, Long>{}
