
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formRol" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" type="text/css" media="all" />
    </head>
   <body>
       <div class="content">
        <h1>Registro del Rol</h1>
        <formRol:form modelAttribute="rol" action="${pageContext.request.contextPath}/navega/registraRol" method="POST">
            <table>
                <tr>  
                <td></td>    
                <td><formRol:hidden  path="idRol" /></td>  
                </tr>  
                <tr>
                    
                    <td>Nombre Rol</td>
                    <td> <formRol:input path="descripcionRol" /></td>
                     <td><formRol:errors path="descripcionRol" style="color: red;" /></td>
                </tr>
                <tr>
                    <td>Sueldo</td>
                    <td><formRol:input path="monto" /></td>
                    <td><formRol:errors path="monto" style="color: red;" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Grabar" /> </td>
                </tr>
            </table>
            
        </formRol:form>
        </div>
    </body>
</html>
