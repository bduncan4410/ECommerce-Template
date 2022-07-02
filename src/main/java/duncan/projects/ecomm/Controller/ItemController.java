package duncan.projects.ecomm.Controller;
import duncan.projects.ecomm.Model.Item;
import duncan.projects.ecomm.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController
{
    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public String createItem(@RequestBody Item item)
    {
        itemService.createItem(item);
        return "Success";
    }
}
