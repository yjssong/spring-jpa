package demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by yjsong on 2018-06-29.
 */
@Entity
public class Sawon {
    private Long id;
    private String name;
    private List<Hobby> hobbies;

    public Sawon(Long id, String name, List<Hobby> hobbies){
        super();
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
    }

    public Sawon(String name, List<Hobby> hobbies){
        this.name = name;
        this.hobbies = hobbies;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,
    CascadeType.REFRESH})
    @JoinTable(name = "sawon_hobby",
    joinColumns = @JoinColumn(name="sawon_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id"))
    @OrderColumn(name = "hobby_order")
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString(){
        String result = String.format("Sawon [id=%d, name='%s']%n", id, name);
        if(hobbies != null){
            for (Hobby hobby : hobbies){
                result += String.format("Hobby[id=%d, name='%s']%n",
                        hobby.getId(), hobby.getName());
            }
        }
        return result;
    }
}
