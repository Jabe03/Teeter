package SwanHacks.Testee.Back.Server;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AccountRegistry {
    private static Map<String, Account> accs;
    static File accountsPath = new File("./accounts/");


    public static Account signIn(String email, String password){
        String passkey = Account.byteArrToStr(password.getBytes());
        for(Account a: readAccounts(true).values()){
            System.out.println("Checking " + a);
            if(Account.byteArrToStr(a.passkey).equals(passkey) && a.email.equals(email)){
                return a;
            }
        }
        return null;
    }
    /**
     *
     * @return a map whose values contains all of the accounts registered with Teeter, keys are emails
     */
    static Map<String, Account> readAccounts(boolean forceRefresh){
        if (accs != null && !forceRefresh) return accs;
        Map<String, Account> accounts = new HashMap<>();
        File[] files = accountsPath.listFiles();
        if(files == null){
            throw new RuntimeException("FATAL ERROR: COULDNT RETRIEVE FILES FROM: " + accountsPath.getAbsolutePath());
        }
        for(File f: files){
            try {
                BufferedReader r = new BufferedReader(new FileReader(f));
                String json = r.readLine();
                String id = f.getName().substring(0, f.getName().length()-5);
                System.out.println(id);
                Account a = Account.getAccountFromJSON(id, json);
                accounts.put(id, a);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        accs = accounts;
        return accounts;
    }

    static boolean registerAccount(Account a){
        if(!isDuplicate(a)){
            File accountFile = new File(accountsPath, a.id.toString() + ".json");
            try {
                FileWriter w = new FileWriter(accountFile);
                w.write(a.JSON());
                w.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            //write the account to database
            return true;

        }
        readAccounts(true);
        return false;

    }
    static boolean isDuplicate(Account a){
        String email = a.email;
        Map<String, Account> accounts = readAccounts(true);
        for(Account temp: accounts.values()){
            if(temp.email.equals(email)){
                return true;
            }
        }
        //TODO::verify that a's username and email are both unique
        return false;
    }

    @Override
    public String toString(){
        return "";
    }
}
