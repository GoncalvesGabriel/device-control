package br.com.rash.devicecontrol.repository.userIdentify;

import br.com.rash.devicecontrol.entity.UserIdentify;
import br.com.rash.devicecontrol.utils.QueryHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CustomUserIdentifyRepositoryImpl implements CustomUserIdentifyRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Optional<UserIdentify> findByUser(String user) {
    Map params = new HashMap<String, Object>();
    StringBuilder query = new StringBuilder();
    query.append("SELECT userIdentify ");
    query.append(" FROM ").append(UserIdentify.class.getCanonicalName()).append(" as userIdentify");
    query.append(" WHERE ");
    query.append("  userIdentify.user = :user ");
    params.put("user", user);
    TypedQuery<UserIdentify> execQuery = entityManager.createQuery(query.toString(), UserIdentify.class);
    QueryHelper.bindParameters(execQuery, params);
    return Optional.of(execQuery.getSingleResult());
  }
}
