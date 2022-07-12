package duncan.projects.ecomm.Model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Name")
    private @NonNull String name;
    @Column(name = "Desc")
    private @NonNull String description;
    @Column(name = "Category")
    private @NonNull String category;
    @Column(name = "Price")
    private @NonNull double price;
    @Column(name = "Active")
    private @NonNull boolean isActive;

    /**Default Constructor
     * does nothing; please avoid using
     */
    public Item()
    {

    }

    /**Overloaded constructor with all required fields.
     *
     * @param id GUID
     * @param name Name of the item
     * @param description Description of the item
     * @param category String of the category (will be changed to category object on later implementation
     * @param price Price of the item in the $0.00 format
     * @param isActive  Boolean value that sets the item to active or inactive
     * */
    public Item(Long id, @NonNull String name, @NonNull String description, @NonNull String category, @NonNull double price, @NonNull boolean isActive)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isActive = isActive;
    }


    public Long getId()
    {
        return id;
    }

    @NonNull
    public String getName()
    {
        return name;
    }

    @NonNull
    public String getDescription()
    {
        return description;
    }

    @NonNull
    public String getCategory()
    {
        return category;
    }

    @NonNull
    public double getPrice()
    {
        return price;
    }

    @NonNull
    public boolean isActive()
    {
        return isActive;
    }


    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    public void setPrice(@NonNull double price) {
        this.price = price;
    }

    public void setActive(@NonNull boolean active) {
        isActive = active;
    }
}
