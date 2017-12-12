package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.fiap.pizzaria.model.Pedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PedidoActivity extends AppCompatActivity {

    String usernameLogin;

    @BindView(R.id.tvUsuario)
    TextView tvUsuario;

    @BindView(R.id.cbAtum)
    CheckBox cbAtum;

    @BindView(R.id.cbCalabresa)
    CheckBox cbCalabresa;

    @BindView(R.id.cbFrango)
    CheckBox cbFrango;

    @BindView(R.id.cbMussarela)
    CheckBox cbMussarela;

    @BindView(R.id.rgTamanho)
    RadioGroup rgTamanho;

    @BindView(R.id.spPagamentos)
    Spinner spPagamentos;

    Pedido pedido = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            usernameLogin = (getIntent().getStringExtra("username").toString());
            tvUsuario.setText(usernameLogin);

        }

        setListernerCheckBox(cbMussarela);
        setListernerCheckBox(cbAtum);
        setListernerCheckBox(cbCalabresa);
        setListernerCheckBox(cbFrango);

    }


    private void setListernerCheckBox(final CheckBox checkBox)
    {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    pedido.addSabor(checkBox.getText().toString());
                }else{
                    pedido.removeSabor(checkBox.getText().toString());
                }
            }
        });
    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido(){

        pedido.setCliente(usernameLogin);
        pedido.setTamanho(getTamanhoSelecionado());
        pedido.setFormaPagamento(spPagamentos.getSelectedItem().toString());


        Intent Confirmar = new Intent(this,ConfirmarPedidoActivity.class);

        Confirmar.putExtra("PEDIDO",pedido);

        startActivity(Confirmar);

    }

    public String getTamanhoSelecionado(){
        return ((RadioButton) findViewById(rgTamanho.getCheckedRadioButtonId())).toString();
    }
}
