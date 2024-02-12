package utils.steps;

import com.google.gson.Gson;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import utils.DiscogsApiService;
import utils.models.Artist;
import utils.models.Release;
import utils.models.ReleaseResponse;

import java.util.List;

import static utils.client.DiscogsClient.createDiscogsApiService;

public class DiscogsApiSteps extends BaseSteps {
    private final DiscogsApiService apiService;

    public DiscogsApiSteps() {
        this.apiService = createDiscogsApiService();
    }

    public Response<ResponseBody> getArtistRaw(String artistId) {
        Call<ResponseBody> artistCall = apiService.getArtist(artistId);
        return execute(artistCall);
    }

    public Artist getArtist(String artistId) throws Exception {
        return new Gson().fromJson(getArtistRaw(artistId).body().string(), Artist.class);
    }

    public Response<ResponseBody> getArtistReleasesRaw(String artistId, String sort, String sortOrder) {
        Call<ResponseBody> artistReleasesCall = apiService.getArtistReleases(artistId, sort, sortOrder);
        return execute(artistReleasesCall);
    }

    public List<Release> getArtistReleases(String artistId, String sort, String sortOrder) throws Exception {
        return new Gson().fromJson(getArtistReleasesRaw(artistId, sort, sortOrder).body().string(), ReleaseResponse.class).getReleases();
    }
}

// "nnRpxrHzeGXDDYWrMUUdxTLwOvVSXaCZNGdqnTkM"