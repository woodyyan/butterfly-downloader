package butterfly;

import org.junit.Assert;
import org.junit.Test;

public class UrlGeneratorTest {
    @Test
    public void testUrl() {
        UrlGenerator generator = new UrlGenerator("https://mtl.ttsqgs.com/images/img/15332/", ".jpg");
        String url = generator.nextUrl();

        Assert.assertEquals("https://mtl.ttsqgs.com/images/img/15332/1.jpg", url);
    }
}