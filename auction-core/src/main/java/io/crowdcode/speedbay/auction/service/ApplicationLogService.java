package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.model.Message;

import java.time.Duration;
import java.util.List;

/**
 * Created by SU00079 on 30.09.2016.
 */
public interface ApplicationLogService {
    void log(String message, Object... args);
    List<Message> lastLogs(Duration duration);
}
