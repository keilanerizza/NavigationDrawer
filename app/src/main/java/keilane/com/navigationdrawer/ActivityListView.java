package keilane.com.navigationdrawer;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import keilane.com.navigationdrawer.model.Aluno;
import keilane.com.navigationdrawer.services.InterfaceDeServicos;
import keilane.com.navigationdrawer.services.RetrofitService;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estende_list_activity);
        // Como esta classe estende ListActivity, não é necessário obter a referência ao listView
        //lista = (ListView) findViewById(R.id.listview_listadealunos);
        imprimeLista();
    }

    private void imprimeLista() {

        InterfaceDeServicos services = RetrofitService.getServico();
        retrofit2.Call<List<Aluno>> call = services.webserviceNotasDeAlunos();

        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> listaAlunosNotas = response.body();
                //O método setListAdapter foi herdado de ListActivity
                setListAdapter(new ListaAdapter(ActivityListView.this, listaAlunosNotas));
            }

            @Override
            public void onFailure(retrofit2.Call<List<Aluno>> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });
    }
}