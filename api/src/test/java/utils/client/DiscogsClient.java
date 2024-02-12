package utils.client;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.DiscogsApiService;

import java.io.IOException;

public class DiscogsClient {

    private static final String END_POINT = "https://api.discogs.com/";

    public static DiscogsApiService createDiscogsApiService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new UserAgentInterceptor("FooBarApp/3.0"))
                .addInterceptor(new UrlLoggingInterceptor(END_POINT))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client) // Установка логирующего клиента
                .build();

        return retrofit.create(DiscogsApiService.class);
    }

    private static class UserAgentInterceptor implements Interceptor {
        private final String userAgent;

        public UserAgentInterceptor(String userAgent) {
            this.userAgent = userAgent;
        }

        @NotNull
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request newRequest = originalRequest.newBuilder()
                    .header("User-Agent", userAgent)
                    .build();
            return chain.proceed(newRequest);
        }
    }
}
