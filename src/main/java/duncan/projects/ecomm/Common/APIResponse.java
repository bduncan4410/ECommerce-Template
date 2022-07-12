package duncan.projects.ecomm.Common;

import java.time.LocalDateTime;

/**Simple API response object that just returns two values
 * isSuccessful will be true if the Response was successful
 * The message will return any error messages if any that were assigned during an error.
 *
 */
public class APIResponse
{
    private final boolean isSuccessful;
    private final String message;

    public APIResponse(boolean success, String message)
    {
        this.isSuccessful = success;
        this.message = message;
    }

    public boolean isSuccessful()
    {
        return isSuccessful;
    }

    public String getMessage()
    {
        return message;
    }

    public String getTimestamp()
    {
        return LocalDateTime.now().toString();
    }
}