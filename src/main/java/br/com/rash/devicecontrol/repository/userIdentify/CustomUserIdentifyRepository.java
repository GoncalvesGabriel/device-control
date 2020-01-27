package br.com.rash.devicecontrol.repository.userIdentify;

import br.com.rash.devicecontrol.entity.UserIdentify;
import java.util.Optional;

public interface CustomUserIdentifyRepository {

  Optional<UserIdentify> findByUser(String user);

}
