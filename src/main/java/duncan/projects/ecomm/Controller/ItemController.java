package duncan.projects.ecomm.Controller;

import duncan.projects.ecomm.Common.APIResponse;
import duncan.projects.ecomm.Model.Item;
import duncan.projects.ecomm.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/item")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<Item>> getItems()
    {
        List<Item> itemList = itemService.listItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createItem(@RequestBody Item item)
    {
        if(Objects.nonNull(itemService.readItem(item.getName())))
        {
            return new ResponseEntity<APIResponse>(new APIResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }
        else
        {
            itemService.createItem(item);
            return new ResponseEntity<>(new APIResponse(true, "Item created successfully!"), HttpStatus.CREATED);
        }
    }

    @PostMapping("/update/{categoryID}")
    public ResponseEntity<APIResponse> updateCategory(@PathVariable("categoryID") Integer itemID, @RequestBody Item item) {
        // Check to see if the category exists.
        if (Objects.nonNull(itemService.readItem(itemID)))
        {
           itemService.updateItem(itemID, item);
            return new ResponseEntity<APIResponse>(new APIResponse(true, "updated the category"), HttpStatus.OK);
        }

        // If the category doesn't exist then return a response of unsuccessful.
        return new ResponseEntity<>(new APIResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
    }
}
