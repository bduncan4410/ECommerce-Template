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
    private @NonNull String description;
    private @NonNull String category;
    private @NonNull double price;
    private @NonNull boolean isActive;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
