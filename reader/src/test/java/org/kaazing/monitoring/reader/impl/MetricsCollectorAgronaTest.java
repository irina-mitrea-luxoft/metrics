/**
 * Copyright (c) 2007-2014 Kaazing Corporation. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kaazing.monitoring.reader.impl;
import static org.junit.Assert.*;

import java.util.function.BiConsumer;

import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.kaazing.monitoring.reader.agrona.extension.CountersManagerEx;

public class MetricsCollectorAgronaTest {
    private Mockery context = new JUnit4Mockery() {
    };

    @SuppressWarnings("unchecked")
    @Test
    public void testMetricsCollector() {
        context.setImposteriser(ClassImposteriser.INSTANCE);
        CountersManagerEx counterManager = context.mock(CountersManagerEx.class);
        context.checking(new Expectations() {{
            oneOf(counterManager).forEach(with(aNonNull(BiConsumer.class)));
        }});
        MetricsCollectorAgrona collector = new MetricsCollectorAgrona(counterManager);
        assertNotNull(collector.getMetrics());
    }

}