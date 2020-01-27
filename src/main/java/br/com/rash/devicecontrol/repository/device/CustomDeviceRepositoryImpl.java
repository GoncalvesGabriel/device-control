package br.com.rash.devicecontrol.repository.device;

import br.com.rash.devicecontrol.entity.Device;
import br.com.rash.devicecontrol.entity.vo.DeviceVo;
import br.com.rash.devicecontrol.utils.QueryHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;

public class CustomDeviceRepositoryImpl implements CustomDeviceRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<DeviceVo> findByUserAndId(String user, Long id) {
    Map params = new HashMap<String, Object>();
    StringBuilder query = new StringBuilder();
    query.append("SELECT new ").append(DeviceVo.class.getCanonicalName());
    query.append(" device.id, ");
    query.append(" device.qrCode, ");
    query.append(" device.adress, ");
    query.append(" userIdentify.user ");
    query.append(" FROM ").append(Device.class.getCanonicalName()).append(" as device");
    query.append(" JOIN device.userIdentify as userIdentify ");
    query.append(" WHERE ");
    query.append("  userIdentify.user = :user ");
    params.put("user", user);
    if (id != null) {
      query.append(" AND ");
      query.append(" device.id = :id");
      params.put("id", id);
    }
    Query execQuery = entityManager.createQuery(query.toString());
    execQuery.unwrap(org.hibernate.query.Query.class).setResultTransformer(new AliasToBeanResultTransformer(DeviceVo.class));
    QueryHelper.bindParameters(execQuery, params);

    return  execQuery.getResultList();
  }
}
