package br.com.rash.devicecontrol.repository.userIdentify;

import br.com.rash.devicecontrol.entity.UserIdentify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdentifyRepository extends JpaRepository<UserIdentify, Long>, CustomUserIdentifyRepository {

}
