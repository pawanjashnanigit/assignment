package com.info.assignment.allocation;

import com.info.assignment.exception.ApplicationException;

/**
 * Allocation service.
 */
public interface AllocationService {

    /**
     * IP allocate method.
     */
    String allocate(String macAddress) throws ApplicationException;

}
