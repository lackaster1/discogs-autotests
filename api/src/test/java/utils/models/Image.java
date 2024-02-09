package utils.models;

import lombok.Builder;

@Builder
public class Image {
    public int height;
    public String resource_url;
    public String type;
    public String uri;
    public String uri150;
    public int width;
}
