package utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface DiscogsApiService{
    String ARTISTS_URL_BASE = "/artists/{artist_id}";

    @GET(ARTISTS_URL_BASE)
    Call<ResponseBody> getArtist(
            @Path("artist_id") String artistId);

    @GET(ARTISTS_URL_BASE + "/releases")
    Call<ResponseBody> getArtistReleases(
            @Path("artist_id") String artistId,
            @Query("sort") String sort,
            @Query("sort_order") String sortOrder);
}
