package ch.swiggels.weddingApp.services;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.swiggels.weddingApp.dto.Image;

@Controller
public class GaleryController {

	@RequestMapping(value = "/galery", method = RequestMethod.GET)
	public String galery(Model model, Device device) {
		return "galery";
	}

	@GetMapping(value = "/images", produces = "application/json")
	public ResponseEntity<String> images() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Image image = new Image();
		return new ResponseEntity<>(mapper.writeValueAsString(image), HttpStatus.OK);
	}
}