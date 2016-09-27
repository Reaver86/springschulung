package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.commons.Identifiable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SU00079 on 27.09.2016.
 */
@Getter
@Setter
@Accessors(chain = true)
public class Bid extends AbstractEntity {
    private BigDecimal amount;
    private String email;

    @Override
    public Identifiable setId(Serializable serializable) {
        return null;
    }
}
