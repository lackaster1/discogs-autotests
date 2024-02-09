package utils.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class UrlLoggingInterceptor implements Interceptor {
    private final String targetUrl;

    public UrlLoggingInterceptor(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();

        if (url.contains(targetUrl)) {
            System.out.println("Logging for URL: " + url);
            System.out.println("Request: " + request);

            Response response = chain.proceed(request);

            System.out.println("Response Code: " + response.code());
            System.out.println("Response Body: " + response.body());
            return response;
        } else {
            return chain.proceed(request);
        }
    }
}
