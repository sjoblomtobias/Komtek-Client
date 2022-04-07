package komtek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class CapeManager {

    private final HashMap<String, String> capes = new HashMap<>();

    public CapeManager() {
        try {
            URL url = new URL("https://pastebin.com/raw/WEbAREdw");
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(":");
                getCapes().put(split[0], split[1]);
                System.out.println(line);
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getCapes() {
        return this.capes;
    }
}
