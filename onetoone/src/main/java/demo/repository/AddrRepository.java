package demo.repository;

import demo.model.Addr;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yjsong on 2018-06-29.
 */
public interface AddrRepository extends JpaRepository<Addr, Long>{}
