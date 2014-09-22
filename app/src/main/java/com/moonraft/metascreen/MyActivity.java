package com.moonraft.metascreen;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import android.os.*;
import java.net.URI;
import java.net.URISyntaxException;
import android.graphics.Bitmap;
import android.util.Base64;
import java.nio.ByteBuffer;
import android.util.DisplayMetrics;
import android.graphics.BitmapFactory;

public class MyActivity extends Activity{
    private WebSocketClient mWebSocketClient;
   // byte[] imageAsBytes;
  //  byte[] imageAsBytes1;
      String message;
      //ByteBuffer message;
      //ByteBuffer imageAsBytes;
      ImageView image;
      Bitmap raw;
      int i = 0;
      byte[] imageAsBytes;
//      int width = 540;
//      int height = 670;
      //Bitmap raw = new Bitmap();





    //ImageView image;
    //int i = 0;
//    int j = 0;
//    ArrayList<byte[]> frame=new ArrayList<byte[]>();
//    final Handler handler = new Handler(Looper.getMainLooper());
//    static Timer timer = new Timer();
//    int frate = 15;
//    int period =  1000/frate;
//    int delay = 1000;
//    int max = 10000;

    public class AsyncHandler extends AsyncTask<String,byte[],Bitmap>  {

//        String[] message ;
//        Drawable toRecycle;


        @Override
        protected Bitmap doInBackground(String... bb) {



               //imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
                //byte[] imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);

               imageAsBytes=null;
               imageAsBytes = Base64.decode(bb[0].getBytes(), Base64.DEFAULT);
               //if(i==3) {
               raw = null;
               raw = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
               // }
               return raw;
            //raw = null;
//
//                imageAsBytes = bb[0];
//                raw.copyPixelsFromBuffer(imageAsBytes);
//
//                System.out.println("Am the cause");
//                return raw;


        }
//        }
//
        //@Override
        protected void onPostExecute(Bitmap k) {
            super.onPostExecute(k);
            //image = null;
            //image.invalidateDrawable();
            //image.refreshDrawableState();

            image.setImageBitmap(k);

            //image = (ImageView) findViewById(R.id.ImageView);

//            toRecycle= image.getDrawable();
////            toRecycle.setCallback(nulls);
//            if (toRecycle != null) {
//                System.gc();
//            }

            //((BitmapDrawable)image.getDrawable()).getBitmap().recycle();
            //image.setImageBitmap(null);

//            addInBitmapOptions(,k)
            //raw = BitmapFactory.decodeByteArray(k, 0, k.length);

        }
    }
//
//
////    AsyncHandler async=new AsyncHandler();
//
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        System.out.println("I am here");
        setContentView(R.layout.activity_my);
        image = (ImageView) findViewById(R.id.ImageView);

        //raw = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        connectWebSocket();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://10.0.0.102:8083");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                System.out.println("connected to the server");
                mWebSocketClient.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(String string){
                i++;

                if(i%10==0){
                  System.gc();
                }

                message = string;
                if (!(message == null)) {
                        runOnUiThread(new Runnable() {
                            //
////               Thread t=new Thread(){
////                   public void run(){
////                       android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
////                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
////                           // On UI thread.
////                           System.out.println("In UI-3");
////                        } else {
////                           // Not on UI thread.
////                           //message=null;
////                            System.out.println("We are in the secondary thread.");
////                        }
////
////                    }
////                Thread t=null;
////                };*/
//
                            @Override
                            public void run() {
                                new AsyncHandler().execute(message);
//                     new WeakReference(new AsyncHandler().execute(message));
//
////                        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
//
////                        imageAsBytes = null;
////                        //imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
////                        //byte[] imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        image = (ImageView) findViewById(R.id.ImageView);
////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
////                        image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes,0,imageAsBytes.length));
//                        //image = null;
////                        image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes,0,imageAsBytes.length));
////                          image = new ImageView();
////                        TextView textView = (TextView) findViewById(R.id.messages);
////                        textView.setText(textView.getText() + "\n" + message);
//                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
//                            // On UI thread.
//                            System.out.println("In UI-2");
//                        } else {
//                            // Not on UI thread.
//                            //message=null;
//                            System.gc();
//                        }
                            }
                        });
                    }

                }





//            @Override
//            public void onMessage(ByteBuffer bytes){
//                i++;
//                message = bytes;
//                System.out.println("Decoding");
////                imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
////                frame.add(j,imageAsBytes);
////                j++;
////                System.out.println(frame.size());
//
//                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
//                    // On UI thread.
//                    System.out.println("In UI-1");
//                } else {
//                    // Not on UI thread.
//
//                    System.out.println("Message received from server in main thread");
//                    System.gc();
//                }
//
////                if(j==50){
//////                            timer.scheduleAtFixedRate(new TimerTask() {
////
////                                public void run() {
////                    runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
//////                            for(int i=0;i<max;i++){
//////                                imageAsBytes1 = frame.get(i);
//////                                image = (ImageView) findViewById(R.id.ImageView);
//////                                image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes1, 0, imageAsBytes1.length));
//////                                //SystemClock.sleep(100);
////
////                            }
////
////                        }
////                    });
////                }
////
//////                            }, delay, period);}
////
////
////
////                }
//
//
//                //final Handler mHandler = new Handler();
//                //Handler need to handle callbacks from UI
////
//                //async.execute(message);
//                if(i>10) {
//                    if (!(message == null)) {
//
//                        runOnUiThread(new Runnable() {
//                            //
//////               Thread t=new Thread(){
//////                   public void run(){
//////                       android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
//////                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
//////                           // On UI thread.
//////                           System.out.println("In UI-3");
//////                        } else {
//////                           // Not on UI thread.
//////                           //message=null;
//////                            System.out.println("We are in the secondary thread.");
//////                        }
//////
//////                    }
//////                Thread t=null;
//////                };*/
////
//                            @Override
//                            public void run() {
//                                new AsyncHandler().execute(message);
////
////
////                     new WeakReference(new AsyncHandler().execute(message));
////
//////                        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
////
//////                        imageAsBytes = null;
//////                        //imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
//////                        //byte[] imageAsBytes = Base64.decode(message.getBytes(),Base64.DEFAULT);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        image = (ImageView) findViewById(R.id.ImageView);
//////                        imageAsBytes = Base64.decode(message.getBytes(), Base64.DEFAULT);
//////                        image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes,0,imageAsBytes.length));
////                        //image = null;
//////                        image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes,0,imageAsBytes.length));
//////                          image = new ImageView();
//////                        TextView textView = (TextView) findViewById(R.id.messages);
//////                        textView.setText(textView.getText() + "\n" + message);
////                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
////                            // On UI thread.
////                            System.out.println("In UI-2");
////                        } else {
////                            // Not on UI thread.
////                            //message=null;
////                            System.gc();
////                        }
//                            }
//                        });
//                    }
//
//                }
//           }


            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };

        mWebSocketClient.connect();
    }
}

