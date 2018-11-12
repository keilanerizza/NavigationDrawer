package keilane.com.navigationdrawer.services;

import java.util.List;

import keilane.com.navigationdrawer.model.Aluno;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface InterfaceDeServicos {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/lista_de_alunos")
    retrofit2.Call<List<Aluno>> webserviceNotasDeAlunos();

}