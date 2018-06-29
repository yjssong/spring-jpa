package demo;

import demo.model.Hobby;
import demo.model.Sawon;
import demo.repository.HobbyRepository;
import demo.repository.SawonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by yjsong on 2018-06-29.
 */
@SpringBootApplication
public class ManytomanyApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ManytomanyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ManytomanyApplication.class, args);
    }

    @Autowired
    SawonRepository sawonRepository;

    @Autowired
    HobbyRepository hobbyRepository;

    @Override
    @Transactional
    public void run(String... strings) {
        save();
        sawonRepository.flush();
        deleteSawon();
        sawonRepository.flush();
        updateSawon();
        sawonRepository.flush();
        deleteSawonHobby();
    }

    void save(){
        Sawon s1 = new Sawon("1길동", new ArrayList(){
            {
                add(new Hobby("취미1"));
                add(new Hobby("취미2"));
            }
        });

        Sawon s2 = new Sawon("2길동", new ArrayList(){
            {
                add(new Hobby("취미3"));
            }
        });

        sawonRepository.save(new HashSet<Sawon>(){
            {
                add(s1);
                add(s2);
            }
        });

        for (Sawon s : sawonRepository.findAll()){
            logger.info(s.toString());
        }
    }

    void deleteSawon(){
        Sawon s2 = sawonRepository.findOne(2L);
        logger.info("삭제될 사원 => "+s2.toString());
        sawonRepository.delete(s2);
    }

    void  updateSawon(){
        Sawon s1 = sawonRepository.findOne(1L);
        logger.info("수정될 사원 => "+s1.toString());
        s1.getHobbies().add(new Hobby("취미4"));
        s1.setName("11길동");
        sawonRepository.save(s1);
    }

    void deleteSawonHobby(){
        Sawon s1 = sawonRepository.findOne(1L);
        Hobby h1 = hobbyRepository.findOne(1L);

        if(s1.getHobbies().contains(h1)){
            s1.getHobbies().remove(h1);
        }
        sawonRepository.save(s1);

    }
}
