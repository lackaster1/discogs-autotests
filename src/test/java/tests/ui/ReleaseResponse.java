package tests.ui;

import utils.models.Pagination;
import utils.models.Release;

import java.util.List;

public record ReleaseResponse(
        List<Release> releases,
        Pagination pagination
) {
}
