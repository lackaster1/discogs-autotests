package utils.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Release {
    public String artist;
    public int id;
    public int main_release;
    public String resource_url;
    public String role;
    public String thumb;
    public String title;
    public String type;
    public int year;
    public String format;
    public String label;
    public String status;
}
