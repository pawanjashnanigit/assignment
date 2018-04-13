package com.info.assignment.heartbeat;

import com.info.assignment.allocation.AllocationService;
import com.info.assignment.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Heartbeat thread class.
 */
@Service
public class HeartbeatThread {

    /**
     * Heartbeat service.
     */
    @Autowired
    private HeartbeatService heartbeatService;

    /**
     * Allocation service.
     */
    @Autowired
    private AllocationService allocationService;

    /**
     * heartbeat thread implementation method.
     *
     * @param macAddress Mac address.
     */
    public void run(String macAddress) throws ApplicationException {
        if (!StringUtils.isEmpty(macAddress)) {
            try {
                while (true) {
                    if (heartbeatService.refresh(macAddress, null)) {
                        allocationService.allocate(macAddress);
                    }
                    Thread.sleep(1 * 1000);
                }
            } catch (InterruptedException e) {
                throw new ApplicationException("Issue encountered while allocating IP to client host.");
            }
        }
    }
}
