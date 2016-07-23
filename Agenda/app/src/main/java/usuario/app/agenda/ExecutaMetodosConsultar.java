package usuario.app.agenda;

import android.app.*;
import android.content.Context;
import android.widget.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import usuario.app.agenda.controller.contatosctrl;
import usuario.app.agenda.model.Contatos;

/**
 * Created by Administrador on 14/06/2016.
 */
public class ExecutaMetodosConsultar {
    Mensagem m = new Mensagem();

    contatosctrl ctr;
    Context contexto;
    public   ExecutaMetodosConsultar(Context contexto){
        ctr = new contatosctrl(contexto);
        this.contexto = contexto;
    }
    public void Voltar(Activity contexto){
       // m.mostraMensagemOK("Consultando Registro","Clicou em voltar", contexto);



    }
    public ArrayList<Contatos> Consultar(Context contexto) {

         return ctr.all();
        //m.mostraMensagemOK("Consultando Registro","Clicou em Consultar", contexto);
    }
    public ArrayList<Contatos> pelo(Context contexto, String criterio) {

        return ctr.pelo(criterio);
        //m.mostraMensagemOK("Consultando Registro","Clicou em Consultar", contexto);
    }
}
