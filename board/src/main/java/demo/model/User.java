package demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by yjsong on 2018-06-30.
 */
@Entity
@Table(name = "user")
public class User {
    private Long userno;
    private String userid;
    private String userpwd;
    private Set<Board> boards;

    public User(){

    }

    public User(String userid, String userpwd){
        this.userid = userid;
        this.userpwd = userpwd;
    }

    @Id
    @GeneratedValue
    public Long getUserno() {
        return userno;
    }

    public void setUserno(Long userno) {
        this.userno = userno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Board> getBoards() {
        return boards;
    }

    public void setBoards(Set<Board> boards) {
        this.boards = boards;
    }
}
