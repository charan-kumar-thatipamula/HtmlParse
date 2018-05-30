package com.charan;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.util.List;

public class JsoupTrial{

    public void processUrl(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements refs = doc.select("a[href^=/science/article/pii]");
            for (Element ref : refs) {
                System.out.println();
                Attributes attributes = ref.attributes();
                String journalUrl = attributes.get("href");
                journalUrl = "https://www.sciencedirect.com" + journalUrl;
                System.out.println("Journal link: " + journalUrl);
                getJournalMetadata(journalUrl);
            }
        } catch (Exception e) {
            System.out.println("Exception for URL: " + url + "ignoring");
        }
    }

    public void getJournalMetadata(String journalUrl) {
        // "https://www.sciencedirect.com/science/article/pii/S0889854518300093"
        try {
            Document doc = Jsoup.connect(journalUrl).get();
            String journalMetadata = "";
//            System.out.println(doc.title());
            journalMetadata = journalMetadata.concat(doc.title() + ",");
            Elements newsHeadlines = doc.select("script[data-iso-key]");
            for (Element headline : newsHeadlines) {
//            headline.text();
//            System.out.println(headline.attr("title") + " : " +headline.absUrl("href"));
//            System.out.println(headline.child(0).text());
                List<Node> childNodes = headline.childNodes();
                for (Node node : childNodes) {
//                    System.out.println(((DataNode) node).getWholeData());
                    // data = {"userAgent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36","abstracts":{"content":[{"#name":"abstract","$":{"xmlns:ce":true,"class":"teaser","id":"abs0010","view":"all"},"$$":[{"#name":"abstract-sec","$":{"id":"abssec0010","view":"all"},"$$":[{"#name":"simple-para","$":{"view":"extended","id":"abspara0010"},"_":"This article reviews some of the more common types of cancer that may be encountered during pregnancy. It reviews the unique challenges with the diagnosis and treatment of breast, cervical, hematologic, and colon cancers in pregnant patients."}]}]}],"floats":[],"footnotes":[],"attachments":[]},"biographies":{},"combinedContentItems":{"content":[{"#name":"keywords","$$":[{"#name":"keywords","$":{"xmlns:ce":true,"xmlns:aep":true,"xmlns:xoe":true,"xmlns:mml":true,"xmlns:xs":true,"xmlns:xlink":true,"xmlns:xocs":true,"xmlns:tb":true,"xmlns:xsi":true,"xmlns:cals":true,"xmlns:sb":true,"xmlns:sa":true,"xmlns:ja":true,"xmlns":true,"lang":"en","id":"kwrds0010","view":"all","class":"keyword"},"$$":[{"#name":"section-title","$":{"id":"sectitle0010"},"_":"Keywords"},{"#name":"keyword","$":{"id":"kwrd0010"},"$$":[{"#name":"text","_":"Gestational breast cancer"}]},{"#name":"keyword","$":{"id":"kwrd0015"},"$$":[{"#name":"text","_":"Cervical cancer in pregnancy"}]},{"#name":"keyword","$":{"id":"kwrd0020"},"$$":[{"#name":"text","_":"Colon cancer in pregnancy"}]},{"#name":"keyword","$":{"id":"kwrd0025"},"$$":[{"#name":"text","_":"Hematologic cancers in pregnancy"}]},{"#name":"keyword","$":{"id":"kwrd0030"},"$$":[{"#name":"text","_":"Lymphoma in pregnancy"}]},{"#name":"keyword","$":{"id":"kwrd0035"},"$$":[{"#name":"text","_":"Leukemia in pregnancy"}]}]}]},{"#name":"title-editors-groups","$":{"xmlns:xocs":true,"xmlns:xoe":true,"xmlns:mml":true,"xmlns:ce":true,"xmlns:xs":true,"xmlns:xlink":true,"xmlns:tb":true,"xmlns:xsi":true,"xmlns:cals":true,"xmlns:sb":true,"xmlns:ja":true,"xmlns":true},"$$":[{"#name":"title","_":"Medical Disorders in Pregnancy"},{"#name":"editors","$$":[{"#name":"author-group","$$":[{"#name":"author","$":{"author-id":"S0889854518X00023-03ddabd0583054b5402ccaee0c373e71"},"$$":[{"#name":"given-name","_":"Erika"},{"#name":"surname","_":"Peterson"},{"#name":"degrees","_":"MD"}]},{"#name":"affiliation","$":{"id":"aff1","affiliation-id":"S0889854518X00023-429a999c46c47ba7b9504aa49c022d53"},"$$":[{"#name":"textfn","_":"Division of Maternal Fetal Medicine, Fetal Concerns Center of Wisconsin, Medical College of Wisconsin, Milwaukee, WI 53226-3522, USA"}]}]},{"#name":"author-group","$$":[{"#name":"author","$":{"author-id":"S0889854518X00023-bb6be118241ff3d6169cc9231ff9bfef"},"$$":[{"#name":"given-name","_":"Judith U."},{"#name":"surname","_":"Hibbard"},{"#name":"degrees","_":"MD"}]},{"#name":"affiliation","$":{"id":"aff2","affiliation-id":"S0889854518X00023-1f18f7c5fcdb9749a7c588b5661e2c15"},"$$":[{"#name":"textfn","_":"Medical College of Wisconsin, Milwaukee, WI 53226-3522, USA"}]}]}]}]}],"floats":[],"footnotes":[],"attachments":[]},"experiments":{},"rawtext":"","authors":{"content":[{"#name":"author-group","$":{"xmlns:ce":true,"id":"augrp0010"},"$$":[{"#name":"author","$":{"id":"au1","author-id":"S0889854518300093-e063a82c584d660c11e03e3992aeb70a"},"$$":[{"#name":"given-name","_":"Anna"},{"#name":"surname","_":"McCormick"},{"#name":"degrees","_":"DO"},{"#name":"cross-ref","$":{"refid":"cor1","id":"crosref0010"},"$$":[{"#name":"sup","$":{"loc":"post"},"_":"∗"}]},{"#name":"e-address","$":{"xmlns:xlink":true,"type":"email","href":"mailto:amccormick@mcw.edu","id":"eadd0010"},"_":"amccormick@mcw.edu"}]},{"#name":"author","$":{"id":"au2","author-id":"S0889854518300093-61137ad49ff38956e710c926033180f2"},"$$":[{"#name":"given-name","_":"Erika"},{"#name":"surname","_":"Peterson"},{"#name":"degrees","_":"MD"}]},{"#name":"affiliation","$":{"id":"aff1","affiliation-id":"S0889854518300093-1a462aa1450714e3213a80ef096d2fdf"},"$$":[{"#name":"textfn","_":"Department of Obstetrics and Gynecology, Medical College of Wisconsin, 8701 W Watertown Plank Road, Milwaukee, WI 53226, USA"},{"#name":"affiliation","$":{"xmlns:sa":true},"$$":[{"#name":"organization","_":"Department of Obstetrics and Gynecology"},{"#name":"organization","_":"Medical College of Wisconsin"},{"#name":"address-line","_":"8701 W Watertown Plank Road"},{"#name":"city","_":"Milwaukee"},{"#name":"state","_":"WI"},{"#name":"postal-code","_":"53226"},{"#name":"country","_":"USA"}]}]},{"#name":"correspondence","$":{"id":"cor1"},"$$":[{"#name":"label","_":"∗"},{"#name":"text","_":"Corresponding author."}]}]}],"floats":[],"footnotes":[],"affiliations":{"aff1":{"#name":"affiliation","$":{"id":"aff1","affiliation-id":"S0889854518300093-1a462aa1450714e3213a80ef096d2fdf"},"$$":[{"#name":"textfn","_":"Department of Obstetrics and Gynecology, Medical College of Wisconsin, 8701 W Watertown Plank Road, Milwaukee, WI 53226, USA"},{"#name":"affiliation","$":{"xmlns:sa":true},"$$":[{"#name":"organization","_":"Department of Obstetrics and Gynecology"},{"#name":"organization","_":"Medical College of Wisconsin"},{"#name":"address-line","_":"8701 W Watertown Plank Road"},{"#name":"city","_":"Milwaukee"},{"#name":"state","_":"WI"},{"#name":"postal-code","_":"53226"},{"#name":"country","_":"USA"}]}]}},"correspondences":{"cor1":{"#name":"correspondence","$":{"id":"cor1"},"$$":[{"#name":"label","_":"∗"},{"#name":"text","_":"Corresponding author."}]}},"attachments":[],"scopusAuthorIds":{},"articles":{}},"body":{},"exam":{},"article":{"publication-content":{"noElsevierLogo":false,"imprintPublisher":{"displayName":"Elsevier","id":"47"},"isSpecialIssue":true,"isSampleIssue":false,"transactionsBlocked":false,"publicationOpenAccess":{"oaStatus":"","oaArticleCount":0,"openArchiveStatus":false,"openArchiveArticleCount":0,"openAccessStartDate":"","oaAllowsAuthorPaid":false},"issue-cover":{"attachment":[{"attachment-eid":"1-s2.0-S0889854518X00023-cov200h.gif","file-basename":"cov200h","extension":"gif","filename":"cov200h.gif","ucs-locator":["https://s3-eu-west-1.amazonaws.com/prod-ucs-content-store-eu-west/content/pii:S0889854518X00023/cover/DOWNSAMPLED200/image/gif/f6b53b23788a187c1a29c453a7d0d6d5/cov200h.gif","https://s3.amazonaws.com/prod-ucs-content-store-us-east/content/pii:S0889854518X00023/cover/DOWNSAMPLED200/image/gif/f6b53b23788a187c1a29c453a7d0d6d5/cov200h.gif"],"attachment-type":"IMAGE-COVER-H200","filesize":"13436","pixel-height":"200","pixel-width":"126"},{"attachment-eid":"1-s2.0-S0889854518X00023-cov150h.gif","file-basename":"cov150h","extension":"gif","filename":"cov150h.gif","ucs-locator":["https://s3-eu-west-1.amazonaws.com/prod-ucs-content-store-eu-west/content/pii:S0889854518X00023/cover/DOWNSAMPLED/image/gif/6e75ef06d6b9bf718f83f6290d77f018/cov150h.gif","https://s3.amazonaws.com/prod-ucs-content-store-us-east/content/pii:S0889854518X00023/cover/DOWNSAMPLED/image/gif/6e75ef06d6b9bf718f83f6290d77f018/cov150h.gif"],"attachment-type":"IMAGE-COVER-H150","filesize":"11316","pixel-height":"150","pixel-width":"94"}]},"smallCoverUrl":"https://ars.els-cdn.com/content/image/S08898545.gif","sourceOpenAccess":false,"publicationCoverImageUrl":"https://ars.els-cdn.com/content/image/1-s2.0-S0889854518X00023-cov150h.gif"},"pii":"S0889854518300093","dates":{"Available online":"7 May 2018","Revised":[],"Publication date":"1 June 2018"},"access":{},"crawlerInformation":{"canCrawlPDFContent":false,"isCrawler":false},"accessOptions":{"purchaseSection":{"link":"/science?_ob=ShoppingCartURL&_method=add&_eid=1-s2.0-S0889854518300093&originContentFamily=serial&_origin=article&_ts=1527695761&md5=841b152961117bf2678c8ea359595852","linkText":{"parameters":[],"key":"purchase_message_no_remote_access"}},"accessHeader":{"parameters":[],"key":"access_header_no_remote_access"},"outwardLinksSection":{"linkingHubUrl":"https://linkinghub.elsevier.com/retrieve/pii/S0889854518300093?showall=true","outwardLinksRequestData":"%7B%22transID%22%3A%22arp-aa398d35-b69f-46cb-b253-1aced20a58a1%22%2C%22pageMetaData%22%3A%7B%22eid%22%3A%221-s2.0-S0889854518300093%22%2C%22pii%22%3A%22S0889854518300093%22%2C%22cid%22%3A%22273330%22%7D%7D"},"checkAccessSection":{"message":{"parameters":[],"key":"check_access_message_no_remote_access"}}},"analyticsMetadata":{"accountId":"228598","accountName":"ScienceDirect Guests","loginStatus":"anonymous","userId":"12975512"},"cid":"273330","content-family":"serial","copyright-line":"© 2018 Elsevier Inc. All rights reserved.","cover-date-years":["2018"],"cover-date-start":"2018-06-01","cover-date-text":"June 2018","document-subtype":"rev","document-type":"article","eid":"1-s2.0-S0889854518300093","doi":"10.1016/j.ogc.2018.01.009","first-fp":"187","hub-eid":"1-s2.0-S0889854518X00023","issuePii":"S0889854518X00023","iss-first":"2","item-weight":"FULL-TEXT","language":"en","last-lp":"200","last-author":{"#name":"last-author","$":{"xmlns:dm":true},"$$":[{"#name":"author","$":{"xmlns:ce":true,"id":"au2","author-id":"S0889854518300093-61137ad49ff38956e710c926033180f2"},"$$":[{"#name":"given-name","_":"Erika"},{"#name":"surname","_":"Peterson"},{"#name":"degrees","_":"MD"}]}]},"normalized-first-auth-initial":"A","normalized-first-auth-surname":"MCCORMICK","open-research":{"#name":"open-research","$":{"xmlns:xocs":true},"$$":[{"#name":"or-embargo-opening-date","_":"2019-05-07T00:00:00.000Z"}]},"pages":[{"last-page":"200","first-page":"187"}],"srctitle":"Obstetrics and Gynecology Clinics of North America","timestamp":"2018-05-08T00:18:11.31846Z","title":{"content":[{"#name":"article-footnote","$":{"xmlns:ce":true,"id":"aep-article-footnote-id1"},"$$":[{"#name":"note-para","$":{"id":"ntpara0010","view":"all"},"_":"The authors have no commercial or financial conflicts of interest to disclose."}]},{"#name":"title","$":{"xmlns:ce":true,"id":"title0010"},"_":"Cancer in Pregnancy"}],"floats":[],"footnotes":[{"#name":"article-footnote","$":{"xmlns:ce":true,"id":"aep-article-footnote-id1"},"$$":[{"#name":"note-para","$":{"id":"ntpara0010","view":"all"},"_":"The authors have no commercial or financial conflicts of interest to disclose."}]}],"attachments":[]},"vol-first":"45","vol-iss-suppl-text":"Volume 45, Issue 2","userSettings":{"forceAbstract":false,"creditCardPurchaseAllowed":true,"preventTransactionalAccess":false,"preventDocumentDelivery":true},"contentType":"JL","crossmark":true,"issn":"08898545","issn-primary-formatted":"0889-8545","useEnhancedReader":false,"isbn-primary-formatted":null,"isbn-primary-unformatted":"9780323584074","pdfPreview":{"link":"/sdfe/pdf/download/eid/1-s2.0-S0889854518300093/first-page-pdf","previewImageLink":"https://ars.els-cdn.com/content/image/1-s2.0-S0889854518300093-main_1.png"},"isCorpReq":false,"pdfDownload":{"linkType":"PURCHASE","linkToPdf":"/science?_ob=ShoppingCartURL&_method=add&_eid=1-s2.0-S0889854518300093&originContentFamily=serial&_origin=article&_ts=1527695761&md5=841b152961117bf2678c8ea359595852","isPdfFullText":false,"fileName":"1-s2.0-S0889854518300093-main.pdf"},"indexTag":true,"volRange":"45","issRange":"2","ssoUrls":["//acw.scopus.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f","//acw.sciencedirect.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f","//acw.mendeley.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f","//acw.sciverse.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f","//acw.evise.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f","//acw.elsevier.com/SSOCore/update?acw=6d7354a27029b24cc24a5d8381fd2a31da28gxrqa%7C%24%7C975956DA96422F3545464E03C5DA04F45D65D2A2835E4D1722D43D0C230F7AE64D5D6E935642DEBEDCFE5A7F6633886C6207814E3BFEEE023FBA44D1BD4E4F2EB0469A67597464825D387A21AFA2E514&utt=3354-7b653b1b361ead85a4-9b0af24349587b8f"],"userProfile":{"departmentName":"ScienceDirect Guests","accessType":"GUEST","accountId":"228598","webUserId":"12975512","accountName":"ScienceDirect Guests","departmentId":"291352","userType":"NORMAL","hasMultipleOrganizations":false},"entitlementReason":"unsubscribed","articleEntitlement":{"entitled":false},"aipType":"none","downloadFullIssue":false,"headerConfig":{"helpUrl":"https://service.elsevier.com/app/home/supporthub/sciencedirect/","contactUrl":"https://service.elsevier.com/app/contact/supporthub/sciencedirect/","userName":"","orgName":"","webUserId":"12975512","libraryBanner":{},"shib_regUrl":"","tick_regUrl":"","recentInstitutions":[],"canActivatePersonalization":false,"hasMultiOrg":false,"userType":"GUEST","allowCart":true},"titleString":"Cancer in Pregnancy","isAbstract":false,"onAbstractWhitelist":false,"isContentVisible":false,"ajaxLinks":{"citingArticles":true,"referredToBy":true,"toc":true,"specialIssueArticles":true,"recommendations":true}},"specialIssueArticles":{},"recommendations":{},"entitledRecommendations":{"isOpen":false,"articles":[],"selected":[],"currentPage":1,"totalPages":2},"citingArticles":{},"workspace":{"isOpen":false},"crossMark":{"isOpen":false},"userIdentity":{},"refersTo":{},"referredToBy":{},"downloadIssue":{"isOpen":false,"articles":[],"selected":[]},"references":{},"referenceLinks":{"internal":{},"external":{}},"glossary":{},"relatedContent":{"isModal":false,"isOpenSpecialIssueArticles":true,"isOpenRecommendations":false,"isOpenCitingArticles":false,"citingArticles":[false,false,false],"recommendations":[false,false,false],"specialIssueArticles":[false,false,false]},"banner":{"expanded":false},"transientError":{"isOpen":false},"pdfDropdown":{},"exportCitation":{"isOpen":false},"tableOfContents":{"showEntitledTocLinks":false},"chapters":[],"enrichedContent":{"tableOfContents":false,"researchData":{"hasResearchData":false,"dataProfile":{},"openData":{},"mendeleyData":{},"databaseLinking":{}},"geospatialData":{"attachments":[]},"interactiveCaseInsights":{},"virtualMicroscope":{}},"metrics":{"isOpen":true},"signOut":{"isOpen":false},"issueNavigation":{"previous":{},"next":{}},"tail":{}}
                    String data = ((DataNode) node).getWholeData();
                    // jsonObject -> "author-group"
                    JSONObject jsonObject= JsonPath.read(data, "$.authors.content[0]");
                    System.out.println();
                    JSONArray jsonArray = (JSONArray) jsonObject.get("$$");
                    String name = "";
                    String email = "";
                    // extract AuthorName and AuthorEmail looping on all the authors
                    for (int i=0;i<jsonArray.size();i++) {
                        // jsonObject1 -> "author"
                        JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
//                        System.out.println();
                        String s = (String) jsonObject1.get("#name");
                        if (s.equals("author")) {
                            JSONArray jsonArray1 = (JSONArray) jsonObject1.get("$$");
                            for (int j=0;j<jsonArray1.size();j++) {
                                JSONObject jsonObject2 = (JSONObject) jsonArray1.get(j);
                                if (jsonObject2.get("#name").equals("given-name")) {
                                    name = name + jsonObject2.get("_");
                                } else if(jsonObject2.get("#name").equals("surname")) {
                                    name = name + " " + jsonObject2.get("_");
                                } else if(jsonObject2.get("#name").equals("e-address")) {
                                    email = (String) jsonObject2.get("_");
                                } else {

                                }
                            }
                            if (email.length() != 0) {
                                break;
                            } else {
                                name = "";
                            }
                        }
                    }
                    journalMetadata = doc.title();
                    if (journalMetadata.indexOf(" - ScienceDirect") != -1) {
                        journalMetadata = journalMetadata.substring(0, journalMetadata.indexOf(" - ScienceDirect"));
                    }
                    journalMetadata = journalMetadata + ",";
                    journalMetadata = journalMetadata + name + "," + email + "\n";
//                JSONObject jsonObject = new JSONObject(data);
//                x.authors.content[0].$$
                }
                //            log("%s\n\t%s",
//                    headline.attr("title"), headline.absUrl("href"));
            }

            System.out.println(journalMetadata);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "] processing journals for \"" + journalUrl + "\"; Ignoring");
        }
    }
    public static void main(String[] args)  throws Exception {
        JsoupTrial jsoupTrial = new JsoupTrial();
        jsoupTrial.processUrl("https://www.sciencedirect.com/search/advanced?qs=cancer&date=2018&show=25&sortBy=relevance");
    }
}
