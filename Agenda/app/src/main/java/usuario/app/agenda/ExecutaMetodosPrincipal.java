package usuario.app.agenda;
import android.app.*;
import android.view.*;
import android.widget.*;
import android.content.Context;
import android.os.*;
/**
 * Created by Administrador on 13/06/2016.
 */
public class ExecutaMetodosPrincipal {

     Mensagem m = new Mensagem();
    public void Editar(Context contexto){
          m.mostraMensagemOK("Editando Registro","Clicou em editar", contexto);
    }
    public void Excluir(Context contexto){
        m.mostraMensagemOK("Excluíndo Registro","Clicou em Excluír", contexto);
    }
    public void Incluir(Context contexto){
        m.mostraMensagemOK("Incluindo Registro","Clicou em Incluir", contexto);
    }
    public void Consultar(Context contexto) {
        m.mostraMensagemOK("Consultando Registro","Clicou em Consultar", contexto);
    }

}
