package butterfly;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        String baseUrl = "https://mtl.ttsqgs.com/images/img/12455/";
        String folderName = "10049杉本有美";
        int startIndex = 202;

        String savePath = "/Users/songbai.yan/Documents/Woody Studio/青娥/图片/" + folderName + "/";

        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdir();
        }

        UrlGenerator generator = new UrlGenerator(baseUrl, ".jpg");

        Downloader downloader = new Downloader(savePath);
        while (true) {
            try {
                String filename = startIndex + ".jpg";
                String url = generator.nextUrl();
                downloader.download(url, filename);
                startIndex++;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
