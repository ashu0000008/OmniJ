package com.msgilligan.mastercoin.consensus.msc

import com.msgilligan.mastercoin.consensus.BaseConsensusSpec
import com.sun.xml.internal.rngom.parse.host.Base
import spock.lang.Unroll

/**
 * User: sean
 * Date: 7/9/14
 * Time: 11:56 PM
 */
class VsOmniBalanceMismatch extends BaseConsensusSpec {

    @Unroll
    def "compare #address balance msc vs omni (#mscBalance == #omniBalance)"() {
        expect:
        omniBalance == mscBalance

        where:
        address << omniSnapshot.entries.intersect(mscSnapshot.entries).keySet()
        omniBalance = omniSnapshot.entries[address].balance
        mscBalance = mscSnapshot.entries[address].balance
    }

}
