package Team.TeamProject.Controller;

import Team.TeamProject.entity.Store;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/api")
    public List<Store> callApi(Model model) throws IOException, ParseException {
        List<Store> storeList = new ArrayList<>();

        String urlStr = "http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInArea?" +
                "&serviceKey=MeKpYik6HKlwmVVBv4gbrrUo%2B51qkAPSIi2ySd5KcGJwMFyx6tOyso6AXxUoA69BCyzh2vF2mYrLNuweuV7pTg%3D%3D" +
                "&pageNo=1" +
                "&numOfRows=100" +
                "&key=10351" +
                "&indsSclsCd=I21201" +
                "&type=json";

        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        StringBuilder result = new StringBuilder();
        String returnLine;
        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n");
        }

        urlConnection.disconnect();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result.toString());
        JSONObject body = (JSONObject) json.get("body");
        JSONArray items = (JSONArray) body.get("items");

        for (Object itemObj : items) {
            JSONObject item = (JSONObject) itemObj;
            String bizesNm = (String) item.get("bizesNm");
            String indsSclsNm = (String) item.get("indsSclsNm");
            String lnoAdr = (String) item.get("lnoAdr");
            String rdnmAdr = (String) item.get("rdnmAdr");
            Double lon = (Double) item.get("lon");
            Double lat = (Double) item.get("lat");

            Store store = new Store(bizesNm, indsSclsNm, lnoAdr, rdnmAdr, lon, lat);
            storeList.add(store);
        }

        model.addAttribute("storeList",storeList);

        return storeList;
    }
}