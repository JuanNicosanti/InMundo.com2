package controllers;

import domain.Tripulante;
import domain.Vuelo;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.commons.model.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;
import repos.RepoTripulantes;
import repos.RepoVuelos;

@Controller
@SuppressWarnings("all")
public class VuelosController extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  public static void main(final String[] args) {
    XTRest.start(VuelosController.class, 9899);
  }
  
  @Get("/vuelos")
  public Result vuelos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoVuelos _instance = RepoVuelos.getInstance();
      final List<Vuelo> vuelos = _instance.allInstances();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(vuelos);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/vuelos/:id")
  public Result vuelo(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType("application/json");
      final Integer iId = Integer.valueOf(id);
      Result _xtrycatchfinallyexpression = null;
      try {
        RepoVuelos _instance = RepoVuelos.getInstance();
        Vuelo _searchById = _instance.searchById((iId).intValue());
        String _json = this._jSONUtils.toJson(_searchById);
        _xtrycatchfinallyexpression = ResultFactory.ok(_json);
      } catch (final Throwable _t) {
        if (_t instanceof UserException) {
          final UserException e = (UserException)_t;
          _xtrycatchfinallyexpression = ResultFactory.notFound((("No existe el vuelo con id " + id) + ""));
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/vuelos/search")
  public Result buscar(final String numero, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final Vuelo vueloBuscado = new Vuelo();
      vueloBuscado.setNumero(numero);
      RepoVuelos _instance = RepoVuelos.getInstance();
      List<Vuelo> _searchByExample = _instance.searchByExample(vueloBuscado);
      String _json = this._jSONUtils.toJson(_searchByExample);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  /**
   * @Put('/tareas/:id')
   * def Result actualizar(@Body String body) {
   * try {
   * val actualizado = body.fromJson(Vuelo)
   * 
   * val asignadoA = body.getPropertyValue("asignadoA")
   * val asignatario = RepoUsuarios.instance.allInstances.findFirst[it.nombre.equalsIgnoreCase(asignadoA)]
   * actualizado.asignarA(asignatario)
   * 
   * if (Integer.parseInt(id) != actualizado.id) {
   * return badRequest('{ "error" : "Id en URL distinto del cuerpo" }')
   * }
   * 
   * RepoTareas.instance.update(actualizado)
   * ok('{ "status" : "OK" }');
   * } catch (Exception e) {
   * badRequest(e.message)
   * }
   * }
   */
  @Get("/tripulantes")
  public Result tripulantes(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoTripulantes _instance = RepoTripulantes.getInstance();
      final List<Tripulante> tripulantes = _instance.allInstances();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(tripulantes);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/vuelos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = vuelos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/vuelos/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = vuelo(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/vuelos/search").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		String numero = request.getParameter("numero");
    		
    		// take variables from url
    		
    		
    	    Result result = buscar(numero, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/tripulantes").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = tripulantes(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/vuelos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/vuelos/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/vuelos/search</td>"
    	+ "				<td>numero</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/tripulantes</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
