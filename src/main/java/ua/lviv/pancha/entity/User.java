package ua.lviv.pancha.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vasyl.Pavlyuk on 08.08.2016.
 */
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String firstname;
    @Column
    private String secondname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public User()
    {
        registrationDate = Calendar.getInstance().getTime();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getSecondname()
    {
        return secondname;
    }

    public void setSecondname(String secondname)
    {
        this.secondname = secondname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }
}
