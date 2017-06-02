package chatv1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chatv1.model.Authorities;
import chatv1.model.Users;
import chatv1.repository.AuthorityRepository;
import chatv1.repository.UserRepository;

@Controller
public class CadastroController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@RequestMapping(value = "/cadastro", method = { RequestMethod.POST })
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Users u = new Users();
		u.setUsername(usuario);
		u.setPassword(senha);
		u.setEnabled(true);
		userRepository.save(u);

		Authorities auth = new Authorities();
		auth.setUsername(usuario);
		auth.setAuthority("user");
		authorityRepository.save(auth);

		ModelAndView modelView = new ModelAndView("login");
		modelView.addObject("status", "Usuário cadastrado com sucesso!!");

		return modelView;
	}
}
