package usuario.app.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

import usuario.app.agenda.model.Contatos;


public class ConsultarActivity extends Activity {

        Button btVoltar, btExcluir,btEditar, btConsultar,btIncluir;
        EditText edConsulta;
        ListView lstContatos;
        Estrutura estrutura;
        ExecutaMetodosConsultar executa ;



    public void chamaTela (char view){



        //Intent redirect = new Intent(AgendaActivity.this,getClass(nome).getClass());

        switch (view) {

            case 'V':{
                Intent redirect = new Intent(ConsultarActivity.this,AgendaActivity.class);
                ConsultarActivity.this.startActivity(redirect);
                break;
            }
            case 'C':{
                Intent redirect = new Intent(ConsultarActivity.this, ConsultarActivity.class);
                ConsultarActivity.this.startActivity(redirect);
                break;
            }
            case 'E':{
                Intent redirect = new Intent(ConsultarActivity.this,EditarActivity.class);
               // params.putInt("idContato", idContato);
                ConsultarActivity.this.startActivity(redirect);
                break;
            }
            case 'X':{
                Intent redirect = new Intent(ConsultarActivity.this,ExcluirActivity.class);
                ConsultarActivity.this.startActivity(redirect);
                break;
            }
            case 'I':{
                Intent redirect = new Intent(ConsultarActivity.this,incluirActivity.class);
                ConsultarActivity.this.startActivity(redirect);
                break;
            }


        }

          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
        private void stanciaBotoesConsultar (){

            btIncluir = (Button) findViewById(R.id.btIncluir);
            btVoltar = (Button) findViewById(R.id.btVoltar);
            btConsultar = (Button) findViewById(R.id.btConsultar);
            btExcluir = (Button) findViewById(R.id.btExcluir);
            btEditar = (Button) findViewById(R.id.btEditar);
            edConsulta = (EditText) findViewById(R.id.edPesquisa);

            lstContatos = (ListView) findViewById(R.id.listContatos);
        }

        private void setExecutaClick (final Button botao){
            botao.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    switch (  botao.getId()){
                        case R.id.btVoltar:{
                            chamaTela('V'); break;
                        }
                        case R.id.btIncluir: {
                            chamaTela('I');
                            break;
                        }
                        case R.id.btEditar: {
                            chamaTela('E');
                            break;
                        }
                        case R.id.btExcluir: {

                            chamaTela('X');
                            break;
                        }

                        case R.id.btConsultar: {
                            ArrayList<Contatos> lista ;

                            if (edConsulta.getText().toString().isEmpty() ) {
                                lista = executa.Consultar(ConsultarActivity.this);
                            }else {
                                lista = executa.pelo(ConsultarActivity.this, edConsulta.getText().toString());
                            }

                            // randerizando o objeto listVoew

                            BaseAdapter crsAdapter = new ContatosAdapter(lista);
                            lstContatos.setAdapter(crsAdapter);

                            break;
                        }
                    }
                }
            });
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consultas);
            executa = new ExecutaMetodosConsultar(ConsultarActivity.this);
            estrutura = new Estrutura();


            stanciaBotoesConsultar();
            setExecutaClick(btIncluir);
            setExecutaClick(btEditar);
            setExecutaClick(btVoltar);

            setExecutaClick(btVoltar);
            setExecutaClick(btConsultar);



        }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar, menu);
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
