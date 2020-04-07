
package com.proyecto.controller;

import com.proyecto.dto.Rol;
import com.proyecto.service.RolService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "navega")
public class RolController {
    @Autowired
    RolService rolService;
    
    @RequestMapping(params="lstRol",method=RequestMethod.GET)
    public ModelAndView listaRol(){
       ModelAndView model=new ModelAndView("ListaRol");
       List<Rol> listaRol=rolService.lstRol();
       Rol rol=new Rol();
       model.addObject("rol", rol);
       model.addObject("listaRol", listaRol);
       return model;
    }
    @RequestMapping(params = "nuevoRol",method=RequestMethod.GET)
    public ModelAndView nuevoRol(){
        ModelAndView model=new ModelAndView("RegistraRol");
        Rol rol=new Rol();
        model.addObject("rol", rol);
       return model;
    }
    @RequestMapping(value = "editarRol",method=RequestMethod.GET)
    public ModelAndView editarRol(HttpServletRequest request){
        ModelAndView model=new ModelAndView("RegistraRol");
        int idRol=Integer.parseInt(request.getParameter("idRol"));
        Rol rol=rolService.getRol(idRol);
        model.addObject("rol", rol);
        return model;
    }
    
    @RequestMapping(value = "eliminarRol", method = RequestMethod.GET)
    public ModelAndView eliminarRol(HttpServletRequest request){
        int idRol=Integer.parseInt(request.getParameter("idRol"));
        rolService.deleteRol(idRol);
        
        return new ModelAndView("redirect:/navega.htm?lstRol");
    }
    @RequestMapping (value="registraRol" ,method = RequestMethod.POST)
    public ModelAndView grabarRol(@Valid @ModelAttribute("rol") Rol rol,BindingResult resultado){
        if(resultado.hasErrors()){
             ModelAndView mav = new ModelAndView("RegistraRol");
             return mav;
        }else{
        rolService.saveRol(rol);
        return new ModelAndView("redirect:/navega.htm?lstRol"); 
        }
       }
}
