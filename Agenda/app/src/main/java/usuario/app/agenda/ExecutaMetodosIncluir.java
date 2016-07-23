package usuario.app.agenda;

import android.content.Context;
import android.widget.*;
import android.app.*;
import android.view.*;

import usuario.app.agenda.controller.*;

import usuario.app.agenda.model.*;

/**
 * Created by Administrador on 18/06/2016.
 */
public class ExecutaMetodosIncluir extends ExecutaMetodosConsultar {

    contatosctrl ctr;
    Context contexto;
    public   ExecutaMetodosIncluir(Context contexto){
        super(contexto);
        ctr = new contatosctrl(contexto);
       this.contexto = contexto;
   }
    public void Cancelar() {
        m.mostraMensagemOK("Cancelando Incluisao","Clicou em Cancelar", contexto);
    }

    public void Salvar(Contatos contatos) {

        try {
            ctr.Insert(contatos);
            m.mostraMensagemOK("Salvando Incluisão","Contato salvo com sucesso !!", contexto);
        }
        catch (Exception ex){
            m.mostraMensagemOK("Falha na Incluisão",ex.getMessage(), contexto);
        }
    }

}
