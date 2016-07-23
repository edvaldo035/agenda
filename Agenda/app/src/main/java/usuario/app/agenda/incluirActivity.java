package usuario.app.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import usuario.app.agenda.model.*;
import usuario.app.agenda.dao.ContatosDAO.*;


public class incluirActivity extends Activity {

    Button btCancelar, btSalvar;

    Estrutura estrutura;
    ExecutaMetodosIncluir executa ;

    public void chamaTela (char view){

        //Intent redirect = new Intent(AgendaActivity.this,getClass(nome).getClass());

        switch (view) {

            case 'C':{
                Intent redirect = new Intent(incluirActivity.this,AgendaActivity.class);
                incluirActivity.this.startActivity(redirect);
                break;
            }

        }

          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
    private void stanciaBotoesConsultar (){

        btCancelar = (Button) findViewById(R.id.btCancelar);
        btSalvar = (Button) findViewById(R.id.btSalvar);

    }
    private Contatos randerizaContatos(){
        TextView txNome = (TextView) findViewById(R.id.edNome);
        TextView txEmail = (TextView) findViewById(R.id.edEmail);
        TextView txObs = (TextView) findViewById(R.id.edObservacao);
        TextView txFone = (TextView) findViewById(R.id.edFone);


        Contatos ct = new Contatos(txNome.getText().toString(),
                txFone.getText().toString(),
                txEmail.getText().toString(),
                txObs.getText().toString()
        );
        return ct;
    }

    private void setExecutaClick (final Button botao){
        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Contatos contato = Contatos.createContatos();
                contato = randerizaContatos();

                switch (  botao.getId()){
                    case R.id.btCancelar:{

                        chamaTela('C'); break;}
                    case R.id.btSalvar:{executa.Salvar( contato); break;}
                }
                contato = null;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incluir);

        executa = new ExecutaMetodosIncluir(this);
        estrutura = new Estrutura();

        stanciaBotoesConsultar();
        setExecutaClick(btCancelar);
        setExecutaClick(btSalvar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_incluir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
