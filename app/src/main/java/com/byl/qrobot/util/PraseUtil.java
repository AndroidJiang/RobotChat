package com.byl.qrobot.util;

import com.byl.qrobot.bean.Answer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * 处理InfoItem的业务类
 */
public class PraseUtil {

    /**
     * 解析机器人回复信息
     * 100000	文本类
     * 200000	链接类
     * 302000	新闻类
     * 308000	菜谱类
     * 313000（儿童版）	儿歌类
     * 314000（儿童版）	诗词类
     *
     * @param result
     * @return
     */
    public static Answer praseMsgText(String result) {
        Answer answer;
        JSONObject jsonObject;
        try {
            answer = new Answer();
            jsonObject = (JSONObject) new JSONTokener(result).nextValue();
            answer.setJsoninfo(result);
            answer.setCode(jsonObject.optString("code"));
            //因为本人的key使用的是上线项目《聊天小公主》中的key，机器人名称被本人设定为了“小公主”，因此需要替换一下（个人重新申请的key不用替换）
            answer.setText(jsonObject.optString("text").replace("小公主", "小Q"));
            switch (answer.getCode()) {
                case "40001"://参数key错误
                case "40002"://请求内容info为空
                case "40004"://当天请求次数已使用完
                case "40007"://数据格式异常
                case "100000":
                    //因text 字段 各类型都会返回，answer.setText已做处理，因此这里不做处理
                    break;
                case "200000":
                    answer.setUrl(jsonObject.optString("url"));
                    break;
            /*    case "302000":
                    try {
                        JSONArray listArray = jsonObject.getJSONArray("list");
                        List<News> listNews=new ArrayList<>();
                        for (int i = 0; i < listArray.length(); i++) {
                            jsonObject = listArray.getJSONObject(i);
                            News news=new News();
                            news.setArticle(jsonObject.optString("article"));
                            news.setIcon(jsonObject.optString("icon"));
                            news.setSource(jsonObject.optString("source"));
                            news.setDetailurl(jsonObject.optString("detailurl"));
                            listNews.add(news);
                        }
                        answer.setListNews(listNews);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "308000":
                    try {
                        JSONArray listArray = jsonObject.getJSONArray("list");
                        List<Cook> listCook=new ArrayList<>();
                        for (int i = 0; i < listArray.length(); i++) {
                            jsonObject = listArray.getJSONObject(i);
                            Cook cook=new Cook();
                            cook.setName(jsonObject.optString("name"));
                            cook.setIcon(jsonObject.optString("icon"));
                            cook.setInfo(jsonObject.optString("info"));
                            cook.setDetailurl(jsonObject.optString("detailurl"));
                            listCook.add(cook);
                        }
                        answer.setListCook(listCook);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;*/
            }

        } catch (Exception e) {
            return null;
        }
        return answer;
    }

    public static String parseIatResult(String json) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);
            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                // 转写结果词，默认使用第一个结果
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                JSONObject obj = items.getJSONObject(0);
                ret.append(obj.getString("w"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret.toString();
    }

}
