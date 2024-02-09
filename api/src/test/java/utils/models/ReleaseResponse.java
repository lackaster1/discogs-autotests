package utils.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReleaseResponse {
    public List<Release> releases;
    public Pagination pagination;
}
