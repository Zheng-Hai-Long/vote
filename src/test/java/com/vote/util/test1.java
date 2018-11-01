package com.vote.util;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/5/26.
 */
public class test1 {

    //根据url地址获取对应页面的HTML内容，我们将上一节中的内容打包成了一个方法，方便调用
    private static String getHTMLContent( String url ) throws IOException {

        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet(url);

        //获取网址的返回结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获取返回结果中的实体
        HttpEntity entity = response.getEntity();

        String content = EntityUtils.toString(entity);

        //关闭HttpEntity流
        EntityUtils.consume(entity);

        return content;

    }

    public static void main(String[] args) {

        /*String url = "http://news.163.com/";//"http://www.datalearner.com/blog_list";
        String rawHTML = null;
        try {
            rawHTML = getHTMLContent(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将当前页面转换成Jsoup的Document对象
        Document doc = Jsoup.parse(rawHTML);

        //获取所有的博客列表集合
        Elements blogList = doc.select("div[id=js_top_news]");

       // String bigTile = blogList.get(0).select("h2").text();

        //System.out.println("BigTitle:\t"+bigTile);

        //针对每个博客内容进行解析，并输出
        for( Element element : blogList ){

            Elements elements1 = element.select("h2");

            for (Element element1 : elements1){

                String bigTile = element1.select("a").text();
                System.out.println("BigTitle:\t"+bigTile);

                Elements elements = element.select("ul");
                for (Element element2 : elements){
                    Elements elements2 = element2.select("li");
                    for (Element element3 : elements2){
                        String html =  element3.select("a").html();
                        System.out.println(html);
                    }
                }
                System.out.println("--------------------------");
            }

        }*/
       /* Short ss = 99S;
        float z = 10.0f;
        int i = "sss".length();
        char c = 17c;*/

        /*int i = 012;
        int j = 034;
        int k = (int)056l;
        //int l = 078;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);*/

        /*Character c = '0';
        int c2 = Character.getNumericValue(c);
        int c3 = (int) c;
        System.out.println(c3 + ";" +c2);*/

        /*int i = 5;
        System.out.println("Value is " + ((i <5)?10.9:9));*/
        char[] c = {'h','e','l','l','o'};
        change(c);
        System.out.print(c);
    }
    public static void change(char[] a){
        a[0] = 'c';
    }
}
class Value{
    public int i = 15;
}

 class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.first();
    }
    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public static void second(Value v, int i){
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }
}
