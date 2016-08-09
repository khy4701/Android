package com.example.busproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
 * Created by 한국정보기술 on 2016-08-04.
 */
public class BusListAsyncTask extends AsyncTask<String,BusVO, List<BusVO>> {

    Activity activity;

    public BusListAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onProgressUpdate(BusVO... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(final List<BusVO> busVOs) {
        super.onPostExecute(busVOs);

        ListView listview = (ListView) activity.findViewById(R.id.listView);
        // Adapter
        MyAdapter adapter = new MyAdapter(activity, R.layout.item ,busVOs);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(activity,StationActivity.class);
                intent.putExtra("status", "showAll");
                intent.putExtra("busRouteId", busVOs.get(position).getBusRouteId());
                intent.putExtra("busRouteNm", busVOs.get(position).getBusRoutNm());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<BusVO> doInBackground(String... arg) {

        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=9uoXYhyW1UhCm%2BJO7Z%2Fp%2Fe7jsOygg1%2FALaPexAJij6Lmv%2FPkhzkNH2YnZ0LcTp6qE2iBVV%2Fh7T76LUCv25vUfQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("strSrch", "UTF-8") + "=" + URLEncoder.encode(arg[0], "UTF-8")); /*검색할 노선번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("999", "UTF-8")); /*검색건수*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
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
                BusVO bus = null;

                List<BusVO> busList = new ArrayList<BusVO>();
                Log.e("BusInfo", "BusNumber : " + arg[0]);
                while (event != XmlPullParser.END_DOCUMENT) {
                    switch (event) {
                        case XmlPullParser.START_TAG:
                            String tagName = parser.getName();

                            if (tagName.equals("busRouteId")) {
                                bus = new BusVO();
                                parser.next();
                                String tagText = parser.getText();
                                bus.setBusRouteId(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            } else if (tagName.equals("busRouteNm")) {
                                parser.next();
                                String tagText = parser.getText();
                                bus.setBusRoutNm(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);

                            } else if (tagName.equals("routeType")) {
                                parser.next();
                                String tagText = parser.getText();
                                bus.setRouteType(tagText);
                                Log.e("TagName - TagText", tagName + " - " + tagText);
                                busList.add(bus);
                            }
                            break;
                    }
                    event = parser.next();
                }
                conn.disconnect();
                return busList;
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
