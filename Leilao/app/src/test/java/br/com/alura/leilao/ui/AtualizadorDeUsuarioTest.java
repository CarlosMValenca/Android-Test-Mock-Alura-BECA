package br.com.alura.leilao.ui;

import static org.junit.Assert.*;

import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.alura.leilao.database.dao.UsuarioDAO;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaUsuarioAdapter;

@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeUsuarioTest {

    @Mock
    private UsuarioDAO dao;
    @Mock
    private ListaUsuarioAdapter adapter;
    @Mock
    private RecyclerView recyclerView;


    @Test
    public void deve_AtualizarListaDeUsuario_QuandoSalvarUsuario(){
        AtualizadorDeUsuario atualizador = new AtualizadorDeUsuario(
                dao,
                adapter,
                recyclerView);

        Usuario alex = new Usuario("Alex");
        atualizador.salva(alex);

        Mockito.verify(dao).salva(alex);
        Mockito.verify(adapter).adiciona(alex);
        Mockito.verify(recyclerView).smoothScrollToPosition(adapter.getItemCount() -1);
    }

}