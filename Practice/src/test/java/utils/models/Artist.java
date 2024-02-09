package utils.models;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Artist {
    public List<String> namevariations;
    public String profile;
    public String releases_url;
    public String resource_url;
    public String uri;
    public ArrayList<String> urls;
    public String data_quality;
    public int id;
    public ArrayList<Image> images;
    public ArrayList<Member> members;
    public List<Artist> aliases;
    public String name;
    public String realname;
}
