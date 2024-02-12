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
import utils.models.Release;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.enums.SortingOptions.*;
import static utils.enums.SortingOrderOptions.*;

@Epic("Releases")
@Feature("Artist releases")
public class DiscogsReleaseTest {

    private final DiscogsApiSteps apiSteps = new DiscogsApiSteps();

    @Test
    @DisplayName("")
    public void checkGetArtistReleaseHandlerResponseWithValidArtistId() {
        String artistId = "321";

        final Response<ResponseBody> response = apiSteps.getArtistReleasesRaw(artistId, year.toString(), asc.toString());

        Assertions.assertAll(
                () -> assertTrue(response.isSuccessful(), "HTTP Response code: " + response.code()),
                () -> assertNotNull(response.body(), "Response body is null")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalidArtistId", "", "!№;%:?*()_-+="})
    @DisplayName("")
    public void checkGetArtistReleaseHandlerResponsesWithInvalidArtistId(String artistId) {
        final Response<ResponseBody> response = apiSteps.getArtistReleasesRaw(artistId, year.toString(), asc.toString());

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
    public void checkArtistReleasesList() throws Exception {
        String artistId = "321";

        final List<Release> releases = apiSteps.getArtistReleases(artistId, year.toString(), asc.toString());
        List<Release> expReleases = List.of();

        assertThat(releases)
                .as("")
                .isEqualTo(expReleases);
    }
}
