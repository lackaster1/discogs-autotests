package tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import utils.steps.DiscogsApiSteps;
import utils.models.Artist;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Token balance")
@Feature("Total value service")
public class DiscogsUserTest {

    private final DiscogsApiSteps apiSteps = new DiscogsApiSteps();

    @Test
    @DisplayName("")
    void testGetArtist() {
        String artistId = "1230";

        Response<ResponseBody> response = apiSteps.getArtistRaw(artistId);

        assertTrue(response.isSuccessful(), "HTTP Response code: " + response.code());
        assertNotNull(response.body(), "Response body is null");
    }

    @Test
    @DisplayName("")
    void testGetArtist1() throws Exception {
        String artistId = "1230";

        Artist artist = apiSteps.getArtist(artistId);

        assertEquals("https://www.discogs.com/artist/1230-Troy-Brown", artist.getUri());
        assertEquals("https://api.discogs.com/artists/1230/releases", artist.getReleases_url());
        assertEquals("https://api.discogs.com/artists/1230", artist.getResource_url());
        assertEquals(List.of("Brown", "T Brown", "T. Brown", "T.C.B.", "Troy"), artist.getNamevariations());
        assertEquals("Correct", artist.getData_quality());
        assertEquals("Troy Brown", artist.getName());
        assertEquals("Troy Brown", artist.getRealname());
        assertEquals("", artist.getProfile());
        assertEquals(1230, artist.getId());
    }
}
