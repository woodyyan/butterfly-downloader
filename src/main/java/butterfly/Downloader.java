package butterfly;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

    private String savePath;

    public Downloader(String savePath) {

        this.savePath = savePath;
    }

    public void download(String url) throws IOException {
        String filename = url.substring(url.lastIndexOf('/') + 1);
        saveImage(url, filename);
    }

    private InputStream read(URL url) {
        try {
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
            httpcon.addRequestProperty("Referer", "https://www.meitulu.com/item/15269.html");

            int responseCode = httpcon.getResponseCode();
            System.out.println(responseCode);
            InputStream stream = httpcon.getErrorStream();
            if (stream == null) {
                stream = httpcon.getInputStream();
                return stream;
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            throw new RuntimeException("123");
        } catch (IOException e) {
            String error = e.toString();
            throw new RuntimeException(e);
        }
    }

    private void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = read(url);//url.openStream();
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
