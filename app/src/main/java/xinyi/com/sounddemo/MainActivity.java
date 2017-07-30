package xinyi.com.sounddemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        org.fmod.FMOD.init(this);

        String s= Environment.getExternalStorageDirectory().getAbsolutePath();
        file=new File(s+"/test.mp3");

        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        play(file.getAbsolutePath(),1);
                    }
                }).start();
                break;
            case R.id.button2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        play(file.getAbsolutePath(),2);
                    }
                }).start();
                break;
            case R.id.button3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        play(file.getAbsolutePath(),4);
                    }
                }).start();
                break;
        }
    }
    public  native void  play(String name,int type);

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("fmod");
        System.loadLibrary("fmodL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        org.fmod.FMOD.close();
    }
}
