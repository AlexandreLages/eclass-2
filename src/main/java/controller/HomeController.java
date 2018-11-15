package controller;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class HomeController {

	@Public
	@Get("/")
	public void home() {
		
	}
}