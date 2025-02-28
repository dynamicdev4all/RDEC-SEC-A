import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    static ArrayList<SongModel> songList = new ArrayList<>();

    public static ArrayList<SongModel> getSongList() {
        getSongData();
        return songList;
    }

    static void getSongData() {
        String address = "https://itunes.apple.com/search?term=honey+singh&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();

        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            String completeData = res.body();
            extractDataFromRes(completeData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void extractDataFromRes(String completeData) {

        JSONObject dataObject = new JSONObject(completeData);
        JSONArray dataArray = dataObject.getJSONArray("results");

        for (int i = 0; i < dataArray.length(); i++) {
            SongModel song;
            JSONObject singleSong = dataArray.getJSONObject(i);

            song = new SongModel(
                    singleSong.has("trackName") ? singleSong.getString("trackName") : "No Data Found",
                    singleSong.has("artistName") ? singleSong.getString("artistName") : "No Data Found",
                    singleSong.has("artworkUrl100") ? singleSong.getString("artworkUrl100") : "No Data Found",
                    singleSong.has("previewUrl") ? singleSong.getString("previewUrl") : "No Data Found",
                    singleSong.has("trackPrice") ? singleSong.getFloat("trackPrice") : 0.0f);

            songList.add(song);
        }
    }
}
