package io.crowdcode.speedbay.commons;

import java.io.Serializable;

/**
 * Created by SU00079 on 27.09.2016.
 */
public interface Identifiable<ID extends Serializable> {
    ID getId();

    <T extends Identifiable<ID>> T setId(ID id);
}
