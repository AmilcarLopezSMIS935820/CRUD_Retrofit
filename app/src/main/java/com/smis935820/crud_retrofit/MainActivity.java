package com.smis935820.crud_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smis935820.crud_retrofit.interfaces.PetAPI;
import com.smis935820.crud_retrofit.models.pet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText edtId;
    TextView tvName, tvAge, tvColor;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtId = findViewById(R.id.edtId);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvColor = findViewById(R.id.tvColor);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find(edtId.getText().toString().trim());
            }
        });
    }

    private void find(String cod){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1:8080").addConverterFactory(GsonConverterFactory.create()).build();

        PetAPI petAPI = retrofit.create(PetAPI.class);

        ///llamada HTTP
        Call<pet> call = petAPI.find(cod);
        call.enqueue(new Callback<pet>() {
            @Override
            public void onResponse(Call<pet> call, Response<pet> response) {
                try {
                    if (response.isSuccessful()){
                        pet pet = response.body();
                        tvName.setText(pet.getName());
                        tvAge.setText(pet.getAge());
                        tvColor.setText(pet.getColor());
                    }

                } catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<pet> call, Throwable t) {

            }
        });
    }
}