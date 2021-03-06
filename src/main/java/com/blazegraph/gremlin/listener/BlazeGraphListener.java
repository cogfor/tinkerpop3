/**
Copyright (C) SYSTAP, LLC DBA Blazegraph 2006-2016.  All rights reserved.

Contact:
     SYSTAP, LLC DBA Blazegraph
     2501 Calvert ST NW #106
     Washington, DC 20008
     licenses@blazegraph.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package com.blazegraph.gremlin.listener;

import com.blazegraph.gremlin.embedded.BlazeGraphEmbedded;

/**
 * Listener interface for a {@link BlazeGraphEmbedded}.
 * 
 * @see BlazeGraphEmbedded#addListener(BlazeGraphListener)
 * 
 * @author mikepersonick
 */
@FunctionalInterface
public interface BlazeGraphListener {

    /**
     * Notification of an edit to the graph.
     * 
     * @param edit
     *          the {@link BlazeGraphEdit}
     * @param rdfEdit
     *          toString() version of the raw RDF mutation
     */
    void graphEdited(BlazeGraphEdit edit, String rdfEdit);

    /**
     * Notification of a transaction committed.
     * 
     * @param commitTime
     *          the timestamp on the commit
     */
    default void transactionCommited(long commitTime) {
        // noop default impl
    }

    /**
     * Notification of a transaction abort.
     */
    default void transactionAborted() {
        // noop default impl
    }
    
}
