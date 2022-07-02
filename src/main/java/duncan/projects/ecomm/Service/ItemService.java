package duncan.projects.ecomm.Service;

import duncan.projects.ecomm.Model.Item;
import duncan.projects.ecomm.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService
{
    @Autowired
    ItemRepo itemRepo;

    public void createItem(Item item)
    {
        itemRepo.save(item);
    }

    public List<Item> listItems()
    {
        return itemRepo.findAll();
    }
    public Item readItem(String itemName)
    {
        return itemRepo.findByItemName(itemName);
    }
    public Optional<Item> readItem(Integer itemID)
    {
        return itemRepo.findById(itemID);
    }

    public void updateItem(Integer itemID, Item newItem)
    {
        Item item = itemRepo.findById(itemID).get();
        item.setName(newItem.getName());
        item.setDescription(newItem.getDescription());
        item.setActive(newItem.isActive());
        item.setPrice(newItem.getPrice());
        itemRepo.save(item);

    }


}
