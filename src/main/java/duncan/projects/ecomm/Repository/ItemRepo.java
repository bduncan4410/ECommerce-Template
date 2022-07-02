package duncan.projects.ecomm.Repository;


import duncan.projects.ecomm.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer>
{
        Item findByItemName(String itemName);
}
