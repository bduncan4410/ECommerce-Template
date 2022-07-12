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

/**CRUD operation for the Item model.
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    /** Returns a list of items containted in a response entity with a valid HttpStatus
     *
     * @return  Response entity of the item list.
     */
    @GetMapping("/")
    public ResponseEntity<List<Item>> getItems()
    {
        List<Item> itemList = itemService.listItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    /** Creates a new item and adds it into the database.
     *
     * @param item The new item to be created
     * @return A response API that displays a response with a respective http status
     */
    @PostMapping("/create")
    public ResponseEntity<APIResponse> createItem(@RequestBody Item item)
    {
        if(Objects.nonNull(itemService.readItem(item.getName())))
        {
            return new ResponseEntity<APIResponse>(new APIResponse(false, "Error: Item already exists"), HttpStatus.CONFLICT);
        }
        else
        {
            itemService.createItem(item);
            return new ResponseEntity<>(new APIResponse(true, "Item created successfully!"), HttpStatus.CREATED);
        }
    }

    /**Update operation that replaces a Item by ID with a new ID
     *
     * @param itemID ID in the DB of the item to be deleted
     * @param item the item with the updated field
     * @return The response from the webserver; Success = true if the operation completed; else false
     */
    @PostMapping("/update/{categoryID}")
    public ResponseEntity<APIResponse> updateCategory(@PathVariable("categoryID") Integer itemID, @RequestBody Item item) {
        // Check to see if the category exists.
        if (Objects.nonNull(itemService.readItem(itemID)))
        {
           itemService.updateItem(itemID, item);
            return new ResponseEntity<APIResponse>(new APIResponse(true, "Item updated successfully"), HttpStatus.OK);
        }

        // If the category doesn't exist then return a response of unsuccessful.
        return new ResponseEntity<>(new APIResponse(false, "Failed to update the item."), HttpStatus.NOT_FOUND);
    }
}
