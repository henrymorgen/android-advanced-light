package com.example.liuwangshu.moonokhttp3;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="OkHttp3";
    private OkHttpClient mOkHttpClient;
    private Button bt_send;
    private Button bt_postsend;
    private Button bt_sendfile;
    private Button bt_downfile;
    private Button bt_cancel;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOkHttpClient();
        bt_send = (Button) this.findViewById(R.id.bt_send);
        bt_sendfile = (Button) this.findViewById(R.id.bt_sendfile);
        bt_postsend = (Button) this.findViewById(R.id.bt_postsend);
        bt_downfile = (Button) this.findViewById(R.id.bt_downfile);
        bt_cancel = (Button) this.findViewById(R.id.bt_cancel);
        bt_send.setOnClickListener(this);
        bt_postsend.setOnClickListener(this);
        bt_sendfile.setOnClickListener(this);
        bt_downfile.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_send:
                //getAsynHttp();
                getAsynForEngine();
                break;
            case R.id.bt_postsend:
                postAsynHttp();
                break;
            case R.id.bt_sendfile:
                postAsynFile();
                break;
            case R.id.bt_downfile:
                downAsynFile();
//              sendMultipart();
                break;
            case R.id.bt_cancel:
                cancel();
                break;
        }
    }


    private void initOkHttpClient() {
        File sdcache = getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
        mOkHttpClient = builder.build();
    }

    /**
     * get异步请求
     */
    private void getAsynHttp() {

        Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i(TAG, str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void getAsynForEngine(){
        OkHttpEngine.getInstance(MainActivity.this).getAsynHttp("http://www.baidu.com", new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }
            @Override
            public void onResponse(String str) throws IOException{
                Log.d(TAG, str);
                Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * post异步请求
     */
    private void postAsynHttp() {
        RequestBody formBody = new FormBody.Builder()
                .add("ip", "59.108.54.37")
                .build();
        Request request = new Request.Builder()
                .url("http://ip.taobao.com/service/getIpInfo.php")
                .post(formBody)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d(TAG, str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

    /**
     * 异步上传文件
     */
    private void postAsynFile() {
        String filepath = "";
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            filepath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            filepath = getFilesDir().getAbsolutePath();
        }
        File file = new File(filepath, "wangshu.txt");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, response.body().string());
            }
        });
    }

    /**
     * 异步下载文件
     */
    private void downAsynFile() {
        String url = "http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg";
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getApplicationContext(), "文件下载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                String filepath = "";
                try {
                    if (Environment.getExternalStorageState().equals(
                            Environment.MEDIA_MOUNTED)) {
                        filepath = Environment.getExternalStorageDirectory().getAbsolutePath();
                    } else {
                        filepath = getFilesDir().getAbsolutePath();
                    }
                    File file = new File(filepath, "wangshu.jpg");
                    if (null != file) {
                        fileOutputStream = new FileOutputStream(file);
                        byte[] buffer = new byte[2048];
                        int len = 0;
                        while ((len = inputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, len);
                        }
                        fileOutputStream.flush();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "文件存储成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "文件存储失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (IOException e) {
                    Log.e(TAG, "IOException");
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendMultipart() {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "wangshu")
                .addFormDataPart("image", "wangshu.jpg",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("/sdcard/wangshu.jpg")))
                .build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "...")
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, response.body().string());
            }
        });
    }

    private void cancel() {
        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build();
        Call call = null;
        call = mOkHttpClient.newCall(request);
        final Call finalCall = call;
        //100毫秒后取消call
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                finalCall.cancel();
            }
        }, 100, TimeUnit.MILLISECONDS);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    Log.d(TAG, "cache---" + str);
                } else {
                    String str = response.networkResponse().toString();
                    Log.d(TAG, "network---" + str);
                }
            }
        });

    }
}
