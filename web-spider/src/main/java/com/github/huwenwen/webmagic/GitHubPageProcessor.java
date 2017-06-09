package com.github.huwenwen.webmagic;

import com.alibaba.fastjson.JSON;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author huwenwen
 * @since 2017/4/19
 */
public class GitHubPageProcessor implements PageProcessor {

  private Site site = Site.me().setRetryTimes(3).setSleepTime(0);

  public void process(Page page) {
    GithubBean githubBean = new GithubBean();
    if (page.getStatusCode() != 200) {
      page.setSkip(true);
    }
    if (page.getResultItems().getRequest().getExtra("statusCode") != "200") {
      page.setSkip(true);
    }
    githubBean.setAuthor(page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
    githubBean.setName(
        page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
    githubBean.setReadme(page.getHtml().xpath("//div[@id='readme']/tidyText()").toString());
    String styleStr = "//div[@role='main']/div/div/div/div/ul/";
    githubBean.setStart(
        page.getHtml().xpath(styleStr + "li[2]/a[2]/@aria-label")
            .toString());
    githubBean.setWatch(page.getHtml().xpath(styleStr + "li[1]/a[2]/@aria-label").toString());
    githubBean.setFork(page.getHtml().xpath(styleStr + "li[3]/a[2]/@aria-label").toString());
    if (githubBean.getStart() == null) {
      //skip this page
      page.setSkip(true);
    } else {
      page.putField("repo", JSON.toJSONString(githubBean));
    }

    // 从页面发现后续的url地址来抓取
    page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//    page.addTargetRequests(
//        page.getHtml().links().regex("https://github\\.com/\\w+(-\\w)*/\\w+(-\\w)*").all());
  }

  public Site getSite() {
    return site;
  }

  public static void main(String[] args) {
    Spider spider = Spider.create(new GitHubPageProcessor()).addUrl("https://github.com/huwenwen");
//    spider.addPipeline(new FilePipeline("/data/webmagic"));
    spider.thread(100).run();
  }
}
