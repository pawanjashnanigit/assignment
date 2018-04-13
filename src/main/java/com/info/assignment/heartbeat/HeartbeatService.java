package com.info.assignment.heartbeat;

/**
 * heartbeat service interface.
 */
public interface HeartbeatService {

    /**
     * Heartbeat refresh method.
     *
     * @param macAddress      mac address.
     * @param allocatedIPAddr Allocate IP string.
     * @return Flag to refresh IP or not.
     */
    boolean refresh(String macAddress, String allocatedIPAddr);

}
