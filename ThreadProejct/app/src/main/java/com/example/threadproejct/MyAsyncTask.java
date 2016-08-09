package com.example.threadproejct;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by 한국정보기술 on 2016-08-04.
 */
public class MyAsyncTask extends AsyncTask<String,Integer,Void>{

    TextView txtView ;

    public MyAsyncTask(TextView txtView)
    {
        this.txtView = txtView;
    }

    @Override
    protected Void doInBackground(String... params) {
        Log.e("AsyncTask", "doInBackground() :" + params.length);

        for( int i =0 ; i< 100 ; i++)
        {
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.e("AsyncTask", "onProgressUpdate() : "+ values[0]);
        txtView.setText("WorkerThread "+ values[0]);

    }
    @Override
    protected void onPreExecute() {
        Log.e("AsyncTask", "onPreExecute()" );

        super.onPreExecute();
    }

    @Override
    protected void onCancelled() {
        Log.e("AsyncTask", "onCancelled()");
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Void aVoid) {
        Log.e("AsyncTask", "onCancelled(aVoid)");

        super.onCancelled(aVoid);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Log.e("AsyncTask", "onPostExecute()");
    }


}
