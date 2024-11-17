package SwanHacks.Testee.Back;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@RestController
@RequestMapping("/api")
public class TextController {

    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("{\"msg\":\"Hello from Josh's computer!\"}");
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitData(@RequestBody String data) {
        System.out.println(data);
        return ResponseEntity.ok("{\"result\": \"Data received\"}");
    }

    @PostMapping("/reverse")
    public ResponseEntity<String> reverseData(@RequestBody String data) {
        try {
            JSONObject jsonData = new JSONObject(data);
            System.out.println(jsonData);
            String strToReverse = (String)jsonData.get("str");
            String result = String.format("{\"result\":\"%s\"}", new StringBuilder().append(strToReverse).reverse().toString());
            System.out.printf("%s -> %s%n", strToReverse, result);
            return ResponseEntity.ok(result);
        } catch(JSONException e){
            System.out.println("NOOOOOOOOOO");
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }

    }

    @PostMapping("/getTutorProfile")
    public ResponseEntity<String> handleTutorBioRequest(@RequestBody String data){
        //ignore data for now... it is supposed to be the tutor ID

        try {
            BufferedReader r = new BufferedReader(new FileReader("./profiles/sample_profile.json"));
            return ResponseEntity.ok(r.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }
}
