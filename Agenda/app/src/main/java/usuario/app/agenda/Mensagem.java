package usuario.app.agenda;

import android.content.Context;
import android.view.*;
import android.app.*;
import android.widget.*;

/**
 * Created by Administrador on 13/06/2016.
 */
 public  class Mensagem {

   public static void mostraMensagemOK (String Titulo, String mensagem,Context tela){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(tela);
        dialogo.setTitle(Titulo);
        dialogo.setMessage(mensagem);
        dialogo.setNeutralButton("OK",null);
       dialogo.show();
   }

}
