package demo;

import demo.model.Addr;
import demo.model.Emp;
import demo.repository.AddrRepository;
import demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjsong on 2018-06-29.
 */
@SpringBootApplication
public class OnetooneApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OnetooneApplication.class, args);
    }
    @Autowired EmpRepository empRepository;
    @Autowired AddrRepository addrRepository;
    @Transactional
    @Override
    public void run(String...args) {
        List<Emp> emps = new ArrayList();

        emps.add(new Emp("김길동", new Addr("서울")));
        emps.add(new Emp("나길동", new Addr("제주")));
        emps.add(new Emp("다길동", new Addr("뉴욕")));

        empRepository.save(emps);

        for(Emp e : empRepository.findAll()) {
            System.out.println(e.toString());
        }
        Addr addr1 = new Addr("대전");
        Emp e1 = new Emp("대전길동");

        e1.setAddr(addr1);

        addr1.setEmp(e1);
        empRepository.save(e1);
        Addr addr2 = new Addr("하와이");
        Emp e2 = new Emp("하와이길동");


        addr1.setEmp(e2);
        addrRepository.save(addr2);

    }
}
