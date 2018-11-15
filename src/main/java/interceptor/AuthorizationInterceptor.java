package interceptor;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import controller.UsuarioController;
import session.UsuarioLogado;

@Intercepts
public class AuthorizationInterceptor {

	@Inject private UsuarioLogado usuarioLogado;
	@Inject private Result result;
	
	@Accepts
	public boolean accepts(ControllerMethod method) {
		return !method.containsAnnotation(Public.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if(!usuarioLogado.isLogado()) {
			result.redirectTo(UsuarioController.class).login();
			return;
		}
		stack.next();
	}
}