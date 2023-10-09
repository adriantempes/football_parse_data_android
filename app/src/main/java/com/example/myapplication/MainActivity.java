package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText resultText;
    int currentFile = 0;
    String result[] = new String[4];
    String join;
    Button buttonGetData;
    String old;
    ArrayList<String> paths = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editUrl = findViewById(R.id.edit_text);
         buttonGetData = findViewById(R.id.button);
         buttonGetData.setOnClickListener(v -> {
//
             ArrayList<String> invoke = null;
             try {
                 invoke = new Read().execute("https://www.pesmaster.com/stade-rennais-fc/efootball-2022/team/218/").get();
             } catch (ExecutionException e) {
                 throw new RuntimeException(e);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }


                for (int i = 0; i < invoke.size(); i++) {
                    new PareseURL().execute(new String[]{invoke.get(i), "" + i});

            }
        });

    }

    public class PareseURL extends AsyncTask<String, Void, String> {

        String path;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showProgessDialog();
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuffer buffer = new StringBuffer();
//            buttonGetData.setOnClickListener(v -> {
//                String joined  = TextUtils.join(", ", paths);
//                buffer.append("1231321312"+"\n");
//                String[] path = new String[]{
//                        joined
//                };
//                for (int i = 0; i <path.length ; i++) {
//                    new PareseURL().execute(new String[]{path[i],""+i});
//                }
//            });

            try {

                    Document document = Jsoup.connect(params[0]).get();

//
////                buffer.append(name.text()+"\n");
//                for (Element data_name : name) {
//                    for (int i = 0; i<18 ; i++) {
//                        String data = data_name.child(i).text();
//                        buffer.append(data + "\n");
//                    }
//                }

////       ability
                    Elements offensive_awareness = document.select("span.offensive_awareness");
                    Elements finishing = document.select("span.finishing");
                    Elements kicking_power = document.select("span.kicking_power");
                    Elements ball_control = document.select("span.ball_control");
                    Elements dribbling = document.select("span.dribbling");
                    Elements tight_possession = document.select("span.tight_possession");
                    Elements balance = document.select("span.balance");
                    Elements heading = document.select("span.heading");
                    Elements jumping = document.select("span.jumping");
                    Elements defensive_awareness = document.select("span.defensive_awareness");
                    Elements tackling = document.select("span.tackling");
                    Elements defensive_engagement = document.select("span.defensive_engagement");
                    Elements aggression = document.select("span.aggression");
                    Elements low_pass = document.select("span.low_pass");
                    Elements lofted_pass = document.select("span.lofted_pass");
                    Elements set_piece_taking = document.select("span.set_piece_taking");
                    Elements curl = document.select("span.curl");
                    Elements speed = document.select("span.speed");
                    Elements acceleration = document.select("span.acceleration");
                    Elements physical_contact = document.select("span.physical_contact");
                    Elements stamina = document.select("span.stamina");
                    Elements gk_awareness = document.select("span.gk_awareness");
                    Elements gk_catching = document.select("span.gk_catching");
                    Elements gk_parrying = document.select("span.gk_parrying");
                    Elements gk_reflexes = document.select("span.gk_reflexes");
                    Elements gk_reach = document.select("span.gk_reach");
                    Elements tactic_possession_game = document.select("span.tactic_possession_game");
                    Elements tactic_quick_counter = document.select("span.tactic_quick_counter");
                    Elements tactic_long_ball_counter = document.select("span.tactic_long_ball_counter");
                    Elements tactic_out_wide = document.select("span.tactic_out_wide");
                    Elements tactic_long_ball = document.select("span.tactic_long_ball");

                    Elements player_info = document.select("   table.player-info > tbody");

//  13 position
                    Elements gk = document.select(" div.player-positions-row");
                    Elements lb = document.select(" div.player-positions-row");
                    Elements cb = document.select(" div.player-positions-row");
                    Elements rb = document.select(" div.player-positions-row");
                    Elements lmf = document.select(" div.player-positions-row");
                    Elements dmf = document.select(" div.player-positions-row");
                    Elements cmf = document.select(" div.player-positions-row");
                    Elements amf = document.select(" div.player-positions-row");
                    Elements rmf = document.select("div.player-positions-row");
                    Elements lwf = document.select(" div.player-positions-row");
                    Elements ss = document.select(" div.player-positions-row");
                    Elements cf = document.select(" div.player-positions-row");
                    Elements rwf = document.select(" div.player-positions-row");

//playing style
                    Elements playing_style = document.select(" div.cards-container.flex.flex-expand");
                    Elements middle = document.select("div.player-main-column.player-info-column > table.player-info > tbody ");
                    Elements ovr = document.select(" li.versions-list-el");
                    Elements s_name = document.select("div.content-container");
                    Elements f_name = document.select("h2.subtle-text");
                    Elements player_skill = document.select(" div.cards-container.flex.flex-expand");

                    buffer.append((f_name.text()).replace("eFootball 2022 Stats", "") + ", ");
                    buffer.append(offensive_awareness.text() + ", ");
                    buffer.append(finishing.text() + ", ");
                    buffer.append(kicking_power.text() + ", ");
                    buffer.append(ball_control.text() + ", ");
                    buffer.append(dribbling.text() + ", ");
                    buffer.append(tight_possession.text() + ", ");
                    buffer.append(balance.text() + ", ");
                    buffer.append(heading.text() + ", ");
                    buffer.append(jumping.text() + ", ");
                    buffer.append(defensive_awareness.text() + ", ");
                    buffer.append(tackling.text() + ", ");
                    buffer.append(defensive_engagement.text() + ", ");
                    buffer.append(aggression.text() + ", ");
                    buffer.append(low_pass.text() + ", ");
                    buffer.append(lofted_pass.text() + ", ");
                    buffer.append(set_piece_taking.text() + ", ");
                    buffer.append(curl.text() + ", ");
                    buffer.append(speed.text() + ", ");
                    buffer.append(acceleration.text() + ", ");
                    buffer.append(physical_contact.text() + ", ");
                    buffer.append(stamina.text() + ", ");
                    buffer.append(gk_awareness.text() + ", ");
                    buffer.append(gk_catching.text() + ", ");
                    buffer.append(gk_parrying.text() + ", ");
                    buffer.append(gk_reflexes.text() + ", ");
                    buffer.append(gk_reach.text() + ", ");
                    buffer.append(tactic_possession_game.text() + ", ");
                    buffer.append(tactic_quick_counter.text() + ", ");
                    buffer.append(tactic_long_ball_counter.text() + ", ");
                    buffer.append(tactic_out_wide.text() + ", ");
                    buffer.append(tactic_long_ball.text() + ", ");
                    buffer.append(player_info.get(1).child(0).child(1).text() + ", ");
                    buffer.append(player_info.get(1).child(1).child(1).text() + ", ");
                    buffer.append(player_info.get(1).child(2).child(1).text() + ", ");
                    buffer.append(player_info.get(1).child(3).child(1).text() + ", ");
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Nationality")) {
                            buffer.append(middle.get(0).child(i).child(1).text() + ", ");
                            break;
                        }
                    }
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Age")) {
                            buffer.append(middle.get(0).child(i).child(1).text() + ", ");
                            break;
                        }
                    }
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Stronger Foot")) {
                            buffer.append(middle.get(0).child(i).child(1).text() + ", ");
                            break;
                        }
                    }
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Height (cm)")) {
                            buffer.append(middle.get(0).child(i).child(1).text() + ", ");
                            break;
                        }
                    }
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Weight")) {
                            buffer.append(middle.get(0).child(i).child(1).text() + ", ");
                            break;
                        }
                    }
                    buffer.append(ovr.get(0).child(0).text() + ", ");
                    buffer.append(s_name.get(0).child(0).child(0).child(0).child(0).child(4).text() + ", ");
                    for (int i = 0; i < middle.get(0).childNodeSize(); i++) {
                        if (middle.get(0).child(i).child(0).text().equals("Position")) {
                            buffer.append(middle.get(0).child(i).child(1).child(0).text() + ", ");
                            break;
                        }
                    }
                    buffer.append(lwf.get(0).child(0).child(1).text() + ", ");
                    buffer.append(ss.get(0).child(1).child(1).text() + ", ");
                    buffer.append(cf.get(0).child(2).child(1).text() + ", ");
                    buffer.append(rwf.get(0).child(3).child(1).text() + ", ");
                    buffer.append(lmf.get(1).child(0).child(1).text() + ", ");
                    buffer.append(dmf.get(1).child(1).child(1).text() + ", ");
                    buffer.append(cmf.get(1).child(2).child(1).text() + ", ");
                    buffer.append(amf.get(1).child(3).child(1).text() + ", ");
                    buffer.append(rmf.get(1).child(4).child(1).text() + ", ");
                    buffer.append(lb.get(2).child(0).child(1).text() + ", ");
                    buffer.append(cb.get(2).child(1).child(1).text() + ", ");
                    buffer.append(rb.get(2).child(2).child(1).text() + ", ");
                    buffer.append(gk.get(3).child(0).child(1).text() + ", ");

                    buffer.append(playing_style.get(0).child(0).child(1).text() + ", ");
                int size = player_skill.get(0).child(1).child(1).children().size();
                for (int i = 0; i < size ;i++){
                    buffer.append(player_skill.get(0).child(1).child(1).child(i).text() + ", ");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            hideProgressDialog();
            if (s != null){
                writefile(s);
            } else {
                resultText.setText("Error ?");
            }
        }


        public  void writefile(String text)
        {
            File externalStorageDir =  new File (Environment.getExternalStorageDirectory().getAbsolutePath()  + "/Download/eyedebug/" );
            String fileName=  System.currentTimeMillis() + ".txt" ;

            boolean statement = externalStorageDir.exists() && externalStorageDir.isDirectory();
            if(!statement) {
                // do something here
                externalStorageDir.mkdirs();
                System.out.println("file 1");
            }
            File myFile = new File(externalStorageDir.getAbsolutePath() ,   fileName  );
            if(!myFile.exists()){
                try {
                    myFile.createNewFile();
                    System.out.println("file 2");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                FileWriter fileWritter = new FileWriter(myFile,true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.append(text);
                bufferWritter.newLine();
                System.out.println("file 3");
                bufferWritter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public class Read extends AsyncTask<String, Void, ArrayList<String>> {
        ArrayList<String> list = new ArrayList<>();
        String data;
        String dataInvoke;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected ArrayList<String> doInBackground(String... params) {

            try {
                Document document1 = Jsoup.connect("https://www.pesmaster.com/stade-rennais-fc/efootball-2022/team/218/").get();
                Elements hehe = document1.select("div.main-container" );
                int gk = hehe.get(0).child(7).child(0).child(0).childNodeSize() - 2;
                int cb = hehe.get(0).child(9).child(0).child(0).childNodeSize() - 2;
                int mf = hehe.get(0).child(11).child(0).child(0).childNodeSize() - 2;
                int cf = hehe.get(0).child(13).child(0).child(0).childNodeSize() - 2;
                int size = gk + cb + mf + cf;
                Elements name = document1.select("figure.player-card.efootball-2022 > a");

                for (int i = 0; i < size; i++) {
                    data = name.get(i).attr("href");
                    list.add(
                            "https://www.pesmaster.com" + data
                    );
                    dataInvoke = "https://www.pesmaster.com" + data;
                }
                }
                catch (IOException e) {
                e.printStackTrace();
                    }
            return list;

        }

        @Override
        protected void onPostExecute(ArrayList<String> s) {
            super.onPostExecute(s);
//            hideProgressDialog();
            if (s != null){
                dataInvoke = TextUtils.join(", ", s);
            } else {
                resultText.setText("Error ?");
            }

        }


        }


}