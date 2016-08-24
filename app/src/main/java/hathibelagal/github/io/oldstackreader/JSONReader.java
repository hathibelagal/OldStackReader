package hathibelagal.github.io.oldstackreader;

import android.text.Html;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Hathibelagal on 5/8/16.
 */
public class JSONReader {

    private OkHttpClient client;

    private static final String API_URL =
            "https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&site=%s";

    /**
     * Initialize the OkHttpClient
     */
    public JSONReader() {
        client = new OkHttpClient();
    }

    /**
     * Fetch JSON output of StackExchange API
     * @param url
     * @return
     */
    private String fetchJSON(String url) {
        String output = "";
        Request request = new Request.Builder()
                .addHeader("User-Agent", "My Little StackExchange Reader 1.0")
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful())
                output = response.body().string();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Fetch the latest list of questions from StackExchange API
     * @param site
     * @return
     */
    public List<Question> fetchQuestionsFrom(String site) {
        List<Question> questions = new ArrayList<Question>(10);
        String url = String.format(API_URL, site);
        String json = fetchJSON(url);

        try {
            JSONArray items = new JSONObject(json).getJSONArray("items");
            for(int i=0;i<items.length();i++) {
                JSONObject item = items.getJSONObject(i);

                // Fetch tags
                JSONArray tags = item.getJSONArray("tags");
                String[] tagsArray = new String[tags.length()];
                for(int j=0;j<tags.length();j++) {
                    tagsArray[j] = tags.getString(j);
                }

                // Fetch author name
                String authorDisplayName = item.getJSONObject("owner").getString("display_name");
                authorDisplayName = Html.fromHtml(authorDisplayName).toString();

                // Fetch author photo
                String authorPhoto = item.getJSONObject("owner").optString("profile_image");

                // Fetch answered status
                boolean isAnswered = item.getBoolean("is_answered");

                // Fetch number of views
                int viewCount = item.getInt("view_count");

                // Fetch score
                int score = item.getInt("score");

                // Fetch creation date
                long creationDate = item.getLong("creation_date");

                // Fetch title
                String title = item.getString("title");
                title = Html.fromHtml(title).toString();

                // Fetch link
                String link = item.getString("link");

                questions.add(new Question(title, authorDisplayName, authorPhoto, score,
                        viewCount, creationDate, isAnswered, link, tagsArray));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
