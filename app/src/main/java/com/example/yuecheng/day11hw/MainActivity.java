package com.example.yuecheng.day11hw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    String [] imageURI = new String []{"https://upload.wikimedia.org/wikipedia/commons/0/0e/Donald_Trump_Pentagon_2017.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/8/8d/President_Barack_Obama.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/2/27/Hillary_Clinton_official_Secretary_of_State_portrait_crop.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/c/cc/Xi_Jinping_March_2017.jpg",
            "https://upload.wikimedia.org/wikipedia/en/4/4b/Big_Hero_6_%28film%29_poster.jpg"};
    Random rn = new Random();
    int location=rn.nextInt(4);
    //Bitmap img_blue = BitmapFactory.decodeResource(getResources(), imageURI[location]);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);

        ImageDownloadTask task =  new ImageDownloadTask();
        //Bitmap result;

        try {
            task.execute(imageURI[location]).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            Bitmap image = null;

            try {
                url = new URL(strings[location]);
                //open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                //connect
                urlConnection.connect();
                InputStream stream = urlConnection.getInputStream();
                image = BitmapFactory.decodeStream(stream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return image;
        }

        protected void onPostExecute(Bitmap image) {

            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(image);

        }
    }

    public void btnClick(View view) {
        //Log.i("ID of button clicked: ", Integer.toString(view.getId()));//long string
        String btnID = view.getResources().getResourceEntryName(view.getId());
        if (location == 0 ) {
            if (btnID.equals("trump")) {
                Toast.makeText(this, "correct", Toast.LENGTH_LONG).show();
            }

            if (btnID.equals("obama")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("clinton")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("xi")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
        }

        if (location == 1 ) {
            if (btnID.equals("trump")) {
                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }

            if (btnID.equals("obama")) {

                Toast.makeText(this, "correct", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("clinton")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("xi")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
        }

        if (location == 2 ) {
            if (btnID.equals("trump")) {
                Toast.makeText(this, "correct", Toast.LENGTH_LONG).show();
            }

            if (btnID.equals("obama")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("clinton")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("xi")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
        }

        if (location == 3 ) {
            if (btnID.equals("trump")) {
                Toast.makeText(this, "correct", Toast.LENGTH_LONG).show();
            }

            if (btnID.equals("obama")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("clinton")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("xi")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
        }

        if (location == 4 ) {
            if (btnID.equals("trump")) {
                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }

            if (btnID.equals("obama")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("clinton")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
            if (btnID.equals("xi")) {

                Toast.makeText(this, "wrong", Toast.LENGTH_LONG).show();
            }
        }


        }

    public void imgFunction(View view) {
        Random rn = new Random();
        location=rn.nextInt(4);

    }


}


