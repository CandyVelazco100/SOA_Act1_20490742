package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Persona;
import modelo.PersonaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Candy Nohemi
 */
public class NewController extends HttpServlet {
    private PersonaDAO personaDAO;    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        List<Persona> personas = new ArrayList<>();
        personaDAO = new PersonaDAO();
        
        switch(accion) {
            case "listar":
                personas = personaDAO.lista();
                
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
                break;
            case "Agregar":
                int r = 0;
                String nombre = request.getParameter("form-nombre");
                String apellido = request.getParameter("form-apellido");
                Persona persona = new Persona();
                
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                
                r = personaDAO.Agregar(persona);
                
                if(r != 0) {
                    request.getRequestDispatcher("index.jsp?accion=listar").forward(request, response);
                }
                
                break;
            case "Editar":
                int res = 0;
                String nombreE = request.getParameter("edit-nombre");
                String apellidoE = request.getParameter("edit-apellido");
                int id = Integer.parseInt(request.getParameter("edit-id"));
                Persona personaE = new Persona();
                
                personaE.setId(id);
                personaE.setNombre(nombreE);
                personaE.setApellido(apellidoE);
                
                res = personaDAO.Actualizar(personaE);
                
                if(res != 0) {
                    request.getRequestDispatcher("index.jsp?accion=listar").forward(request, response);
                }                
                break;
            case "Eliminar":
                int resul = 0;
                int idE = Integer.parseInt(request.getParameter("id"));
                
                resul = personaDAO.Delete(idE);
                
                if(resul != 0) {
                    request.getRequestDispatcher("index.jsp?accion=listar").forward(request, response);
                }
                
                break;
            case "Buscar":
                int idB = Integer.parseInt(request.getParameter("busc-id"));
                
                personas = personaDAO.buscar(idB);
                   
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp?accion=listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
