package SwanHacks.Testee.Back;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TextController {

    // This endpoint will receive the text from the frontend
    @PostMapping("/print")
    public void printText(@RequestBody String text) {
        // Print the received text to the server console
        System.out.println("Received text: " + text);
    }
}
