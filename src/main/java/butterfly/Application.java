package butterfly;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        UrlGenerator generator = new UrlGenerator("https://mtl.ttsqgs.com/images/img/15269/", ".jpg");

        String savePath = "/Users/songbai.yan/Documents/Woody Studio/青娥/图片/10021/";
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
