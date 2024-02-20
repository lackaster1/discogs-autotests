package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit2.Response;
import utils.steps.DiscogsApiSteps;
import utils.models.Release;
import org.example.DefaultDisplayNameGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.enums.SortingOptions.*;
import static utils.enums.SortingOrderOptions.*;

@Epic("Releases")
@Feature("Artist releases")
@DisplayNameGeneration(DefaultDisplayNameGenerator.class)
public class DiscogsReleaseTest {

    private final DiscogsApiSteps apiSteps = new DiscogsApiSteps();

    @Test
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
    public void checkArtistReleasesList() {
        String artistId = "1069645";
        final Release expectedRelease = Release.builder().build();

        final List<Release> releases = apiSteps.getArtistReleases(artistId, year.toString(), asc.toString());
        List<Release> expReleases = List.of(expectedRelease);

        assertThat(releases)
                .as("")
                .isEqualTo(expReleases);
    }
}
