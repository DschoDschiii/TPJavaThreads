package net.tfobz.rss;

public class main {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser(
                "https://www.spiegel.de/schlagzeilen/tops/index.rss");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }
    }
}
