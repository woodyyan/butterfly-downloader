package butterfly;

import org.junit.Test;

import java.io.IOException;

public class DownloaderTest {
    @Test
    public void testDownloadImage() throws IOException {
        Downloader downloader = new Downloader("/Users/songbai.yan/Desktop/123/");
        downloader.download("https://mtl.ttsqgs.com/images/img/15269/1.jpg");
        //https://mtl.ttsqgs.com/images/img/15269/1.jpg
        //https://mtl.ttsqgs.com/images/img/15332/1.jpg
    }
}