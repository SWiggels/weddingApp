package ch.swiggels.weddingApp.services;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public String home(Model model, Device device) {
		return "route";
	}
}