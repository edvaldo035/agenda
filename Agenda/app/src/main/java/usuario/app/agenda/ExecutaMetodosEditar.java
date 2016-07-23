package usuario.app.agenda;

import android.content.Context;

import usuario.app.agenda.model.Contatos;

/**
 * Created by Administrador on 17/06/2016.
 */
public class ExecutaMetodosEditar extends ExecutaMetodosConsultar {


    public ExecutaMetodosEditar(Context contexto) {
        super(contexto);
    }

    public void Cancelar(Context contexto) {
        m.mostraMensagemOK("Cancelando Edicao","Clicou em Cancelar", contexto);
    }

    public void Salvar(Contatos contatos,Context contexto) {

        try {
            ctr.update(contatos);
            m.mostraMensagemOK("Salvando Edição","Contato salvo com sucesso !!", contexto);
        }
        catch (Exception ex){
            m.mostraMensagemOK("Salvando Edicao","Falha :" + ex.getMessage(), contexto);
        }

    }
}
