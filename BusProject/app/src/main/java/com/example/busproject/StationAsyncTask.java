package com.example.busproject;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-05.
 */
public class StationAsyncTask extends AsyncTask<String,Void,List<StationVO>> {

    Activity activity;
    String busRouteNm = null;
    String busRouteId = null;

    public StationAsyncTask(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(List<StationVO> list) {
        super.onPostExecute(list);

        CurrentStation_AsynTask cs_AsyncTask = new CurrentStation_AsynTask(activity, list);
        cs_AsyncTask.execute(busRouteId);
    }

    @Override
    protected List<StationVO> doInBackground(String... arg){

        try {
            busRouteId = arg[0];
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=9uoXYhyW1UhCm%2BJO7Z%2Fp%2Fe7jsOygg1%2FALaPexAJij6Lmv%2FPkhzkNH2YnZ0LcTp6qE2iBVV%2Fh7T76LUCv25vUfQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(arg[0], "UTF-8")); /*노선ID*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("999", "UTF-8")); /*검색건수*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            URL url = new URL(urlBuilder.toString());

            // Server에 연결 시키는 것.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            // 응답 결과를 확인 하는 코드
            // 200 : 성공
            // 404 : Page Not Find
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

                // XmlPullParserFactory의 SingleTon 형태
                XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();

                // 공장에서 하나의 parser 생성
                XmlPullParser parser = parserFactory.newPullParser();

                // HttpURLConnection의 InputStream 가져오고, UTF-8로 인코딩
                parser.setInput(conn.getInputStream(), "UTF-8");

                int event = parser.getEventType();
                StationVO station = null;

                List<StationVO> stationList = new ArrayList<StationVO>();
                Log.e("BusInfo", "StationNumber : " + arg[0]);
                while (event != XmlPullParser.END_DOCUMENT) {
                    switch (event) {
                        case XmlPullParser.START_TAG:
                            String tagName = parser.getName();

                            if (tagName.equals("beginTm")) {
                                station = new StationVO();
                                parser.next();
                                String tagText = parser.getText();
                                station.setBeginTm(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            } else if (tagName.equals("lastTm")) {
                                parser.next();
                                String tagText = parser.getText();
                                station.setLastTm(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            }else if (tagName.equals("section")) {
                                parser.next();
                                String tagText = parser.getText();
                                station.setSectionId(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            }else if (tagName.equals("stationNm")) {
                                parser.next();
                                String tagText = parser.getText();
                                station.setStationNm(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            } else if (tagName.equals("stationNo")) {
                                parser.next();
                                String tagText = parser.getText();
                                station.setStationNo(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);
                                stationList.add(station);
                            }
                            break;
                    }
                    event = parser.next();
                }
                conn.disconnect();
                return stationList;
            }
        }  catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;
    }
}
