package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.common.time.TimeMachine;
import io.crowdcode.speedbay.commons.Identifiable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by SU00079 on 27.09.2016.
 */
@Getter
@Setter
@Accessors(chain = true)
public class Auction extends AbstractEntity {
    private String owner;
    private LocalDateTime expireDate;
    private LocalDateTime beginDate;
    private BigDecimal minAmount;
    private String title;
    private String description;

    private List<Bid> bids;

    public Bid getHighestBid() {
        return null;
    }

    public boolean isExpired() {
        return TimeMachine.now().isAfter(expireDate);
    }

    public boolean isRunning() {
        return TimeMachine.now().isBefore(expireDate) && LocalDateTime.now().isAfter(beginDate);
    }

    @Override
    public Identifiable setId(Serializable serializable) {
        return null;
    }
}
