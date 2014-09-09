package com.jcs.goboax.aulavirtual.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.service.api.UsuarioService;
import com.jcs.goboax.aulavirtual.viewmodel.ObjectToJsonObject;
import com.jcs.goboax.aulavirtual.viewmodel.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsuarioController
{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping("/usuario")
    public String listUsuarios()
    {
        return "usuarios";
    }

    @RequestMapping(value = "usuario/list", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public @ResponseBody String readUsuarios()
    {
        List<Usuario> myUsuarios = usuarioService.readUsuarios();

        @SuppressWarnings("unchecked")
        List<UsuarioModel> myUsuariosModel = (List<UsuarioModel>) conversionService.convert(
                myUsuarios,
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(Usuario.class)),
                TypeDescriptor.collection(List.class,
                        TypeDescriptor.valueOf(UsuarioModel.class)));

        ObjectToJsonObject<UsuarioModel> myUsuarioToJsonObject = new ObjectToJsonObject<UsuarioModel>();

        myUsuarioToJsonObject.setiTotalDisplayRecords(myUsuarios.size());
        myUsuarioToJsonObject.setiTotalRecords(myUsuarios.size());
        myUsuarioToJsonObject.setAaData(myUsuariosModel);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String myJsonResponse = gson.toJson(myUsuarioToJsonObject);

        return myJsonResponse;
    }
}
