package com.youngman.cosmosdemo.repository;

import com.youngman.cosmosdemo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by youngman on 2019-01-29.
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findProfileById(Long id);
}
