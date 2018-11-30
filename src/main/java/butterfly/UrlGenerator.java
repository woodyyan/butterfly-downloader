package butterfly;

public class UrlGenerator {

    private String baseUrl;
    private String extension;
    private Integer count = 0;

    public UrlGenerator(String baseUrl, String extension) {
        this.baseUrl = baseUrl;
        this.extension = extension;
    }

    public String nextUrl() {
        count++;
        return baseUrl + count + extension;
    }
}
