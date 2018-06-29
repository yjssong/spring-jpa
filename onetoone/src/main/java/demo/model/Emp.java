package demo.model;


import javax.persistence.*;

/**
 * Created by yjsong on 2018-06-29.
 */
@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Long empno;
    private String ename;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addr_id")
    private Addr addr;

    public Emp(String ename, Addr addr) {
        this.ename = ename;
        this.addr = addr;
    }

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public Emp(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Addr getAddr() {
        return addr;
    }

    public void setAddr(Addr addr) {
        this.addr = addr;
    }

    public String toString() {
        return String.format(
                "Emp[empno=%d, ename='%s', address='%s']",
                empno, ename, addr.getAddress());
    }
}