package usuario.app.agenda;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.*;

import java.sql.SQLException;

import usuario.app.agenda.dao.sqllitehelper;



public class AgendaActivity extends Activity {

    Button btIncluir,  btConsultar;

    Estrutura estrutura;
    ExecutaMetodosPrincipal executa ;
    sqllitehelper clDB;

    public static Object getClass (String nameClass) {
        try {
            //return (Class.forName(nameClass)).newInstance();
            return (Class.forName(nameClass));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void chamaTela (char view){



        //Intent redirect = new Intent(AgendaActivity.this,getClass(nome).getClass());

        switch (view) {
         case 'C':{
                Intent redirect = new Intent(AgendaActivity.this, ConsultarActivity.class);
                AgendaActivity.this.startActivity(redirect);
            break;
            }
            case 'E':{
                Intent redirect = new Intent(AgendaActivity.this,EditarActivity.class);
                AgendaActivity.this.startActivity(redirect);
                break;
            }
            case 'X':{
                Intent redirect = new Intent(AgendaActivity.this,ExcluirActivity.class);
                AgendaActivity.this.startActivity(redirect);
                break;
            }
            case 'I':{
                Intent redirect = new Intent(AgendaActivity.this,incluirActivity.class);
                AgendaActivity.this.startActivity(redirect);
                break;
            }
        }

          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
    private void stanciaBotoesPrincipal (){

       btIncluir = (Button) findViewById(R.id.btIncluir);

       btConsultar = (Button) findViewById(R.id.btConsultar);
    }

    private void setExecutaClick (final Button botao){
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    switch (botao.getId()) {
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
        setContentView(R.layout.activity_agenda);
        // instaciando classe de acesso ao banco

        executa = new ExecutaMetodosPrincipal();
        estrutura = new Estrutura();
        //
        // criando banco de dados ou abrindo
        //

        stanciaBotoesPrincipal();

        setExecutaClick(btIncluir);
        setExecutaClick(btConsultar);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agenda, menu);
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
