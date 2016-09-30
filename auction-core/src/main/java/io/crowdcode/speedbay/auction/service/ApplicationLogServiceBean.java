package io.crowdcode.speedbay.auction.service;

import io.crowdcode.speedbay.auction.model.Message;
import io.crowdcode.speedbay.auction.repository.ApplicationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by SU00079 on 30.09.2016.
 */
@Service
public class ApplicationLogServiceBean implements ApplicationLogService {

    @Autowired
    private ApplicationLogRepository logRepository;

    @Override
    // TODO Diese Methode soll immer in einer eigenen Transaktion laufen!
    @Transactional
    public void log(String message, Object... args) {
        String msg = String.format(message, args);
        String username = "System";
        logRepository.log(msg, LocalDateTime.now(), username);
    }

    @Override
    // TODO Diese Methode kann wahlweise mit oder ohne Transaktion laufen!
    @Transactional
    public List<Message> lastLogs(Duration duration) {
        LocalDateTime to = LocalDateTime.now();
        LocalDateTime from = to.minus(duration);

        return logRepository.findLogs(from, to);
    }
}
