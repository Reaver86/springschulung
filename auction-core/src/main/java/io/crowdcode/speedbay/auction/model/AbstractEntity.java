package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.commons.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by SU00079 on 27.09.2016.
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode() @ToString()
public abstract class AbstractEntity implements Identifiable {
    private Long id;
}
