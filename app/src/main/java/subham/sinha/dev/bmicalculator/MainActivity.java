package subham.sinha.dev.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
TextInputEditText weight,hieght;
MaterialButton calc;
AppCompatTextView result;
AppCompatImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        weight=findViewById(R.id.weight);
        hieght=findViewById(R.id.height);
        calc=findViewById(R.id.calc);
        result=findViewById(R.id.result);
        img=findViewById(R.id.img);

        GradientDrawable gd=new GradientDrawable();
        gd.setStroke(3,null);
        gd.setCornerRadius(20);
        result.setBackgroundDrawable(gd);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w=weight.getText().toString().trim();
                String h=hieght.getText().toString().trim();
                if(!w.isEmpty()&&!h.isEmpty()){


                    float wf=Float.parseFloat(w);
                    float hf=Float.parseFloat(h);
                    calcBMI(wf,hf);

                }else {

                    result.setText("Empty");

                }




            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Developed By Subham Kr Sinha", Snackbar.LENGTH_SHORT);
                snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
                snackbar.show();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void calcBMI(float weight,float hieght){

        OkHttpClient client =new OkHttpClient();
        Request request=new Request.Builder().url("https://bmicalculatorapi.vercel.app/api/bmi/"+weight+"/"+hieght).build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                  final   String data=response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json=new JSONObject(data);
                              String category=  json.getString("Category");
                              String bmi=  json.getString("bmi");
                              result.setText("BMI:"+bmi+"\nCategory:"+category);



                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }



                        }
                    });                }


            }
        });

    }
    public  void  api(View v){
        Intent i=new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("https://bmicalculatorapi.vercel.app/api/"));
        startActivity(i);
    }
    public  void  github(View v){
        Intent i=new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/subhamsinhadev"));
        startActivity(i);
    }



}