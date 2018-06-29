package demo;

import demo.model.Board;
import demo.model.User;
import demo.repository.BoardRepository;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yjsong on 2018-06-29.
 */
@SpringBootApplication
public class BoardApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        User u1 = new User("yjsong", "1234");

        Board b1 = new Board("title1", "content1", new Date(), u1);
        Board b2 = new Board("title2", "content2", new Date(), u1);

        u1.setBoards(new HashSet<Board>(){
            {
                add(b1);
                add(b2);
            }
        });

        userRepository.save(u1);

        for(Board b : boardRepository.findAll()){
            System.out.println(b.toString());
        }


    }
}
