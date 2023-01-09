package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Entries;
import com.masai.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationServiceIntr{

	@Autowired
	ApplicationRepository appRepo;

	@Override
	public String saveEntries(Entries entries) {
		appRepo.save(entries);
		return "entrie is saved successfully";
	}
}
