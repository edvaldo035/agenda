package usuario.app.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import usuario.app.agenda.controller.contatosctrl;
import usuario.app.agenda.model.Contatos;


public class EditarActivity extends Activity {

    Button btSalvar, btCancelar;
    EditText edNome, edFone,edEmail;
    EditText        edObservacao;
    Contatos ct = new Contatos();
    Estrutura estrutura ;
    ExecutaMetodosEditar executa  ;

    public void chamaTela (char view){



        //Intent redirect = new Intent(AgendaActivity.this,getClass(nome).getClass());

        switch (view) {

            case 'C':{
                Intent redirect = new Intent(EditarActivity.this,ConsultarActivity.class);
                EditarActivity.this.startActivity(redirect);
                break;
            }

        }

          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
    private void stanciaBotoesEditar (){

        btSalvar = (Button) findViewById(R.id.btSalvar);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        edNome = (EditText) findViewById(R.id.edNome);
        edFone = (EditText) findViewById(R.id.edFone);
        edEmail= (EditText) findViewById(R.id.edEmail);
        edObservacao = (EditText) findViewById(R.id.edObservacao);
    }

    private void setExecutaClick (final Button botao){
        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                switch (  botao.getId()){
                    case R.id.btCancelar:{
                        chamaTela('C');
                        break;
                    }
                    case R.id.btSalvar:{
                       ct = raderizadaTela(ct);
                        executa.Salvar(ct,EditarActivity.this);
                        chamaTela('C');
                        break;
                    }
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        executa = new ExecutaMetodosEditar(this);
        estrutura = new Estrutura();
        TextView textView = new TextView(this);


        stanciaBotoesEditar();
        setExecutaClick(btSalvar);
        setExecutaClick(btCancelar);

        Intent intent = getIntent();

        Bundle params = intent.getExtras();

       // if (params != null) {
        if (Contatos.idPassado>0){
            //int idContato = params.getInt("idContato");
           // Mensagem.mostraMensagemOK("Id Selecionado",String.valueOf(Contatos.idPassado),this);
           contatosctrl ctr = new contatosctrl(this) ;

           ct = ctr.porID(Contatos.idPassado);
           raderizatela(ct);
        }
    }

    private Contatos raderizadaTela(Contatos ct) {

         ct.setNome(edNome.getText().toString());
         ct.setFone(edFone.getText().toString());
         ct.setEmail(edEmail.getText().toString());
         ct.setObservacao(edObservacao.getText().toString());
       return ct;
    }
    private void raderizatela(Contatos ct) {
        edNome.setText(ct.getNome());
        edFone.setText(ct.getFone());
        edEmail.setText(ct.getEmail());
        edObservacao.setText(ct.getObservacao());
    }
}
