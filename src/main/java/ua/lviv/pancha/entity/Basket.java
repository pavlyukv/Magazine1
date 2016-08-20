package ua.lviv.pancha.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
@Entity
public class Basket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private boolean ordered;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    // User
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // Products
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prod_in_bask", joinColumns = @JoinColumn(name = "id_bask"), inverseJoinColumns = @JoinColumn(name = "id_prod"))
    private List<Product> productList;

    public Basket()
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

    public boolean isOrdered()
    {
        return ordered;
    }

    public void setOrdered(boolean ordered)
    {
        this.ordered = ordered;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Product> getProductList()
    {
        return productList;
    }

    public void setProductList(List<Product> productList)
    {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;
        return id == basket.id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
