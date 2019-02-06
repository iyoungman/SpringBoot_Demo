package com.youngman.cosmosdemo.repository;

import com.youngman.cosmosdemo.model.manytoone.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-01-29.
 */

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findProfileById(Long id);
}
