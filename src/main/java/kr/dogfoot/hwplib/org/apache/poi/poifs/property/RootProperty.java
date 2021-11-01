/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package kr.dogfoot.hwplib.org.apache.poi.poifs.property;

import kr.dogfoot.hwplib.org.apache.commons.math3.util.ArithmeticUtils;
import kr.dogfoot.hwplib.org.apache.poi.poifs.common.POIFSConstants;

/**
 * Root property
 */
public final class RootProperty extends DirectoryProperty {
   private static final String NAME = "Root Entry";

    RootProperty()
    {
        super(NAME);

        // overrides
        setNodeColor(_NODE_BLACK);
        setPropertyType(PropertyConstants.ROOT_TYPE);
        setStartBlock(POIFSConstants.END_OF_CHAIN);
    }

    /**
     * reader constructor
     *
     * @param index index number
     * @param array byte data
     * @param offset offset into byte data
     */
    RootProperty(final int index, final byte [] array, final int offset) {
        super(index, array, offset);
    }

    /**
     * set size
     *
     * @param size size in terms of small blocks
     */
    public void setSize(int size)
    {
        final int BLOCK_SHIFT = 6;
        final int _block_size = 1 << BLOCK_SHIFT;
        super.setSize(ArithmeticUtils.mulAndCheck(size, _block_size));
    }

    /**
     * Returns the fixed name "Root Entry", as the
     *  raw property doesn't have a real name set
     */
    @Override
    public String getName() {
        return NAME;
    }
}
