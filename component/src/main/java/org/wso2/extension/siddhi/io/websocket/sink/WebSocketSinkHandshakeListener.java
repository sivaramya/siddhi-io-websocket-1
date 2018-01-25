/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.extension.siddhi.io.websocket.sink;

import org.wso2.siddhi.core.exception.SiddhiAppRuntimeException;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.transport.http.netty.contract.websocket.HandshakeListener;

import javax.websocket.Session;

/**
 * Future listener for WebSocket handshake.
 */

public class WebSocketSinkHandshakeListener implements HandshakeListener {
    private StreamDefinition streamDefinition;
    private Session session = null;

    public WebSocketSinkHandshakeListener(StreamDefinition streamDefinition) {
        this.streamDefinition = streamDefinition;
    }

    @Override
    public void onSuccess(Session session) {
        this.session = session;
    }

    @Override public void onError(Throwable throwable) {
        throw new SiddhiAppRuntimeException("Error while connecting with the websocket server defined in '"
                                                    + streamDefinition + "'.", throwable);
    }

    public Session getSession() {
        return session;
    }
}
