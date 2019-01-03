package com.elsospring.service;

import org.springframework.stereotype.Service;

@Service("spying")
public class SpyService {

	public String mondokValamit() {
		return "Felfedtem magamat!";
	}

}
