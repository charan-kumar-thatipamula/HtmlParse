package com.charan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.util.*;

public class JsoupTrial{

    public List<String> extractJournalUrls(String url) {
        List<String> journalUrls = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements refs = doc.select("a[href^=/science/article/pii]");
            for (Element ref : refs) {
//                System.out.println();
                Attributes attributes = ref.attributes();
                String journalUrl = attributes.get("href");
                journalUrl = "https://www.sciencedirect.com" + journalUrl;
//                getJournalMetadata(journalUrl);
                if (map.get(journalUrl) == null) {
                    map.put(journalUrl, true);
                } else {
                    continue;
                }
                System.out.println("Journal link: " + journalUrl);
                journalUrls.add(journalUrl);
            }
        } catch (Exception e) {
            System.out.println("Exception for URL: " + url + "ignoring");
        }
        return journalUrls;
    }

    public static void main(String[] args)  throws Exception {
        JsoupTrial jsoupTrial = new JsoupTrial();
        List<String> journalUrls = jsoupTrial.extractJournalUrls("https://www.sciencedirect.com/search/advanced?qs=cancer&date=2018&show=25&sortBy=relevance");
        ProcessJournal processJournal = new ProcessJournal();
        String fData = "Title,Author,Email" + "\n";
        for (String journalUrl : journalUrls) {
            String contents = processJournal.getJournalMetadata(journalUrl);
            if (contents.indexOf("@") == -1)
                continue;
            System.out.println("contents: " + contents);
            fData = fData + contents;
        }
        FileUility fileUility = new FileUility();
        String fName = "outputcsv" + new Date().getTime() + ".csv";
        fileUility.setOutputFileName(fName);
        fileUility.writeOutputFile(fData);
    }
}
