package br.com.fiap.pizzaria;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PedidoActivity extends AppCompatActivity {

    @BindView(R.id.tvUsuario)
    TextInputLayout tvUsuario;

    String usernameLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

//        ButterKnife.bind(this);
        if (getIntent() != null) {
            usernameLogin = (getIntent().getStringExtra("username").toString());

           // tvUsuario.getEditText().setText(usernameLogin.toString());

           // Toast.makeText(this,usernameLogin.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
