package demo.repository;

import demo.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yjsong on 2018-06-30.
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
