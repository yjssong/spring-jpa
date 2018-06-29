package demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yjsong on 2018-06-29.
 */
@Entity
@Table(name = "board")
public class Board {

    private Long boardno;
    private String bTitle;
    private String bContent;
    private Date bDate;

    private User user;

    public Board(){

    }

    public Board(String bTitle, String bContent, Date bDate, User user ){
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bDate = bDate;
        this.user = user;
    }

    @Id
    @GeneratedValue
    public Long getBoardno() {
        return boardno;
    }

    public void setBoardno(Long boardno) {
        this.boardno = boardno;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    @ManyToOne
    @JoinColumn(name = "userno")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
                "Board[boardNo=%d, bTitle='%s', bContent='%s', bDate='%s', userno=%d]%n",
                boardno, bTitle, bContent, bDate, getUser().getUserno());
    }
}
