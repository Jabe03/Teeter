package SwanHacks.Testee.Back.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Account {
    UUID id;
    Name username;
    String email;
    byte[] passkey;


    /**
     *
     * @param acct must be of format {"user": "{value}", "email":"{value}", "passkey":"{value}"}
     * @return Account object with the given data
     */
    public static Account getAccountFromJSON(String id, String acct){
        try {
            return new Account(id, acct);

        } catch(JSONException e){
            System.out.println("ERROR, JSON is wrong format: " + acct);
            return null;
        }
    }
    public String getProfileJSON(){
        try {
            BufferedReader r = new BufferedReader(new FileReader("./profiles/sample_profile.json"));
            return r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Account(String name, String email, String passkey){
        this.username = new Name(name);
        this.email = email;
        this.passkey = (passkey.getBytes(StandardCharsets.UTF_8));
        this.id = UUID.randomUUID();
    }

    private Account(String id, String jsonStr) throws JSONException {
        JSONObject jsonData = new JSONObject(jsonStr);
        this.username = new Name((String)jsonData.get("user"));
        this.email = (String)jsonData.get("email");
        this.passkey = hexStrToArr((String)jsonData.get("passkey"));
        this.id = UUID.fromString(id);

    }



    public void register(){
        AccountRegistry.registerAccount(this);
    }

    public static String byteArrToStr(byte[] key){
        StringBuilder passkeystr = new StringBuilder();
        for(byte a: key){
            passkeystr.append(Integer.toHexString(a).toUpperCase());
        }
        return passkeystr.toString();
    }
    public static byte[] hexStrToArr(String hexString){
        // Ensure the string has an even number of characters
        if (hexString.length() % 2 != 0) {
            hexString = "0" + hexString; // Pad with a leading zero if necessary
        }

        // Convert the string to a byte array
        byte[] byteArray = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            String byteString = hexString.substring(i, i + 2); // Extract two characters
            byteArray[i / 2] = (byte) Integer.parseInt(byteString, 16); // Parse as a byte
        }
        return byteArray;
    }

    public String JSON(){
        String json =
                "{\"user\":\"" + this.username + "\"," +
                "\"email\":\"" + this.email + "\"," +
                "\"passkey\":\"" + byteArrToStr(this.passkey) + "\"}"
                ;
        return json;
    }

    @Override
    public String toString(){

        return "Account:{" +this.username + ", " + this.email + ","+ byteArrToStr(this.passkey) + "}";
    }
}
