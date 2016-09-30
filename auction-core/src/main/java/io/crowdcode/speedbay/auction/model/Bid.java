package io.crowdcode.speedbay.auction.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Getter @Setter @Accessors(chain = true)
@EqualsAndHashCode @ToString
@Entity
public class Bid extends AbstractEntity {

    private String email;
    private BigDecimal amount;

}
