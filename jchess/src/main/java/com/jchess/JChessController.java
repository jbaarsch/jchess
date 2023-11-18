package com.jchess;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class JChessController {

	@GetMapping(value = "/Home")
	public String index() {
		return "Home";
	}
	
}
