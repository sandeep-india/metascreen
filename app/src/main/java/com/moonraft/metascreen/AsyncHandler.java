//package com.moonraft.metascreen;
//
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//import android.util.Base64;
//import android.widget.ImageView;
//import android.app.Activity;
//
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.ImageView;
//import android.graphics.BitmapFactory;
//import android.util.Base64;
//import org.java_websocket.client.WebSocketClient;
//import org.java_websocket.handshake.ServerHandshake;
//import android.os.*;
//import android.os.Process;
//import java.net.URI;
//import java.net.URISyntaxException;
//import android.app.ActivityManager;
//
//
//
//
//
//public class AsyncHandler extends AsyncTask<String, byte[], byte[]>  {
//
//     byte[] imageAsBytes;
//     String message;
//    ImageView image;
//    //@Override
//    protected byte[] doInBackground(String... strings) {
//       // imageAsBytes = null;
//       // imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
//        //byte[] imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
//        //ImageView image = (ImageView) findViewById(R.id.ImageView);
//        //image = null;
//        //publishProgress();
//      //
//        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
//
//        System.out.println("Am the cause");
//        return imageAsBytes;
//    }
//
//    @Override
//    protected void onPostExecute(byte[] k) {
//        super.onPostExecute(k);
//        image = (ImageView) findViewById(R.id.ImageView);
//        image.setImageBitmap(BitmapFactory.decodeByteArray(k, 0, k.length));
//    }
//}
