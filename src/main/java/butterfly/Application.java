package butterfly;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        String initialUrl = "";
        UrlGenerator generator = new UrlGenerator("", "");

        String savePath = "";
        Downloader downloader = new Downloader(savePath);
        while (true) {
            try {
                String url = generator.nextUrl();
                downloader.download(url);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
