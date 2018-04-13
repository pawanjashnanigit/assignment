package com.info.assignment.heartbeat.impl;

import com.info.assignment.heartbeat.HeartbeatService;
import com.info.assignment.pojo.Config;
import com.info.assignment.repository.AllocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Heartbeat service implementation class.
 */
@Service
public class HeartbeatServiceImpl implements HeartbeatService {

    /**
     * Expired time.
     */
    @Value("${expired.time}")
    private long expiredTime;

    /**
     * Allocation DAO.
     */
    @Autowired
    private AllocationDao allocationDao;

    @Override
    public boolean refresh(String macAddress, String allocatedIPAddr) {
        final Config config = allocationDao.findOne(macAddress);
        if (null == config) {
            return Boolean.TRUE;
        } else if (null != config && null != config.getCreatedDate()) {
            if (System.currentTimeMillis() - config.getCreatedDate().getTime() > expiredTime) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
