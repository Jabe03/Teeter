package SwanHacks.Testee.Back.Server;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Server {

    public static void main(String[] args) throws JSONException {
        //initializeServer();
        //Account john = new Account("John Doe", "jdoe@university.com", "johnpassword123");
        //new Account("Gary Squarepants", "gpants@university.com", "garypass2000").register();
        //new Account("Becca Warfield", "bwarf@university.com", "myword80880").register();
        //JSONObject json = new JSONObject(john.JSON());
        //AccountRegistry.registerAccount(john);

        //Map<String, Account> f = AccountRegistry.readAccounts(true);
        //System.out.println(f);
        try {
            BufferedReader r = new BufferedReader(new FileReader("./profiles/sample_profile.json"));
            System.out.println( ResponseEntity.ok(r.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeServer(){
        AccountRegistry.readAccounts(true);
    }
}
