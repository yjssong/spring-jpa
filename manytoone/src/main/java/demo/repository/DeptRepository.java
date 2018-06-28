package demo.repository;

import demo.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-29.
 */
public interface DeptRepository extends JpaRepository<Dept, Long>{}
