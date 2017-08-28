package pro.mike.com.clase24agosto;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Handler handler;
    int s = 0;
    int m = 0;
    int h = 0;
    boolean isPaused = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
    }

    public void start(View view){
        Button stop = (Button) findViewById(R.id.stop);

        final Runnable r = new Runnable(){

            TextView seg = (TextView) findViewById(R.id.seconds);
            TextView min = (TextView) findViewById(R.id.minutes);
            TextView hor = (TextView) findViewById(R.id.hours);

            Button reset = (Button) findViewById(R.id.reset);

            public void run() {
                s++;
                // Toast.makeText(getApplicationContext(),"Pro", Toast.LENGTH_SHORT).show();
                if(s>=60){
                    s = 0;
                    m++;
                }
                if(m>=60){
                    m = 0;
                    h++;
                    s=0;
                }
                if(s<10){
                    seg.setText("0" + s);
                }else{
                    seg.setText("" + s);
                }

                if(m<10){
                    min.setText("0" + m);

                }else{
                    min.setText("" + m);

                }

                if(h<10){
                    hor.setText("0"+ h);
                }else{
                    hor.setText(""+ h);

                }

                handler.postDelayed(this,1000);
            }//fin run
        };//fin runnable

        //start
        //if(handler.i)
        handler.postDelayed(r,1000);

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               handler.removeCallbacks(r);
            }
        });

    }
    public void reset(View view){
        s = 0;
        m = 0;
        h = 0;
    }
}
