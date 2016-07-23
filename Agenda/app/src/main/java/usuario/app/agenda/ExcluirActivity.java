package usuario.app.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ExcluirActivity extends Activity {

    Button btConfimar, btCancelar;

    Estrutura estrutura ;
    ExecutaMetodosExcluir executa  ;

    public void chamaTela (char view){



        //Intent redirect = new Intent(AgendaActivity.this,getClass(nome).getClass());

        switch (view) {

            case 'C':{
                Intent redirect = new Intent(ExcluirActivity.this,AgendaActivity.class);
                ExcluirActivity.this.startActivity(redirect);
                break;
            }

        }

          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
    private void stanciaBotoesExcluir (){

        btConfimar = (Button) findViewById(R.id.btConfirmar);
        btCancelar = (Button) findViewById(R.id.btCancelar);
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
                    case R.id.btConfirmar:{executa.Confirmar(ExcluirActivity.this);
                        break;
                    }
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);
        executa = new ExecutaMetodosExcluir(this);
        estrutura = new Estrutura();

        stanciaBotoesExcluir();
        setExecutaClick(btCancelar);
        setExecutaClick(btConfimar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_excluir, menu);
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
