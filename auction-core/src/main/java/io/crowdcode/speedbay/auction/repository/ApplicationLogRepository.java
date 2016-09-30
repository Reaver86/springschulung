package io.crowdcode.speedbay.auction.repository;

import io.crowdcode.speedbay.auction.model.Message;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by SU00079 on 30.09.2016.
 */
public interface ApplicationLogRepository {
    void log(String message, LocalDateTime loggedAt, String username);
    List<Message> findLogs(LocalDateTime from, LocalDateTime to);
}
