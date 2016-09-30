package io.crowdcode.speedbay.auction.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by SU00079 on 30.09.2016.
 */
@Getter
@Setter
@ToString
public class Message {
    private String message;
    private String createdBy;
    private LocalDateTime createdAt;

    public Message withMessage(final String message) {
        this.message = message;
        return this;
    }

    public Message withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Message withCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
