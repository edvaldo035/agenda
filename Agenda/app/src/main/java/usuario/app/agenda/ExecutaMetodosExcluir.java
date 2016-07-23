package usuario.app.agenda;

import android.content.Context;

/**
 * Created by Administrador on 21/06/2016.
 */
public class ExecutaMetodosExcluir extends ExecutaMetodosConsultar {

    public ExecutaMetodosExcluir(Context contexto) {
        super(contexto);
    }

    public void Cancelar(Context contexto) {
        m.mostraMensagemOK("Cancelando Exclusão","Clicou em Cancelar", contexto);
    }

    public void Confirmar(Context contexto) {
        m.mostraMensagemOK("Confirmando Exclusão","Clicou em Salvar", contexto);
    }
}
