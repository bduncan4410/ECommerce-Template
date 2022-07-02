package duncan.projects.ecomm.Service;

import duncan.projects.ecomm.Model.Item;
import duncan.projects.ecomm.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


}
