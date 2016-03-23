import java.lang.Exception;
import java.io.IOException;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;

public class Md{
    public static void main(String[] args){
        run();
    }

    public static final MediaType MEDIA_TYPE_MARKDOWN
        = MediaType.parse("text/x-markdown; charset=utf-8");

    private final static OkHttpClient client = new OkHttpClient();

    public static void run(){
        try{
            File file = new File("README.md");

            Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println(response.body().string().getBytes("UTF-8"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
