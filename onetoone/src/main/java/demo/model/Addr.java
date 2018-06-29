package demo.model;

import javax.persistence.*;

/**
 * Created by yjsong on 2018-06-29.
 */
@Entity //양방향인경우 CascadeType.ALL
public class Addr {
    @Id
    @GeneratedValue
    private Long id;
    private String address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "addr")
    private Emp emp;

    public Addr(String address, Emp emp) {
        this.address = address;
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Addr(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return String.format(
                "Addr[id=%d, address='%s', ename='%s']",
                id, address, emp.getEname());
    }
}
