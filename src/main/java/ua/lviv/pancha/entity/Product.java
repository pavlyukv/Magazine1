package ua.lviv.pancha.entity;

import javax.persistence.*;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int quantity;
    @Column
    private double price;
    @Column
    @Lob
    private byte[] image = new byte[1];
    @Transient
    private String image64;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    // Group
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    // Baskets
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prod_in_bask", joinColumns = @JoinColumn(name = "id_prod"), inverseJoinColumns = @JoinColumn(name = "id_bask"))
    private List<Basket> basketList;

    public Product()
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate)
    {
        this.registrationDate = registrationDate;
    }

    public Group getGroup()
    {
        return group;
    }

    public void setGroup(Group group)
    {
        this.group = group;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public List<Basket> getBasketList()
    {
        return basketList;
    }

    public void setBasketList(List<Basket> basketList)
    {
        this.basketList = basketList;
    }

    public String getImage64()
    {
        return image64;
    }

    public void setImage64(String image64)
    {
        this.image64 = image64;
    }

    // Convert image -> image64
    public void loadImage()
    {
        image64 = Base64.getEncoder().encodeToString(image);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}
