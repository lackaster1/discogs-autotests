package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit2.Response;
import utils.steps.DiscogsApiSteps;
import utils.models.Artist;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Epic("User")
@Feature("GetArtist handler")
public class DiscogsUserTest {

    private final DiscogsApiSteps apiSteps = new DiscogsApiSteps();

    @Test
    @DisplayName("")
    void checkGetArtistHandlerResponseWithValidArtistId() {
        String artistId = "1230";

        final Response<ResponseBody> response = apiSteps.getArtistRaw(artistId);

        Assertions.assertAll(
                () -> assertTrue(response.isSuccessful(), "HTTP Response code: " + response.code()),
                () -> assertNotNull(response.body(), "Response body is null")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalidArtistId", "", "!№;%:?*()_-+="})
    @DisplayName("")
    void checkGetArtistHandlerResponsesWithInvalidArtistId(String artistId) {
        final Response<ResponseBody> response = apiSteps.getArtistRaw(artistId);

        Assertions.assertAll(
                () -> assertThat(response.code())
                        .as("HTTP Response code: " + response.code())
                        .isEqualTo(404),
                () -> assertThat(response.body())
                        .as("Response body is not null")
                        .isNull()
        );
    }

    @Test
    @DisplayName("")
    void checkContentFromGetArtistHandlerResponses() {
        String artistId = "1230";

        final Artist artist = apiSteps.getArtist(artistId);
        Assertions.assertAll(
                () -> assertEquals("https://www.discogs.com/artist/1230-Troy-Brown", artist.getUri()),
                () -> assertEquals("https://api.discogs.com/artists/1230/releases", artist.getReleases_url()),
                () -> assertEquals("https://api.discogs.com/artists/1230", artist.getResource_url()),
                () -> assertEquals(List.of("Brown", "T Brown", "T. Brown", "T.C.B.", "Troy"), artist.getNamevariations()),
                () -> assertEquals("Correct", artist.getData_quality()),
                () -> assertEquals("Troy Brown", artist.getName()),
                () -> assertEquals("Troy Brown", artist.getRealname()),
                () -> assertEquals("", artist.getProfile()),
                () -> assertEquals(1230, artist.getId())
        );
    }
}
