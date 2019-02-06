package com.youngman.cosmosdemo.repository;

import com.youngman.cosmosdemo.model.manytoone.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-01-29.
 */

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
