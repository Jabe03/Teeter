package SwanHacks.Testee.Back.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfileRegistry {
    static Map<String, Profile> profiles;
    static File profilesPath = new File("./profiles/");
    /**
     *
     * @return a map whose values contains all of the accounts registered with Teeter, keys are emails
     */
    static Map<String, Profile> readProfiles(boolean forceRefresh){
        Map<String, Profile> accounts = new HashMap<>();
        File[] files = profilesPath.listFiles();
        if(files == null){
            throw new RuntimeException("FATAL ERROR: COULDNT RETRIEVE FILES FROM: " + profilesPath.getAbsolutePath());
        }
        for(File f: files){
            try {
                BufferedReader r = new BufferedReader(new FileReader(f));
                String json = r.readLine();
                String id = f.getName().substring(0, f.getName().length()-5);
                System.out.println(id);
                //Profile p = Account.getAccountFromJSON(id, json);
                //accounts.put(id, a);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        profiles = accounts;
        return accounts;
    }
}

