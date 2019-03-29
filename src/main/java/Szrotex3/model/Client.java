package Szrotex3.model;

import javax.persistence.*;

@Entity
@Table(name='Client')
public class Client {

    @Id
    @Column(name='id')
    private int id;

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private User user;

    Client()
    {

    }

    Client(User user, int Id)
    {
        this.setUser(user);
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.id=user.getId();
        this.user = user;
    }
}
