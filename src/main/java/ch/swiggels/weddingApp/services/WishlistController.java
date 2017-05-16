package ch.swiggels.weddingApp.services;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.swiggels.weddingApp.domain.Article;
import ch.swiggels.weddingApp.domain.Person;
import ch.swiggels.weddingApp.repository.ArticleRepository;
import ch.swiggels.weddingApp.repository.PersonRepository;

@Controller
public class WishlistController {

	@Autowired
	ArticleRepository articleRepo;
	@Autowired
	PersonRepository personRepo;

	@RequestMapping(value = "/wishList", method = RequestMethod.GET)
	public String home(Model model, Device device) {
		model.addAttribute("wishList", articleRepo.findAll());
		model.addAttribute("person");
		return "wishList";
	}

	@RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
	public String article(Model model, Device device, @PathVariable("articleId") int id) {
		model.addAttribute("selectedArticle", articleRepo.getOne(id));
		return "article";
	}

	@RequestMapping(value = "/reserve/{name}/{articleId}", method = RequestMethod.GET)
	public String reserve(Model model, Device device, @PathVariable("articleId") int id, @PathVariable("name") String eMail) {

		Person person = new Person();
		person.setId(new SecureRandom().nextInt(100000000));
		person.setName(eMail);
		person = personRepo.save(person);
		Article article = articleRepo.getOne(id);
		article.setPerson_id(person.getId());
		article = articleRepo.save(article);
		String mailBody = "Lieber Schenkender \r\n\r\nBereits im Voraus: Vielen Dank!!!\r\nZur Erinnerung hier das von dir gewählte Geschenk: \r\n\r\n"
				+ article.getName() + " (" + article.getAmount() + "x)" + "\r\n" + article.getUrl() + "\r\n\r\n"
				+ "Herzliche Dank und bis bald! \r\n\r\n Sarah & Daniel";
		new Mailer().send(eMail, "Wunschliste von Sarahs und Daniels Hochzeit", mailBody);
		model.addAttribute("selectedArticle", articleRepo.getOne(id));
		return "article";
	}
}