package ua.lviv.pancha.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Entity
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> productList;

    public Group()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public List<Product> getProductList()
    {
        return productList;
    }

    public void setProductList(List<Product> productList)
    {
        this.productList = productList;
    }
}
