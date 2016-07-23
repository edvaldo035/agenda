package usuario.app.agenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrador on 14/06/2016.
 */
public class Estrutura extends Activity {

    public void chamaTela (Context ctx,Activity contexto){



                Intent tela = new Intent(ctx, contexto.getClass());
                contexto.startActivity(tela);


          /* Activity a  = (Activity)contexto;
        a.setContentView(novatela);
*/
    }
}
