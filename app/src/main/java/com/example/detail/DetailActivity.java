package com.example.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DetailActivity extends AppCompatActivity {

    private Intent intent;
    private String dist, link;
    TextView tview;
    ImageButton imagbtn;
    Context context;
    Document doc = null;
    LinearLayout layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.detail);

        tview = (TextView)findViewById(R.id.textView);
        imagbtn = (ImageButton)findViewById(R.id.imagebtn);
        layout = (LinearLayout)findViewById(R.id.layout);
        context = this;

        Integer[] cropID = {R.drawable.crop0, R.drawable.crop1, R.drawable.crop2, R.drawable.crop3,
                R.drawable.crop4, R.drawable.crop5, R.drawable.crop6};
        Integer[] ID={-1};

        int i;
        for(i=0;i<7;i++){
            ImageButton img = new ImageButton(context);

            img.setLayoutParams(new ViewGroup.LayoutParams(350,220));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(20,20,20,20);
            img.setBackgroundColor(Color.argb(0,0,0,0));
            img.setImageResource(cropID[i]);
            layout.addView(img);
        }


        intent= getIntent();
        dist = intent.getStringExtra("code");
        link = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + dist;
    }

    public void MyonClick(View view){
        GetXMLTask1 task = new GetXMLTask1();
        task.execute(link);
    }
    private class GetXMLTask1 extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML?????? ?????? ????????? ??????
                doc = db.parse(new InputSource(url.openStream())); //XML????????? ????????????.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }


        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data????????? ?????? ????????? ????????? ????????? ????????? ???????????? ??????
            NodeList nodeList = doc.getElementsByTagName("data");
            //data ????????? ????????? ????????? ??????, ???????????? ?????? ????????? ??????

            //?????? ???????????? ??????
            s += ""+ " ";

            Node node = nodeList.item(0); //data???????????? ??????
            Element fstElmnt = (Element) node;

            NodeList tempList = fstElmnt.getElementsByTagName("temp");
            s += "?????? : " + tempList.item(0).getChildNodes().item(0).getNodeValue() +"??? \n";

            NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
            s += "?????? = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n";
            switch (websiteList.item(0).getChildNodes().item(0).getNodeValue()){
                case "??????" :
                    imagbtn.setImageResource(R.drawable.sunny);
                    break;
                case "?????? ??????" :
                    imagbtn.setImageResource(R.drawable.cloudy);
                    break;
                case "?????? ??????" :
                    imagbtn.setImageResource(R.drawable.littlecloud);
                    break;
                case "??????" :
                    imagbtn.setImageResource(R.drawable.cloud);
                    break;
                case "???":
                    imagbtn.setImageResource(R.drawable.rain);
                    break;
                case "???" :
                    imagbtn.setImageResource(R.drawable.snow);
                    break;
                case "???/???" :
                    imagbtn.setImageResource(R.drawable.snowrain);
                    break;
            }
            NodeList moistList = fstElmnt.getElementsByTagName("reh");
            s += "?????? = "+  moistList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            NodeList percentList = fstElmnt.getElementsByTagName("pop");
            s += "???????????? = "+  percentList.item(0).getChildNodes().item(0).getNodeValue() +"% \n";

            tview.setText(s);

            super.onPostExecute(doc);
        }
    }

}
