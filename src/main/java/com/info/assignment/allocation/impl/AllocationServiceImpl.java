package com.info.assignment.allocation.impl;

import com.info.assignment.allocation.AllocationService;
import com.info.assignment.exception.ApplicationException;
import com.info.assignment.pojo.Config;
import com.info.assignment.repository.AllocationDao;
import com.info.assignment.util.Utility;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Allocation service implementation class.
 */
@Service
public class AllocationServiceImpl implements AllocationService {

    /**
     * Logger instance.
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AllocationServiceImpl.class);

    /**
     * IP allocation DAO.
     */
    @Autowired
    private AllocationDao allocationDao;

    /**
     * Utility class.
     */
    @Autowired
    private Utility utility;

    @Override
    public String allocate(String macAddress) throws ApplicationException {
        String ipAddress = utility.getRandomHexString();
        LOGGER.info("IP allocated : " + ipAddress);
        if(!StringUtils.isEmpty(ipAddress)) {
            Config config = new Config(macAddress, ipAddress, new Date(System.currentTimeMillis()));
            return allocationDao.save(config).getIpAddress();
        } else {
            throw  new ApplicationException("Application is not able to allocate IP.");
        }
    }
}
