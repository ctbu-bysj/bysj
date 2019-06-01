package com.ctbu.schoolofai.btsjmanager.database.dao;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Database;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseDao  extends JpaRepository<Database,Long> {
}
