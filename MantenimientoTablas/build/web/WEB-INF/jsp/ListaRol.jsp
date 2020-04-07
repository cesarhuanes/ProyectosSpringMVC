<%-- 
    Document   : RegistraRol
    Created on : 06-abr-2020, 21:48:56
    Author     : Cesar Huanes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" type="text/css" media="all" />
    </head>
  
    <body>
        <div class="contentList">
        <h1>Mantenimiento de Roles</h1>
    <ui>
        <li>
            
            <a href="navega.htm?nuevoRol" >Nuevo Rol</a>
        </li>
        
    </ui>
    
        <table  style="margin: auto;width: 540px">
            
            <thead>
                    <td>Nº</td>
                    <td>Descripcion</td>
                    <td>Sueldo</td>
                     <td>Actualizar</td>
                     <td>Eliminar</td>
            </thead>
            <tbody>
                <c:forEach var="item"  items="${listaRol}">
                     <tr>
                        <td>${item.idRol}</td>
                        <td>${item.descripcionRol}</td>
                        <td>${item.monto}</td>
                        <td>
<!--                            <a href="navega/editRol/${item.idRol}"> Actualizar</a>-->                        
                        <a href="navega/editarRol?idRol=${item.idRol}"> Actualizar</a>
                        </td>
                        <td>
                           <a href="navega/eliminarRol?idRol=${item.idRol}"> Eliminar</a> 
                        </td>
                     </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
