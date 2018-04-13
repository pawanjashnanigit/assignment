package com.info.assignment.repository;

import com.info.assignment.pojo.Config;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IP allocation DAO.
 */
@Repository
public interface AllocationDao extends CrudRepository<Config, String> {

    /**
     * Search for IP address string.
     *
     * @param ipAddress IP address.
     * @return Configuration object.
     */
    Config findByIpAddress(String ipAddress);
}
