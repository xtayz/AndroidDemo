package com.zhanghao.androiddemo.chapter9;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkTest extends BaseActivity {

    @BindView(R.id.response_text)
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_test);
    }

    @OnClick({ R.id.send_request1, R.id.send_request2, R.id.parse_xml1, R.id.parse_xml2, R.id.parse_json1, R.id.parse_json2 })
    void onClickedButton(View v) {

        String xmlData = "<apps> \n" +
                "  <app> \n" +
                "    <id>1</id>  \n" +
                "    <name>Google Maps</name>  \n" +
                "    <version>1.0</version> \n" +
                "  </app>  \n" +
                "  <app> \n" +
                "    <id>2</id>  \n" +
                "    <name>Chrome</name>  \n" +
                "    <version>2.0</version> \n" +
                "  </app>  \n" +
                "  <app> \n" +
                "    <id>3</id>  \n" +
                "    <name>Google Play</name>  \n" +
                "    <version>3.0</version> \n" +
                "  </app> \n" +
                "</apps>";

        String jsonData = "[\n" +
                "    {\n" +
                "        \"id\": 5,\n" +
                "        \"name\": \"Clash of CLans\",\n" +
                "        \"version\": 5.5\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 6,\n" +
                "        \"name\": \"Boom Beach\",\n" +
                "        \"version\": 7.5\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 7,\n" +
                "        \"name\": \"Clash Royale\",\n" +
                "        \"version\": 3.5\n" +
                "    }\n" +
                "]";

        switch (v.getId()) {
            case R.id.send_request1:
                sendRequestWithHttpURLConnection();
                break;
            case R.id.send_request2:
                sendRequestWithOkHttp();
                break;
            case R.id.parse_xml1:

                parseXMLWithPull(xmlData);
                break;
            case R.id.parse_xml2:
                parseXMLWithSAX(xmlData);
                break;
            case R.id.parse_json1:
                parseJSONWithJSONObject(jsonData);
                break;
            case R.id.parse_json2:
                parseJSONWithGSON(jsonData);
                break;
            default:
                break;
        }
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>(){}.getType());
        String result = "";
        for (App app : appList) {
            result += String.format("id = %s, name = %s, version = %s\n", app.getId(), app.getName(), app.getVersion());
        }
        showResponse(result);
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            String result = "";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                result += String.format("id = %s, name = %s, version = %s\n", id, name, version);
            }
            showResponse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            XmlContentHandler handler = new XmlContentHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
            showResponse(TextUtils.join("\n", handler.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            String result = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("app".equals(nodeName)) {
                            result += String.format("id = %s, name = %s, version = %s\n", id, name, version);
                        }
                        showResponse(result);
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.baidu.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }

}
