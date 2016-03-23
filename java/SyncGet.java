import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Headers;

public class SyncGet {
   public static void main(String[] args) throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("http://ipinfo.io")
			.header("User-Agent", "Mem")
			.addHeader("Accept", "application/json; q=0.5")
            .build();

    Response response = client.newCall(request).execute();
    if (!response.isSuccessful()) {
        throw new IOException("服务器端错误: " + response);
    }

    Headers responseHeaders = response.headers();
    for (int i = 0; i < responseHeaders.size(); i++) {
        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
    }

    System.out.println(response.body().string());
   }
}
