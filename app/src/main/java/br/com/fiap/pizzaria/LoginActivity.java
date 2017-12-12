package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.login)
    public void conectar(View v){

        if(validaUsuario() && validaSenha() ){
            Intent MainTela = new Intent(this, PedidoActivity.class);

            MainTela.putExtra("username",
                    username.getEditText().getText().toString());

             startActivity(MainTela);
        }

        return ;
    }

    private boolean validaUsuario() {
        if( username.getEditText().getText().toString().isEmpty()) {
            username.setError("error no login");
            return false;
        }
        username.setErrorEnabled(false) ;
        return true;

    }

    private boolean validaSenha() {
        if( password.getEditText().getText().toString().isEmpty()) {
            password.setError("digite a senha");
            return false;
        }
        password.setErrorEnabled(false) ;
        return true;
    }

}
