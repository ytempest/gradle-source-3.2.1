/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.tasks

import com.android.ide.common.workers.WorkerExecutorFacade
import org.gradle.workers.IsolationMode
import java.io.Serializable
import org.gradle.workers.WorkerExecutor
import javax.inject.Inject

/**
 * Simple implementation of [WorkerExecutorFacade] that uses a Gradle [WorkerExecutor]
 * to submit new work actions.
 *
 */
class WorkerExecutorAdapter
/**
 * Creates a new adapter using a [WorkerExecutor] instance and a work action [Class]
 * that should be instantiated for each work submission.
 *
 * @param workerExecutor instance of WorkerExecutor.
 */
    (private val workerExecutor: WorkerExecutor) : WorkerExecutorFacade {

    override fun submit(
        actionClass: Class<out Runnable>,
        parameter: Serializable
    ) {
        workerExecutor.submit(actionClass) {
                it.isolationMode = IsolationMode.NONE
                it.params(parameter)
            }
    }

    override fun await() {
        workerExecutor.await()
    }

    override fun close() {
        // do nothing.
    }
}
