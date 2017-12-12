package br.com.fiap.pizzaria;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tvUsuario)
    TextInputLayout tvUsuario;

    String usernameLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
