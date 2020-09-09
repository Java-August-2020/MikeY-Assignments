package com.mike.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mike.dojosninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
}
