package butterfly;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

    private String savePath;

    public Downloader(String savePath) {
        this.savePath = savePath;
    }

    public void download(String url, String filename) throws IOException {
        System.out.println("Start download " + url);
        saveImage(url, savePath + filename);
    }

    private InputStream read(URL url, String referer) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        connection.addRequestProperty("Referer", "https://www.meitulu.com/item/" + referer + ".html");

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        InputStream stream = connection.getErrorStream();
        if (stream == null) {
            stream = connection.getInputStream();
            return stream;
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        throw new IOException("No image");
    }

    private void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        String urlWithoutName = imageUrl.substring(0, imageUrl.lastIndexOf('/'));
        String referer = urlWithoutName.substring(urlWithoutName.lastIndexOf('/') + 1);
        InputStream is = read(url, referer);
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
