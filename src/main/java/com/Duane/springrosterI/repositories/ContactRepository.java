package com.Duane.springrosterI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.springrosterI.models.ContactInfo;

@Repository
public interface ContactRepository extends CrudRepository<ContactInfo, Long>{}
