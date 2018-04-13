package com.info.assignment;

import com.info.assignment.exception.ApplicationException;
import com.info.assignment.heartbeat.HeartbeatThread;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    /**
     * Logger instance.
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Mac address.
     */
    @Value("${mac.address}")
    private String macAddress;

    /**
     * Heartbeat thread.
     */
    @Autowired
    private HeartbeatThread thread;

    /**
     * Main method.
     * @param args Program arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void startHeartbeatThread() {
        if (!StringUtils.isEmpty(macAddress)) {
            try {
                thread.run(macAddress);
            } catch (ApplicationException e) {
                LOGGER.error("Application is not able to allocate IP address.");
            }
        } else {
            LOGGER.error("Exiting from application. No mac address has been provided.");
        }

    }
}
