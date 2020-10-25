package com.example.loginmvvm.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.loginmvvm.model.Usuario;
import com.example.loginmvvm.request.ApiClient;

import java.io.File;
import java.util.logging.FileHandler;

public class ViewModelMain extends AndroidViewModel {

    private MutableLiveData<Usuario> usuario;

    public ViewModelMain(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getUsuario(){
        if(usuario==null){
            usuario= new MutableLiveData<>();

        }
        return usuario;
    }

    public void Ingresar (Context context, String mail, String password, File directorio){
        Usuario us = ApiClient.login(context, mail, password, directorio);
        usuario.setValue(us);
    }
}
