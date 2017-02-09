package com.example.liuwangshu.moonvolley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private static final String TAG="Volley";
    private ImageView iv_image;
    private Button bt_send;
    private NetworkImageView nv_image;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_image = (ImageView) this.findViewById(R.id.iv_image);
        bt_send = (Button) this.findViewById(R.id.bt_send);
        nv_image = (NetworkImageView) this.findViewById(R.id.nv_image);
        mQueue = Volley.newRequestQueue(getApplicationContext());
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UseStringRequest();
                  UseJsonRequest();
//                UseImageRequest();
//                UseImageLoader();
//                UseNetworkImageView();
            }
        });
    }


    private void UseStringRequest() {
        //创建请求队列
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        });
        //将请求添加在请求队列中
        mQueue.add(mStringRequest);
    }

    private void UseJsonRequest() {
        String requestBody = "ip=59.108.54.37";
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://ip.taobao.com/service/getIpInfo.php?ip=59.108.54.37",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        IpModel ipModel = new Gson().fromJson(response.toString(), IpModel.class);
                        if (null != ipModel && null != ipModel.getData()) {
                            String city = ipModel.getData().getCity();
                            Log.d(TAG, city);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        }
        );
        mQueue.add(mJsonObjectRequest);
    }

    private void UseImageRequest() {
        ImageRequest imageRequest = new ImageRequest(
                "http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv_image.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iv_image.setImageResource(R.drawable.ico_default);
            }
        });
        mQueue.add(imageRequest);
    }


    private void UseImageLoader() {
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv_image, R.drawable.ico_default, R.drawable.ico_default);
        imageLoader.get("http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg", listener);
    }

    private void UseNetworkImageView() {
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        nv_image.setDefaultImageResId(R.drawable.ico_default);
        nv_image.setErrorImageResId(R.drawable.ico_default);
        nv_image.setImageUrl("http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg",
                imageLoader);

    }
}
